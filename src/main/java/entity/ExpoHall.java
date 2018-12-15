/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package entity;

public class ExpoHall {
	
	private int expoHallId;
	private String expoHallName;
	private int expo_exhibitionId;
	
	public int getExpoHallId() {
		return expoHallId;
	}
	
	public void setExpoHallId(int expoHallId) {
		this.expoHallId = expoHallId;
	}
	
	public String getExpoHallName() {
		return expoHallName;
	}
	
	public void setExpoHallName(String expoHallName) {
		this.expoHallName = expoHallName;
	}
	
	public int getExpo_exhibitionId() {
		return expo_exhibitionId;
	}
	
	public void setExpo_exhibitionId(int exhibitionId) {
		this.expo_exhibitionId = exhibitionId;
	}
	
	@Override
	public int hashCode() {
		int result = 31 * Integer.hashCode(expoHallId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ExpoHall))
			return false;
		ExpoHall other = (ExpoHall) obj;
		return this.expoHallId == other.expoHallId;
	}
	
	@Override
	public String toString() {
		return "ExpoHall [expoHallId=" + expoHallId + ", expoHallName=" + expoHallName + "]";
	}
	
}
