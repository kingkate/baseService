package com.baseService.designmodel.elevator;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ElevatorService {
	
	private int layerSize;
	private int[] layers = new int[layerSize];
	
	private Set<Integer> set = new TreeSet<>();
	
	private List<Elevator> elevators;
	
	public ElevatorService(int layerSize,List<Elevator> elevators) {
		this.layerSize = layerSize;
		this.elevators = elevators;
	}
	
	private void initLayers(){
		for(int i=0;i<layers.length;i++){
			layers[i] = i+1;
		}
	}

	public void start(){
		initLayers();
	}
	
	public void stop(){
		elevators = null;
	}
	
	public void service(int layer) {
		set.add(layer);
		this.notifyAll();
		while (null !=elevators) {
			while (set.size() == 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
				}
				distributeRequest(elevators,set);
			}
			
		}
		System.out.println("控制器已经停止服务！");
	}

	private void distributeRequest(List<Elevator> elevators2, Set<Integer> set2) {
			
	}


	public List<Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(List<Elevator> elevators) {
		this.elevators = elevators;
	}
	
	
	
}
