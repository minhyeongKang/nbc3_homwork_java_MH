package homework01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {


    List<Coffee> coffeeList = new ArrayList<>();
    List<Tea> teaList = new ArrayList<>();
    List<Ade> adeList = new ArrayList<>();
    List<Bread> breadList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Kiosk() {
        coffeeList.add(new Coffee("Americano", "W 4.0", "진한 맛과 향을 담은 커피"));
        coffeeList.add(new Coffee("CafeLatte", "W 4.5", "고소한 우유를 담은 커피"));
        coffeeList.add(new Coffee("Cappuccino", "W 4.5", "몽글한 거품을 담은 커피"));
        coffeeList.add(new Coffee("Einspanner", "W 5.0", "달달한 생크림을 담은 커피"));

        teaList.add(new Tea("HubTea", "W 5.0", "풍부한 향과 맛을 가진 티"));
        teaList.add(new Tea("LemonTea", "W 5.5", "상큼한 향과 맛을 가진 티"));
        teaList.add(new Tea("EarlGreyTea", "W 5.5", "진한 향과 맛을 가진 티"));
        teaList.add(new Tea("MilkTea", "W 5.5", "달콤한 향과 맛을 가진 티"));

        adeList.add(new Ade("OrangeAde", "W 6.0", "생과일을 갈아 넣은 톡 쏘는 에이드"));
        adeList.add(new Ade("PeachAde", "W 6.0", "생과일을 갈아 넣은 톡 쏘는 에이드"));
        adeList.add(new Ade("LemonAde", "W 6.0", "생과일을 갈아 넣은 톡 쏘는 에이드"));
        adeList.add(new Ade("GreenGrapeAde", "W 6.0", "생과일을 갈아 넣은 톡 쏘는 에이드"));

        breadList.add(new Bread("OriginalBagel", "W 5.0", "촉촉하게 구운 오리지널 베이글"));
        breadList.add(new Bread("CreamCheeseBagel", "W 5.5", "크림치즈를 담은 베이글"));
        breadList.add(new Bread("OriginalMuffin", "W 3.0", "촉촉하게 구운 오리지널 머핀"));
        breadList.add(new Bread("ChocolateMuffin", "W 5.5", "초콜릿을 담은 머핀"));
    }

    public void kioskView() {
        System.out.println("'SPARTA CAFE' 에 오신걸 환영합니다 :)");
        System.out.println("아래의 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ SPARTA CAFE MENU ]");
        System.out.println("1. Coffee          | 과테말라산 원두로 갈아 만든 커피");
        System.out.println("2. Tea             | 직접 만든 티백으로 우려낸 티");
        System.out.println("3. Ade             | 생과일을 넣어 만든 톡 쏘는 에이드");
        System.out.println("4. Bread           | 촉촉하고 바삭하게 구운 브레드");
        System.out.println();
        System.out.println("[   ORDER   MENU   ]");
        System.out.println("5. Order           | 장바구니 확인 후 주문합니다.");
        System.out.println("6. Cancel          | 진행중인 주문을 취소합니다.");

        System.out.println("메뉴선택(숫자만 입력) : ");
        int selectMenu = sc.nextInt();
        sc.nextLine();

    }


}
