package ru.parcel.system.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ru.parcel.system.entities.Transporter;

@Stateless
@LocalBean
public class TransporterEJB extends BaseEJB<Transporter> {

	public TransporterEJB() {
		super(Transporter.class);
	}
}
