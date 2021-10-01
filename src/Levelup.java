import java.util.logging.Level;

public class Levelup extends Feature {

    private boolean grow;
    private int level;
    private int famous;

    public boolean isGrow() {
        return grow;
    }

    public void setGrow(boolean grow) {
        this.grow = grow;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFamous() {
        return famous;
    }

    public void setFamous(int famous) {
        this.famous = famous;
    }

    public Levelup(int level, int economy, int religion, int force, int population, int famous, boolean grow) {
        super(economy, religion, force, population);
        this.grow = grow;
        this.level = level;
        this.famous = famous;
    }

    public Levelup(){

    }

    public void levelshow (){
        System.out.println();
        System.out.println();
        System.out.println("---------------------다음 목표 도시 레벨 : " + getLevel() + " ---------------------");
        System.out.println("필요한 도시의 경제력 or 종교력 or 군사력 : " + getEconomy());;
        System.out.println("필요한 도시의 인구수 : " + getPopulation());
        System.out.println("필요한 도시의 명성도 : " + getFamous());
        System.out.println("---------------------------------------------------------------------------");
        System.out.println();
        System.out.println();
    }

    public static void canGrow(City mycity, Levelup[] other){
        if (mycity.getLevel() == 1){
            System.out.println("다음 도시 레벨은 " + other[0].getLevel() + "레벨 입니다.");
            other[0].levelshow();
            if((mycity.getEconomy() >= other[0].getEconomy() || mycity.getReligion() >= other[0].getReligion() || mycity.getForce() >= other[0].getForce()) && mycity.getPopulation() >= other[0].getPopulation() && mycity.getFamous() >= other[0].getFamous()){
                other[0].setGrow(true);
            }
            System.out.println("레벨업 가능 여부 : " + other[0].isGrow());
            if (other[0].isGrow() == true){
                System.out.println("조건이 충족되었습니다. \n도시 레벨업이 진행되었습니다.");
                mycity.setLevel(2);

            } else {
                System.out.println("조건이 충족되지 못했습니다.\n");
                if (mycity.getPopulation() < other[0].getPopulation()){
                    System.out.println("인구수가 부족합니다.");
                } else if (mycity.getFamous() < other[0].getFamous()){
                    System.out.println("명성이 부족합니다.");
                } else if ((mycity.getEconomy() < other[0].getEconomy() && mycity.getReligion() < other[0].getReligion() && mycity.getForce() < other[0].getForce())){
                    System.out.println("성장 스탯(경제력 or 종교력 or 군사력)이 부족합니다.");
                }
            }
        } else if (mycity.getLevel() == 2){
            System.out.println("다음 도시 레벨은 " + other[1].getLevel() + "레벨 입니다.");
            other[1].levelshow();
            if((mycity.getEconomy() >= other[1].getEconomy() || mycity.getReligion() >= other[1].getReligion() || mycity.getForce() >= other[1].getForce()) && mycity.getPopulation() >= other[1].getPopulation() && mycity.getFamous() >= other[1].getFamous()){
                other[1].setGrow(true);
            }
            System.out.println("레벨업 가능 여부 : " + other[1].isGrow());
            if (other[1].isGrow() == true){
                System.out.println("조건이 충족되었습니다. \n도시 레벨업이 진행되었습니다.");
                mycity.setLevel(3);
                //mycity.status();
            } else {
                System.out.println("조건이 충족되지 못했습니다.\n");
                if (mycity.getPopulation() < other[1].getPopulation()){
                    System.out.println("인구수가 부족합니다.");
                } else if (mycity.getFamous() < other[1].getFamous()){
                    System.out.println("명성이 부족합니다.");
                } else if ((mycity.getEconomy() < other[1].getEconomy() && mycity.getReligion() < other[1].getReligion() && mycity.getForce() < other[1].getForce())){
                    System.out.println("성장 스탯(경제력 or 종교력 or 군사력)이 부족합니다.");
                }
            }
        } else if (mycity.getLevel() == 3){
            System.out.println("다음 도시 레벨은 " + other[2].getLevel() + "레벨 입니다.");
            other[2].levelshow();
            if((mycity.getEconomy() >= other[2].getEconomy() || mycity.getReligion() >= other[2].getReligion() || mycity.getForce() >= other[2].getForce()) && mycity.getPopulation() >= other[2].getPopulation() && mycity.getFamous() >= other[2].getFamous()){
                other[2].setGrow(true);
            }
            System.out.println("레벨업 가능 여부 : " + other[2].isGrow());
            if (other[2].isGrow() == true){
                System.out.println("조건이 충족되었습니다. \n도시 레벨업이 진행되었습니다.");
                mycity.setLevel(4);
                //mycity.status();
            } else {
                System.out.println("조건이 충족되지 못했습니다.\n");
                if (mycity.getPopulation() < other[2].getPopulation()){
                    System.out.println("인구수가 부족합니다.");
                } else if (mycity.getFamous() < other[2].getFamous()){
                    System.out.println("명성이 부족합니다.");
                } else if ((mycity.getEconomy() < other[2].getEconomy() && mycity.getReligion() < other[2].getReligion() && mycity.getForce() < other[2].getForce())){
                    System.out.println("성장 스탯(경제력 or 종교력 or 군사력)이 부족합니다.");
                }
            }
        } else {
            System.out.println("다음 도시 레벨은 " + other[3].getLevel() + "레벨 입니다.");
            other[3].levelshow();
            if((mycity.getEconomy() >= other[3].getEconomy() || mycity.getReligion() >= other[3].getReligion() || mycity.getForce() >= other[3].getForce()) && mycity.getPopulation() >= other[3].getPopulation() && mycity.getFamous() >= other[3].getFamous()){
                other[3].setGrow(true);
            }
            System.out.println("레벨업 가능 여부 : " + other[3].isGrow());
            if (other[3].isGrow() == true){
                System.out.println("조건이 충족되었습니다. \n도시 레벨업이 진행되었습니다.");
                mycity.setLevel(5);
                //mycity.status();
            } else {
                System.out.println("조건이 충족되지 못했습니다.\n");
                if (mycity.getPopulation() < other[3].getPopulation()){
                    System.out.println("인구수가 부족합니다.");
                } else if (mycity.getFamous() < other[3].getFamous()){
                    System.out.println("명성이 부족합니다.");
                } else if ((mycity.getEconomy() < other[3].getEconomy() && mycity.getReligion() < other[3].getReligion() && mycity.getForce() < other[3].getForce())){
                    System.out.println("성장 스탯(경제력 or 종교력 or 군사력)이 부족합니다.");
                }
            }
        }
    }




}
