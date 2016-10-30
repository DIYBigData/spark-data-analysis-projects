package net.diybigdata.udf;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import net.diybigdata.udf.FormatYearMonthString;

public class FormatYearMonthString_T {

	@Test
	public void testStringFormating() {
		FormatYearMonthString udf = new FormatYearMonthString();
	
		assertEquals(
			"evaluate(1936, 12)",
			"1936-12", 
			udf.evaluate( 1936, 12 )
		);
		assertEquals(
			"evaluate(1980, 07)",
			"1980-07", 
			udf.evaluate( 1980, 07 )
		);	
	}
}
