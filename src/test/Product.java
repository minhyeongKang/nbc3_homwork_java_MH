package test;

import java.util.Objects;

public class Product extends Menu {

    //필수요구사항
    //상품 클래스는 이름, 가격, 설명 필드를 가지는 클래스로 만들어주세요.
    //상품 클래스의 이름, 설명 필드는 메뉴 클래스를 상속받아 사용하는 구조로 개발해주세요.
    private double price;
    private double drinkTemperate;
    private double priceSizeUp;
    private double temperateSizeUp;
    private String category;

    // Bread 관련 상품 내용
    public Product(String name, String description, double price, String category) {
        super(name, description);
        this.price = price;
        this.category = category;
    }
    // Ade 관련 상품 내용
    public Product(String name, String description, double price, double priceSizeUp, String category)
    {
        super(name, description);
        this.price = price;
        this.priceSizeUp = priceSizeUp;
        this.category = category;
    }
    // Coffee, Tea 관련 상품 내용
    public Product(String name, String description, double price, double drinkTemperate, double priceSizeUp, double temperateSizeUp, String category)
    {
        super(name, description);
        this.price = price;
        this.drinkTemperate = drinkTemperate;
        this.priceSizeUp = priceSizeUp;
        this.temperateSizeUp = temperateSizeUp;
        this.category = category;
    }

    public double getPrice() { return price; }
    public double getDrinkTemperate() { return drinkTemperate; }
    public double getPriceSizeUp() { return priceSizeUp; }
    public double getTemperateSizeUp() { return temperateSizeUp; }
    public String getCategory() { return category; }

    @Override
    public void Show() { System.out.printf("%-20s | W %s\n", getName(), price); }
    public void ShowDrinkTemperate() { System.out.printf("%-20s | W %s\n", getName(), drinkTemperate); }
    public void ShowPriceSizeUp() { System.out.printf("%-20s | W %s\n", getName(), priceSizeUp); }
    public void ShowTemperateSizeUp() { System.out.printf("%-20s | W %s\n", getName(), temperateSizeUp); }
    public void Show(int EA) { System.out.printf("%-20s | W %s | %s개 | W %s\n", getName(), price, EA, drinkTemperate); }


    //equals, hashcode 재정의
    //HashSet이 새롭게 선언하고 추가한 사이즈업메뉴를 동일객체로 인식하지 못함.
    //이유 :기존노드와 같은지 확인하려는 작업으로 추가할 노드의 equals()와 hashCode()를 호출하게 되는데, 이 부분에서 같은 객체로 인식하지 못함
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Product) {
            Product temp = (Product)obj;
            return this.getName().equals(temp.getName()) &&
                    this.getPrice() == temp.getPrice() &&
                    this.getDrinkTemperate() == temp.getDrinkTemperate() &&
                    this.getPriceSizeUp() == temp.getPriceSizeUp() &&
                    this.getTemperateSizeUp() == temp.getTemperateSizeUp() &&
                    this.getDescription().equals(temp.getDescription()) &&
                    this.getCategory().equals(temp.getCategory());
        }
        return false;
    }
    public int hashCode(){
        return Objects.hash(getName(),getDescription(),getPrice(),getDrinkTemperate(),getPriceSizeUp(), getTemperateSizeUp(), getCategory());
    }
}