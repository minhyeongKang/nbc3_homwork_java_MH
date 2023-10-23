package Kiosk;

import java.util.Objects;

public class Product extends Menu {

    //필수요구사항
    //상품 클래스는 이름, 가격, 설명 필드를 가지는 클래스로 만들어주세요.
    //상품 클래스의 이름, 설명 필드는 메뉴 클래스를 상속받아 사용하는 구조로 개발해주세요.
    private double price;
    private double drinkTemperature;
    private double hotSizeUp;
    private double iceSizUp;
    private String category;

    // Bread 관련 상품 내용
    public Product(String name, String description, double price, String category) {
        super(name, description);
        this.price = price;
        this.category = category;
    }
    // Ade 관련 상품 내용
    public Product(String name, String description, double price, double hotSizeUp, String category)
    {
        super(name, description);
        this.price = price;
        this.hotSizeUp = hotSizeUp;
        this.category = category;
    }
    // Coffee, Tea 관련 상품 내용
    public Product(String name, String description, double price, double drinkTemperature, double hotSizeUp, double iceSizUp, String category)
    {
        super(name, description);
        this.price = price;
        this.drinkTemperature = drinkTemperature;
        this.hotSizeUp = hotSizeUp;
        this.iceSizUp = iceSizUp;
        this.category = category;
    }

    public double getPrice() { return price; }
    public double getDrinkTemperature() { return drinkTemperature; }
    public double getHotSizeUp() { return hotSizeUp; }
    public double getIceSizeUp() { return iceSizUp; }
    public String getCategory() { return category; }

    @Override
    public void Show() { System.out.printf("%-20s | W %s | %s\n", getName(), price, getDescription()); }
    public void HotSizeUpShow() { System.out.printf("%-20s | W %s | %s\n", getName(), hotSizeUp, getDescription()); }
    public void IceShow() { System.out.printf("%-20s | W %s | %s\n", getName(), drinkTemperature, getDescription()); }
    public void IceSizeUpShow() { System.out.printf("%-20s | W %s | %s\n", getName(), iceSizUp, getDescription()); }
    public void Show(int EA) { System.out.printf("%-20s | W %s | %s개 | W %s\n", getName(), price, EA, getDescription()); }
    public void HotSizeUpShow(int EA) { System.out.printf("%-20s | W %s | %s개 | %s\n", getName(), hotSizeUp, EA,getDescription()); }
    public void IceShow(int EA) { System.out.printf("%-20s | W %s | %s개 | %s\n", getName(), drinkTemperature, EA,getDescription()); }
    public void IceSizeUpShow(int EA) { System.out.printf("%-20s | W %s | %s개 | %s\n", getName(), iceSizUp, EA,getDescription()); }



    //equals, hashcode 재정의
    //HashSet이 새롭게 선언하고 추가한 사이즈업메뉴를 동일객체로 인식하지 못함.
    //이유 :기존노드와 같은지 확인하려는 작업으로 추가할 노드의 equals()와 hashCode()를 호출하게 되는데, 이 부분에서 같은 객체로 인식하지 못함
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Product) {
            Product temp = (Product)obj;
            return this.getName().equals(temp.getName()) &&
                    this.getPrice() == temp.getPrice() &&
                    this.getDrinkTemperature() == temp.getDrinkTemperature() &&
                    this.getHotSizeUp() == temp.getHotSizeUp() &&
                    this.getIceSizeUp() == temp.getIceSizeUp() &&
                    this.getDescription().equals(temp.getDescription()) &&
                    this.getCategory().equals(temp.getCategory());
        }
        return false;
    }
    public int hashCode(){
        return Objects.hash(getName(),getDescription(),getPrice(),getDrinkTemperature(),getHotSizeUp(), getIceSizeUp(), getCategory());
    }
}