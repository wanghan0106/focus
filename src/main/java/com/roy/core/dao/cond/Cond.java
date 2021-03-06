package com.roy.core.dao.cond;

import org.hibernate.criterion.Criterion;

import com.roy.core.dao.cond.logic.AndCond;
import com.roy.core.dao.cond.logic.NotCond;
import com.roy.core.dao.cond.logic.OrCond;
import com.roy.core.dao.cond.property.EqCond;
import com.roy.core.dao.cond.property.GeCond;
import com.roy.core.dao.cond.property.GtCond;
import com.roy.core.dao.cond.property.ILikeCond;
import com.roy.core.dao.cond.property.InCond;
import com.roy.core.dao.cond.property.LeCond;
import com.roy.core.dao.cond.property.LikeCond;
import com.roy.core.dao.cond.property.LtCond;
import com.roy.core.dao.cond.property.NeCond;

public abstract class Cond {
	
	public static Cond and(Cond left,Cond right) {
		return new AndCond(left,right);
	}
	
	public static Cond or(Cond left,Cond right) {
		return new OrCond(left,right);
	}
	
	public static Cond not(Cond cond) {
		return new NotCond(cond);
	}
	
	public static Cond eq(String property,Object value) {
		return new EqCond(property,value);
	}
	
	public static Cond ne(String property,Object value) {
		return new NeCond(property,value);
	}
	
	public static Cond lt(String property,Object value) {
		return new LtCond(property,value);
	}
	
	public static Cond le(String property,Object value) {
		return new LeCond(property,value);
	}
	
	public static Cond gt(String property,Object value) {
		return new GtCond(property,value);
	}
	
	public static Cond ge(String property,Object value) {
		return new GeCond(property,value);
	}
	
	public static Cond like(String property,String value) {
		return new LikeCond(property,value);
	}
	
	public static Cond ilike(String property,String value) {
		return new ILikeCond(property,value);
	}
	
	public static Cond in(String property,Object[] values) {
		return new InCond(property,values);
	}
	
	public Cond and(Cond c) {
		return new AndCond(this,c);
	}
	
	public Cond or(Cond c) {
		return new OrCond(this,c);
	}
	
	public abstract Cond clone();
	
	public abstract Criterion toCriterion();
}
