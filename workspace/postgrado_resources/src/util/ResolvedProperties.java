package util;

import java.util.Properties;
import java.util.Stack;

public class ResolvedProperties extends Properties {
	/**
	 * Creates a new instance of ResolvedProperties using System.getProperties.
	 */
	public ResolvedProperties() {
		super(System.getProperties());
	}

	public ResolvedProperties(Properties defaults) {
		super(defaults);
	}

	@Override
	public String getProperty(String name) {
		String value = super.getProperty(name);
		return value != null ? resolve(value) : null;
	}

	@Override
	public String getProperty(String name, String defaultValue) {
		// Note that this must call this.getProperty(String name),
		// not the other way around, as that's what the superclass does.
		// Otherwise you get a stack overflow.
		String value = getProperty(name);
		return value != null ? value : defaultValue;
	}

	public String resolve(String string) {
		StringBuffer sb = new StringBuffer();
		Stack<StringBuffer> stack = new Stack<StringBuffer>();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			switch (c) {
			case '$':
				if (i + 1 < string.length() && string.charAt(i + 1) == '{') {
					stack.push(sb);
					sb = new StringBuffer();
					i++;
				}
				break;
			case '}':
				if (stack.isEmpty())
					throw new IllegalArgumentException("unexpected '}'");
				String name = sb.toString();
				sb = stack.pop();
				sb.append(super.getProperty(name, null));
				break;
			default:
				sb.append(c);
				break;
			}
		}
		if (!stack.isEmpty())
			throw new IllegalArgumentException("expected '}'");
		return sb.toString();
	}

	public static void main(String[] args) {
		ResolvedProperties pr = new ResolvedProperties();
		pr.setProperty("first.name", "Esmond");
		pr.setProperty("surname", "Pitt");
		pr.setProperty("degrees", "B.A.");
		pr.setProperty("memberships", "MIEEE FACS");
		pr.setProperty("FullName",
				"${first.name} ${surname} ${degrees} ${memberships}");
		String s = pr.getProperty("FullName");
		System.out.println(s);
	}

}
