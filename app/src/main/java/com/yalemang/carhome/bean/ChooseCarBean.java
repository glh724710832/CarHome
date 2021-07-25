package com.yalemang.carhome.bean;

public class ChooseCarBean {

    private int icon;
    private String brand;
    private String title;
    private String model;

    public ChooseCarBean( String title){

        this.title = title;
    }

    public ChooseCarBean(int icon, String brand){
        this.icon = icon;
        this.brand = brand;
    }


    public ChooseCarBean(int icon,  String model,String title){
        this.icon = icon;
        this.model = model;
        this.title = title;
    }


    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
