public class Festival extends Event{

    private int needfamous;
    private int cooltime;
    private int increasehappy;

    public int getNeedfamous() {
        return needfamous;
    }

    public void setNeedfamous(int needfamous) {
        this.needfamous = needfamous;
    }

    public int getCooltime() {
        return cooltime;
    }

    public void setCooltime(int cooltime) {
        this.cooltime = cooltime;
    }

    public int getIncreasehappy() {
        return increasehappy;
    }

    public void setIncreasehappy(int increasehappy) {
        this.increasehappy = increasehappy;
    }

    public Festival(String name, int reward, int needfamous, int cooltime, int increasehappy,int energy) {
        super(name, reward,energy);
        this.needfamous = needfamous;
        this.cooltime = cooltime;
        this.increasehappy = increasehappy;
    }

    public static void listshow(Festival[] other){
        for (int i = 0; i < other.length; i++){
            System.out.println("----------------------축제 리스트" + (i+1) + "------------------------");
            System.out.println("축제 : " + other[i].getName());
            System.out.println("필요한 명성 : " + other[i].getNeedfamous());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
            System.out.println("쿨타임 : " + other[i].getCooltime());
            System.out.println("보상 : " + other[i].getReward() + "G");
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("9 : 처음으로 돌아가기");
    }

    public static boolean processFestival(City mycity, int sc_num, Festival[] other){
        if (mycity.getEnergy() < other[sc_num - 1].getEnergy()){
            System.out.println();
            System.out.println("도시 활동력이 부족합니다. \n휴식을 취하면 도시 활동력을 회복할 수 있습니다.");
            System.out.println("현재 도시 활동력 : " + mycity.getEnergy());
            System.out.println("필요한 활동력 : " + other[sc_num-1].getEnergy());
            System.out.println();
            return false;
        }
        else {
            if (mycity.getCooltime()[1] == 0){
                if (mycity.getFamous() >= other[sc_num - 1].getNeedfamous()) {
                    System.out.println(other[sc_num - 1].getName() + "를 개최했습니다!");
                    System.out.println();
                    System.out.println();
                    System.out.println(other[sc_num - 1].getName() + "를 호황리에 마쳐서 " + other[sc_num - 1].getReward() + "G 를 얻었습니다!");
                    System.out.println("축제 개최로 인해서 주민들의 행복도가 " + other[sc_num - 1].getIncreasehappy() + "만큼 증가합니다!");
                    System.out.println();
                    System.out.println("축제 지역을 정리하고 재정비하는 동안 축제를 개최할 수 없습니다.");
                    System.out.println();
                    System.out.println();
                    System.out.println("보유골드 : " + mycity.getGold() + "G  ▶  " + (mycity.getGold() + other[sc_num - 1].getReward()) + "G");
                    System.out.println("행복도 : " + mycity.getHappy() + "  ▶  " + (mycity.getHappy() + other[sc_num - 1].getIncreasehappy()));
                    System.out.println("축제 쿨타임 : " + mycity.getCooltime()[1] + "  ▶  " + (other[sc_num - 1].getCooltime()));
                    System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num - 1].getEnergy()));
                    //mycity.setForce(mycity.getForce() - other[sc_num-1].getReduceforce()); 도시에는 쿨타임 개념이없어서 일단뺴놓음
                    int[] arr = new int[]{mycity.getCooltime()[0],other[sc_num -1].getCooltime(),mycity.getCooltime()[2]};
                    mycity.setCooltime(arr);
                    mycity.setGold(mycity.getGold() + other[sc_num - 1].getReward());
                    mycity.setHappy(mycity.getHappy() + other[sc_num - 1].getIncreasehappy());
                    mycity.setEnergy(mycity.getEnergy() - other[sc_num - 1].getEnergy());
                    return false;

                } else {
                    System.out.println("※※※※※※※ " + other[sc_num - 1].getName() + "을 진행하기엔 도시 명성이 모자랍니다. ※※※※※※※ \n도시의 명성에 어울리는 축제를 선택 해주세요.");
                    System.out.println();
                    return true;
                }
            } else {
                System.out.println("※※※※※※※ " + other[sc_num - 1].getName() + "을 진행하기엔 축제 지역 정리가 덜끝났습니다. ※※※※※※※ \n축제개최 쿨타임을 확인해주세요.");
                System.out.println("축제 쿨타임 : " + mycity.getCooltime()[1]);
                System.out.println();
                return false;
            }
        }

    }

}
