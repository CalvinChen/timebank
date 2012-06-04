package tk.util.bean;

public class Values {
	
	public static final int PAGE_SIZE = 10;
	
	//不明、未使用、未填
	public static final int UNKNOWN = 0;
	
	public static final int NO = 0;
	public static final int YES = 1;
	
	//默认头像地址
	public static final String DEFAULT_PHOTO = "/TimeBank/CSS/images/img00.jpg";
	
	//返回结果
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	
	//性别
	public static final int BOY = 1;
	public static final int GIRL = 2;
	
	//区域
	public static final int QI_LIN_NAN = 1;
	public static final int QI_LIN_BEI = 2;
	public static final int WU_SHAN = 3;
	public static final int HUA_SHAN = 4;
	public static final int OTHER_ZONE = 5;//(暂不启用)
	
	//学院
	//稍后补充
	
	//互助的申请方
	public static final int REQUIRE_BY_TO_HELP = 1;
	public static final int REQUIRE_BY_HELPED = 2;
	
	//反馈的回复状态
	public static final int FEEDBACK_NOT_HANDLED = 0;//默认状态
	public static final int FEEDBACK_HANDLED = 1;
	
	//存取向导的选择
	public static final int GIUDE_UNCERTAIN = 1;//不确定空闲时间，需要查看清单
	public static final int GUIDE_CERTAIN = 2;//确定空闲时间，直接存入空闲时间

	public static final int INIT_BALANCE = 3;//初始时间币
	
	//文章类型
	public static final int TYPE_NOTIFICATION = 1;//通知通告
	public static final int TYPE_NEWS = 2;//新闻快讯
	public static final int TYPE_TIME_BANK = 3;//时间银行

	//用户状态
	public static final int USER_NOT_VERIFIED = 0;//未被验证，无法使用银行功能
	public static final int USER_VERIFIED = 1;//已被验证，可以使用银行功能
	
	//用户信息状态
	public static final int INFO_NOT_USED = 0;//未被使用，可以注册
	public static final int INFO_USED = 1;//已被使用，无法注册

	/**
	 * 消息类型，1-消息（时间存储动态、反馈动态等）。
	 */
	public static final int MSG_MESSAGE = 1;
	
	/**
	 * 消息类型，2-私信（用户之间传递）（暂不开放）。
	 */
	private static final int MSG_PRIVATE = 2;
	
	/**
	 * 消息类型，3-通知（管理员发布、网站发布）。
	 */
	public static final int MSG_NOTICE = 3;
	
	/**
	 * 消息类型，4-粉丝（加关注功能使用）（暂不开放）
	 */
	private static final int MSG_FANS = 4;

	/**
	 * 用户名最小长度
	 */
	public static final int USERNAME_MIN_LENGTH = 2;	
	/**
	 * 用户名最大长度
	 */
	public static final int USERNAME_MAX_LENGTH = 10;
	/**
	 * 密码最小长度
	 */
	public static final int PSW_MIN_LENGTH = 4;	
	/**
	 * 密码最大长度
	 */
	public static final int PSW_MAX_LENGTH = 20;	
	/**
	 * 姓名最小长度
	 */
	public static final int NAME_MIN_LENGTH = 2;	
	/**
	 * 姓名最大长度
	 */
	public static final int NAME_MAX_LENGTH = 10;
	/**
	 * 邮箱最小长度
	 */
	public static final int EMAIL_MIN_LENGTH = 5;	
	/**
	 * 邮箱最大长度
	 */
	public static final int EMAIL_MAX_LENGTH = 50;
	/**
	 * 手机长号最小长度
	 */
	public static final int PHONEL_MIN_LENGTH = 2;	
	/**
	 * 手机长号最大长度
	 */
	public static final int PHONEL_MAX_LENGTH = 15;
	/**
	 * 短号最小长度
	 */
	public static final int PHONES_MIN_LENGTH = 2;	
	/**
	 * 短号最大长度
	 */
	public static final int PHONES_MAX_LENGTH = 10;
	/**
	 * 年级最小长度
	 */
	public static final int GRADE_MIN_LENGTH = 2;	
	/**
	 * 年级最大长度
	 */
	public static final int GRADE_MAX_LENGTH = 4;
	/**
	 * 专业最小长度
	 */
	public static final int MAJOR_MIN_LENGTH = 2;	
	/**
	 * 专业最大长度
	 */
	public static final int MAJOR_MAX_LENGTH = 30;
	/**
	 * 学号长度
	 */
	public static final int STUDENTID_LENGTH = 12;
	/**
	 * QQ最小长度
	 */
	public static final int QQ_MIN_LENGTH = 4;	
	/**
	 * QQ最大长度
	 */
	public static final int QQ_MAX_LENGTH = 15;
	/**
	 * 博客最小长度
	 */
	public static final int BLOG_MIN_LENGTH = 10;	
	/**
	 * 博客最大长度
	 */
	public static final int BLOG_MAX_LENGTH = 50;
	/**
	 * 微博最小长度
	 */
	public static final int WEIBO_MIN_LENGTH = 15;	
	/**
	 * 微博最大长度
	 */
	public static final int WEIBO_MAX_LENGTH = 50;
	/**
	 * 地址最小长度
	 */
	public static final int ADDRESS_MIN_LENGTH = 2;	
	/**
	 * 地址最大长度
	 */
	public static final int ADDRESS_MAX_LENGTH = 50;

	/**
	 * 	能提前几天约
	 */
	public static final int DAY_EARLIEST = 0;

	/**
	 *  最晚晚几天约
	 */
	public static final int DAY_LASTEST = 15;

	/**
	 *  爱好特长数少于这个数字以下就无法删除当前爱好特长
	 */
	public static final int MIN_COUNT_SKILL = 5;

	/**
	 *  时间储备少于这个数字以下就无法删除当前爱好特长
	 */
	public static final int MIN_COUNT_IDLETIME = 1;

	/**
	 * 标志此条记录为存储记录
	 */
	public static final int TYPE_DEPOSIT = 1;
	/**
	 * 标志此条记录为提取记录
	 */
	public static final int TYPE_WITHDRAW = 2;
	/**
	 * 普通管理员
	 */
	public static final int ADMIN_NORMAL = 1;
	/**
	 * 超级管理员
	 */
	public static final int ADMIN_SUPER = 2;

	/**
	 * 匹配次数模式
	 */
	public static final int MODE_SEEK = 1;
	/**
	 * 过期模式
	 */
	public static final int MODE_EXPIRE = 2;
	/**
	 * 双模式
	 */
	public static final int MODE_BOTH = 3;
}
