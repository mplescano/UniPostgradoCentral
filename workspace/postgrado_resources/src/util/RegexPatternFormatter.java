package util;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.DefaultFormatter;

public class RegexPatternFormatter extends DefaultFormatter {
	protected Matcher matcher;
	
	public RegexPatternFormatter (Pattern regex) {
		this.setOverwriteMode(false);
		matcher = regex.matcher("");
	}
	
	public RegexPatternFormatter (String stringRegex, boolean caseInsensitive) {
		Pattern regex;
		if (caseInsensitive) {
			regex = Pattern.compile(stringRegex, Pattern.CASE_INSENSITIVE);
		}
		else {
			regex = Pattern.compile(stringRegex);
		}
		this.setOverwriteMode(false);
		matcher = regex.matcher("");
	}
	
	public Object stringToValue(String arg0) throws ParseException {
		// TODO Auto-generated method stub
		if (arg0 == null) {
			return null;
		}
		matcher.reset(arg0);
		if (! matcher.matches()) {
			throw new ParseException("No coincide con el regex", 0);
		}
		return super.stringToValue(arg0);
	}
}