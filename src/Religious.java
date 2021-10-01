public class Religious extends Event{

    private int needreligion;
    private int cooltime;
    private int increase;

    public int getNeedreligion() {
        return needreligion;
    }

    public void setNeedreligion(int needreligion) {
        this.needreligion = needreligion;
    }

    public int getCooltime() {
        return cooltime;
    }

    public void setCooltime(int cooltime) {
        this.cooltime = cooltime;
    }

    public int getIncrease() {
        return increase;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public Religious(String name, int reward, int needreligion, int cooltime, int increase, int energy) {
        super(name, reward,energy);
        this.needreligion = needreligion;
        this.cooltime = cooltime;
        this.increase = increase;
    }

    public static void listshow(Religious[] other){
        for (int i = 0; i < other.length; i++){
            System.out.println("----------------------종교활동 리스트" + (i+1) + "------------------------");
            System.out.println("종교활동 : " + other[i].getName());
            System.out.println("필요한 종교력 : " + other[i].getNeedreligion());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
            System.out.println("쿨타임 : " + other[i].getCooltime());
            System.out.println("보상 : " + other[i].getReward() + "G  &  +" + other[i].getIncrease() + "종교력" );
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("9 : 처음으로 돌아가기");
    }

    public static boolean processReligion(City mycity, int sc_num, Religious[] other){
        if (mycity.getEnergy() < other[sc_num - 1].getEnergy()){
            System.out.println();
            System.out.println("도시 활동력이 부족합니다. \n휴식을 취하면 도시 활동력을 회복할 수 있습니다.");
            System.out.println("현재 도시 활동력 : " + mycity.getEnergy());
            System.out.println("필요한 활동력 : " + other[sc_num-1].getEnergy());
            System.out.println();
            return false;
        }
        else {
            if (mycity.getCooltime()[2] == 0){
                if (mycity.getReligion() >= other[sc_num - 1].getNeedreligion()) {
                    System.out.println(other[sc_num - 1].getName() + "를 실시합니다.");
                    System.out.println();
                    System.out.println();
                    System.out.println(other[sc_num - 1].getName() + "를 성공적으로 실시했습니다. " + other[sc_num - 1].getReward() + "G 를 얻었습니다!");
                    System.out.println("종교활동은 일정 시간이 지나야 가능합니다.");
                    System.out.println();
                    System.out.println("보유골드 : " + mycity.getGold() + "G  ▶  " + (mycity.getGold() + other[sc_num - 1].getReward()) + "G");
                    System.out.println("종교력 : " + mycity.getReligion() + "  ▶  " + (mycity.getReligion() + other[sc_num-1].getIncrease()));
                    System.out.println("종교활동 쿨타임 : " + mycity.getCooltime()[2] + "  ▶  " + (other[sc_num - 1].getCooltime()));
                    System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num - 1].getEnergy()));
                    //mycity.setForce(mycity.getForce() - other[sc_num-1].getReduceforce()); 도시에는 쿨타임 개념이없어서 일단뺴놓음
                    int[] arr = new int[]{mycity.getCooltime()[0],mycity.getCooltime()[1],other[sc_num -1].getCooltime()};
                    mycity.setCooltime(arr);
                    mycity.setGold(mycity.getGold() + other[sc_num - 1].getReward());
                    mycity.setReligion(mycity.getReligion() + other[sc_num-1].getIncrease());
                    mycity.setEnergy((mycity.getEnergy() - other[sc_num - 1].getEnergy()));
                    return false;

                } else {
                    System.out.println("※※※※※※※ " + other[sc_num - 1].getName() + "을 진행하기엔 도시 종교력이 모자랍니다. ※※※※※※※ \n도시의 종교력에 맞는 종교활동을 선택 해주세요.");
                    System.out.println();
                    return true;
                }
            } else {
                System.out.println("※※※※※※※ " + other[sc_num - 1].getName() + "을 진행하기엔 시간이 좀 더 지나야합니다. ※※※※※※※ \n남은 종교활동 쿨타임을 확인해주세요.");
                System.out.println("종교활동 쿨타임 : " + mycity.getCooltime()[2]);
                System.out.println();
                return false;
            }
        }
    }
}
