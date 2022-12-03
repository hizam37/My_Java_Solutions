package ru.parcel.system.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;

//Lombok
@Data
@EqualsAndHashCode(callSuper = true)
//Jaxb
@XmlRootElement(name = "Transporter")
//Jpa
@Entity
@NamedQueries({ @NamedQuery(name = Transporter.FIND_ALL, query = "SELECT t FROM Transporter t"),
		@NamedQuery(name = Transporter.FIND_BY_ID, query = "SELECT t FROM Transporter t where t.id=:id"), })
public class Transporter extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Transporter.findAll";
	public static final String FIND_BY_ID = "Transporter.findById";

	@NotEmpty(message = "Transporter name must be set")
	private String transporterName;

	@Positive(message = "The INN must be a positive number")
	@Digits(integer = 12, fraction = 0)
	private int transporterINN;

	@Positive(message = "The INN must be a positive number")
	@Digits(integer = 9, fraction = 0)
	private int transporterKPP;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CREADITIONALS_ID")
	private Creaditionals creaditionals;

}
