package tk.persistence;

import timebank.model.bank.BankInfo;

public interface BankInfoDao {

	/**
	 * 增加一条用户银行信息
	 * @param userId 新注册的用户
	 * @return 增加的结果
	 */
	public abstract String createOne(int userId);

	public abstract double readBalanceByUserId(int userId);

	public abstract String updateOne(BankInfo one);

	/**【原子】
	 * 更改编号为userId的会员银行数据，传入参数为改变量。
	 * @param userId 会员编号
	 * @param change 例如-2,+1等等
	 * @return 结果
	 */
	public abstract String updateOne(int userId, double balance,
			int depositCountAll, int depositCountValid, int withdrawCountAll,
			int withdrawCountValid, int averageScore);

	/**
	 * 获得某个用户的银行信息
	 * @param userId 某个用户的ID
	 * @return 该用户的银行信息
	 */
	public abstract BankInfo readOneByUserId(int userId);

}