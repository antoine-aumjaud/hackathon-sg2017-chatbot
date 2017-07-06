package com.tesobe.obp.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DataFormatter {

    private static DecimalFormat decimalFormat = new DecimalFormat("### ###.00");
	private static SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");

	public String formatAmount(double number) {
        	return (number < 0 ? "- " : "+ ") + decimalFormat.format(number);
	}    
	public String formatAmount(BigDecimal number) {
        	return formatAmount(number.doubleValue());
	}    
	public String formatDate(Date date) {
        	return dateformatter.format(date);
	}    
}

