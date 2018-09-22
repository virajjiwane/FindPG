package com.example.viraj.finderpg;
/*
* A simple custom item for list view.
* Used to customize List view in TenantCityDetailsActivity
* Refer HostelAdapter.java
*
* */
class HostelItem {
    String name,type,addr;
    int price;
    int noOfBeds;
    /*
    * include PG_ID but keep it hidden
    * use Address object. It will be very helpful
    *
    * */
    public HostelItem(String name, String type, String addr, int price, int noOfBeds) {
        this.name = name;
        this.type = type;
        this.addr = addr;
        this.price = price;
        this.noOfBeds = noOfBeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }
}
