package com.roy.core.dao.cond.logic;

import com.roy.core.dao.cond.Cond;

public abstract class LogicCond extends Cond {
	protected Cond left;
	protected Cond right;
	
	LogicCond(final Cond left,final Cond right) {
		this.left = left;
		this.right = right;
	}

	public Cond getLeft() {
		return left;
	}

	public void setLeft(Cond left) {
		this.left = left;
	}

	public Cond getRight() {
		return right;
	}

	public void setRight(Cond right) {
		this.right = right;
	}
}
