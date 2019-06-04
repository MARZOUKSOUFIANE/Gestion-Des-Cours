package org.glsid.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.glsid.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{

	private User user;
	
	
	public UserPrincipal(User user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		
		// Extract list of permissions (name)
		user.getPermissionList().forEach(p->{
			GrantedAuthority authority=new SimpleGrantedAuthority(p);
			authorities.add(authority);
		});
		
		// Extract list of roles (ROLE_name)
		user.getRoleList().forEach(r->{
			GrantedAuthority role=new SimpleGrantedAuthority("ROLE_" + r);
			authorities.add(role);
		});
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
