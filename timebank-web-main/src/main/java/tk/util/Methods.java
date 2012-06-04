package tk.util;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import timebank.model.user.User;
import timebank.util.lang.convertor.Convertor;
import tk.util.bean.Values;

public class Methods {
	
	
	public static long getUserInfoPercentage(User user){
		int i = 0;
//		if(user.getAddress() != null && !user.getAddress().equals("")) i++;
//		if(user.getBlog() != null && !user.getBlog().equals("")) i++;
//		if(user.getClassId() != 0) i++;
//		if(user.getCollege() != 0) i++;
//		if(user.getEmail() != null && !user.getEmail().equals("")) i++;
//		if(user.getGrade() != 0) i++;
//		if(user.getMajor() != null && !user.getMajor().equals("")) i++;
//		if(user.getName() != null && !user.getName().equals("")) i++;
//		if(user.getPhoneLong() != null && !user.getPhoneLong().equals("")) i++;
//		if(user.getPhoneShort() != null && !user.getPhoneShort().equals("")) i++;
//		if(user.getPicture() != null && !user.getPicture().equals("")) i++;
//		if(user.getQq() != null && !user.getQq().equals("")) i++;
//		if(user.getSex() != null && !user.getSex().equals("")) i++;
//		if(user.getStudentId() != null && !user.getStudentId().equals("")) i++;
//		if(user.getWeibo() != null && !user.getWeibo().equals("")) i++;
//		if(user.getZone() != null && !user.getZone().equals("")) i++;
		double percentage = i/16.0*100;
		return Math.round(percentage);
	}

	public static int readPages(int count) {
		int page;
		if(count%Values.PAGE_SIZE == 0){
			page = count/Values.PAGE_SIZE;
		}else{
			page = count/Values.PAGE_SIZE + 1;
		}
		return page;
	}
	

	/**
	 * 读取最近的几天
	 */
	public ArrayList<String> readDays() {
		GregorianCalendar now = new GregorianCalendar();
		ArrayList<String> days = new ArrayList<String>();
		days.add(Convertor.changeDateToString(now.getTime()));
		for (int i = Values.DAY_EARLIEST; i < Values.DAY_LASTEST; i++) {
			now.add(GregorianCalendar.DAY_OF_MONTH, 1);
			days.add(Convertor.changeDateToString(now.getTime()));
		}
		return days;
	}

	public static int correctPage(int p){
		if(p < 1){
			return 1;
		}else return p;
	}
}
