package pe.edu.upc.stumatch.business.crud;

import java.util.List;

import pe.edu.upc.stumatch.model.entity.Role;

public interface IRoleService {
	public void insert(Role role);

	List<Role> list();

}
