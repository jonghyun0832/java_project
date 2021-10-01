public class Tax extends Event{

    private int needpopulation;
    private int reducehappy;

    public int getNeedpopulation() {
        return needpopulation;
    }

    public void setNeedpopulation(int needhappy) {
        this.needpopulation = needpopulation;
    }

    public int getReducehappy() {
        return reducehappy;
    }

    public void setReducehappy(int reducehappy) {
        this.reducehappy = reducehappy;
    }

    public Tax(String name, int reward, int needpopulation, int reducehappy,int energy) {
        super(name, reward,energy);
        this.needpopulation = needpopulation;
        this.reducehappy = reducehappy;
    }

    public static void listshow(Tax[] other){
        System.out.println("주의 : 징수를 시행하면 행복도가 감소합니다");
        for (int i = 0; i < other.length; i++){
            System.out.println();
            System.out.println("----------------------징수 리스트" + (i+1) + "------------------------");
            System.out.println("징수 : " + other[i].getName());
            System.out.println("필요한 인구수 : " + other[i].getNeedpopulation());
            System.out.println("감소하는 행복도 : " + other[i].getReducehappy());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
            System.out.println("보상 : " + other[i].getReward() + "G");
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("9 : 처음으로 돌아가기");
    }

    public static boolean processTax(City mycity, int sc_num, Tax[] other){
        if (mycity.getEnergy() < other[sc_num - 1].getEnergy()){
            System.out.println();
            System.out.println("도시 활동력이 부족합니다. \n휴식을 취하면 도시 활동력을 회복할 수 있습니다.");
            System.out.println("현재 도시 활동력 : " + mycity.getEnergy());
            System.out.println("필요한 활동력 : " + other[sc_num-1].getEnergy());
            System.out.println();
            return false;
        }
        else {
            if (mycity.getPopulation() >= other[sc_num - 1].getNeedpopulation()) {
                System.out.println(other[sc_num - 1].getName() + "를 수행했습니다!");
                System.out.println();
                System.out.println();
                System.out.println(other[sc_num - 1].getName() + "를 수행하여 " + other[sc_num - 1].getReward() + "G 를 얻었습니다!");
                System.out.println("세금을 징수하여 수입은 얻었지만 주민들의 행복도는 감소하였습니다.");
                System.out.println();
                System.out.println("보유골드 : " + mycity.getGold() + "G  ▶  " + (mycity.getGold() + other[sc_num - 1].getReward()) + "G");
                System.out.println("행복도 : " + mycity.getHappy() + "  ▶  " + (mycity.getHappy() - other[sc_num - 1].getReducehappy()));
                System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num - 1].getEnergy()));
                mycity.setHappy(mycity.getHappy() - other[sc_num - 1].getReducehappy());
                mycity.setGold(mycity.getGold() + other[sc_num - 1].getReward());
                mycity.setEnergy(mycity.getEnergy() - other[sc_num - 1].getEnergy());
                return false;

            } else {
                System.out.println("※※※※※※※ " + other[sc_num - 1].getName() + "을 진행하기엔 도시 주민수가 부족합니다. ※※※※※※※ \n도시의 인구수를 고려하여 진행해주세요.");
                System.out.println();
                return true;
            }
        }
    }
}
