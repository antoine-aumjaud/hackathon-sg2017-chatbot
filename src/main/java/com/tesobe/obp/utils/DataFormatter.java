package com.tesobe.obp.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class DataFormatter {

//	@Test
	public void main()
	{
//	assertEquals("11,21", System.out.println(decimalFormater.format(11.219)) );
//	assertEquals("+ 1 234 556.21", decimalFormater.format(1234556.21));
//	assertEquals("- 1 234 556.21", decimalFormater.format(-1234556.21);
	}

    private static DecimalFormat decimalFormater = new DecimalFormat("### ### ##0.00");{
		decimalFormater.setNegativePrefix("- ");
		decimalFormater.setPositivePrefix("+ ");
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

