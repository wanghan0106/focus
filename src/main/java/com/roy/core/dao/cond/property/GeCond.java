package com.roy.core.dao.cond.property;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.roy.core.dao.cond.Cond;

public class GeCond extends PropertyCond {
	public GeCond(final String property,final Object value) {
		super(property,value);
	}
	
	@Override
	public Cond clone() {
		return new GeCond(property,value);
	}
	
	@Override
	public Criterion toCriterion() {
		return Restrictions.ge(property, value);
	}

}
