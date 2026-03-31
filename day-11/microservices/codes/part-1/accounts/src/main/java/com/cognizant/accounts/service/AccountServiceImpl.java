package com.cognizant.accounts.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.cognizant.accounts.dto.AccountDto;
import com.cognizant.accounts.dto.CustomerDto;
import com.cognizant.accounts.entities.Account;
import com.cognizant.accounts.entities.Customer;
import com.cognizant.accounts.exception.CustomerAlreadyExistsException;
import com.cognizant.accounts.exception.ResourceNotFoundException;
import com.cognizant.accounts.mapper.AccountMapper;
import com.cognizant.accounts.mapper.CustomerMapper;
import com.cognizant.accounts.repositories.AccountRepository;
import com.cognizant.accounts.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
	private AccountRepository accountRepo;
	private CustomerRepository customerRepo;

	@Override
	public void createAccount(CustomerDto customerDto) {
		Optional<Customer> optionalCustomer = customerRepo.findByMobileNumber(customerDto.getMobileNumber());
		if(optionalCustomer.isPresent()) {
		       throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber " +customerDto.getMobileNumber());
		}

		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Customer savedCustomer = customerRepo.save(customer);
		
		accountRepo.save(createNewAccount(savedCustomer));
	}

	/**
	 * @param customer - Customer Object
	 * @return the new account details
	 */
	private Account createNewAccount(Customer customer) {
		Account newAccount = new Account();
		newAccount.setCustomerId(customer.getCustomerId());
		long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

		newAccount.setAccountNumber(randomAccNumber);
		newAccount.setAccountType("Savings Account");
		newAccount.setBranchAddress("Gachibowli, Hyderabad, Telangana");
		return newAccount;
	}

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepo.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account accounts = accountRepo.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountMapper.mapToAccountsDto(accounts, new AccountDto()));
        return customerDto;
    }

    
    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountDto accountsDto = customerDto.getAccountDto();
        if(accountsDto !=null ){
            Account accounts = accountRepo.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountRepo.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepo.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepo.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    } 
    
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepo.findByMobileNumber(mobileNumber)
        							.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountRepo.deleteByCustomerId(customer.getCustomerId());
        customerRepo.deleteById(customer.getCustomerId());
        return true;
    }   
}
