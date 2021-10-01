public class Expert extends Feature {

    private String name;
    private int wage;
    private int contract_price;
    private int energy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getContract_price() {
        return contract_price;
    }

    public void setContract_price(int contract_price) {
        this.contract_price = contract_price;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Expert(int economy, int religion, int force, int population, String name, int wage, int contract_price, int energy) {
        super(economy, religion, force, population);
        this.name = name;
        this.wage = wage;
        this.contract_price = contract_price;
        this.energy = energy;
    }

    public static void listshow(Expert[] other){
        for (int i = 0; i < other.length; i++){
            System.out.println("---------------------- 전문가 " + (i+1) + " ------------------------");
            System.out.println("이름 : " + other[i].getName());
            System.out.println("계약금 : " + other[i].getContract_price()+ "G");
            System.out.println("유지금 : " + other[i].getWage() + "G");
            System.out.println("증가하는 경제력 : " + other[i].getEconomy());
            System.out.println("증가하는 종교력 : " + other[i].getReligion());
            System.out.println("증가하는 군사력 : " + other[i].getForce());
            System.out.println("증가하는 인구수 : " + other[i].getPopulation());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
        }
        System.out.println();
        System.out.println("9 : 처음으로 돌아가기");
        System.out.println();
    }

    public static boolean hire(City mycity, int sc_num, Expert[] other){
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
            if (mycity.getGold() >= other[sc_num-1].getContract_price()){
                System.out.println();
                System.out.println("주의 : 전문가는 유지비가 발생합니다. \n과도한 전문가 고용은 재정 파탄으로 이어질 수 있습니다.");
                System.out.println("전문가는 "+ other[sc_num-1].getPopulation() + "의 인구수를 제공합니다.");
                System.out.println();
                System.out.println(other[sc_num-1].getName() + "를 고용했습니다.");
                System.out.println();
                System.out.println("경제력 : " + mycity.getEconomy() + "  ▶  " + (mycity.getEconomy()+other[sc_num-1].getEconomy()));
                System.out.println("종교력 : " + mycity.getReligion() + "  ▶  " + (mycity.getReligion()+other[sc_num-1].getReligion()));
                System.out.println("군사력 : " + mycity.getForce() + "  ▶  " + (mycity.getForce()+other[sc_num-1].getForce()));
                System.out.println("인구수 : " + mycity.getPopulation() + "  ▶  " + (mycity.getPopulation() + other[sc_num-1].getPopulation()));
                System.out.println("전문가 유지비 : " + (mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2])*10 + "  ▶  " + (mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2]+1)*10);
                System.out.println("보유골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold()-other[sc_num-1].getContract_price()));
                System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num-1].getEnergy()));
                mycity.setEconomy(mycity.getEconomy()+other[sc_num-1].getEconomy());
                mycity.setReligion(mycity.getReligion()+other[sc_num-1].getReligion());
                mycity.setForce(mycity.getForce()+other[sc_num-1].getForce());
                mycity.setPopulation(mycity.getPopulation() + other[sc_num-1].getPopulation());
                mycity.setGold(mycity.getGold()-other[sc_num-1].getContract_price());
                mycity.setEnergy(mycity.getEnergy() - other[sc_num-1].getEnergy());
                int[] arr = new int[]{mycity.getEmployed()[0] + numarr[0],mycity.getEmployed()[1] + numarr[1],mycity.getEmployed()[2] + numarr[2]};
                mycity.setEmployed(arr);
                return false;
            }
            else {
                System.out.println("계약하는데 필요한 골드가 부족합니다. \n돈을 모아서 다시 시도해주세요.");
                return false;
            }
        }
    }


    public static boolean fire(City mycity, int sc_num, Expert[] other){
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
                if (mycity.getEmployed()[0] == 0){
                    System.out.println();
                    System.out.println("고용하고있는 경제학자가 없어서 해고할 수 없습니다.");
                    System.out.println("다른 전문가를 선택해주세요.");
                    System.out.println();
                    return true;
                }
                else {
                    numarr[0] = 1;
                }
            }
            else if (sc_num == 2) {
                if (mycity.getEmployed()[1] == 0){
                    System.out.println();
                    System.out.println("고용하고있는 신학자가 없어서 해고할 수 없습니다.");
                    System.out.println("다른 전문가를 선택해주세요.");
                    System.out.println();
                    return true;
                }
                else {
                    numarr[1] = 1;
                }
            } else {
                if (mycity.getEmployed()[2] == 0){
                    System.out.println();
                    System.out.println("고용하고있는 군사전문가가 없어서 해고할 수 없습니다.");
                    System.out.println("다른 전문가를 선택해주세요.");
                    System.out.println();
                    return true;
                }
                else {
                    numarr[2] = 1;
                }
            }

            System.out.println(other[sc_num-1].getName() +"를 해고합니다");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("도시의 경제력/종교력/군사력/인구수 (이)가 감소합니다.");
            System.out.println("경제력 : " + mycity.getEconomy() + "  ▶  " + (mycity.getEconomy()-other[sc_num-1].getEconomy()));
            System.out.println("종교력 : " + mycity.getReligion() + "  ▶  " + (mycity.getReligion()-other[sc_num-1].getReligion()));
            System.out.println("군사력 : " + mycity.getForce() + "  ▶  " + (mycity.getForce()-other[sc_num-1].getForce()));
            System.out.println("인구수 : " + mycity.getPopulation() + "  ▶  " + (mycity.getPopulation()-other[sc_num-1].getPopulation()));
            System.out.println("유지비 : " + (mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2])*10 + "  ▶  " + (mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2]-1)*10);
            System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num-1].getEnergy()));
            mycity.setEconomy(mycity.getEconomy()-other[sc_num-1].getEconomy());
            mycity.setReligion(mycity.getReligion()-other[sc_num-1].getReligion());
            mycity.setForce(mycity.getForce()-other[sc_num-1].getForce());
            mycity.setPopulation(mycity.getPopulation()-other[sc_num-1].getPopulation());
            mycity.setEnergy(mycity.getEnergy() - other[sc_num-1].getEnergy());
            int[] arr = new int[]{mycity.getEmployed()[0] - numarr[0],mycity.getEmployed()[1] - numarr[1],mycity.getEmployed()[2] - numarr[2]};
            mycity.setEmployed(arr);
            return false;
        }
    }


    public static void calculate(City mycity, Master[] other){
        boolean influencer = false;
        for (int i = 0; i < other.length; i++){
            if(other[i].isContract() == true){
                influencer = true;
            }
        }

        if (influencer == true){
            System.out.println();
            System.out.println("-----------------유지비가 차감되었습니다-----------------");
            int employers = mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2];
            System.out.println("보유골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold()-(employers*10 + other[0].getWage())));
            mycity.setGold(mycity.getGold()-(employers*10 + other[0].getWage()));
        } else {
            if (mycity.getEmployed()[0] == 0 && mycity.getEmployed()[1] == 0 && mycity.getEmployed()[2] == 0 ){
            }
            else {
                System.out.println();
                System.out.println("-----------------유지비가 차감되었습니다-----------------");
                int employers = mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2];
                System.out.println("보유골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold()-employers*10));
                mycity.setGold(mycity.getGold()-employers*10);
            }
        }
    }

}
