import java.util.Random;

public class Sudden extends Feature {

    private int startday;
    private String name;

    public int getStartday() {
        return startday;
    }

    public void setStartday(int startday) {
        this.startday = startday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sudden(String name,int economy, int religion, int force, int population, int startday) {
        super(economy, religion, force, population);
        this.startday = startday;
        this.name = name;
    }

    public static void suddenevent(City mycity, Sudden[] other1,Sudden[] other2,Sudden[] other3 ){
        Random rand = new Random();
        int rand_num = rand.nextInt(3);
        if (mycity.getDay() >= 8 && mycity.getDay() <= 20 && mycity.getDay() % 4 == 0){
            System.out.println();
            System.out.println("1단계 돌발이벤트 발생");
        } else if (mycity.getDay() > 20 && mycity.getDay() <= 40 && mycity.getDay() % 4 == 0){
            System.out.println();
            System.out.println("2단계 돌발이벤트 발생");
            other1 = other2;
        } else if (mycity.getDay() >  40 && mycity.getDay() % 4 == 0){
            System.out.println();
            System.out.println("3단계 돌발이벤트 발생");
            other1 = other3;
        }
        if (mycity.getDay() % 4 == 0 && mycity.getDay() >= 8){
            System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
            System.out.println();
            System.out.println(other1[rand_num].getName() + "(이)가 발생했습니다.");
            System.out.println();
            System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
            if (rand_num == 0){
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                if(mycity.getEconomy() >= other1[rand_num].getEconomy()){
                    System.out.println("도시의 경제력이 뛰어났기 때문에 별다른 피해를 입지 않았습니다.");
                    System.out.println();
                } else {
                    System.out.println("도시의 경제력이 약해 피해를 입었습니다.");
                    System.out.println("도시에 재정난이 찾아와 보유골드와 행복도가 낮아집니다.");
                    System.out.println();
                    System.out.println("도시의 경제력을 일정수준까지 올리는것을 추천드립니다.");
                    System.out.println("8일~20일 : 50 / 21~40일 : 100 / 41일~ : 300");
                    System.out.println();
                    System.out.println("보유골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold() + ((mycity.getEconomy()-other1[rand_num].getEconomy())*40)));
                    System.out.println("행복도 : " + mycity.getHappy() + "  ▶  " + (mycity.getHappy() + (mycity.getEconomy()-other1[rand_num].getEconomy())));
                    System.out.println();
                    mycity.setGold((mycity.getGold() + ((mycity.getEconomy()-other1[rand_num].getEconomy())*40)));
                    mycity.setHappy((mycity.getHappy() + (mycity.getEconomy()-other1[rand_num].getEconomy())));
                }
            } else if (rand_num == 1){
                System.out.println();
                System.out.println();
                if(mycity.getReligion() >= other1[rand_num].getReligion()){
                    System.out.println("도시의 종교력이 뛰어나 별다른 피해를 입지 않았습니다.");
                    System.out.println();
                } else {
                    System.out.println("도시의 종교력이 약해 피해를 입었습니다.");
                    System.out.println("도시에 대한 안좋은 소문이 돌며 명성과 행복도가 낮아집니다.");
                    System.out.println();
                    System.out.println("도시의 종교력을 일정 수준까지 올리는것을 추천드립니다.");
                    System.out.println("8일~20일 : 50 / 21~40일 : 100 / 41일~ : 300");
                    System.out.println();
                    System.out.println("명성 : " + mycity.getFamous() + "  ▶  " + (mycity.getFamous()+(mycity.getReligion()-other1[rand_num].getReligion())));
                    System.out.println("행복도 : " + mycity.getHappy() + "  ▶  " + (mycity.getHappy() + (mycity.getReligion()-other1[rand_num].getReligion())));
                    System.out.println();
                    mycity.setFamous((mycity.getFamous()+(mycity.getReligion()-other1[rand_num].getReligion())));
                    mycity.setHappy((mycity.getHappy() + (mycity.getReligion()-other1[rand_num].getReligion())));
                }
            } else {
                System.out.println();
                System.out.println();
                if(mycity.getForce() >= other1[rand_num].getForce()){
                    System.out.println("도시의 군사력이 뛰어나 별다른 피해를 입지 않았습니다.");
                    System.out.println();
                } else {
                    System.out.println("도시의 군사력이 약해 피해를 입었습니다.");
                    System.out.println("도시에 인명피해가 발생하여 인구수와 행복도가 낮아집니다.");
                    System.out.println();
                    System.out.println("도시의 군사력을 일정 수준까지 올리는것을 추천드립니다.");
                    System.out.println("8일~20일 : 50 / 21~40일 : 100 / 41일~ : 300");
                    System.out.println();
                    System.out.println("인구수 : " + mycity.getPopulation() + "  ▶  " + (mycity.getPopulation()+(mycity.getForce()-other1[rand_num].getForce())));
                    System.out.println("행복도 : " + mycity.getHappy() + "  ▶  " + (mycity.getHappy() + (mycity.getForce()-other1[rand_num].getForce())));
                    System.out.println();
                    mycity.setPopulation((mycity.getPopulation()+(mycity.getForce()-other1[rand_num].getForce())));
                    mycity.setHappy((mycity.getHappy() + (mycity.getForce()-other1[rand_num].getForce())));
                }
            }
        }

    }
}
