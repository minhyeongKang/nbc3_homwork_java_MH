package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Order {
    private ArrayList<Product> shoppingBag = new ArrayList<Product>();
    private ArrayList<Product> shoppingBag2 = new ArrayList<Product>();
    private ArrayList<Product> shoppingBag3 = new ArrayList<Product>();
    private ArrayList<Product> shoppingBag4 = new ArrayList<Product>();
    private HashSet<Product> soldProduct = new HashSet<Product>();
    private int counter = 0;


    public void AddOrder(Product product) {
        Scanner sc = new Scanner(System.in);
        int firstInput;
        int secondInput;

        if (product.getDrinkTemperate() != 0) { // HOT or ICE 옵션이 있을때
            product.Show(); // 메뉴 | W 가격 | 이름

            System.out.println();
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            System.out.println("1. HOT(W " + product.getPrice() + ")          2. ICE(W " + product.getDrinkTemperate() + ")");
            firstInput = sc.nextInt();
            if (firstInput == 1) { // HOT 음료
                System.out.println("사이즈 업을 하시겠습니까?");
                System.out.println("1. M(W " + product.getPrice() + ")          2. L(W " + product.getPriceSizeUp() + ")");
                secondInput = sc.nextInt();
                if (secondInput == 1) {
                    product.Show();
                    question(product);
                } else if (secondInput == 2) {
                    product.HotSizeUp();
                    coffeequestion(product);
                }
            } else if (firstInput == 2) { // ICE 음료
                System.out.println("음료 사이즈를 골라주세요.");
                System.out.println("1. M(W " + product.getDrinkTemperate() + ")          2. L(W " + product.getTemperateSizeUp() + ")");
                secondInput = sc.nextInt();
                if (secondInput == 1) {
                    product.IceShow();
                    DrinkTemperatequestion(product);
                } else if (secondInput == 2) {
                    product.IceSizeUp();
                    Temperatequestion(product);
                }
            }
        } else if(product.getDrinkTemperate() == 0 && product.getPriceSizeUp() !=0){
            System.out.println("사이즈 업을 하시겠습니까?");
            System.out.println("1. M(W " + product.getPrice() + ")          2. L(W " + product.getPriceSizeUp() + ")");
            secondInput = sc.nextInt();
            if (secondInput == 1) {
                product.Show();
                question(product);
            } else if (secondInput == 2) {
                product.HotSizeUp();
                coffeequestion(product);
            }
        }else{
            question(product);
        }
    }
    public void question (Product product) {
        Scanner sc = new Scanner(System.in);
        int input;
        //product.Show();
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인          2.취소");
        input = sc.nextInt();
        if (input == 1) {//장바구니 추가
            System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
            System.out.println();
            shoppingBag.add(product);
        } else if (input == 2) {
            System.out.println("장바구니에 추가하지 않았습니다.");
            System.out.println();
        }
    }

    public void coffeequestion (Product product) {
        Scanner sc = new Scanner(System.in);
        int input;
        //product.Show();
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인          2.취소");
        input = sc.nextInt();
        if (input == 1) {//장바구니 추가
            System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
            System.out.println();
            shoppingBag2.add(product);
        } else if (input == 2) {
            System.out.println("장바구니에 추가하지 않았습니다.");
            System.out.println();
        }
    }
    public void DrinkTemperatequestion (Product product) {
        Scanner sc = new Scanner(System.in);
        int input;
        //product.Show();
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인          2.취소");
        input = sc.nextInt();
        if (input == 1) {//장바구니 추가
            System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
            System.out.println();
            shoppingBag3.add(product);
        } else if (input == 2) {
            System.out.println("장바구니에 추가하지 않았습니다.");
            System.out.println();
        }
    }
    public void Temperatequestion (Product product) {
        Scanner sc = new Scanner(System.in);
        int input;
        //product.Show();
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인          2.취소");
        input = sc.nextInt();
        if (input == 1) {//장바구니 추가
            System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
            System.out.println();
            shoppingBag4.add(product);
        } else if (input == 2) {
            System.out.println("장바구니에 추가하지 않았습니다.");
            System.out.println();
        }
    }
    public double getShoppingBag(){//쇼핑백 내용 보여주기, 가격 return
        double totalprice = 0;
        int EA;
        HashSet<Product> productCountSet = new HashSet<Product>(shoppingBag);
        for (Product item : productCountSet) {
            EA = Collections.frequency(shoppingBag,item);
            item.Show(EA);
            totalprice += item.getPrice() * EA; //가격계산
        }
        HashSet<Product> productCountSet2 = new HashSet<Product>(shoppingBag2);
        for (Product item : productCountSet2) {
            EA = Collections.frequency(shoppingBag2,item);
            item.HotSizeUp(EA);
            totalprice += item.getPriceSizeUp() * EA; //가격계산
        }
        HashSet<Product> productCountSet3 = new HashSet<Product>(shoppingBag3);
        for (Product item : productCountSet3) {
            EA = Collections.frequency(shoppingBag3,item);
            item.IceShow(EA);
            totalprice += item.getDrinkTemperate() * EA; //가격계산
        }
        HashSet<Product> productCountSet4 = new HashSet<Product>(shoppingBag4);
        for (Product item : productCountSet4) {
            EA = Collections.frequency(shoppingBag4,item);
            item.IceSizeUp(EA);
            totalprice += item.getTemperateSizeUp() * EA; //가격계산
        }
        totalprice=Math.round((totalprice*100))/100.0;//소수점 둘째자리까지 나타내고 반올림 ( 자바는 IEEE 754 부동 소수점 방식 - 근사치 제공에 의해 소수 오차 발생 방지)
        return totalprice;
    }

    public int CompleteOrder() {
        soldProduct.addAll(shoppingBag); //총 판매상품 hashset에 쇼핑백 목록 넣기
        shoppingBag.clear();//
        shoppingBag2.clear();
        shoppingBag3.clear();
        shoppingBag4.clear();
        counter++;          //대기번호 +1
        return counter;
    }

    public void CancelOrder() {
        shoppingBag.clear();
    }
    public void SoldList(){
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        for(Product item : soldProduct){
            System.out.printf("%-20s | W %s\n",item.getName(), item.getPrice());

        }


    }
}