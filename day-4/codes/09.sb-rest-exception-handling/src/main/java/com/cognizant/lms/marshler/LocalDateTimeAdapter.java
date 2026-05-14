package com.cognizant.lms.marshler;

import java.time.LocalDate;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}
