package pe.edu.upc.stumatch.business.crud;

import java.util.List;

import pe.edu.upc.stumatch.model.entity.Users;

public interface IUserService {
	public Integer insert(Users user);

	List<Users> list();

}
