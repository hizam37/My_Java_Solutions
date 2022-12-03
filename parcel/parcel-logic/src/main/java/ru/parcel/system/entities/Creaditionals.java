package ru.parcel.system.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.parcel.system.utils.EncryptUtils;

// jaxb
@XmlRootElement(name = "Creaditionals")
// Lombok
@Data
@EqualsAndHashCode(callSuper = true)
//Jpa
@Entity
@NamedQueries({ @NamedQuery(name = Creaditionals.FIND_ALL, query = "SELECT c FROM Creaditionals c"),
		@NamedQuery(name = Creaditionals.FIND_BY_ID, query = "SELECT c FROM Creaditionals c where c.id=:id"), })
public class Creaditionals extends BaseEntity {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Creaditionals.findAll";
	public static final String FIND_BY_ID = "Creaditionals.findById";

	@NotEmpty(message = "Username must be set")
	@NotNull
	private String userName;

	@NotEmpty(message = "Username must be set")
	@NotNull
	private String password;

	// Hash the password before store it to db
	@PrePersist
	private void init() {
		this.password = EncryptUtils.encrypt(this.getPassword());
	}

}
