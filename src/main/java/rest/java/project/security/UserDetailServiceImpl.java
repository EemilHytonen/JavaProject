package rest.java.project.security;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rest.java.project.role.entity.Role;
import rest.java.project.user.entity.User;
import rest.java.project.user.repo.UserRepo;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found for email " + username);
		}
		
		System.out.println("User roles: " + user.getRoles());
		
		Iterator<Role> roleIterator = user.getRoles().iterator();
		while(roleIterator.hasNext()) {
			System.out.println(roleIterator.next().getName());
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
	}

}
