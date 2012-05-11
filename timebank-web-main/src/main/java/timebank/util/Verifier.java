package timebank.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import sun.awt.SunHints.Value;
import timebank.business.user.UserManager;
import timebank.model.user.User;
import timebank.util.bean.Values;

public class Verifier {
	
//	public static boolean verifySCAU(String name, String studentId) {
//		try {
//			Date day = new Date();
//			SimpleDateFormat format = new SimpleDateFormat("yyyy");
//			int thisYear = Integer.parseInt(format.format(day));
//			int onesGrage = Integer.parseInt(studentId.substring(0, 4));
//			if(onesGrage > thisYear || onesGrage < thisYear - 5){
//				return false;
//			}
//			return true;
//		} catch (NumberFormatException e) {
//			return false;
//		}
//	}
	
	public static boolean verifyInfo(String name, String studentId) {
		if(name.length() < 2 ||
				name.length() > 5 ||
				studentId.length() != 12){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 验证注册时注册信息的数据合法性
	 * @param user
	 * @param passwordConfirm
	 * @return
	 */
	public static boolean verifyReg(User user, String passwordConfirm) {
		if(user.getUsername().length() < 2 ||
				user.getUsername().length() > 20 ||
				user.getPassword().length() < 4 ||
				user.getPassword().length() > 20 ||
				user.getUserInfo().getEmail().length() < 5 ||
				user.getUserInfo().getEmail().length() > 50 ||
				!user.getPassword().equals(passwordConfirm)
		){
			return false;
		}else{
			return true;
		}
	}
	
	public static String verifyAdminModifyUser(User user){
		int length;
		
		//用户名
		User oneDatabase = new UserManager().getOneByUsername(user.getUsername());
		if(oneDatabase != null && oneDatabase.getUserId() != user.getUserId()){
			return "此用户名已被他人注册";
		}
		length = user.getUsername().length();
		if(length < Values.USERNAME_MIN_LENGTH ||
				length > Values.USERNAME_MAX_LENGTH){
			return "用户名超过长度限制！(" + 
					Values.USERNAME_MIN_LENGTH + 
					"-" + 
					Values.USERNAME_MAX_LENGTH + 
					")";
		}
		
		//姓名
		length = user.getUserInfo().getTrueName().length();
		if(length < Values.NAME_MIN_LENGTH ||
				length > Values.NAME_MAX_LENGTH){
			return "姓名超过长度限制！(" + 
					Values.NAME_MIN_LENGTH + 
					"-" + 
					Values.NAME_MAX_LENGTH + 
					")";
		}
		
		
		return Values.SUCCESS;
	}

	public boolean testUsername(String username, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && username == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && username == null){
			return false;
		}
		
		int length = username.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.USERNAME_MIN_LENGTH || length > Values.USERNAME_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testPassword(String password, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && password == null){
			return true;
		}
		
		if(isRequired == false && password.length() == 0){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && password == null){
			return false;
		}
		
		int length = password.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.PSW_MIN_LENGTH || length > Values.PSW_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testEmail(String email, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && email == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && email == null){
			return false;
		}
		
		int length = email.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.EMAIL_MIN_LENGTH || length > Values.EMAIL_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testName(String name, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && name == null){
			return true;
		}
		
		if(isRequired == false && name.length() != 0){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && name == null){
			return false;
		}
		
		int length = name.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.NAME_MIN_LENGTH || length > Values.NAME_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testQq(String qq, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && qq == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && qq == null){
			return false;
		}
		
		int length = qq.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.QQ_MIN_LENGTH || length > Values.QQ_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testWeibo(String weibo, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && weibo == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && weibo == null){
			return false;
		}
		
		int length = weibo.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.WEIBO_MIN_LENGTH || length > Values.WEIBO_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testBlog(String blog, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && blog == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && blog == null){
			return false;
		}
		
		int length = blog.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.BLOG_MIN_LENGTH || length > Values.BLOG_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testMajor(String major, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && major == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && major == null){
			return false;
		}
		
		int length = major.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.MAJOR_MIN_LENGTH || length > Values.MAJOR_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testStudentId(String studentId, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && studentId == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && studentId == null){
			return false;
		}
		
		int length = studentId.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length != Values.STUDENTID_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testAddress(String address, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && address == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && address == null){
			return false;
		}
		
		int length = address.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.ADDRESS_MIN_LENGTH || length > Values.ADDRESS_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testPhoneLong(String phoneLong, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && phoneLong == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && phoneLong == null){
			return false;
		}
		
		int length = phoneLong.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.PHONEL_MIN_LENGTH || length > Values.PHONEL_MAX_LENGTH){
			return false;
		}
		return true;
	}
	public boolean testPhoneShort(String phoneShort, boolean isRequired){
		//不要求，输入为null，成功
		if(isRequired == false && phoneShort == null){
			return true;
		}
		
		//要求，输入为null，失败
		if(isRequired == true && phoneShort == null){
			return false;
		}
		
		int length = phoneShort.trim().length();
		
		//要求，输入不为null，但长度为0，失败
		if(isRequired == true && length == 0){
			return false;
		}
		
		//验证长度
		if(length < Values.PHONES_MIN_LENGTH || length > Values.PHONES_MAX_LENGTH){
			return false;
		}
		return true;
	}
}
