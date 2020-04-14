package com.itranswarp.learnjava;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/11 15:57
 */
public class Template {
	final String template;
	final Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\}");

	public Template(String template) {
		this.template = template;
	}

	public String render(Map<String, Object> data) {
		Matcher m = pattern.matcher(template);
		StringBuffer sb= new StringBuffer();
		while (m.find()) {
            for (String key:data.keySet()){
	            if (("${" + key + "}").equals(template.substring(m.start(), m.end()))) {
		            m.appendReplacement(sb, (String) data.get(key));
		            break;
	            }
            }
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public String render2(Map<String, Object> data) {
		Matcher m = pattern.matcher(template);
		StringBuffer sb= new StringBuffer();
		while (m.find()) {
			String tmp = template.substring(m.start()+2,m.end()-1);
			m.appendReplacement(sb,(String)data.get(tmp));
		}
		m.appendTail(sb);
		return sb.toString();
	}

}
