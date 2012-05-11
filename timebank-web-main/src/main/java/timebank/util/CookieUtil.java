/**
 * @Project TimeBank
 * @CreatedTime 2011-10-24 下午07:27:41 
 * @Author CK
 * @Todo TODO
 */
package timebank.util;

import javax.servlet.http.Cookie;

/**
 * @author CK
 *
 */
public class CookieUtil {

	public String getValueByName(String name, Cookie[] list){
		int length = list.length;
		Cookie one = null;
		String value = null;
		for (int i = 0; i < length; i++) {
			one = list[i];
			if(one.getName().equals(name)){
				value = one.getValue();
			}
		}
		return value;
	}
}
