package net.diybigdata.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.exec.Description;

@Description(
	name = "FormatYearMonthString",
    value = "_FUNC_(InputDataType) - Converts the passed year and month integers to a formatted string.",
    extended = "Example:\n"
             + "  > SELECT _FUNC_(InputDataType) FROM tablename;")

public class FormatYearMonthString extends UDF {
	public String evaluate( Integer year, Integer month ) {
		return String.format("%1$d-%2$02d", year, month );
	}
}
