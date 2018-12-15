/**
 * DaoExpoHall.java
 *
 * @version 1.0
 *
 * @date Nov 28, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoImpl;

import java.util.List;
import daoNew.DaoUtil;
import daoNew.IdaoExpoHall;
import entity.ExpoHall;

public class DaoExpoHall implements IdaoExpoHall {
	private static DaoExpoHall instance;	
	private DaoExpoHall() {}
		
	public static DaoExpoHall getInstance(){
        if(instance == null){
            instance = new DaoExpoHall();
        }
        return instance;
    }
	
	@Override
	public void addExpoHall(ExpoHall expoHall) {
		String SQL = "insert into ExpoHall (expoHallName, expo_exhibitionId ) values (?,?)";
		updateExpoHallDynamically(SQL, expoHall.getExpoHallName(), expoHall.getExpo_exhibitionId());
	}
	
	@Override
	public void updateExpoHallDynamically(String sql, Object... values) {
		DaoUtil.updateDynamically(sql, values);
	}
	
	@Override
	public List<ExpoHall> findExpoHallsbyId(int exhibitionId){
		String SQL = "SELECT * FROM expoHall WHERE expo_exhibitionId = ?";
		List<ExpoHall> expoHalls = findExpoHallsDynamically(SQL, exhibitionId);
		if(expoHalls.size()>0) {
			return expoHalls;
		}
		return null;		
	}
	
	@Override
	public List<ExpoHall> findExpoHallsDynamically(String sql, Object... values){
		return DaoUtil.findDynamically(DaoUtil.ObjectType.ExpoHall,sql,values);
	}
}
