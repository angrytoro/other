package com.pjxy.wap.util.ubb;

import java.util.ArrayList;
import java.util.List;

public class UbbTree {
	private UbbType type;
	private Object[] args;
	private List<UbbTree> children;

	private static final List<UbbTree> EMPTY_TREE = new ArrayList<UbbTree>();

	public UbbTree(UbbType type, Object... args) {
		this.type = type;
		this.args = args;
	}

	public void addChild(UbbTree ubbTree) {
		if (children == null) {
			children = new ArrayList<UbbTree>();
		}
		children.add(ubbTree);
	}

	public UbbType getType() {
		return type;
	}

	public Object[] getArgs() {
		return args;
	}

	public List<UbbTree> getChildren() {
		return children == null ? EMPTY_TREE : children;
	}

}
