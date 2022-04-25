package com.matbustamant.beportfolio.security.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="user")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@NotNull
	@Column(name="username", unique = true)
	private String username;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotNull
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<Role>();

	public User(String name, String username, String email, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User() {
	}
}
