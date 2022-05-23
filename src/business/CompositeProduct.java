package business;

public class CompositeProduct implements MenuItem {
//daily menus
	/**
	 * 
	 */
	private static final long serialVersionUID = -5925076595280048059L;

	private String name;
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int orderedTimes;
    public CompositeProduct() {
    	this.name="";
    	this.rating=0;
    	this.calories=0;
    	this.protein=0;
    	this.fat=0;
    	this.sodium=0;
    	this.price=0;
    	this.orderedTimes=0;
	}
	public void setName(String name) {
		this.name = this.name+" & "+name;
	}
	public void setRating(float rating) {
		this.rating += rating;
	}
	public void setCalories(int calories) {
		this.calories += calories;
	}
	public void setProtein(int protein) {
		this.protein += protein;
	}
	public void setFat(int fat) {
		this.fat += fat;
	}
	public void setSodium(int sodium) {
		this.sodium += sodium;
	}
	public void setPrice(int price) {
		this.price += price;
	}
	public void setOrderedTimes() {
		this.orderedTimes ++;
	}
    
    public void addProduct(BaseProduct product){
        setName(product.getName());
        setRating(product.getRating());
        setCalories(product.getCalories());
        setProtein(product.getProtein());
        setFat(product.getFat());
        setSodium(product.getSodium());
        setPrice(product.getPrice());
    }
	public String getName() {
		return name;
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(String text) {
		if(getName().contains(text))
			return true;
		return false;
	}
    
}
