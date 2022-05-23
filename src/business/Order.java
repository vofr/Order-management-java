package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6838746804034102284L;
	private int orderId;
    private static int ordersNumber = 1;
    private int clientId;
    private LocalDateTime date;
    private int price;

    public Order(int clientId, int totalPrice){
        this.clientId = clientId;
        this.orderId = ordersNumber;
        ordersNumber++;
        this.date = LocalDateTime.now();
        this.price = totalPrice;
    }

	public int getOrderId() {
		return orderId;
	}

	public static int getOrdersNumber() {
		return ordersNumber;
	}

	public int getClientId() {
		return clientId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, date, orderId, price);
	}

}