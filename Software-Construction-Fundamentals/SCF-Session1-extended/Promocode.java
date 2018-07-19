/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

/**
 *
 * @author Home
 */



public enum Promocode {
PROMO1("2017-09-06","CODE1","2018-09-06",10),
PROMO2("2017-04-03","CODE2","2018-04-03",20),
PROMO3("2017-03-07","CODE3","2018-03-07",30);
private String start;
private String end;
private String code;
private int percent;
Promocode(String start,String code,String end, int percent){
	this.start=start;
	this.end=end;
	this.code=code;
        this.percent=percent;
}
public String getCode(){
	return code;
}
public String getStart(){
	return start;
}
public String getEnd(){
	return end;
}
public int getPercent(){
    return percent;
}



}


