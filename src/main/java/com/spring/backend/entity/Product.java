package com.spring.backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduct ;
    @Column(name = "name")
    private String name ;
    @Column(name = "price")
    private int price ;
    @Column(name = "status")
    private String status ;
    @Column(name = "priceSale")
    private int priceSale ;
    @Column(name = "thumbnail")
    private String thumbnail ;
    @Column(name = "color")
    private String color ;
    @Column(name = "size")
    private String size ;
    @Column(name = "type_shoe")
    private String typeShoe ;
    @Column(name = "inforProduct")
    private String inforProduct ;
    @Column(name = "description")
    private String description ;
    @JoinColumn(name = "branch_id")
    @ManyToOne
    private Branch branch ;

    @OneToMany(mappedBy = "product")
    private List<Image> listImage ;

    @OneToMany(mappedBy = "product")
    private List<DetailOrder> listDetailProduct ;
    public Product() {

    }

    public Product( String name, int price, String status, int priceSale, String thumbnail, String color, String size, String typeShoe, String inforProduct, String description, Branch branch, List<Image> listImage, List<DetailOrder> listDetailProduct) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.priceSale = priceSale;
        this.thumbnail = thumbnail;
        this.color = color;
        this.size = size;
        this.typeShoe = typeShoe;
        this.inforProduct = inforProduct;
        this.description = description;
        this.branch = branch;
        this.listImage = listImage;
        this.listDetailProduct = listDetailProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(int priceSale) {
        this.priceSale = priceSale;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTypeShoe() {
        return typeShoe;
    }

    public void setTypeShoe(String typeShoe) {
        this.typeShoe = typeShoe;
    }

    public String getInforProduct() {
        return inforProduct;
    }

    public void setInforProduct(String inforProduct) {
        this.inforProduct = inforProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<Image> getListImage() {
        return listImage;
    }

    public void setListImage(List<Image> listImage) {
        this.listImage = listImage;
    }

    public List<DetailOrder> getListDetailProduct() {
        return listDetailProduct;
    }

    public void setListDetailProduct(List<DetailOrder> listDetailProduct) {
        this.listDetailProduct = listDetailProduct;
    }
}
