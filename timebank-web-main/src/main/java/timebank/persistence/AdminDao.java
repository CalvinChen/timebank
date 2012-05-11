package timebank.persistence;

import java.util.ArrayList;

import timebank.model.admin.Admin;

public interface AdminDao {

	public abstract Admin readOne(String username);

	public abstract String readUsernameById(int adminId);

	public abstract String createOne(Admin one);

	public abstract ArrayList<Admin> readSomeByPage(int page);

	public abstract int readCountAll();

	public abstract Admin readOne(int adminId);

	public abstract String updateOne(Admin one);

	public abstract String createOneByPromote(Admin one);

	public abstract String deleteOne(int aid);

}