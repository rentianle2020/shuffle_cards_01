import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardsShuffle {


    public static void main(String[] args) {

        //初始化一个随机数，洗牌时作为下标使用
        Random random = new Random();

        //初始化一个牌组
        //数字(13)
        List<String> value = new ArrayList<>();
        value.add("A");
        for (int i = 2; i < 10; i++) {
            value.add(String.valueOf(i));
        }
        value.add("T");
        value.add("J");
        value.add("Q");
        value.add("K");
        //花色(4)
        List<String> color = new ArrayList<>();
        color.add("S");
        color.add("H");
        color.add("D");
        color.add("C");
        //组合
        List<String> card = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                card.add(i*j,color.get(j)+value.get(i));
            }
        }
        //加上俩王
        card.add("BJ");
        card.add("LJ");

        //打印出来看一下牌组(洗牌前)
        System.out.println("============洗牌前================");
        for (int i = 0; i < 54; i++) {
            System.out.print(card.get(i));
            if (i != 53){
                System.out.print("、");
            }
        }
        System.out.println();

        //通过和随机下标的牌交换，来进行洗牌（就很真实）
        for (int i = 53; i >= 0; i--) {
            String substitute = card.get(i);
            int index = random.nextInt(i+1);
            card.set(i,card.get(index));
            card.set(index,substitute);
        }

        //打印出来看一下洗牌后的牌组
        System.out.println("============洗牌后================");
        for (int i = 0; i < 54; i++) {
            System.out.print(card.get(i));
            if (i != 53){
                System.out.print("、");
            }
        }
        System.out.println();


        //初始化3个ArrayList，分别代表三个玩家
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();

        //已经洗好了，准备发牌
        //一次发3人，发18圈
        for (int i = 0; i < 18; i++) {
                player1.add(i,card.get(i*3));
                player2.add(i,card.get(i*3+1));
                player3.add(i,card.get(i*3+2));
        }


        //打印出来看一眼
        System.out.println("========== 一号玩家手牌 ===============");
        for (int i = 0; i < player1.size(); i++) {
            System.out.print(player1.get(i));
            if (i != 17){
                System.out.print("、");
            }

        }
        System.out.println();

        System.out.println("========== 二号玩家手牌 ===============");
        for (int i = 0; i < player2.size(); i++) {
            System.out.print(player2.get(i));
            if (i != 17){
                System.out.print("、");
            }

        }
        System.out.println();

        System.out.println("========== 三号玩家手牌 ===============");
        for (int i = 0; i < player3.size(); i++) {
            System.out.print(player3.get(i));
            if (i != 17){
                System.out.print("、");
            }
        }
        System.out.println();
    }
}
