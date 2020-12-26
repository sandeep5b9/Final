package com.iiht.training.eloan.inspectors;

import java.util.ArrayList;
import java.util.List;

import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.entity.SanctionInfo;

public class InspectProcessinginfo {
    private List<String> errors;

    public boolean checkData(ProcessingInfo processingInfo) {
        errors = new ArrayList<>();
        if (null == processingInfo)
            errors.add("Loan surity details are required");
        else {
            if (null == processingInfo.getAcresOfLand())
                errors.add("Acres of land is not null and can't be 0");

            if (null == processingInfo.getLandValue())
                errors.add("Land value is not null and can't be 0");

            Double suggestedamount = processingInfo.getSuggestedAmountOfLoan();
            if (null == suggestedamount || suggestedamount != 0) 
                errors.add("Stock price is required and can't be 0");
            
            if (null == processingInfo.getAddressOfProperty())
                errors.add("Address of property is not null, min 3 and max 150 characters");
            
        }
        return !(errors.size() > 0);
    }
    
    public boolean checkloanamountsanctioned(SanctionInfo sanctionInfo) {
        errors = new ArrayList<>();
        if (null == sanctionInfo)
            errors.add("Loan amount sanctioned details are required");
        else {
            if (null == sanctionInfo.getLoanAmountSanctioned())
                errors.add("Loan amount sanctioned is not null and can't be 0");

            Double termofloan = sanctionInfo.getTermOfLoan();
            if (null == termofloan || termofloan != 0) 
                errors.add("Term of loan is not null and can't be 0");
            
        }
        return !(errors.size() > 0);
    }

    public List<String> getErrors() {
        return errors;
    }

}
