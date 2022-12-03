package ru.parcel.system.dao;

import javax.ejb.Stateless;

import ru.parcel.system.entities.Creaditionals;

@Stateless
public class CreaditinalsEJB extends BaseEJB<Creaditionals> {

	public CreaditinalsEJB() {
		super(Creaditionals.class);
	}

}
