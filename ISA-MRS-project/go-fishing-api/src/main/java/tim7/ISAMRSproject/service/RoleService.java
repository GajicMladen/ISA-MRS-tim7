package tim7.ISAMRSproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.model.Role;
import tim7.ISAMRSproject.repository.RoleRepository;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @SuppressWarnings("deprecation")
  public Role findById(Long id) {
    Role auth = this.roleRepository.getOne(id);
    return auth;
  }

  public List<Role> findByName(String name) {
	List<Role> roles = this.roleRepository.findByName(name);
    return roles;
  }


}
