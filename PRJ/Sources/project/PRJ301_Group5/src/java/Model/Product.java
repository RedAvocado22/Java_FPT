/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Anh Tuan
 */
public class Product {

    private int productID;
    private String title, description, thumbnail;
    private int price;
    private int quantity;
    private int sizeID;
    private String sizeName;
    private int brandID;
    private String brandName;
    private int categoryID;
    private String categoryName;
    private String productGender;

    public Product() {
    }

    public Product(int productID, String title, String description, String thumbnail, int price, int quantity, int sizeID, String sizeName, int brandID, String brandName, int categoryID, String categoryName, String productGender) {
        this.productID = productID;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.quantity = quantity;
        this.sizeID = sizeID;
        this.sizeName = sizeName;
        this.brandID = brandID;
        this.brandName = brandName;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.productGender = productGender;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductGender() {
        return productGender;
    }

    public void setProductGender(String productGender) {
        this.productGender = productGender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("productID=").append(productID);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", thumbnail=").append(thumbnail);
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append(", sizeID=").append(sizeID);
        sb.append(", sizeName=").append(sizeName);
        sb.append(", brandID=").append(brandID);
        sb.append(", brandName=").append(brandName);
        sb.append(", categoryID=").append(categoryID);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", productGender=").append(productGender);
        sb.append('}');
        return sb.toString();
    }

}
