package business;

import java.io.Serializable;

public interface MenuItem extends Serializable{

	public void setName(String name);
	public void setRating(float rating);
	public void setCalories(int calories);
	public void setProtein(int protein);
	public void setFat(int fat);
	public void setSodium(int sodium);
	public void setPrice(int price);
	public void setOrderedTimes();
    
    
	public String getName();
	public float getRating();
	public int getCalories();
	public int getProtein();
	public int getFat();
	public int getSodium();
	public int getPrice();
	public int getOrderedTimes();
	void modifyProduct(BaseProduct product);
	public boolean contains(String text);
}
