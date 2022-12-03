package ru.parcel.system.dao;

import javax.ejb.Stateless;

import ru.parcel.system.entities.User;

@Stateless
public class UserEJB extends BaseEJB<User> {

	public UserEJB() {
		super(User.class);

	}

	// Here we can add any unique methods for this class
	

}
