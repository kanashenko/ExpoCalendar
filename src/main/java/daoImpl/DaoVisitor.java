/**
 * DaoVisitor.java
 *
 * @version 1.0
 *
 * @date Oct 8, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoImpl;

import java.util.List;

import dao.DaoUtil;
import dao.IdaoVisitor;
import entity.Visitor;

public class DaoVisitor implements IdaoVisitor {
	
	private static DaoVisitor instance;

	private DaoVisitor(){}
	
	public static DaoVisitor getInstance(){
        if(instance == null){
            instance = new DaoVisitor();
        }
        return instance;
    }
	
	@Override
	public void addVisitor(Visitor visitor) {
		String SQL = "INSERT INTO visitor (visitorName, login, password, isAdmin) values (?,?,?,?)";
		updateVisitorDynamically(SQL, visitor.getName(), visitor.getLogin(), visitor.getPass(), visitor.isAdmin());
	}

	@Override
	public void updateVisitorDynamically(String sql, Object... values) {
		DaoUtil.updateDynamically(sql, values);
	}

	@Override
	public Visitor findVisitorbyLogin(String uname)
	{
		String SQL = "SELECT * FROM visitor WHERE login = ?";
		List<Visitor> visitors = findVisitorsDynamically(SQL, uname);
		if(visitors.size()>0) {
			return visitors.get(0);
		}
		return null;
	}
	
	@Override
    public List<Visitor> findVisitorsDynamically(String sql, Object... values) {
		 return DaoUtil.findDynamically(DaoUtil.ObjectType.Visitor,sql,values);
    }
}
