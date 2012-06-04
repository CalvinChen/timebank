package tk.persistence;

import java.util.ArrayList;

import timebank.model.reserve.ReserveSkill;

public interface SkillDao {

	/**
	 * 向数据库中新增一项爱好
	 * @param one
	 * @return
	 */
	public abstract String createOne(ReserveSkill one);

	/**
	 * 获得数据库中指定用户指定第一分类的所有技能信息
	 * @param userId 
	 * @return
	 */
	public abstract ArrayList<ReserveSkill> readSomeByUserIdAndClass1(
			long userId, String class1);

	/**
	 * 获得数据库中指定用户的所有技能信息的总数
	 * @param userId 
	 * @return
	 */
	public abstract int readCountByUserId(int userId);

	public abstract ReserveSkill readOneById(int skillId);

	/**
	 * 根据信息查看用户有没有这条爱好特长
	 * @param userId 用户编号
	 * @param c1 第一分类
	 * @param c2 第二分类
	 * @return
	 */
	public abstract boolean readOneIsHave(int userId, String c1, String c2);

	/**
	 * 根据信息查看用户有没有这条模糊的爱好特长
	 * @param userId 用户编号
	 * @param someSkills 模糊的技能储备
	 * @return
	 */
	public abstract boolean readOneIsHave(int userId, String someSkills);

	public abstract String deleteOne(int skillId);

	/**
	 * 根据关键字找出用户爱好技能里面含有的记录
	 * @param someInfo
	 * @param p 页码
	 * @return
	 */
	public abstract ArrayList<Integer> readUserIdBySomeSkill(String someInfo,
			int p);

	/**
	 * 根据关键字找出用户爱好技能里面含有的记录
	 * @param someInfo
	 * @param p 页码
	 * @return
	 */
	public abstract ArrayList<Integer> readUserIdByHaveSkills(int p);

	/**
	 * 根据关键字找出用户爱好技能里面含有的记录的总数
	 * @param someInfo
	 * @param p
	 * @return
	 */
	public abstract int readCountUserIdBySomeSkill(String someInfo);

	/**
	 * 读出所有有填写爱好技能的用户的总数
	 * @param someInfo
	 * @param p
	 * @return
	 */
	public abstract int readCountUserIdByHaveSkills();

	/**
	 * 读出所有爱好技能的总数
	 * @param someInfo
	 * @param p
	 * @return
	 */
	public abstract int readCountSkills();

}