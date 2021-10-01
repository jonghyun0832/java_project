public class Building extends Feature{

    private String name;
    private int price;
    private int energy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Building(int economy, int religion, int force, int population, String name, int price,int energy) {
        super(economy, religion, force, population);
        this.name = name;
        this.price = price;
        this.energy = energy;
    }

    public static void listshow(Building[] other){
        for (int i = 0; i < other.length; i++){
            System.out.println("---------------------- 건물 " + (i+1) + " ------------------------");
            System.out.println("이름 : " + other[i].getName());
            System.out.println("가격 : " + other[i].getPrice()+ "G");
            System.out.println("증가하는 경제력 : " + other[i].getEconomy());
            System.out.println("증가하는 종교력 : " + other[i].getReligion());
            System.out.println("증가하는 군사력 : " + other[i].getForce());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
            System.out.println();
        }
        System.out.println();
        System.out.println("9 : 처음으로 돌아가기");
        System.out.println();
    }

    public static boolean buy(City mycity, int sc_num, Building[] other){
        int[] numarr = new int[]{0,0,0};
        if (sc_num == 1){
            numarr[0] = 1;
        }
        else if (sc_num == 2){
            numarr[1] = 1;
        }
        else if (sc_num == 3){
            numarr[2] = 1;
        }
        if (mycity.getEnergy() < other[sc_num - 1].getEnergy()){
            System.out.println();
            System.out.println("도시 활동력이 부족합니다. \n휴식을 취하면 도시 활동력을 회복할 수 있습니다.");
            System.out.println("현재 도시 활동력 : " + mycity.getEnergy());
            System.out.println("필요한 활동력 : " + other[sc_num-1].getEnergy());
            System.out.println();
            return false;
        }
        else {
            if (mycity.getGold() >= other[sc_num - 1].getPrice()){
                System.out.println("골드를 지불하고 건물을 건설합니다.");
                System.out.println();
                System.out.println();
                System.out.println(other[sc_num-1].getName() + "을 성공적으로 건설하였습니다.");
                System.out.println("도시의 경제력/종교력/군사력이 증가합니다.");
                System.out.println("경제력 : " + mycity.getEconomy() + "  ▶  " + (mycity.getEconomy()+other[sc_num-1].getEconomy()));
                System.out.println("종교력 : " + mycity.getReligion() + "  ▶  " + (mycity.getReligion()+other[sc_num-1].getReligion()));
                System.out.println("군사력 : " + mycity.getForce() + "  ▶  " + (mycity.getForce()+other[sc_num-1].getForce()));
                System.out.println("보유골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold()-other[sc_num-1].getPrice()));
                System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num-1].getEnergy()));
                mycity.setEconomy(mycity.getEconomy()+other[sc_num-1].getEconomy());
                mycity.setReligion(mycity.getReligion()+other[sc_num-1].getReligion());
                mycity.setForce(mycity.getForce()+other[sc_num-1].getForce());
                mycity.setGold(mycity.getGold()-other[sc_num-1].getPrice());
                mycity.setEnergy(mycity.getEnergy() - other[sc_num-1].getEnergy());
                int[] arr = new int[]{mycity.getOwnbuliding()[0] + numarr[0],mycity.getOwnbuliding()[1] + numarr[1],mycity.getOwnbuliding()[2] + numarr[2]};
                mycity.setOwnbuliding(arr);
                return false;
            }
            else {
                System.out.println("건설하는데 필요한 골드가 부족합니다. \n돈을 모아서 다시 시도해주세요.");
                return false;
            }
        }
    }

    public static boolean sell(City mycity, int sc_num, Building[] other){
        if (mycity.getEnergy() < other[sc_num - 1].getEnergy()){
            System.out.println();
            System.out.println("도시 활동력이 부족합니다. \n휴식을 취하면 도시 활동력을 회복할 수 있습니다.");
            System.out.println("현재 도시 활동력 : " + mycity.getEnergy());
            System.out.println("필요한 활동력 : " + other[sc_num-1].getEnergy());
            System.out.println();
            return false;
        }
        else {
            int[] numarr = new int[]{0,0,0};
            if (sc_num == 1){
                if (mycity.getOwnbuliding()[0] == 0){
                    System.out.println();
                    System.out.println("보유하고 있는 시장이 없어서 매각할 수 없습니다.");
                    System.out.println("다른 건물을 선택해주세요.");
                    System.out.println();
                    return true;
                }
                else{
                    numarr[0] = 1;
                }
            }
            else if (sc_num == 2){
                if (mycity.getOwnbuliding()[1] == 0){
                    System.out.println();
                    System.out.println("보유하고 있는 신학 건물이 없어서 매각할 수 없습니다.");
                    System.out.println("다른 건물을 선택해주세요.");
                    System.out.println();
                    return true;
                }
                else {
                    numarr[1] = 1;
                }

            }
            else if (sc_num == 3){
                if (mycity.getOwnbuliding()[2] == 0){
                    System.out.println();
                    System.out.println("보유하고 있는 훈련소가 없어서 매각할 수 없습니다.");
                    System.out.println("다른 건물을 선택해주세요.");
                    System.out.println();
                    return true;
                }
                else{
                    numarr[2] = 1;
                }
            }
            System.out.println(other[sc_num-1].getName() +"을 매각합니다.");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(other[sc_num-1].getName() + "을 매각하여 " + other[sc_num-1].getPrice()*0.5 + "G를 얻었습니다.");
            System.out.println("도시의 경제력/종교력/군사력이 감소합니다.");
            System.out.println("경제력 : " + mycity.getEconomy() + "  ▶  " + (mycity.getEconomy()-other[sc_num-1].getEconomy()));
            System.out.println("종교력 : " + mycity.getReligion() + "  ▶  " + (mycity.getReligion()-other[sc_num-1].getReligion()));
            System.out.println("군사력 : " + mycity.getForce() + "  ▶  " + (mycity.getForce()-other[sc_num-1].getForce()));
            System.out.println("보유골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold()+(int)(other[sc_num-1].getPrice()*0.5)));
            System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num-1].getEnergy()));
            mycity.setEconomy(mycity.getEconomy()-other[sc_num-1].getEconomy());
            mycity.setReligion(mycity.getReligion()-other[sc_num-1].getReligion());
            mycity.setForce(mycity.getForce()-other[sc_num-1].getForce());
            mycity.setGold(mycity.getGold()+(int)(other[sc_num-1].getPrice()*0.5));
            mycity.setEnergy(mycity.getEnergy() - other[sc_num-1].getEnergy());
            int[] arr = new int[]{mycity.getOwnbuliding()[0] - numarr[0],mycity.getOwnbuliding()[1] - numarr[1],mycity.getOwnbuliding()[2] - numarr[2]};
            mycity.setOwnbuliding(arr);

            return false;
        }
    }
}
