package onlineshop_enity;

public class CART {
	private int cart_id;
	private String cart_p_filename;
	private String cart_p_name;
	private float cart_price;
	private int cart_quantity;
	private int cart_p_stock;
	private int cart_p_id;
	private String cart_u_id;
	private int cart_status;
	public CART(int cart_id, String cart_p_filename, String cart_p_name, float cart_price, int cart_quantity,
			int cart_p_stock, int cart_p_id, String cart_u_id, int cart_status) {
		super();
		this.cart_id = cart_id;
		this.cart_p_filename = cart_p_filename;
		this.cart_p_name = cart_p_name;
		this.cart_price = cart_price;
		this.cart_quantity = cart_quantity;
		this.cart_p_stock = cart_p_stock;
		this.cart_p_id = cart_p_id;
		this.cart_u_id = cart_u_id;
		this.cart_status = cart_status;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getCart_p_filename() {
		return cart_p_filename;
	}
	public void setCart_p_filename(String cart_p_filename) {
		this.cart_p_filename = cart_p_filename;
	}
	public String getCart_p_name() {
		return cart_p_name;
	}
	public void setCart_p_name(String cart_p_name) {
		this.cart_p_name = cart_p_name;
	}
	public float getCart_price() {
		return cart_price;
	}
	public void setCart_price(float cart_price) {
		this.cart_price = cart_price;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public int getCart_p_stock() {
		return cart_p_stock;
	}
	public void setCart_p_stock(int cart_p_stock) {
		this.cart_p_stock = cart_p_stock;
	}
	public int getCart_p_id() {
		return cart_p_id;
	}
	public void setCart_p_id(int cart_p_id) {
		this.cart_p_id = cart_p_id;
	}
	public String getCart_u_id() {
		return cart_u_id;
	}
	public void setCart_u_id(String cart_u_id) {
		this.cart_u_id = cart_u_id;
	}
	public int getCart_status() {
		return cart_status;
	}
	public void setCart_status(int cart_status) {
		this.cart_status = cart_status;
	}
}
