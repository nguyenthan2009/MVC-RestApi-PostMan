package com.than.Formatter;

import com.than.model.Company;
import com.than.service.ICompanyService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CompanyFormatter implements Formatter<Company> {
    private ICompanyService companyService;

    public CompanyFormatter(ICompanyService companyService) {
        this.companyService = companyService;
    }


    @Override
    public Company parse(String text, Locale locale) throws ParseException {
        return   companyService.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Company object, Locale locale) {
        return null;
    }
}
