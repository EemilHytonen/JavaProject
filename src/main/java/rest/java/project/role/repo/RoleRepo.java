package rest.java.project.role.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.java.project.role.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
