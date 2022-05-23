package business;

import java.util.List;

public interface DeliveryProcessing {
	
    void PlaceOrder(Order order);//cleint
    

    void ModifyProduct(MenuItem product);//admin
    void CreateDailyMenu(String product1, String product2, String product3, String product4);
    void GenerateRaports();
    List<MenuItem> ImportProducts();
    void AddProduct(MenuItem product);
    void DeleteProduct(MenuItem product);
}
