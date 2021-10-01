public class Trading extends Event {

    private int needeconomy;
    private int cooltime;

    public int getNeedeconomy() {
        return needeconomy;
    }

    public void setNeedeconomy(int needeconomy) {
        this.needeconomy = needeconomy;
    }

    public int getCooltime() {
        return cooltime;
    }

    public void setCooltime(int cooltime) {
        this.cooltime = cooltime;
    }

    public Trading(String name, int reward, int needeconomy, int cooltime, int energy) {
        super(name, reward,energy);
        this.needeconomy = needeconomy;
        this.cooltime = cooltime;
    }

    public static void listshow(Trading[] other){
        for (int i = 0; i < other.length; i++){
            System.out.println("----------------------무역 리스트" + (i+1) + "------------------------");
            System.out.println("무역 : " + other[i].getName());
            System.out.println("필요한 경제력 : " + other[i].getNeedeconomy());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
            System.out.println("쿨타임 : " + other[i].getCooltime());
            System.out.println("보상 : " + other[i].getReward() + "G");
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("9 : 처음으로 돌아가기");
    }

    public static boolean processTrade(City mycity, int trade_num, Trading[] other) {
        if (mycity.getEnergy() < other[trade_num - 1].getEnergy()){
            System.out.println();
            System.out.println("도시 활동력이 부족합니다. \n휴식을 취하면 도시 활동력을 회복할 수 있습니다.");
            System.out.println("현재 도시 활동력 : " + mycity.getEnergy());
            System.out.println("필요한 활동력 : " + other[trade_num-1].getEnergy());
            System.out.println();
            return false;
        }
        else {
            if (mycity.getCooltime()[0] == 0){
                if (mycity.getEconomy() >= other[trade_num - 1].getNeedeconomy()) {
                    System.out.println(other[trade_num - 1].getName() + "무역을 시작합니다.");
                    System.out.println();
                    System.out.println();
                    System.out.println(other[trade_num - 1].getName() + "를 성공리에 마쳐서 " + other[trade_num - 1].getReward() + "G 를 얻었습니다!");
                    System.out.println("상인들이 무역으로 지쳐서 쿨타임동안 무역을 이용할 수 없습니다.");
                    System.out.println();
                    System.out.println("보유골드 : " + mycity.getGold() + "G  ▶  " + (mycity.getGold() + other[trade_num - 1].getReward()) + "G");
                    System.out.println("무역 쿨타임 : " + mycity.getCooltime()[0] + "  ▶  " + (other[trade_num - 1].getCooltime()));
                    System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[trade_num-1].getEnergy()));
                    //mycity.setForce(mycity.getForce() - other[trade_num-1].getReduceforce()); 도시에는 쿨타임 개념이없어서 일단뺴놓음
                    int[] arr = new int[]{other[trade_num -1].getCooltime(),mycity.getCooltime()[1],mycity.getCooltime()[2]};
                    mycity.setCooltime(arr);
                    mycity.setGold(mycity.getGold() + other[trade_num - 1].getReward());
                    mycity.setEnergy(mycity.getEnergy() - other[trade_num-1].getEnergy());
                    return false;

                } else {
                    System.out.println("※※※※※※※ " + other[trade_num - 1].getName() + "을 진행하기엔 경제력이 모자랍니다. ※※※※※※※ \n도시의 경제력에 맞는 무역을 선택 해주세요.");
                    System.out.println();
                    return true;
                }
            } else {
                System.out.println("※※※※※※※ " + other[trade_num - 1].getName() + "을 진행하기엔 상인들이 지쳐있습니다. ※※※※※※※ \n무역 쿨타임을 확인해주세요.");
                System.out.println("무역 쿨타임 : " + mycity.getCooltime()[0]);
                System.out.println();
                return false;
            }
        }
    }

}
