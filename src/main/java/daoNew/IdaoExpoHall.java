/**
 * IdaoExpoHall.java
 *
 * @version 1.0
 *
 * @date Nov 28, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoNew;

import java.util.List;
import entity.ExpoHall;

public interface IdaoExpoHall {	
	void addExpoHall(ExpoHall expoHall);
	void updateExpoHallDynamically(String sql, Object... values);
	
	List<ExpoHall> findExpoHallsbyId(int exhibitionId);
	List<ExpoHall> findExpoHallsDynamically(String sql, Object... values);
}
