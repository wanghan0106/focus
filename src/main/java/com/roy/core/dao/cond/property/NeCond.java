package com.roy.core.dao.cond.property;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.roy.core.dao.cond.Cond;

public class NeCond extends PropertyCond {
	public NeCond(final String property,final Object value) {
		super(property,value);
	}
	
	@Override
	public Cond clone() {
		return new NeCond(property,value);
	}
	
	@Override
	public Criterion toCriterion() {
		if(value == null) {
			return Restrictions.isNotNull(property);
		}
		return Restrictions.ne(property, value);
	}

}
