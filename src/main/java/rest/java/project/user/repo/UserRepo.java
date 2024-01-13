package rest.java.project.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.java.project.user.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
