package dataClass;

public class P9_item {

    private String name;
    private  String date;
    private String[] menu;

    private String status;

    public void setName(String name){this.name=name;}

    public String getName(){return this.name;}

    public void  setData(String data){this.date = data;}

    public String getDate(){return this.date;}

    public void setMenu(String[] menu){this.menu = menu;}

    public String[] getMenu(){return this.menu;}

    public String getSpMenu(int position){return (position < this.menu.length) ? (this.menu[position]) : ("IndexNotFound");}

    public void setStatus(String status){this.status = status;}
    public String getStatus(){return this.status;}

//    public P9_item(){
//
//    }

    public P9_item(String  name, String date, String[] menu){
        this.name = name;
        this.date = date;
        this.menu = menu;


    }

//    public  P9_item(String  name, String date, String status, String[] menu){
//        this.name = name;
//        this.date = date;
//        this.status = status;
//        this.menu = menu;
//
//
//    }




}
