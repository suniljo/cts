package com.cognizant.oto.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private Integer employeeId;
	private String employeeName;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
	@JoinColumn(name="addr_id")
	private Address employeeAddress;
}
