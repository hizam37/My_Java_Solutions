package ru.parcel.system.entities;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.parcel.system.utils.LocalDateAdapter;

//Lombok
@Data
@EqualsAndHashCode(callSuper = true)
//Jaxb
@XmlRootElement(name = "Parcel")

//Jpa
@Entity
@NamedQueries({ @NamedQuery(name = Parcel.FIND_ALL, query = "SELECT p FROM Parcel p"),
		@NamedQuery(name = Parcel.FIND_BY_ID, query = "SELECT p FROM Parcel p where p.id=:id"), })
public class Parcel extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Parcel.findAll";
	public static final String FIND_BY_ID = "Parcel.findById";

	@NotEmpty
	private String PRCL; // this filed will be generated auto

	@Positive(message = "The departure post code must be a positive number")
	@Digits(integer = 6, fraction = 0, message = "The departure post code value must be six digits or more")
	private int departurePostCode; // the post code of departure point

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@JsonbDateFormat(value = "yyyy-MM-dd")
	private LocalDate departureDate;

	@Positive
	@Min(value = 1, message = "The attachments must be set (min 1 attachment)")
	private int attachmentsNumber;

	@Positive(message = "The package price must be positive")
	private double packageValue;

	@OneToOne
	@JoinColumn(name = "SENDER_ID")
	@XmlElement(name = "Sender")
	private User sender;

	@OneToOne
	@JoinColumn(name = "RECIPIENT_ID")
	@XmlElement(name = "Recipient")
	private User recipient;

	@OneToOne
	@JoinColumn(name = "TRANSPORTER_ID")
	private Transporter transporter;

	@PrePersist
	private void parcelPrePersist() {
		this.PRCL = "PRCL - " + this.getId();
	}

}
