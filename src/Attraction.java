public class Attraction extends Building {


    private boolean produce;
    private int increasefamous;



    public boolean isProduce() {
        return produce;
    }

    public void setProduce(boolean produce) {
        this.produce = produce;
    }

    public int getIncreasefamous() {
        return increasefamous;
    }

    public void setIncreasefamous(int increasefamous) {
        this.increasefamous = increasefamous;
    }

    public Attraction(int economy, int religion, int force, int population, String name, int price,int increasefamous, boolean produce,int energy) {
        super(economy, religion, force, population, name, price,energy);
        this.produce = produce;
        this.increasefamous = increasefamous;
    }

    public static void listshow(Attraction[] other){
        for (int i = 0; i < other.length; i++){
            System.out.println("---------------------- 명소 " + (i+1) + " ------------------------");
            System.out.println("이름 : " + other[i].getName());
            System.out.println("가격 : " + other[i].getPrice()+ "G");
            System.out.println("증가하는 경제력 : " + other[i].getEconomy());
            System.out.println("증가하는 종교력 : " + other[i].getReligion());
            System.out.println("증가하는 군사력 : " + other[i].getForce());
            System.out.println("증가하는 인구수 : " + other[i].getPopulation());
            System.out.println("증가하는 명성 : " + other[i].getIncreasefamous());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
            System.out.println();
        }
        System.out.println();
        System.out.println("9 : 처음으로 돌아가기");
    }

    public static boolean build(City mycity, int sc_num, Attraction[] other){
        if (mycity.getEnergy() < other[sc_num - 1].getEnergy()){
            System.out.println();
            System.out.println("도시 활동력이 부족합니다. \n휴식을 취하면 도시 활동력을 회복할 수 있습니다.");
            System.out.println("현재 도시 활동력 : " + mycity.getEnergy());
            System.out.println("필요한 활동력 : " + other[sc_num-1].getEnergy());
            System.out.println();
            return false;
        }
        else {
            if (mycity.getGold() >= other[sc_num-1].getPrice()){
                System.out.println("명소 " + other[sc_num-1].getName() + "(을)를 건설합니다.");
                System.out.println();
                System.out.println();
                System.out.println("명소 " + other[sc_num-1].getName() + "(을)를 성공적으로 건설했습니다.");
                System.out.println("경제력 : " + mycity.getEconomy() + "  ▶  " + (mycity.getEconomy()+other[sc_num-1].getEconomy()));
                System.out.println("종교력 : " + mycity.getReligion() + "  ▶  " + (mycity.getReligion()+other[sc_num-1].getReligion()));
                System.out.println("군사력 : " + mycity.getForce() + "  ▶  " + (mycity.getForce()+other[sc_num-1].getForce()));
                System.out.println("명성 : " + mycity.getFamous() + "  ▶  " + (mycity.getFamous()+other[sc_num-1].getIncreasefamous()));
                System.out.println("보유골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold()-other[sc_num-1].getPrice()));
                System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num-1].getEnergy()));
                mycity.setEconomy(mycity.getEconomy()+other[sc_num-1].getEconomy());
                mycity.setReligion(mycity.getReligion()+other[sc_num-1].getReligion());
                mycity.setForce(mycity.getForce()+other[sc_num-1].getForce());
                mycity.setFamous(mycity.getFamous()+other[sc_num-1].getIncreasefamous());
                mycity.setGold(mycity.getGold()-other[sc_num-1].getPrice());
                mycity.setEnergy(mycity.getEnergy() - other[sc_num-1].getEnergy());
                other[sc_num-1].setProduce(true);
                mycity.setExistattraction(true);
                System.out.println();
                System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆ 이제부터 명인을 뽑을 수 있습니다. ☆☆☆☆☆☆☆☆☆☆☆☆☆");
                System.out.println();
            }
            else {
                System.out.println("명소 건설에 필요한 골드가 부족합니다. \n돈을 모아서 다시 시도해주세요.");
            }
            return false;
        }
    }

}
