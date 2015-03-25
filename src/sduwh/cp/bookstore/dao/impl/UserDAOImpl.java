package sduwh.cp.bookstore.dao.impl;

import sduwh.cp.bookstore.dao.UserDAO;
import sduwh.cp.bookstore.domain.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

	@Override
	public User getUser(String username) {
		String sql = "SELECT userId, username, accountId " +
				"FROM userinfo WHERE username = ?";
		return query(sql, username);
	}

}
