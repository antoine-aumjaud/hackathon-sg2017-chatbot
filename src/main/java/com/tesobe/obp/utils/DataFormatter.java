package com.tesobe.obp.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class DataFormatter {

    private static DecimalFormat decimalFormater = new DecimalFormat("0.00");{
		decimalFormater.setNegativePrefix("- ");
		decimalFormater.setPositivePrefix("+ ");
		decimalFormater.setGroupingSize(3);
		decimalFormater.setGroupingUsed(true);		
		decimalFormater.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.FRANCE));

	}
	private static SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");

	public String formatAmount(double number) {
        	return decimalFormater.format(number);
	}    
	public String formatAmount(BigDecimal number) {
        	return formatAmount(number.doubleValue());
	}    
	public String formatDate(Date date) {
        	return dateformatter.format(date);
	}    


}

