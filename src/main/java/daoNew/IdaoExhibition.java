/**
 * IdaoExhibition.java
 *
 * @version 1.0
 *
 * @date Nov 28, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package daoNew;

import java.util.List;
import entity.Exhibition;

public interface IdaoExhibition {
	void addExhibition(Exhibition exhibition);
	void updateExhibitionDynamically(String sql, Object... values);
	
	Exhibition findExhibitionbyName(String name);
	List<Exhibition> findAllExhibitions();
	List<Exhibition> findExhibitionsDynamically(String sql, Object... values);
}
