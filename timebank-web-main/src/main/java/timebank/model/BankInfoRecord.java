package timebank.model;

public class BankInfoRecord {
	private int bankinfoId;
	private int userId;
	private double balance; 
	private int depositCountAll;
	private int depositCountValid; 
	private int withdrawCountAll;
	private int withdrawCountValid;
	private double averageScore;
	public int getBankinfoId() {
		return bankinfoId;
	}
	public void setBankinfoId(int bankinfoId) {
		this.bankinfoId = bankinfoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getDepositCountAll() {
		return depositCountAll;
	}
	public void setDepositCountAll(int depositCountAll) {
		this.depositCountAll = depositCountAll;
	}
	public int getDepositCountValid() {
		return depositCountValid;
	}
	public void setDepositCountValid(int depositCountValid) {
		this.depositCountValid = depositCountValid;
	}
	public int getWithdrawCountAll() {
		return withdrawCountAll;
	}
	public void setWithdrawCountAll(int withdrawCountAll) {
		this.withdrawCountAll = withdrawCountAll;
	}
	public int getWithdrawCountValid() {
		return withdrawCountValid;
	}
	public void setWithdrawCountValid(int withdrawCountValid) {
		this.withdrawCountValid = withdrawCountValid;
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
}
