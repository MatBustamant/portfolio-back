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
	
	@NotNull(message="Nombre no puede ser null.")
	@Column(name="name", unique=true)
	private String name;
	
	@NotNull(message="Apellido no puede ser null.")
	@Column(name="surname")
	private String surname;
	
	@NotNull(message="Email no puede ser null.")
	@Column(name="email")
	private String email;
	
	@NotNull(message="Contraseña no puede ser null.")
	@Column(name="password")
	private String password;
	
	@NotNull(message="Roles no pueden ser null.")
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();

	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	
	public User() {
	}

}
