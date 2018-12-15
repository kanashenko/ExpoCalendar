/**
 * @version 1.0
 *
 * @date Sep 2, 2018
 *
 * Copyright by Mykyta Kanashchenko
 */
package entity;

import java.time.LocalDate;

public class Exhibition implements Comparable<Exhibition> {
	
	private int exhibitionId;
	private String exhibitionName;
	private int price;
	private LocalDate exhibStart;
	private LocalDate exhibEnd;
	
	public Exhibition() {
	}
			
	public Exhibition(int exhibitionId) {
		super();
		this.exhibitionId = exhibitionId;
	}

	public int getExhibId() {
		return exhibitionId;
	}

	public void setExhibId(int id) {
		this.exhibitionId = id;
	}

	public String getExhibitionName() {
		return exhibitionName;
	}

	public void setExhibitionName(String exhibitionName) {
		this.exhibitionName = exhibitionName;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getExhibStart() {
		return exhibStart;
	}

	public void setExhibStart(LocalDate exhibStart) {
		this.exhibStart = exhibStart;
	}

	public LocalDate getExhibEnd() {
		return exhibEnd;
	}

	public void setExhibEnd(LocalDate exhibEnd) {
		this.exhibEnd = exhibEnd;
	}

	@Override
	public int hashCode() {
		int result = 31 * Integer.hashCode(exhibitionId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Exhibition))
			return false;
		Exhibition other = (Exhibition) obj;
		return this.exhibitionId == other.exhibitionId;
	}

	@Override
	public String toString() {
		return "Exhibition [exhibitionId=" + exhibitionId + ", exhibitionName=" + exhibitionName + ", price=" + price
				+ ", exhibitionTime= from " + exhibStart + " to " + exhibEnd + "]";
	}

	public int compareTo(Exhibition obj) {
		return String.valueOf(exhibStart).compareTo(String.valueOf(obj.exhibStart));
	}

	

	

	

}
