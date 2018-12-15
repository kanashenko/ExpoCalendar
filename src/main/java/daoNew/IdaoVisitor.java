/**
 * IdaoVisitor.java
 *
 * @version 1.0
 *
 * @date Oct 8, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoNew;

import java.util.List;
import entity.Visitor;

public interface IdaoVisitor {
	void addVisitor(Visitor visitor);
	Visitor findVisitorbyLogin(String uname);
	void updateVisitorDynamically(String sql, Object... values);
    List<Visitor> findVisitorsDynamically(String sql, Object... values); 
}
