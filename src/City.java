import javax.swing.*;
import java.util.ArrayList;

public class City extends Feature {
    private int number;
    private String name;
    private int level;
    private int happy;
    private int famous;
    private String explain;
    private int gold;
    private int[] cooltime = new int[3]; //무역 축제 종교 사냥
    private int[] ownbuliding = new int[3]; //경제 종교 군사
    private int[] employed = new int[3]; //경제 종교 군사
    private int day;
    private int energy;
    private boolean existattraction;
    private int masternum;
    private int friendship;
    private int waiting;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getFamous() {
        return famous;
    }

    public void setFamous(int famous) {
        this.famous = famous;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }


    public int[] getCooltime() {
        return cooltime;
    }

    public void setCooltime(int[] cooltime) {
        this.cooltime = cooltime;
    }

    public int[] getOwnbuliding() {
        return ownbuliding;
    }

    public void setOwnbuliding(int[] ownbuliding) {
        this.ownbuliding = ownbuliding;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int[] getEmployed() {
        return employed;
    }

    public void setEmployed(int[] employed) {
        this.employed = employed;
    }

    public boolean isExistattraction() {
        return existattraction;
    }

    public void setExistattraction(boolean existattraction) {
        this.existattraction = existattraction;
    }

    public int getMasternum() {
        return masternum;
    }

    public void setMasternum(int masternum) {
        this.masternum = masternum;
    }

    public int getFriendship() {
        return friendship;
    }

    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }

    public int getWaiting() {
        return waiting;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }

    public City(int economy, int religion, int force, int number, String name, int level, int happy, int population, int famous, int gold, int[] cooltime, int[] ownbuliding, int[] employed, int day, int energy, int friendship, boolean existattraction, String explain) {
        super(economy, religion, force, population);
        this.number = number;
        this.name = name;
        this.level = level;
        this.happy = happy;
        this.famous = famous;
        this.explain = explain;
        this.gold = gold;
        this.cooltime = cooltime;
        this.ownbuliding = ownbuliding;
        this.day = day;
        this.energy = energy;
        this.employed = employed;
        this.existattraction = existattraction;
        this.friendship = friendship;
    }

    public City() {

    }

    public void status() {
        System.out.println();
        System.out.println("--------------당신의 도시 상태입니다----------------");
        System.out.println("도시이름 : " + name);
        System.out.println("도시레벨 : " + level);
        System.out.println("행복도 : " + happy);
        System.out.println("경제력 : " + getEconomy());
        System.out.println("종교력 : " + getReligion());
        System.out.println("군사력 : " + getForce());
        System.out.println("인구수 : " + getPopulation());
        System.out.println("명성 : " + famous);
        System.out.println("보유 골드 : " + gold + "G");
        System.out.println("활동력 : " + getEnergy());
        System.out.println("진행일수 : DAY " + getDay());
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    public void enemystatus() {
        System.out.println();
        System.out.println("--------------상대 도시 상태입니다----------------");
        System.out.println("도시이름 : " + name);
        System.out.println("도시레벨 : " + level);
        System.out.println("경제력 : " + getEconomy());
        System.out.println("종교력 : " + getReligion());
        System.out.println("군사력 : " + getForce());
        System.out.println("지금 우호점수 : " + getFriendship());
        if (getFriendship() >= 70) {
            System.out.println("상대 도시 : 우호적");
        } else if (getFriendship() < 70 && getFriendship() >= 30) {
            System.out.println("상대 도시 : 보통");
        } else if (getFriendship() < 30 && getFriendship() >= 10){
            System.out.println("상대 도시 : 적대적");
        } else {
            System.out.println("상대 도시 : 원수");
        }
        //System.out.println("인구수 : " + getPopulation());
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    public void startcity() {
        System.out.println("---------------------------시작 도시 선택 -----------------------------");
        System.out.println("도시번호 : " + number);
        System.out.println("도시이름 : " + name);
        System.out.println("도시의 특징 : " + explain);
        System.out.println("---------------------------------------------------------------------");
        System.out.println();
    }

    public void showcooltime() {
        System.out.println("-----------------------현재 도시 쿨타임----------------------------------");
        System.out.println("무역 쿨타임(DAY) : " + getCooltime()[0]);
        System.out.println("축제 쿨타임(DAY) : " + getCooltime()[1]);
        System.out.println("종교 쿨타임(DAY) : " + getCooltime()[2]);
        System.out.println();
    }

    public void showbuilding() {
        System.out.println("-----------------------건물 보유 현황----------------------------------");
        System.out.println("시장 : " + getOwnbuliding()[0] + "개");
        System.out.println("신학건물 : " + getOwnbuliding()[1] + "개");
        System.out.println("훈련소 : " + getOwnbuliding()[2] + "개");
        System.out.println();
    }

    public void showbuilding(Attraction[] other) {
        boolean isthere = false;
        System.out.println("-----------------------건물 보유 현황----------------------------------");
        System.out.println("시장 : " + getOwnbuliding()[0] + "개");
        System.out.println("신학건물 : " + getOwnbuliding()[1] + "개");
        System.out.println("훈련소 : " + getOwnbuliding()[2] + "개");
        System.out.println();
        System.out.println("------------------------명소 보유현황----------------------------------");
        for (int i = 0; i < other.length; i++) {
            if (other[i].isProduce() == true) {
                System.out.println();
                System.out.println("                        " + other[i].getName());
                System.out.println();
                System.out.println("-------------------------------------------------------------------");
                isthere = true;
            }
        }
        if (isthere == false) {
            System.out.println();
            System.out.println("보유중인 명소가 없습니다.");
        }
    }

    public void showemployer() {
        System.out.println("-----------------------전문가 보유 현황----------------------------------");
        System.out.println("경제학자 : " + getEmployed()[0] + "명");
        System.out.println("신학자 : " + getEmployed()[1] + "명");
        System.out.println("군사전문가 : " + getEmployed()[2] + "명");
        System.out.println();
    }

    public void showemployer(Master[] other) {
        boolean isthere = false;
        System.out.println("-----------------------전문가 보유 현황----------------------------------");
        System.out.println("경제학자 : " + getEmployed()[0] + "명");
        System.out.println("신학자 : " + getEmployed()[1] + "명");
        System.out.println("군사전문가 : " + getEmployed()[2] + "명");
        System.out.println();
        System.out.println("-----------------------명인 보유 현황----------------------------------");
        for (int i = 0; i < other.length; i++) {
            if (other[i].isContract() == true) {
                System.out.println();
                System.out.println("                         " + other[i].getName());
                System.out.println();
                System.out.println("-------------------------------------------------------------------");
                isthere = true;
            }
        }
        if (isthere == false) {
            System.out.println();
            System.out.println("도시와 계약중인 명인이 없습니다.");
        }
    }


    public City startinfo(City other) {
        System.out.println("선택하신도시는 " + other.getName() + " 입니다.");
        System.out.println();
        other.status();
        return other;
    }


    public void rest() {
        System.out.println("휴식을 취해 행동 쿨타임과 도시 활동력이 증가되었습니다.");
        System.out.println("(도시의 명성이 높아지면 인구수 증가량이 늘어납니다)");
        System.out.println();
        if (getCooltime()[0] == 0) {
            System.out.println("무역 쿨타임(DAY) : " + getCooltime()[0] + "  ▶  " + getCooltime()[0]);
        } else {
            System.out.println("무역 쿨타임(DAY) : " + getCooltime()[0] + "  ▶  " + (getCooltime()[0] - 1));
            int[] arr = new int[]{getCooltime()[0] - 1, getCooltime()[1], getCooltime()[2]};
            setCooltime(arr);
        }
        if (getCooltime()[1] == 0) {
            System.out.println("축제 쿨타임(DAY) : " + getCooltime()[1] + "  ▶  " + getCooltime()[1]);
        } else {
            System.out.println("축제 쿨타임(DAY) : " + getCooltime()[1] + "  ▶  " + (getCooltime()[1] - 1));
            int[] arr = new int[]{getCooltime()[0], getCooltime()[1] - 1, getCooltime()[2]};
            setCooltime(arr);
        }
        if (getCooltime()[2] == 0) {
            System.out.println("종교 쿨타임(DAY) : " + getCooltime()[2] + "  ▶  " + getCooltime()[2]);
        } else {
            System.out.println("종교 쿨타임(DAY) : " + getCooltime()[2] + "  ▶  " + (getCooltime()[2] - 1));
            int[] arr = new int[]{getCooltime()[0], getCooltime()[1], getCooltime()[2] - 1};
            setCooltime(arr);
        }
        if (getEnergy() + (getLevel() * 2) >= getLevel() * 5) {
            System.out.println("도시 활동력      : " + getEnergy() + "  ▶  " + getLevel() * 5);
            setEnergy(getLevel() * 5);
        } else {
            System.out.println("도시 활동력      : " + getEnergy() + "  ▶  " + (getEnergy() + (getLevel() * 2)));
            setEnergy(getEnergy() + (getLevel() * 2));
        }
        System.out.println("인구수          : " + getPopulation() + "  ▶  " + (getPopulation() + 1 + (int) (getFamous() * 0.1)));
        setPopulation((getPopulation() + 1 + (int) (getFamous() * 0.1)));
        System.out.println("DAY            : " + getDay() + "  ▶  " + (getDay() + 1));
        setDay(getDay() + 1);

    }

    public synchronized void search(City mycity, City enemycity, City enemycity_observe,JTextArea txtArea,ArrayList<JTextField> txt_list3) {
        System.out.println("탐험대를 파견합니다.");
        System.out.println((5 - mycity.getLevel()) + "초후 적의 정보가 갱신됩니다.");
        Thread t1 = new Thread(new thread1(mycity, enemycity, enemycity_observe, txtArea,txt_list3));
        t1.start();
    }



    /*public synchronized void rest2(City mycity) {
        System.out.println("쿨타임 회복");
        System.out.println();
        Thread t2 = new Thread(new cooltime_thread(mycity));
        t2.setDaemon(true);
        t2.start();
    }*/

    public void donate(City mycity, City enemycity, int money) {
        if (money < 50) {
            System.out.println("최소금액 이상을 입력해주세요.\n첫 화면으로 돌아갑니다.");
        } else {
            System.out.println(money + "G 를 상대도시에 기부합니다.");
            System.out.println();
            System.out.println("상대 도시의 우호도가 증가합니다.");
            enemycity.setFriendship(enemycity.getFriendship() + money / 50); //100골드에 2씩오름
            mycity.setGold(mycity.getGold() - money);
        }
    }

    public boolean interact(City mycity, City enemycity, int num, boolean chance) {
        if (chance == true) {
            if (num == 1) {
                System.out.println("경제 교류로 두 도시의 경제력이 모두 증가합니다.(양쪽 도시 경제력 합의 50%)");
                System.out.println();
                System.out.println("각 도시의 경제력 증가 수치" + "  ▶  " + (mycity.getEconomy() + enemycity.getEconomy())/2);
                mycity.setEconomy(mycity.getEconomy() + (mycity.getEconomy() + enemycity.getEconomy())/2);
                enemycity.setEconomy(enemycity.getEconomy() + (mycity.getEconomy() + enemycity.getEconomy())/2);
            } else if (num == 2) {
                System.out.println("종교 교류로 두 도시의 종교력이 모두 증가합니다.(양쪽 도시 종교력 합의 50%)");
                System.out.println();
                System.out.println("각 도시의 종교력 증가 수치" + "  ▶  " + (mycity.getReligion() + enemycity.getReligion())/2);
                mycity.setReligion(mycity.getReligion() + (mycity.getReligion() + enemycity.getReligion())/2);
                enemycity.setReligion(enemycity.getReligion() + (mycity.getReligion() + enemycity.getReligion())/2);
            } else {
                System.out.println("군사 교류로 두 도시의 군사력이 모두 증가합니다.(양쪽 도시 군사력 합의 50%)");
                System.out.println();
                System.out.println("각 도시의 군사력 증가 수치" + "  ▶  " + (mycity.getForce() + enemycity.getForce())/2);
                mycity.setForce(mycity.getForce() + (mycity.getForce() + enemycity.getForce())/2);
                enemycity.setForce(enemycity.getForce() + (mycity.getForce() + enemycity.getForce())/2);
            }
            return false;
        } else {
            System.out.println("이미 교류를 진행했기 떄문에 더이상 교류를 진행할 수 없습니다.");
            return false;
        }
    }

    public boolean pressure(City mycity, City enemycity, int num){
        if (num == 1){
            if (mycity.getEconomy() > enemycity.getEconomy()){
                System.out.println("상대 도시에 경제적 압박을 가했습니다.");
                System.out.println();
                System.out.println("상대 도시의 경제력이 감소합니다.");
                System.out.println("상대도시의 우호도 수치가 감소합니다.");
                System.out.println();
                enemycity.setEconomy(enemycity.getEconomy() - enemycity.getEconomy()/10);
                enemycity.setFriendship(enemycity.getFriendship() - 10);
                return false;

            } else {
                System.out.println("내 도시의 경제력이 상대 도시보다 높아야 압박을 할 수 있습니다.");
                return true;
            }
        } else if (num == 2){
            if(mycity.getReligion() > enemycity.getReligion()){
                System.out.println("상대 도시에 종교적 압박을 가했습니다.");
                System.out.println();
                System.out.println("상대 도시의 종교력이 감소합니다.");
                System.out.println("상대도시의 우호도 수치가 감소합니다.");
                System.out.println();
                enemycity.setReligion(enemycity.getReligion() - enemycity.getReligion()/10);
                enemycity.setFriendship(enemycity.getFriendship() - 10);
                return false;
            } else {
                System.out.println("내 도시의 종교력이 상대 도시보다 높아야 압박을 할 수 있습니다.");
                return true;
            }
        } else {
            if(mycity.getForce() > enemycity.getForce()){
                System.out.println("상대 도시에 군사적 압박을 가했습니다.");
                System.out.println();
                System.out.println("상대 도시의 군사력이 감소합니다.");
                System.out.println("상대도시의 우호도 수치가 감소합니다.");
                System.out.println();
                enemycity.setForce(enemycity.getForce() - enemycity.getForce()/10);
                enemycity.setFriendship(enemycity.getFriendship() - 10);
                return false;
            } else {
                System.out.println("내 도시의 군사력이 상대 도시보다 높아야 압박을 할 수 있습니다.");
                return true;
            }

        }
    }

    public boolean war(City mycity, City enemycity){
        if (enemycity.getFriendship() < 10){
            System.out.println("상대 도시에 선전포고를 합니다.");
            System.out.println();
            System.out.println();
            System.out.println();
            if(mycity.getForce() > enemycity.getForce()){
                System.out.println("상대 도시와의 전쟁에서 승리했습니다.");
                System.out.println();
                System.out.println("상대 도시의 군사력이 감소합니다. (80% 감소)");
                System.out.println("상대도시의 성장이 멈춥니다. (5일간)");
                System.out.println("상대도시의 우호도가 0이 됩니다.");
                System.out.println("당분간 상대 도시의 도발이 멈춥니다. (5일간)");
                enemycity.setForce(enemycity.getForce() - (enemycity.getForce()/10)*8);
                enemycity.setFriendship(0);
                enemycity.setWaiting(10);
                System.out.println("------------------------------------------------------");
                System.out.println("상대 도시가 전쟁 배상금을 내놓았습니다.");
                System.out.println("골드 : " + mycity.getGold() + "  ▶  " + (mycity.getGold() + 5000));
                mycity.setGold(mycity.getGold() + 5000);
                System.out.println();
                System.out.println();
                System.out.println("당신의 도시도 전쟁으로 인해 많은 피해를 입었습니다.");
                System.out.println();
                System.out.println("군사력 : " + mycity.getForce() + "  ▶  " + (mycity.getForce() - (mycity.getForce()/2)));
                System.out.println("인구수 : " + mycity.getPopulation() + "  ▶  " + (mycity.getPopulation() - (mycity.getPopulation()/2)));
                System.out.println("명성 : " + mycity.getFamous() + "  ▶  " + (mycity.getFamous() - (mycity.getFamous()/2)));
                System.out.println("행복도 : " + mycity.getHappy() + "  ▶  " + (mycity.getHappy() - (mycity.getHappy()/2)));
                mycity.setForce(mycity.getForce() - (mycity.getForce()/2));
                mycity.setPopulation(mycity.getPopulation() - (mycity.getPopulation()/2));
                mycity.setFamous(mycity.getFamous() - (mycity.getFamous()/2));
                mycity.setHappy(mycity.getHappy() - (mycity.getHappy()/2));
                return false;
            } else {
                Interface.Defeat_war();
                return true;
            }
        } else {
            System.out.println("전쟁은 상대 도시와 원수관계일 경우에만 가능합니다.");
            return false;
        }

    }

    public synchronized Thread rest2(City mycity,JTextArea txtArea) {
        System.out.println();
        Thread t2 = new Thread(new cooltime_thread(mycity,txtArea));
        t2.setDaemon(true);
        t2.start();
        return t2;
    }

    public void rest2_interrupt(Thread t2) {
        t2.interrupt();
    }


    public synchronized Thread rest3(City mycity,JTextArea txtArea) {
        System.out.println();
        Thread t3 = new Thread(new energy_thread(mycity, txtArea));
        t3.setDaemon(true);
        t3.start();
        return t3;
    }

    public void rest3_interrupt(Thread t3) {
        t3.interrupt();
    }


    public synchronized Thread rest4(City mycity, Master[] other, JTextArea txtArea) {
        System.out.println();
        Thread t4 = new Thread(new day_thread(mycity, other, txtArea));
        t4.setDaemon(true);
        t4.start();
        return t4;
    }

    public void rest4_interrupt(Thread t4) {
        t4.interrupt();
    }

    public synchronized Thread enemygrow(City enemycity, City mycity, int[] levelinfo, JTextArea txtArea) {
        Thread t5 = new Thread(new enemy_thread(enemycity, mycity, levelinfo, txtArea));
        t5.setDaemon(true);
        t5.start();
        return t5;
    }

    public void enemygrow_interrupt(Thread t5) {
        t5.interrupt();
    }

    public synchronized Thread city_status(City mycity, ArrayList<JTextField> txt_list){
        Thread t6 = new Thread(new citystatus(mycity,txt_list));
        t6.setDaemon(true);
        t6.start();
        return t6;
    }


}
