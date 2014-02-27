package com.roy.core.dao.cond.property;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.roy.core.dao.cond.Cond;


public class InCond extends PropertyCond {
	public InCond(final String property,final Object[] values) {
		super(property,values);
	}
	
	@Override
	public Cond clone() {
		return new InCond(property,(Object[]) value);
	}
	
	@Override
	public Criterion toCriterion() {
		return Restrictions.in(property, (Object[]) value);
	}
	
}
