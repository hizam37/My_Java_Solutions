package ru.parcel.system.entities;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;




//Jpa annotations
@Embeddable
//Lombok
@Data
//Jaxb annotaions
@XmlRootElement
public class Address  {
	
	private String city;

	private String region;

	private String street;

	private int houseNumber;

	private int aprtNumber;	

}
