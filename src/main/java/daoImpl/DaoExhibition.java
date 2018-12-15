/**
 * DaoExhibition.java
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
import daoNew.IdaoExhibition;
import entity.Exhibition;

public class DaoExhibition implements IdaoExhibition {
	
	private static DaoExhibition instance;
	
	public static DaoExhibition getInstance(){
        if(instance == null){
            instance = new DaoExhibition();
        }
        return instance;
    }
	
	@Override
	public void addExhibition(Exhibition exhibition) {
		String SQL = "INSERT INTO exhibition (exhibitionName, price, exhibStart, exhibEnd) values (?,?,?,?)";
		updateExhibitionDynamically(SQL, exhibition.getExhibitionName(), exhibition.getPrice(),exhibition.getExhibStart(), exhibition.getExhibEnd());
	}
	
	@Override
	public void updateExhibitionDynamically(String sql, Object... values) {
		DaoUtil.updateDynamically(sql, values);
	}

	@Override
	public Exhibition findExhibitionbyName(String exhibitionName)
	{
		String SQL = "SELECT * FROM exhibition WHERE exhibitionName = ?";
		List<Exhibition> exhibition = findExhibitionsDynamically(SQL, exhibitionName);
		if(exhibition.size()>0) {
			return exhibition.get(0);
		}
		return null;
	}
	
	@Override
	public List<Exhibition> findAllExhibitions(){
		String SQL = "SELECT * FROM exhibition ORDER BY exhibStart";
		List<Exhibition> exhibitions = findExhibitionsDynamically(SQL);
		if(exhibitions.size()>0) {
			return exhibitions;
		}
		return null;
	}
	
	@Override
    public List<Exhibition> findExhibitionsDynamically(String sql, Object... values) {
		 return DaoUtil.findDynamically(DaoUtil.ObjectType.Exhibition,sql,values);
    }
}
