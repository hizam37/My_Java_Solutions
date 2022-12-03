package ru.parcel.system.entities;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.parcel.system.utils.LocalDateAdapter;

// Lombok
@Data
@EqualsAndHashCode(callSuper = true)
// Jaxb
@XmlRootElement(name = "User")
//Jpa
@Entity(name = "Users")
@NamedQueries({ @NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM Users u"),
		@NamedQuery(name = User.FIND_BY_ID, query = "SELECT u FROM Users u where u.id = :id"), })
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "User.findAll";
	public static final String FIND_BY_ID = "User.findById";

	@NotEmpty(message = "Name cannot be empty")
	private String fullName;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@JsonbDateFormat(value = "yyyy-MM-dd")
	@Past(message = "Date of birth must be in the past")
	private LocalDate dateOfBirth;

	@NotNull(message = "Passport number must be set!")
	private String passportNumber;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@PastOrPresent(message = "Issue date of passport must be in the past or present")
	@JsonbDateFormat(value = "yyyy-MM-dd")
	private LocalDate passportDateOfIssue;

	@Embedded
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CREADITIONALS_ID")
	private Creaditionals creaditionals;

}
