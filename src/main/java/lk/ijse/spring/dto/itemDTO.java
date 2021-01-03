package lk.ijse.spring.dto;

import java.math.BigDecimal;

public class itemDTO {
    private String id;
    private String name;
    private int QTY;
    private BigDecimal price;

    public itemDTO() {
    }

    public itemDTO(String id, String name, int QTY, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.QTY = QTY;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "itemDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", QTY=" + QTY +
                ", price=" + price +
                '}';
    }
}
