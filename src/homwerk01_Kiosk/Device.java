package homwerk01_Kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Device {
    private Order order = new Order();
    private ArrayList<Menu> categoryMenu = new ArrayList<Menu>(); // 카테고리 메뉴판
    private ArrayList<Product> allProducts = new ArrayList<Product>(); // 전체상품
    private ArrayList<Product> categoryProduct = new ArrayList<Product>(); // 카테고리 상품 메뉴판
    private double revenue;

    public void LoadMenu() { //카테고리메뉴와 상품메뉴를 리스트에 담기
        Menu burgersMenu = new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거");
        Menu frozencustardMenu = new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림");
        Menu drinksMenu = new Menu("Drinks", "매장에서 직접 만드는 음료");
        Menu beerMenu = new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주");
        categoryMenu.add(burgersMenu);
        categoryMenu.add(frozencustardMenu);
        categoryMenu.add(drinksMenu);
        categoryMenu.add(beerMenu);

        Product shackBurger = new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, 10.9,"Burgers");
        Product smokeShack = new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9, 12.9,"Burgers");
        Product shroomBurger = new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4, "Burgers");
        Product cheeseBurger = new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9,10.9, "Burgers");
        Product hamBurger = new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 6.9,9.0, "Burgers");
        allProducts.add(shackBurger);
        allProducts.add(smokeShack);
        allProducts.add(shroomBurger);
        allProducts.add(cheeseBurger);
        allProducts.add(hamBurger);

        Product shakes = new Product("Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛 버터, 커피", 5.9, "Frozen Custard");
        Product shakeOfTheWeek = new Product("Shake of the Week", "특별한 커스터드 플레이버", 6.5, "Frozen Custard");
        Product redBeanShake = new Product("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6.5, "Frozen Custard");
        Product floats = new Product("Floats", "루트 비어, 퍼플 카우, 크림 시클", 5.9, "Frozen Custard");
        Product cupsAndCones = new Product("Cups & Cones", "바닐라, 초콜렛, Flavor of the Week", 4.9,5.9, "Frozen Custard");
        Product concretes = new Product("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5.9,8.9, "Frozen Custard");
        Product shackAttack = new Product("Shack Attack", "초콜렛 퍼지소스, 초콜렛 트러플 쿠키, Lumiere 초콜렛 청크와 스프링클이 들어간 진한 초콜렛 커스터드", 5.9, "Frozen Custard");
        allProducts.add(shakes);
        allProducts.add(shakeOfTheWeek);
        allProducts.add(redBeanShake);
        allProducts.add(floats);
        allProducts.add(cupsAndCones);
        allProducts.add(concretes);
        allProducts.add(shackAttack);

        Product shackmadeLemonade = new Product("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드(오리지날/시즈널)", 3.9, "Drinks");
        Product freshBrewedIcedTea = new Product("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4, "Drinks");
        Product fiftyfifty = new Product("Fifty/Fifty", "레몬에이드와 아이스티의 만남", 3.5, "Drinks");
        Product fountainSoda = new Product("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2.7, "Drinks");
        Product abitaRootBeer = new Product("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4, "Drinks");
        Product bottledWater = new Product("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0, "Drinks");
        allProducts.add(shackmadeLemonade);
        allProducts.add(freshBrewedIcedTea);
        allProducts.add(fiftyfifty);
        allProducts.add(fountainSoda);
        allProducts.add(abitaRootBeer);
        allProducts.add(bottledWater);

        Product shackMeisterAle = new Product("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9.8, "Beer");
        Product magpieBrewingCo = new Product("Magpie Brewing Co.", "설명 없음", 6.8, "Beer");
        allProducts.add(shackMeisterAle);
        allProducts.add(magpieBrewingCo);
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
        System.out.println("\"SHAKESHACK BURGER 에 오신 걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("[ SHAKESHACK MENU ]");
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
        System.out.println("\"SHAKESHACK BURGER 에 오신 걸 환영합니다.\"");
        System.out.println("아래 상품 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
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
        } else if (input == numbering) {//Order주문하기 선택 시
            System.out.println("아래와 같이 주문하시겠습니까?");
            System.out.println("[ Orders ]");
            totalPrice = order.getShoppingBag(); //장바구니에 담긴 내용물을 보여주고, 총가격 리턴받음
            System.out.println("[ Total ]");
            System.out.println("W " + totalPrice + "\n");
            System.out.println("1. 주문     2. 메뉴판");
            optionInput = sc.nextInt();
            if (optionInput == 1 && totalPrice !=0) {
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
