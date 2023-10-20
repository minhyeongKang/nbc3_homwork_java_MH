package homework01_Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Device {
    private Order order = new Order();
    private ArrayList<Menu> categoryMenu = new ArrayList<Menu>(); // 카테고리 메뉴판
    private ArrayList<Product> allProducts = new ArrayList<Product>(); // 전체상품
    private ArrayList<Product> categoryProduct = new ArrayList<Product>(); // 카테고리 상품 메뉴판
    private double revenue;

    public void LoadMenu() { //카테고리메뉴와 상품메뉴를 리스트에 담기
        Menu coffeeMenu = new Menu("Coffee", "과테말라 원두를 갈아 만든 커피");
        Menu teaMenu = new Menu("Tea", "풍부한 향을 가진 티");
        Menu adeMenu = new Menu("Ade", "생과일을 갈아 넣어 톡쏘는 에이드");
        Menu breadMenu = new Menu("Bread", "직접 반죽해 오븐으로 구운 빵");
        categoryMenu.add(coffeeMenu);
        categoryMenu.add(teaMenu);
        categoryMenu.add(adeMenu);
        categoryMenu.add(breadMenu);

        Product americano = new Product("Americano", "진한 향과 맛을 가진 커피", 4.0, 4.5,"Coffee");
        Product caffeMocha = new Product("CaffeMocha", "초코시럽이 들어간 커피", 5.0, 5.5,"Coffee");
        Product cafeLatte = new Product("CafeLatte", "고소한 우유를 담은 커피", 5.0, 5.5, "Coffee");
        Product cappuccino = new Product("Cappuccino", "몽글한 거품을 담은 커피", 5.0,5.5, "Coffee");
        Product einspanner = new Product("Einspanner", "달달한 생크림을 담은 커피", 6.0,6.5, "Coffee");
        allProducts.add(americano);
        allProducts.add(caffeMocha);
        allProducts.add(cafeLatte);
        allProducts.add(cappuccino);
        allProducts.add(einspanner);

        Product hubTea = new Product("HubTea", "진한 향과 맛을 우려낸 티", 4.5, 5.0, "Tea");
        Product greenTea = new Product("GreenTea", "보성에서 가져와 우려낸 티", 4.5, 5.0, "Tea");
        Product lemonTea = new Product("LemonTea", "상큼한 향과 맛을 우려낸 티", 4.5, 5.0, "Tea");
        Product earlGreyTea = new Product("EarlGreyTea", "진하고 풍부한 향과 맛을 우려낸 티", 5.0, 5.5, "Tea");
        Product milkTea = new Product("MilkTea", "달콤한 향과 맛을 우려낸 티", 5.0,5.5, "Tea");
        allProducts.add(hubTea);
        allProducts.add(greenTea);
        allProducts.add(lemonTea);
        allProducts.add(earlGreyTea);
        allProducts.add(milkTea);

        Product orangeAde = new Product("OrangeAde", "오랜지를 갈아 넣은 에이드", 5.5, "Ade");
        Product peachAde = new Product("PeachAde", "복숭아를 갈아 넣은 에이드", 5.5, "Ade");
        Product lemonAde = new Product("LemonAde", "레몬을 갈아 넣은 에이드", 5.5, "Ade");
        Product strawberryAde = new Product("StrawberryAde", "딸기를 갈아 넣은 에이드", 5.5, "Ade");
        Product greenGrapeAde = new Product("GreenGrapeAde", "청포도를 갈아 넣은 에이드", 5.5, "Ade");
        allProducts.add(orangeAde);
        allProducts.add(peachAde);
        allProducts.add(lemonAde);
        allProducts.add(strawberryAde);
        allProducts.add(greenGrapeAde);

        Product originalBagel = new Product("OriginalBagel", "촉촉하게 구운 베이글", 4.0, "Bread");
        Product creamCheeseBagel = new Product("CreamCheeseBagel", "촉촉함에 크림치즈를 더한 베이글", 4.5, "Bread");
        Product originalMuffin = new Product("OriginalMuffin", "부드럽게 구운 머핀", 3.0, "Bread");
        Product chocolateMuffin = new Product("ChocolateMuffin", "부드러움에 초코를 더한 머핀", 3.5, "Bread");
        allProducts.add(originalBagel);
        allProducts.add(creamCheeseBagel);
        allProducts.add(originalMuffin);
        allProducts.add(chocolateMuffin);
    }

    public void Display() throws InterruptedException {
        while (true) {
            int numbering;          // 번호매김을 위한 변수 numbering 선언 (카테고리나 메뉴 갯수 변경 따른 유동적인 번호부여를 고려하여 numbering 사용)
            int selectCategoryNum;  // 카테고리메뉴판에서 선택한 카테고리번호
            int selectProductNum;   // 상품메뉴판에서 선택한 상품번호

            //(1)카테고리 메뉴판
            numbering = ShowMenu();                                     //1. 카테고리메뉴판 보여주기(번호매김 후 숫자 값 리턴)
            ShowOption(numbering);                                      //옵션메뉴(order/cancel) 보여주기 (order/cancel에 부여할 동적 번호를 인자값으로 전달)
            selectCategoryNum = getResponse(numbering, categoryMenu);   //사용자 응답.사용자 응답에 따른 결과를 전달받음

            if (selectCategoryNum >= numbering || selectCategoryNum == 0) {                       //order/cancel 번호 또는 옵션(0) 선택하였을 경우  : 초기로 돌아가기
                continue;
            }
            //(2)상세 메뉴판
            numbering = ShowMenu(selectCategoryNum);                     //2.선택카테고리의 메뉴판 보여주기 (번호매김 후 숫자 값 리턴)
            ShowOption(numbering);                                       //옵션메뉴(order/cancel) 보여주기 (order/cancel에 부여할 동적 번호를 인자값으로 전달)
            selectProductNum = getResponse(numbering, categoryProduct); //사용자 응답. 응답에 따라 메뉴추가 또는 order/cancel

            if (selectProductNum >= numbering || selectCategoryNum == 0) {                         //order/cancel 번호를 선택하였을 경우  : 초기로 돌아가기
                continue;
            }
            order.AddOrder(categoryProduct.get(selectProductNum - 1)); //선택한 상품 객체를 Addorder메서드의 인자값으로 전달
        }
    }

    public int ShowMenu() { //메뉴판
        int numbering = 1;
        System.out.println("\"SPARTA CAFE 에 오신 걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ SPARTA MENU ]");
        for (Menu item : categoryMenu) { // 카테고리 보여주기 categoryMenu -  Arraylist.
            System.out.print(numbering + ". ");//번호매김 1. 2. 3. (카테고리 추가를 고려하여 numbering 사용)
            item.Show();
            numbering++;
        }
        return numbering;
    }

    public int ShowMenu(int selectCategoryNum) { //상품메뉴판. 선택카테고리에 대한 ShowMenu()
        int numbering = 1;
        String menuName;
        categoryProduct.clear(); // 이전 카테고리메뉴가 남아 있을 시 지우기
        System.out.println("\"SPARTA CAFE 에 오신 걸 환영합니다.\"");
        System.out.println("아래 상품 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        menuName = categoryMenu.get(selectCategoryNum - 1).getName(); //선택한 카테고리명 가져오기
        System.out.println("[ " + menuName + " MENU ]");
        for (Product item : allProducts) { //전체 상품에서 선택한 카테고리의 상품들을 뽑아오기
            if (menuName.equals(item.getCategory())) {
                categoryProduct.add(item);
                System.out.print(numbering + ". ");
                item.Show();
                numbering++;
            }
        }
        return numbering;
    }
    public void ShowOption(int numbering) { //옵션 메뉴
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.printf(numbering + ". %-15s | %s\n", "Order", "장바구니를 확인 후 주문을 완료합니다.");
        System.out.printf(numbering + 1 + ". %-15s | %s\n", "Cancel", "진행중인 주문을 취소합니다.");
    }

    //<T extends Menu> : 어떤타입 T 인자로 받을 종류는 Menu클래스 이거나, 상속받은 하위타입만 받을 수 있다.
    //즉 Menu의 자식관계에 있는 Product도 같은 메서드에 접근할 수 있다.
    public <T extends Menu> int getResponse(int numbering, ArrayList<T> list) throws InterruptedException { //응답을 받고 처리하는 메서드
        int input;    // 리턴받을 사용자 응답(1 or 2 or 3 or ...)
        int optionInput; // 옵션 응답과 나누어 별도 저장
        double totalPrice;
        Scanner sc = new Scanner(System.in); // 사용자 응답을 받기 위한 Scanner
        input = sc.nextInt();
        if (1 <= input && input < numbering) { //카테고리 범위 내 번호 선택 시 - select
            System.out.println(list.get(input - 1).getName() + " 선택하셨습니다.");
            System.out.println();
        } else if (input == numbering) {//Order주문하기 선택 시
            System.out.println("아래와 같이 주문하시겠습니까?");
            System.out.println("[ Orders ]");
            totalPrice = order.getShoppingBag(); //장바구니에 담긴 내용물을 보여주고, 총가격 리턴받음
            System.out.println();
            System.out.println("[ Total ]");
            System.out.println("W " + totalPrice + "\n");
            System.out.println("1. 주문     2. 메뉴판");
            optionInput = sc.nextInt();
            if (optionInput == 1 && totalPrice !=0) {
                System.out.println("-------------------------------------------------");
                System.out.println("주문이 완료되었습니다!");
                System.out.println("대기번호는 [ " + order.CompleteOrder() + " ]번 입니다."); //장바구니를 비우고, 대기번호 리턴받음
                revenue +=totalPrice; // 주문한 가격만큼 수익에 계산
                System.out.println("(3초 후 초기 메뉴판으로 돌아갑니다.)");
                Thread.sleep(1000);
                System.out.println("(2초 후 초기 메뉴판으로 돌아갑니다.)");
                Thread.sleep(1000);
                System.out.println("(1초 후 초기 메뉴판으로 돌아갑니다.)");
                Thread.sleep(1000);
            } else if (optionInput == 2) {
                System.out.println("주문이 완료되지 않았습니다.");
                System.out.println("(초기 메뉴판으로 돌아갑니다.)");
                Thread.sleep(500);
            }
            else if(totalPrice==0){
                System.out.println("주문하신 내용이 없습니다.");
                System.out.println("(초기 메뉴판으로 돌아갑니다.)");
                Thread.sleep(500);
            }
        } else if (input == numbering + 1) {//Cancel취소하기 선택시
            System.out.println("진행하던 주문을 취소하겠습니까?");
            System.out.println("1. 확인     2. 취소");
            optionInput= sc.nextInt();
            if (optionInput == 1) {
                order.CancelOrder();
                System.out.println("진행하던 주문이 취소되었습니다. 이전 화면으로 돌아갑니다.");
                Thread.sleep(500);
            }
            if (optionInput == 2) {
                System.out.println("주문이 취소되지 않았습니다. 이전 화면으로 돌아갑니다.");
                Thread.sleep(500);
            }
        }
        else if (input == 0) { //옵션 기능 선택 시
            System.out.println("[ 총 판매금액 현황 ]");
            System.out.println("현재까지 총 판매된 금액은 [ W "+Math.round((revenue*100))/100.0 +"] 입니다.\n"); //소수점 둘째자리까지 나타내고 반올림 ( 자바는 IEEE 754 부동 소수점 방식 - 근사치 제공에 의해 소수 오차 발생 방지)
            order.SoldList();
            while(true) {
                System.out.println("1. 돌아가기");
                optionInput = sc.nextInt();
                if (optionInput == 1) {
                    System.out.println("이전 화면으로 돌아갑니다.");
                    break;
                }
                else{
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            }
        }

        return input;//선택한 번호 전달
    }
}