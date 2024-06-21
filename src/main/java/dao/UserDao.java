package dao;

import java.util.List;

import beans.User;

public interface UserDao {
	void add(User user);

	List<User> list();

	User get(int id);

	void update(User user);

	void delete(int id);
}
