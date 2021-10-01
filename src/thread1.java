import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class thread1 implements Runnable {
    City mycity;
    City enemycity;
    City enemycity_observe;
    JTextArea txtArea;
    ArrayList<JTextField> txt_list3;

    public void observe(City enemycity, City enemycity_observe) {
        enemycity_observe.setLevel(enemycity.getLevel());
        enemycity_observe.setName(enemycity.getName());
        enemycity_observe.setEconomy(enemycity.getEconomy());
        enemycity_observe.setReligion(enemycity.getReligion());
        enemycity_observe.setForce(enemycity.getForce());
        enemycity_observe.setFriendship(enemycity.getFriendship());
    }

    public thread1(City mycity, City enemycity, City enemycity_observe, JTextArea txtArea, ArrayList<JTextField> txt_list3) {
        this.mycity = mycity;
        this.enemycity = enemycity;
        this.enemycity_observe = enemycity_observe;
        this.txtArea = txtArea;
        this.txt_list3 = txt_list3;
    }


    public void run() {
        try {
            Thread.sleep(5000 - mycity.getLevel()*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("적의 정보가 갱신되었습니다.");

        txtArea.append("적의 정보가 갱신되었습니다.\n");
        txtArea.append(" \n");
        txtArea.setCaretPosition(txtArea.getDocument().getLength());

        observe(enemycity, enemycity_observe);
        txt_list3.get(0).setText(enemycity.getName());
        txt_list3.get(1).setText(enemycity.getLevel() +"");
        txt_list3.get(2).setText(enemycity.getEconomy()+"");
        txt_list3.get(3).setText(enemycity.getReligion()+"");
        txt_list3.get(4).setText(enemycity.getForce()+"");
        if (enemycity.getFriendship() >= 70) {
            txt_list3.get(5).setText("우호적 (" + enemycity.getFriendship() + ")");
        } else if (enemycity.getFriendship() < 70 && enemycity.getFriendship() >= 30) {
            txt_list3.get(5).setText("보통 (" + enemycity.getFriendship() + ")");
        } else if (enemycity.getFriendship() < 30 && enemycity.getFriendship() >= 10){
            txt_list3.get(5).setText("적대적 (" + enemycity.getFriendship() + ")");
        } else {
            txt_list3.get(5).setText("원수 (" + enemycity.getFriendship() + ")");
        }
    }
}

class cooltime_thread implements Runnable {
    City mycity;
    JTextArea txtArea;

    public cooltime_thread(City mycity, JTextArea txtArea) {
        this.mycity = mycity;
        this.txtArea = txtArea;
    }

    @Override
    public void run() {
        boolean tmp = true;
        while (true) {
            if (mycity.getCooltime()[0] == 0 && mycity.getCooltime()[1] == 0 && mycity.getCooltime()[2] == 0) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    break;
                }
                if (tmp == true) {
                    //System.out.println("모든 쿨타임이 회복되었습니다.");
                    txtArea.append("모든 쿨타임이 회복되었습니다.\n");
                    txtArea.append(" \n");
                    txtArea.setCaretPosition(txtArea.getDocument().getLength());
                    tmp = false;
                }
            } else {
                try {
                    Thread.sleep(4000 - mycity.getLevel() * 500);
                } catch (Exception e) {
                    break;
                }
                if (tmp == false) {
                    tmp = true;
                }

                int[] arr = new int[]{mycity.getCooltime()[0], mycity.getCooltime()[1], mycity.getCooltime()[2]};

                if (mycity.getCooltime()[0] != 0) {
                    arr[0] = mycity.getCooltime()[0] - 1;
                }
                if (mycity.getCooltime()[1] != 0) {
                    arr[1] = mycity.getCooltime()[1] - 1;
                }
                if (mycity.getCooltime()[2] != 0) {
                    arr[2] = mycity.getCooltime()[2] - 1;
                }
                mycity.setCooltime(arr);
            }
        }
    }
}

class energy_thread implements Runnable {
    City mycity;
    JTextArea txtArea;

    public energy_thread(City mycity, JTextArea txtArea) {
        this.mycity = mycity;
        this.txtArea = txtArea;
    }

    @Override
    public void run() {
        boolean tmp = true;
        while (true) {
            if (mycity.getEnergy() == mycity.getLevel() * 5) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    break;
                }
                if (tmp == true) {
                    //System.out.println("활동력 MAX");
                    txtArea.append("활동력 MAX\n");
                    txtArea.append(" \n");
                    txtArea.setCaretPosition(txtArea.getDocument().getLength());
                    tmp = false;
                }
            } else {
                try {
                    Thread.sleep(3000 - mycity.getLevel() * 400);
                } catch (Exception e) {
                    break;
                }
                if (tmp == false) {
                    tmp = true;
                }

                mycity.setEnergy(mycity.getEnergy() + 1);

            }
        }
    }
}

class day_thread implements Runnable {
    City mycity;
    Master[] other;
    JTextArea txtArea;

    public day_thread(City mycity, Master[] other,JTextArea txtArea) {
        this.mycity = mycity;
        this.other = other;
        this.txtArea = txtArea;
    }

    @Override
    public void run() {
        boolean tmp = true;
        while (true) {
            try {
                Thread.sleep(20000);
            } catch (Exception e) {
                break;
            }
            //System.out.println("---------------------------------------------------하루가 지났습니다.-----------------------------------------------------");
            txtArea.append("---------------------하루가 지났습니다.------------------------\n");
            txtArea.append(" \n");
            txtArea.setCaretPosition(txtArea.getDocument().getLength());

            mycity.setDay(mycity.getDay() + 1);
            mycity.setPopulation(mycity.getPopulation() + 1 + (int) (mycity.getFamous() * 0.1));
            int employers = mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2];
            if (mycity.getMasternum() == 0) {
                if (employers != 0) {
                    //고용했다가 해고했을떄 제대로 들어가는지 다시 확인해봐야함
                    mycity.setGold(mycity.getGold() - (employers * 10));
                }
            } else {
                mycity.setGold(mycity.getGold() - (employers * 10 + other[mycity.getMasternum() - 1].getWage()));

                if (tmp == true) { //메세지 한번만 출력
                    /*System.out.println();
                    System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
                    System.out.println();
                    System.out.println("계약한 명인 : " + other[mycity.getMasternum() - 1].getName());
                    System.out.println("명인을 보유했으므로 추가 보너스 스탯이 부여됩니다.");
                    System.out.println();
                    System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
                    System.out.println();*/

                    txtArea.append("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\n");
                    txtArea.append(" \n");
                    txtArea.append("계약한 명인 : " + other[mycity.getMasternum() - 1].getName() + "\n");
                    txtArea.append("명인 보유로 추가 보너스 스탯이 부여됩니다.\n");
                    txtArea.append(" \n");
                    txtArea.append("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆\n");
                    txtArea.append(" \n");
                    txtArea.setCaretPosition(txtArea.getDocument().getLength());

                    tmp = false;

                } else {
                    if (mycity.getMasternum() == 1) {

                        mycity.setEconomy((mycity.getEconomy() + 3));
                        mycity.setFamous((mycity.getFamous() + 2));

                    } else if (mycity.getMasternum() == 2) {
                        mycity.setEconomy((mycity.getReligion() + 3));
                        mycity.setFamous((mycity.getFamous() + 2));

                    } else {
                        mycity.setEconomy((mycity.getForce() + 3));
                        mycity.setFamous((mycity.getFamous() + 2));
                    }
                }

            }

            if (mycity.getNumber() == 1){
                /*System.out.println("경제도시이므로 추가 경제력을 얻습니다.");
                System.out.println("추가 경제력 : " + mycity.getEconomy()/20);
                System.out.println();*/

                txtArea.append("경제도시이므로 추가 경제력을 얻습니다.\n");
                txtArea.append("추가 경제력 : " + mycity.getEconomy()/20);
                txtArea.append(" \n");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

                mycity.setEconomy(mycity.getEconomy() + mycity.getEconomy()/20);
            } else if (mycity.getNumber() == 2){
                /*System.out.println("종교도시이므로 추가 종교력을 얻습니다.");
                System.out.println("추가 종교력 : " + mycity.getReligion()/20);
                System.out.println();*/

                txtArea.append("종교도시이므로 추가 종교력을 얻습니다.\n");
                txtArea.append("추가 종교력 : " + mycity.getReligion()/20);
                txtArea.append(" \n");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

                mycity.setReligion(mycity.getReligion() + mycity.getReligion()/20);
            } else {
                /*System.out.println("군사도시이므로 추가 군사력을 얻습니다.");
                System.out.println("추가 군사력 : " + mycity.getForce()/20);
                System.out.println();*/

                txtArea.append("군사도시이므로 추가 군사력을 얻습니다.\n");
                txtArea.append("추가 군사력 : " + mycity.getForce()/20);
                txtArea.append(" \n");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

                mycity.setForce(mycity.getForce() + mycity.getForce()/20);
            }

            //if (mycity.getDay() >= 8 && ) 여긴 서든 이벤트 넣으면 넣는자리임

        }
    }
}


class enemy_thread implements Runnable {
    City enemycity;
    City mycity;
    int[] levelinfo;
    int waiting;
    JTextArea txtArea;

    public enemy_thread(City enemycity, City mycity, int[] levelinfo, JTextArea txtArea) {
        this.enemycity = enemycity;
        this.mycity = mycity;
        this.levelinfo = levelinfo;
        this.txtArea = txtArea;
    }


    void grow1(City enemycity, int turn){
        int mainstatus, substatus;
        Random enemy_behavior = new Random();
        int behavior_num = enemy_behavior.nextInt(3) + 1; //
        if (behavior_num == 1){ //초반강캐

            if (enemycity.getLevel() == 1){
                mainstatus = 5;
                substatus = 3;
            } else if (enemycity.getLevel() == 2){
                mainstatus = 5;
                substatus = 3;
            } else if (enemycity.getLevel() == 3){
                mainstatus = 6;
                substatus = 4;
            } else {
                mainstatus = 6;
                substatus = 4;
            }

        }else if (behavior_num == 2){

            if (enemycity.getLevel() == 1){
                mainstatus = 4;
                substatus = 2;
            } else if (enemycity.getLevel() == 2){
                mainstatus = 4;
                substatus = 3;
            } else if (enemycity.getLevel() == 3){
                mainstatus = 5;
                substatus = 4;
            } else {
                mainstatus = 7;
                substatus = 5;
            }

        } else {

            if (enemycity.getLevel() == 1){
                mainstatus = 3;
                substatus = 2;
            } else if (enemycity.getLevel() == 2){
                mainstatus = 4;
                substatus = 3;
            } else if (enemycity.getLevel() == 3){
                mainstatus = 7;
                substatus = 5;
            } else {
                mainstatus = 9;
                substatus = 6;
            }

        }

        int[] status;
        if (enemycity.getNumber()==7){
            status = new int[]{mainstatus,substatus,substatus};
        } else if(enemycity.getNumber() == 8){
            status = new int[]{substatus,mainstatus,substatus};
        } else {
            status = new int[]{substatus,substatus,mainstatus};
        }
        enemycity.setEconomy(enemycity.getEconomy()+status[0]);
        enemycity.setReligion(enemycity.getReligion()+status[1]);
        enemycity.setForce(enemycity.getForce()+status[2]);
        enemycity.setFriendship(enemycity.getFriendship() - 2); //매턴 우호도 감소 수치
    }

    void special(int num, int friendship){
        int[] arr = new int[]{mycity.getCooltime()[0],mycity.getCooltime()[1],mycity.getCooltime()[2]};
        if (enemycity.getNumber()==7){
            /*System.out.println("----------------------------------------------------------");
            System.out.println();
            System.out.println("적 도시가 경제력을 바탕으로 압박을 시도합니다.");*/

            txtArea.append("----------------------------------------------------------\n");
            txtArea.append(" \n");
            txtArea.append("적 도시가 경제력을 바탕으로 압박을 시도합니다.\n");
            txtArea.setCaretPosition(txtArea.getDocument().getLength());

            if (mycity.getEconomy() >= enemycity.getEconomy()){
                /*System.out.println("내 도시의 경제력이 더 앞서기 때문에 효과가 미미했습니다.");
                System.out.println();
                System.out.println("----------------------------------------------------------");*/

                txtArea.append("내 도시의 경제력이 더 앞서기 때문에 효과가 미미했습니다.\n");
                txtArea.append(" \n");
                txtArea.append("----------------------------------------------------------\n");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

            } else {
                /*System.out.println("적 도시의 무역 선점으로 당분간 무역관련 활동이 제한됩니다.");
                System.out.println("무역활동 쿨타임 : " + mycity.getCooltime()[0] + "  ▶  " + (mycity.getCooltime()[0] + 2 + num/6));
                System.out.println();
                System.out.println("----------------------------------------------------------");*/

                txtArea.append("적 도시의 무역 선점으로 당분간 무역관련 활동이 제한됩니다.\n");
                txtArea.append("무역활동 쿨타임 : " + mycity.getCooltime()[0] + "  ▶  " + (mycity.getCooltime()[0] + 4 + num/6 - friendship/10));
                txtArea.append(" \n");
                txtArea.append("----------------------------------------------------------\n");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

                arr[0] = mycity.getCooltime()[0] + 2 + num/6;
                mycity.setCooltime(arr);
            }
        } else if(enemycity.getNumber() == 8){
            /*System.out.println("----------------------------------------------------------");
            System.out.println();
            System.out.println("상대 도시가 종교전파를 시도합니다");*/

            txtArea.append("----------------------------------------------------------\n");
            txtArea.append(" \n");
            txtArea.append("상대 도시가 종교전파를 시도합니다\n");
            txtArea.setCaretPosition(txtArea.getDocument().getLength());

            if (mycity.getReligion() >= enemycity.getReligion()){
                /*System.out.println("종교력이 높아서 전파가 이루어지지 않았습니다.");
                System.out.println();
                System.out.println("----------------------------------------------------------");*/

                txtArea.append("종교력이 높아서 전파가 이루어지지 않았습니다.\n");
                txtArea.append(" \n");
                txtArea.append("----------------------------------------------------------\n");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

            } else {
                /*System.out.println("적 도시의 종교가 내 도시의 종교력에 악영향을 끼칩니다.");
                System.out.println("종교활동 쿨타임 : " + mycity.getCooltime()[2] + "  ▶  " + (mycity.getCooltime()[2] + 2 + num/6));
                System.out.println();
                System.out.println("----------------------------------------------------------");*/

                txtArea.append("적 도시의 종교가 내 도시의 종교력에 악영향을 끼칩니다.\n");
                txtArea.append("종교활동 쿨타임 : " + mycity.getCooltime()[2] + "  ▶  " + (mycity.getCooltime()[2] + 4 + num/6 - friendship/10));
                txtArea.append(" \n");
                txtArea.append("----------------------------------------------------------\n");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

                arr[2] = mycity.getCooltime()[2] + 2 + num/6;
                mycity.setCooltime(arr);
            }
        } else {
            /*System.out.println("----------------------------------------------------------");
            System.out.println();
            System.out.println("적 도시의 무력시위를 일으킵니다.");*/

            txtArea.append("----------------------------------------------------------\n");
            txtArea.append(" \n");
            txtArea.append("적 도시의 무력시위를 일으킵니다.\n");
            txtArea.setCaretPosition(txtArea.getDocument().getLength());

            if (mycity.getForce() >= enemycity.getForce()){
                /*System.out.println("도시의 군사력이 충분하기 때문에 시민들이 안정감을 느낍니다.");
                System.out.println();
                System.out.println("----------------------------------------------------------");*/

                txtArea.append("도시의 군사력이 충분하기 때문에 시민들이 안정감을 느낍니다.\n");
                txtArea.append(" \n");
                txtArea.append("----------------------------------------------------------\n");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

            } else {
                /*System.out.println("시민들이 불안감을 느끼기 시작합니다.(행복도 감소)\n");
                System.out.println("행복도 : " + mycity.getHappy() + "  ▶  " + (mycity.getHappy() + (mycity.getForce() - enemycity.getForce())/5 - num/6));
                System.out.println();
                System.out.println("----------------------------------------------------------");*/

                txtArea.append("시민들이 불안감을 느끼기 시작합니다.(행복도 감소)\n");
                txtArea.append("행복도 : " + mycity.getHappy() + "  ▶  " + (mycity.getHappy() + (mycity.getForce() - enemycity.getForce())/5 - num/6 + friendship/10 -2));
                txtArea.append(" \n");
                txtArea.append("----------------------------------------------------------");
                txtArea.append(" \n");
                txtArea.setCaretPosition(txtArea.getDocument().getLength());

                mycity.setHappy(mycity.getHappy() + (mycity.getForce() - enemycity.getForce())/5 - num/6);
            }
        }
    }

    @Override
    public void run() {
        int turn = 1;
        int level = 0;
        while(true){
            try {
                Thread.sleep(10000); //10초에 한번씩 성장

            } catch (Exception e) {
                break;
            }
            if (enemycity.getWaiting() == 0){
                if (enemycity.getFriendship() < 30){
                    if (turn % 6 == 0){ //특별이벤트 6턴마다 발생
                        //System.out.println(turn);
                        special(turn,enemycity.getFriendship());
                    }
                }

                if (enemycity.getEconomy() >= levelinfo[enemycity.getLevel()-1] || enemycity.getReligion() >= levelinfo[enemycity.getLevel()-1] || enemycity.getForce() >= levelinfo[enemycity.getLevel()-1]){
                    enemycity.setLevel(enemycity.getLevel() + 1);
                    if (enemycity.getLevel() == 4){
                        /*System.out.println("※※※※※※※※※※※※ 경고 ※※※※※※※※※※※※※");
                        System.out.println();
                        System.out.println("상대도시의 레벨이 4에 도달했습니다.");
                        System.out.println();
                        System.out.println("※※※※※※※※※※※※ 경고 ※※※※※※※※※※※※※");*/

                        txtArea.append("※※※※※※※※※※※※ 경고 ※※※※※※※※※※※※※\n");
                        txtArea.append(" \n");
                        txtArea.append("상대도시의 레벨이 4에 도달했습니다.\n");
                        txtArea.append(" \n");
                        txtArea.append("※※※※※※※※※※※※ 경고 ※※※※※※※※※※※※※\n");
                        txtArea.append(" \n");
                        txtArea.setCaretPosition(txtArea.getDocument().getLength());

                    }
                }

                grow1(enemycity,turn);
                turn += 1;
            } else {
                enemycity.setWaiting(enemycity.getWaiting() - 1);
            }

        }
    }
}

class citystatus implements Runnable {
    City mycity;
    ArrayList<JTextField> txt_list;


    public citystatus(City mycity, ArrayList<JTextField> txt_list) {
        this.mycity = mycity;
        this.txt_list = txt_list;
    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1500);
            }catch (Exception e){
                break;
            }
            txt_list.get(0).setText(mycity.getName());
            txt_list.get(1).setText(mycity.getLevel() +"");
            txt_list.get(2).setText(mycity.getHappy() +"");
            txt_list.get(3).setText(mycity.getEconomy() +"");
            txt_list.get(4).setText(mycity.getReligion() +"");
            txt_list.get(5).setText(mycity.getForce() +"");
            txt_list.get(6).setText(mycity.getPopulation() +"");
            txt_list.get(7).setText(mycity.getFamous() +"");
            txt_list.get(8).setText(mycity.getGold() +"");
            txt_list.get(9).setText(mycity.getEnergy() +"");
            txt_list.get(10).setText(mycity.getDay() +"");
        }

    }
}

class main_music implements Runnable {
    int music_num;

    public main_music(int music_num) {
        this.music_num = music_num;
    }

    @Override
    public void run() {
        String music_name;
        if (music_num == 1){
            music_name = "friendly.wav";
        } else if (music_num == 2){
            music_name = "pick.wav";
        } else if (music_num == 3){
            music_name = "bad.wav";
        } else {
            music_name = "war.wav";
        }
        File path = new File("C:\\Users\\jongh\\IdeaProjects\\project_edit\\src\\music\\" + music_name);
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(path);
            Clip clip = AudioSystem.getClip();
            try{
              clip.open(audio);
              clip.start();
              clip.loop(Clip.LOOP_CONTINUOUSLY);
              Thread.sleep(clip.getMicrosecondLength()/1000);

            }catch (Exception e){
                clip.stop();
                clip.close();
            }
        }catch (Exception e){
        }
    }
}

