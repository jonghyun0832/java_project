public class Hunting extends Event {
    private int needforce;
    private int reduceforce;

    public int getNeedforce() {
        return needforce;
    }

    public void setNeedforce(int needforce) {
        this.needforce = needforce;
    }

    public int getReduceforce() {
        return reduceforce;
    }

    public void setReduceforce(int reduceforce) {
        this.reduceforce = reduceforce;
    }

    public Hunting(String name, int reward, int needforce, int reduceforce, int energy) {
        super(name, reward, energy);
        this.needforce = needforce;
        this.reduceforce = reduceforce;
    }

    public static void listshow(Hunting[] other) {
        for (int i = 0; i < other.length; i++) {
            System.out.println("----------------------사냥 리스트" + (i + 1) + "------------------------");
            System.out.println("사냥 : " + other[i].getName());
            System.out.println("필요한 군사력 : " + other[i].getNeedforce());
            System.out.println("감소하는 군사력 : " + other[i].getReduceforce());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
            System.out.println("보상 : " + other[i].getReward() + "G");
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("9 : 처음으로 돌아가기");
    }

    public static boolean processHunt(City mycity, int hunt_num, Hunting[] other) {
        if (mycity.getEnergy() < other[hunt_num - 1].getEnergy()) {
            System.out.println();
            System.out.println("도시 활동력이 부족합니다. \n휴식을 취하면 도시 활동력을 회복할 수 있습니다.");
            System.out.println("현재 도시 활동력 : " + mycity.getEnergy());
            System.out.println("필요한 활동력 : " + other[hunt_num - 1].getEnergy());
            System.out.println();
            return false;
        } else {
            if (mycity.getForce() >= other[hunt_num - 1].getNeedforce()) {
                System.out.println(other[hunt_num - 1].getName() + "사냥을 시작합니다.");
                System.out.println();
                System.out.println();
                System.out.println("사냥을 성공적으로 마쳤습니다.");
                System.out.println(other[hunt_num - 1].getName() + "의 갓을 판매하여 " + other[hunt_num - 1].getReward() + "G 를 얻었습니다!");
                System.out.println("몇몇 병사들이 사냥 과정에서 다쳐서 더이상 군사활동을 할 수 없습니다. \n군사력이 감소합니다.");
                System.out.println();
                System.out.println("보유골드 : " + mycity.getGold() + "G  ▶  " + (mycity.getGold() + other[hunt_num - 1].getReward()) + "G");
                System.out.println("군사력 : " + mycity.getForce() + " ▶ " + (mycity.getForce() - other[hunt_num - 1].getReduceforce()));
                System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[hunt_num - 1].getEnergy()));
                mycity.setForce(mycity.getForce() - other[hunt_num - 1].getReduceforce());
                mycity.setGold(mycity.getGold() + other[hunt_num - 1].getReward());
                mycity.setEnergy(mycity.getEnergy() - other[hunt_num - 1].getEnergy());
                return false;

            } else {
                System.out.println("※※※※※※※ " + other[hunt_num - 1].getName() + "을 잡기엔 전투력이 모자랍니다. ※※※※※※※ \n도시의 전투력에 맞는 사냥을 선택 해주세요.");
                System.out.println();
                return true;
            }
        }
    }
}
