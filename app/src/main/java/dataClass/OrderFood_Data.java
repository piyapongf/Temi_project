package dataClass;

//keep data for Orderfood page
public class OrderFood_Data {
    //this page shows image, name and category of store
    String name_store;
    String category_store;
    String picture_store;
    //Integer picture_store;

    //this keep image, name and category of store from Database
    public OrderFood_Data(String name_store,String category_store,String picture_store){
        this.name_store = name_store;
        this.category_store = category_store;
        this.picture_store = picture_store;
    }

    public OrderFood_Data(){

    }


    public String getName_store() {
        return name_store;
    }

    public void setName_store(String name_store) {
        this.name_store = name_store;
    }

    public String getCategory_store() {
        return category_store;
    }

    public void setCategory_store(String category_store) {
        this.category_store = category_store;
    }

    public  String getPicture_store(){
        return picture_store;
    }

    public void setPicture_store(String picture_store) {
        this.picture_store = picture_store;
    }
}
