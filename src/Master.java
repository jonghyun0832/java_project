public class Master extends Expert{

    private int increasefamous;
    private boolean contract;

    public int getIncreasefamous() {
        return increasefamous;
    }

    public void setIncreasefamous(int increasefamous) {
        this.increasefamous = increasefamous;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    public Master(int economy, int religion, int force, int population, String name, int wage, int contract_price, int increasefamous, boolean contract, int energy) {
        super(economy, religion, force, population, name, wage, contract_price, energy);
        this.increasefamous = increasefamous;
        this.contract = contract;
    }

    public static void listshow(Master[] other) {
        for (int i = 0; i < other.length; i++){
            System.out.println("---------------------- 명인 " + (i+1) + " ------------------------");
            System.out.println("이름 : " + other[i].getName());
            System.out.println("계약금 : " + other[i].getContract_price()+ "G");
            System.out.println("유지금 : " + other[i].getWage() + "G");
            System.out.println("증가하는 경제력 : " + other[i].getEconomy());
            System.out.println("증가하는 종교력 : " + other[i].getReligion());
            System.out.println("증가하는 군사력 : " + other[i].getForce());
            System.out.println("증가하는 명성 : " + other[i].getIncreasefamous());
            System.out.println("필요한 활동력 : " + other[i].getEnergy());
            System.out.println();
        }
        System.out.println();
        System.out.println("9 : 처음으로 돌아가기");
    }

    public static boolean contract(City mycity, int sc_num, Master[] other){
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
                System.out.println("명인 " + other[sc_num-1].getName() + "(와)과 계약을 맺습니다.");
                System.out.println();
                System.out.println();
                System.out.println("명인 " + other[sc_num-1].getName() + "(와)과 성공적으로 계약을 맺어 도시에 영속시켰습니다.");
                System.out.println("경제력 : " + mycity.getEconomy() + "  ▶  " + (mycity.getEconomy()+other[sc_num-1].getEconomy()));
                System.out.println("종교력 : " + mycity.getReligion() + "  ▶  " + (mycity.getReligion()+other[sc_num-1].getReligion()));
                System.out.println("군사력 : " + mycity.getForce() + "  ▶  " + (mycity.getForce()+other[sc_num-1].getForce()));
                System.out.println("인구수 : " + mycity.getPopulation() + "  ▶  " + (mycity.getPopulation()+other[sc_num-1].getPopulation()));
                System.out.println("명성 : " + mycity.getFamous() + "  ▶  " + (mycity.getFamous()+other[sc_num-1].getIncreasefamous()));
                System.out.println("보유골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold()-other[sc_num-1].getContract_price()));
                System.out.println("유지비 : " + ((mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2])*10) +"  ▶  "+ (((mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2])*10) + other[sc_num-1].getWage()));
                System.out.println("도시 활동력 : " + mycity.getEnergy() + "  ▶  " + (mycity.getEnergy() - other[sc_num-1].getEnergy()));
                mycity.setEconomy(mycity.getEconomy()+other[sc_num-1].getEconomy());
                mycity.setReligion(mycity.getReligion()+other[sc_num-1].getReligion());
                mycity.setForce(mycity.getForce()+other[sc_num-1].getForce());
                mycity.setPopulation(mycity.getPopulation()+other[sc_num-1].getPopulation());
                mycity.setFamous(mycity.getFamous()+other[sc_num-1].getIncreasefamous());
                mycity.setGold(mycity.getGold()-other[sc_num-1].getContract_price());
                mycity.setEnergy(mycity.getEnergy() - other[sc_num-1].getEnergy());
                other[sc_num-1].setContract(true);
                mycity.setMasternum(sc_num);
                System.out.println();
                System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆ 이제부터 매턴 추가 명성을 얻습니다. ☆☆☆☆☆☆☆☆☆☆☆☆☆");
                System.out.println();
            }
            else {
                System.out.println("명인과 계약하기위한 계약금이 부족합니다. \n돈을 모아서 다시 시도해주세요.");
            }
            return false;
        }
    }

    public static void growpopular(City mycity, Master[] other) {
        boolean fa1 = false;
        boolean fa2 = false;
        boolean fa3 = false;

        for (int i = 0; i < other.length; i++){
            if(other[i].isContract() == true && i == 0){
                fa1 = true;
            } else if (other[i].isContract() == true && i == 1){
                fa2 = true;
            } else if (other[i].isContract() == true && i == 2){
                fa3 = true;
            }
        }

        if (fa1 == true){
            System.out.println();
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
            System.out.println();
            System.out.println("계약한 명인 : " + other[0].getName());
            System.out.println("경제분야명인을 보유했으므로 보너스 경제/명성이 부여됩니다.");
            System.out.println();
            System.out.println("경제력 : " + mycity.getEconomy() + "  ▶  " + (mycity.getEconomy()+3));
            System.out.println("명성 : " + mycity.getFamous() + "  ▶  " + (mycity.getFamous()+2));
            mycity.setEconomy((mycity.getEconomy()+3));
            mycity.setFamous((mycity.getFamous()+2));
            System.out.println();
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");

        } else if (fa2 == true){
            System.out.println();
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
            System.out.println();
            System.out.println("계약한 명인 : " + other[1].getName());
            System.out.println("종교분야명인을 보유했으므로 보너스 종교/명성이 부여됩니다.");
            System.out.println();
            System.out.println("종교력 : " + mycity.getReligion() + "  ▶  " + (mycity.getReligion()+3));
            System.out.println("명성 : " + mycity.getFamous() + "  ▶  " + (mycity.getFamous()+2));
            mycity.setEconomy((mycity.getReligion()+3));
            mycity.setFamous((mycity.getFamous()+2));
            System.out.println();
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");

        } else if (fa3 == true){
            System.out.println();
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
            System.out.println();
            System.out.println("계약한 명인 : " + other[2].getName());;
            System.out.println("군사분야명인을 보유했으므로 보너스 군사/명성이 부여됩니다.");
            System.out.println();
            System.out.println("군사력 : " + mycity.getForce() + "  ▶  " + (mycity.getForce()+3));
            System.out.println("명성 : " + mycity.getFamous() + "  ▶  " + (mycity.getFamous()+2));
            mycity.setEconomy((mycity.getForce()+3));
            mycity.setFamous((mycity.getFamous()+2));
            System.out.println();
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");

        } else {

        }
    }

}
