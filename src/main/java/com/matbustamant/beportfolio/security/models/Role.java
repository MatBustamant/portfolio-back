package com.matbustamant.beportfolio.security.models;

import com.matbustamant.beportfolio.security.enums.RoleName;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="role")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Short id;
	
	@NotNull(message="Nombre no puede ser null.")
	@Enumerated(EnumType.STRING)
	@Column(name="role_name")
	private RoleName roleName;

	public Role(RoleName roleName) {
		this.roleName = roleName;
	}

	public Role() {
	}
}
