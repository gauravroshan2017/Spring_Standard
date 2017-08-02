package com.gaurav.validator;

import org.apache.commons.validator.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gaurav.model.CustomerInfo;

@Component
public class CustomerInfoValidator implements Validator {
 
    @SuppressWarnings("deprecation")
	private EmailValidator emailValidator = EmailValidator.getInstance();
 
    // This Validator support CustomerInfo class.
    
    public boolean supports(Class<?> clazz) {
        return clazz == CustomerInfo.class;
    }
 
    public void validate(Object target, Errors errors) {
        CustomerInfo custInfo = (CustomerInfo) target;
 
        // Check the fields of CustomerInfo class.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");
 
        if (!emailValidator.isValid(custInfo.getEmail())) {
            errors.rejectValue("email", "Pattern.customerForm.email");
        }
    }
 
}