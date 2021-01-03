package lk.ijse.spring.dto;



public class orderDTO {
    private String orderID;
    private String Orderdate;
    private String cusID;
    private String itemCode;
    private int qty;


    public orderDTO() {
    }

    public orderDTO(String orderID, String orderdate, String cusID, String itemCode, int qty) {
        this.orderID = orderID;
        Orderdate = orderdate;
        this.cusID = cusID;
        this.itemCode = itemCode;
        this.qty = qty;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderdate() {
        return Orderdate;
    }

    public void setOrderdate(String orderdate) {
        Orderdate = orderdate;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "orderDTO{" +
                "orderID='" + orderID + '\'' +
                ", Orderdate='" + Orderdate + '\'' +
                ", cusID='" + cusID + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                '}';
    }
}
