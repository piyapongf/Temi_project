package dataClass;

//keep data for Basket page
public class OrderFood_Basket_Data {
    String name_menu;
    int price_menu;

    //this keep image, name and category of store from Database
    public OrderFood_Basket_Data(String name_menu,int price_menu){
        this.name_menu = name_menu;
        this.price_menu = price_menu;
    }

    public String getName_menu() {
        return name_menu;
    }

    public void setName_menu(String name_menu) {
        this.name_menu = name_menu;
    }

    public int getPrice_menu(){
        return price_menu;
    }

    public void setPrice_menu(int price_menu) {
        this.price_menu = price_menu;
    }
}
