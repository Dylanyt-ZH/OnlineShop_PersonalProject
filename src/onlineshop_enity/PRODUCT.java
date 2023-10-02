package onlineshop_enity;

public class PRODUCT {
	private int PRODUCT_ID;
	private String PRODUCT_NAME;
	private String PRODUCT_DESCRIPTION;
	private float PRODUCT_PRICE;
	private int PRODUCT_STOCK;
	private int PRODUCT_FID;
	private int PRODUCT_CID;
	private String PRODUCT_PICTURE;
	public PRODUCT(int pRODUCT_ID, String pRODUCT_NAME, String pRODUCT_DESCRIPTION, float pRODUCT_PRICE,
			int pRODUCT_STOCK, int pRODUCT_FID, int pRODUCT_CID, String pRODUCT_PICTURE) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		PRODUCT_NAME = pRODUCT_NAME;
		PRODUCT_DESCRIPTION = pRODUCT_DESCRIPTION;
		PRODUCT_PRICE = pRODUCT_PRICE;
		PRODUCT_STOCK = pRODUCT_STOCK;
		PRODUCT_FID = pRODUCT_FID;
		PRODUCT_CID = pRODUCT_CID;
		PRODUCT_PICTURE = pRODUCT_PICTURE;
	}
	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getPRODUCT_DESCRIPTION() {
		return PRODUCT_DESCRIPTION;
	}
	public void setPRODUCT_DESCRIPTION(String pRODUCT_DESCRIPTION) {
		PRODUCT_DESCRIPTION = pRODUCT_DESCRIPTION;
	}
	public float getPRODUCT_PRICE() {
		return PRODUCT_PRICE;
	}
	public void setPRODUCT_PRICE(float pRODUCT_PRICE) {
		PRODUCT_PRICE = pRODUCT_PRICE;
	}
	public int getPRODUCT_STOCK() {
		return PRODUCT_STOCK;
	}
	public void setPRODUCT_STOCK(int pRODUCT_STOCK) {
		PRODUCT_STOCK = pRODUCT_STOCK;
	}
	public int getPRODUCT_FID() {
		return PRODUCT_FID;
	}
	public void setPRODUCT_FID(int pRODUCT_FID) {
		PRODUCT_FID = pRODUCT_FID;
	}
	public int getPRODUCT_CID() {
		return PRODUCT_CID;
	}
	public void setPRODUCT_CID(int pRODUCT_CID) {
		PRODUCT_CID = pRODUCT_CID;
	}
	public String getPRODUCT_PICTURE() {
		return PRODUCT_PICTURE;
	}
	public void setPRODUCT_PICTURE(String pRODUCT_PICTURE) {
		PRODUCT_PICTURE = pRODUCT_PICTURE;
	}
	
	
}

