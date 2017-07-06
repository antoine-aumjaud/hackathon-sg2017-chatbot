package com.tesobe.obp.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataFormatterTest {

	private DataFormatter dataFormatter = new DataFormatter ();

	@Test
	public void format_should_arround_an_amount()
	{
		assertEquals("+ 11,22", dataFormatter.formatAmount(11.219) );
	}

	@Test
	@Ignore
	public void format_should_format_crrectly_if_amount_is_positive()
	{
		assertEquals("+ 1 234 556,21", dataFormatter.formatAmount(1234556.21));
	}

	@Test
	@Ignore
	public void format_should_format_crrectly_if_amount_is_negative()
	{
		assertEquals("- 1 234 556,21", dataFormatter.formatAmount(-1234556.21));
	}
}

