package sduwh.cp.bookstore.dao;

import sduwh.cp.bookstore.domain.User;



public interface UserDAO {

	/**
	 * �����û�����ȡ User ����
	 * @param username
	 * @return
	 */
	public abstract User getUser(String username);

}

