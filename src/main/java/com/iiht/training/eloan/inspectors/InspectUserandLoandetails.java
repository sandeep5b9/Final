package com.iiht.training.eloan.inspectors;

import java.util.ArrayList;
import java.util.List;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.UserDto;

public class InspectUserandLoandetails {
    private List<String> errors;

    public boolean isValid(UserDto userDto) {
        errors = new ArrayList<>();
        if (null == userDto)
            errors.add("User details are required");
        else {
            if (null == userDto.getFirstName())
                errors.add("User firstname is not null, min 3 and max 100 characters");
            
            if (null == userDto.getLastName())
                errors.add("User lastname is not null, min 3 and max 100 characters");
            
            if (null == userDto.getEmail())
                errors.add("User email is not null, min 3 and max 100 characters and in proper email format");
            
            if (null == userDto.getMobile())
                errors.add("User mobile is not null, min 10 and max 10 characters");
            
        }
        return !(errors.size() > 0);
    }
    
    public boolean isValidLoanInfo(LoanDto loanDto) {
        errors = new ArrayList<>();
        if (null == loanDto)
            errors.add("Loan details are required");
        else {
            if (null == loanDto.getLoanName())
                errors.add("Loan name is not null, min 3 and max 100 characters");
            
            if (null == loanDto.getLoanAmount())
                errors.add("Loan amount is not null, and not 0");       
            
        }
        return !(errors.size() > 0);
    }

    public List<String> getErrors() {
        return errors;
    }

}
