package business;

public class BaseProduct implements MenuItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6398618787439004303L;

    private String name;
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int orderedTimes;
    
    public BaseProduct(String name, float rating, int calories, int protein, int fat, int sodium, int price) {
    	this.name=name;
    	this.rating=rating;
    	this.calories=calories;
    	this.protein=protein;
    	this.fat=fat;
    	this.sodium=sodium;
    	this.price=price;
    	this.orderedTimes=0;
	}

	@Override
	public String toString() {
        return 
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +"\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setOrderedTimes() {
		this.orderedTimes ++;
	}

	public float getRating() {
		return rating;
	}

	public int getCalories() {
		return calories;
	}

	public int getProtein() {
		return protein;
	}

	public int getFat() {
		return fat;
	}

	public int getSodium() {
		return sodium;
	}

	public int getPrice() {
		return price;
	}

	public int getOrderedTimes() {
		return orderedTimes;
	}

	@Override
	public void modifyProduct(BaseProduct product) {
		setName(product.getName());
		setRating(product.getRating());
		setCalories(product.getCalories());
		setProtein(product.getProtein());
		setFat(product.getFat());
		setSodium(product.getSodium());
		setPrice(product.getPrice());
		
	}

	@Override
	public boolean contains(String text) {
		if(getName().contains(text))
			return true;
		return false;
	}

}
