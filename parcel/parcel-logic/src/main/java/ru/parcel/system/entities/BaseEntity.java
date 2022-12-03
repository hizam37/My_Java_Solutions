package ru.parcel.system.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import ru.parcel.system.utils.LocalDateTimeAdapter;


// JAXB Annotations
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(value = {Address.class,Creaditionals.class,Parcel.class,Transporter.class,User.class})
// JPA annotations
@MappedSuperclass
//Lombok annotation
@Data
public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlAttribute(name="id")
	protected Long id;
	
	@Version
	@XmlAttribute(name="version")
	protected Long version;
	
	@XmlAttribute(name="createdOn")
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@JsonbDateFormat(value="yyyy-MM-dd")
	protected LocalDateTime createdOn;
	
	@XmlAttribute(name="updatedOn")
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@JsonbDateFormat(value="yyyy-MM-dd")
    protected LocalDateTime updatedOn;
	
	
	@PrePersist
	private void init() {
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.updatedOn = LocalDateTime.now();
	}
	

}
