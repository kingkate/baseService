package com.baseService.designmodel.elevator;

import java.io.Serializable;

public class Elevator implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1131454099698646953L;
	private int status;//0 打开 1 关闭  3 运行 4 停止
	private byte direction;//0 向下 1 向上
	private int layer;//所在楼层
	private boolean isEnable;//是否可用  0 不可用 1 可用
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public byte getDirection() {
		return direction;
	}
	public void setDirection(byte direction) {
		this.direction = direction;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	@Override
	public String toString() {
		return "Elevator [status=" + status + ", direction=" + direction
				+ ", layer=" + layer + ", isEnable=" + isEnable + "]";
	}
}
