package timebank.util.lang.convertor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Convertor {

//	public static String changeHTML(String value) {
//		value = value.replace("&", "&amp;");
//		value = value.replace(" ", "&nbsp;");
//		value = value.replace("<", "&lt;");
//		value = value.replace(">", "&gt;");
//		value = value.replace("\r\n", "<br>");
//		return value;
//	}
	
//	public static String changeHTMLBack(String value) {
//		value = value.replace("&amp;", "&");
//		value = value.replace("&nbsp;", " ");
//		value = value.replace("&lt;", "<");
//		value = value.replace("&gt;", ">");
//		value = value.replace("<br>", "\r\n");
//		return value;
//	}
	
	public static String changeTimeToString(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
		return format.format(date);
	}
	
	public static String changeDateTimeToString(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return format.format(date);
	}
	
	public static String changeDateToString(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public static String changeTimeStamp(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(date);
	}
}
