package ru.parcel.system.dao;

import javax.ejb.Stateless;

import ru.parcel.system.entities.Parcel;

@Stateless
public class ParcelEJB extends BaseEJB<Parcel> {

	public ParcelEJB() {
		super(Parcel.class);
	}

}
