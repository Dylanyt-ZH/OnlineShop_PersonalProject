package onlineshop_enity;

public class ORDER {
	private int order_id;
	private int product_id;
	private String buyer_id;
	private String puacher_time;
	private int product_amount;
	private int order_status;
	private String order_delivery;
	private String order_delivery_num;
	public ORDER(int order_id, int product_id, String buyer_id, String puacher_time, int product_amount,
			int order_status, String order_delivery, String order_delivery_num) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.buyer_id = buyer_id;
		this.puacher_time = puacher_time;
		this.product_amount = product_amount;
		this.order_status = order_status;
		this.order_delivery = order_delivery;
		this.order_delivery_num = order_delivery_num;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getPuacher_time() {
		return puacher_time;
	}
	public void setPuacher_time(String puacher_time) {
		this.puacher_time = puacher_time;
	}
	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public String getOrder_delivery() {
		return order_delivery;
	}
	public void setOrder_delivery(String order_delivery) {
		this.order_delivery = order_delivery;
	}
	public String getOrder_delivery_num() {
		return order_delivery_num;
	}
	public void setOrder_delivery_num(String order_delivery_num) {
		this.order_delivery_num = order_delivery_num;
	}
	
	
	
}
