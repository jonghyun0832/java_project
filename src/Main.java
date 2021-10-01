import org.w3c.dom.Attr;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Interface.Startwindow();
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        if (start == 0){
            System.out.println("도시 키우기를 종료합니다.");
        }
        int[] coolarr = new int[]{1,1,1,0}; //쿨타임 초기화용
        int[] buildarr = new int[]{0,0,0}; // 건물 초기화용
        int[] employarr = new int[]{0,0,0};


        Interface.startMessage();
        City city1 = new City(150,50,60,1,"베네지아",1,10,100,50,5000,coolarr,buildarr,employarr,1,0,10,false,"베네지아는 상업특화 도시이며 시작 경제력이 높은것이 장점입니다.\n하지만 종교력은 낮다는 단점이 있습니다.");
        City city2 = new City(50,60,40,2,"바리칸",1,20,50,30,500,coolarr,buildarr,employarr,1,0,10,false,"바리칸은 종교특화 도시이며 시작 종교력이 높은것이 장점입니다. \n하지만 군사력이 낮다는 단점이 있습니다.");
        City city3 = new City(8,5,15,3,"스파르다",1,10,10,10,500,coolarr,buildarr,employarr,1,0,10,false,"스파르다는 군사특화 도시이며 시작 군사력이 높은것이 장점입니다. \n하지만 종교력이 낮다는 단점이 있습니다.");
        City mycity = new City();

        City enemycity1 = new City(10,10,10,7,"상대도시(경제도시)",1,10,10,10,500,coolarr,buildarr,employarr,1,5,50,false,"적군입니다");
        City enemycity2 = new City(10,10,10,8,"상대도시(종교도시)",1,10,10,10,500,coolarr,buildarr,employarr,1,5,50,false,"적군입니다");
        City enemycity3 = new City(10,10,10,9,"상대도시(군사도시)",1,10,10,10,500,coolarr,buildarr,employarr,1,5,50,false,"적군입니다");
        City enemycity=new City();
        City enemycity_observe = new City(); //유지되는값임
//------------------------------------------사냥용------------------------------------------------------------------------------
        Hunting hunt1 = new Hunting("주황버섯(하급)",200,10,2,3);
        Hunting hunt2 = new Hunting("파란버섯(중급)",400,30,5,4);
        Hunting hunt3 = new Hunting("좀비버섯(상급)",500,100,8,5);
        Hunting hunt4 = new Hunting("머쉬룸(최상급)",1000,250,12,6);
        Hunting[] hunts = {hunt1,hunt2,hunt3,hunt4};
//------------------------------------------무역용------------------------------------------------------------------------------
        Trading trade1 = new Trading("초급무역",200,10,2,3);
        Trading trade2 = new Trading("중급무역",400,30,3,4);
        Trading trade3 = new Trading("상급무역",600,100,4,5);
        Trading trade4 = new Trading("최상급무역",1200,250,5,6);
        Trading[] trades = {trade1,trade2,trade3,trade4};
//-------------------------------------------축제--------------------------------------------------------------------------------
        Festival festival1 = new Festival("초급축제",400,10,5,10,4);
        Festival festival2 = new Festival("중급축제",1000,50,7,30,5);
        Festival festival3 = new Festival("고급축제",2000,80,10,60,6);
        Festival[] festivals = {festival1,festival2,festival3};
//-------------------------------------------종교--------------------------------------------------------------------------------
        Religious religion1 = new Religious("초급종교",100,15,3,5,5);
        Religious religion2 = new Religious("중급종교",200,50,5,10,6);
        Religious religion3 = new Religious("상급종교",500,120,6,20,7);
        Religious religion4 = new Religious("최상급종교",1200,260,7,40,8);
        Religious[] religions = {religion1,religion2,religion3,religion4};
//-------------------------------------------징수--------------------------------------------------------------------------------
        Tax tax1 = new Tax("초급징수",200,20,5,3);
        Tax tax2 = new Tax("중급징수",400,40,15,4);
        Tax tax3 = new Tax("상급징수",800,60,30,5);
        Tax tax4 = new Tax("최상급징수",1600,80,50,6);
        Tax[] taxes = {tax1,tax2,tax3,tax4};
//-------------------------------------------건물리스트--------------------------------------------------------------------------------
        Building build1 = new Building(20,6,4,20,"시장",300,2);
        Building build2 = new Building(6,20,4,20,"종교건물",350,2);
        Building build3 = new Building(6,4,20,20,"훈련소",300,2);
        Building[] builds = {build1,build2,build3};
//-------------------------------------------명소리스트--------------------------------------------------------------------------------
        Attraction attract1 = new Attraction(100,10,30,50,"세계무역센터",1000,60,false,3);
        Attraction attract2 = new Attraction(30,100,10,50,"노트르담대성당",1000,60,false,3);
        Attraction attract3 = new Attraction(30,10,100,50,"사관학교",1000,60,false,3);
        Attraction[] attracts = {attract1,attract2,attract3};
//-------------------------------------------전문가리스트--------------------------------------------------------------------------------
        Expert expert1 = new Expert(15,3,5,10,"경제학자",15,150,2);
        Expert expert2 = new Expert(5,15,3,10,"신학자",15,150,2);
        Expert expert3 = new Expert(5,3,15,10,"군사전문가",15,150,2);
        Expert[] experts = {expert1,expert2,expert3};
//-------------------------------------------명인리스트--------------------------------------------------------------------------------
        Master master1 = new Master(80,20,30,20,"워렌머핏",60,600,30,false,3);
        Master master2 = new Master(30,80,20,20,"교황 프란지스코",60,600,30,false,3);
        Master master3 = new Master(30,20,80,20,"토니 스티크",60,600,30,false,3);
        Master[] masters = {master1,master2,master3};

//-------------------------------------------돌발이벤트--------------------------------------------------------------------------------
        Sudden event_economy1 = new Sudden("IMF",50,50,50,30,10);
        Sudden event_religion1 = new Sudden("사이비침입",50,50,50,30,10);
        Sudden event_force1 = new Sudden("외세침략",50,50,50,30,10);
        Sudden event_economy2 = new Sudden("IMF",100,100,100,30,20);
        Sudden event_religion2 = new Sudden("사이비침입",100,100,100,30,20);
        Sudden event_force2 = new Sudden("외세침략",100,100,100,100,20);
        Sudden event_economy3 = new Sudden("IMF",300,300,300,30,40);
        Sudden event_religion3 = new Sudden("사이비침입",300,300,300,30,40);
        Sudden event_force3 = new Sudden("외세침략",300,300,300,30,40);
        Sudden[] event1 = {event_economy1,event_religion1,event_force1};
        Sudden[] event2 = {event_economy2,event_religion2,event_force2};
        Sudden[] event3 = {event_economy3,event_religion3,event_force3};






        int[] levelinfo = {30,70,160,300};
        int[] popularinfo = {0,40,100,200};
        int[] famousinfo = {0,0,40,100};
        Levelup[] levels = new Levelup[4];

        for (int i = 1; i <= levels.length; i++){
            levels[i-1] = new Levelup(i+1,levelinfo[i-1],levelinfo[i-1],levelinfo[i-1],popularinfo[i-1],famousinfo[i-1],false);
        }
        city1.startcity();
        city2.startcity();
        city3.startcity();

        boolean choice = true;
        boolean choice2 = true;
        boolean choice3 = true;
        boolean choice4 = true;
        boolean chance = true;
        boolean end = false;
        boolean canstop = true;




        while(choice){
            System.out.println();
            System.out.println("시작하고싶은 도시 번호를 입력해주세요.\n");
            int startcity = sc.nextInt();
            if (startcity == 1){
                mycity = mycity.startinfo(city1);
                choice = false;
            } else if (startcity == 2){
                mycity = mycity.startinfo(city2);
                choice = false;
            } else if (startcity == 3){
                mycity = mycity.startinfo(city3);
                choice = false;
            } else {
                System.out.println("도시번호들중 한가지를 입력해주세요.");
            }
        }

        Random enemy_rand = new Random();
        int rand_num = enemy_rand.nextInt((9-7)+1) + 7; //((최대 - 최소)+1) + 최소값
        if (rand_num == 7){
            enemycity = enemycity1;
        } else if (rand_num == 8){
            enemycity = enemycity2;
        } else {
            enemycity = enemycity3;
        }
        enemycity.setWaiting(1);
        System.out.println("상대 도시 설정이 완료되었습니다.");

        System.out.println("기본 설정을 모두 마쳤습니다.");
        System.out.println();



        choice = true;
        while(choice) {
            System.out.println("게임설명을 들으시겠습니까? (예 : 1   아니오 : 2)");
            int game_explain = sc.nextInt();
            if (game_explain == 1) {
                Interface.Explaination();
                System.out.println("게임을 시작하시려면 아무거나 입력해주세요.");
                String  game_start = sc.next();
                choice = false;
            } else if (game_explain == 2){
                choice = false;
            } else {
                System.out.println("잘못 입력하셨습니다. 예/아니오 중에 선택해주세요. \n");
            }
        }
        choice = true;
        Interface.Gamestart();

//--------------------------------------------------도시 상태창 ---------------------------------------------------------
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel word_panels = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();
        JLabel label9 = new JLabel();
        JLabel label10 = new JLabel();
        JLabel label11 = new JLabel();
        ArrayList<JPanel> panels_list = new ArrayList();
        ArrayList<JTextField> txt_list = new ArrayList();

        label1.setText("도시이름  ");
        label2.setText("도시레벨  ");
        label3.setText("행복도  ");
        label4.setText("경제력  ");
        label5.setText("종교력  ");
        label6.setText("군사력  ");
        label7.setText("인구수  ");
        label8.setText("명성  ");
        label9.setText("보유골드  ");
        label10.setText("활동력  ");
        label11.setText("DAY   ");

        JLabel[] labels = new JLabel[]{label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11};

        for (int i = 0; i < labels.length; i++){
            labels[i].setForeground(Color.WHITE);
        }
        {
            JPanel word_panel1 = new JPanel();
            word_panel1.setLayout(new BoxLayout(word_panel1, BoxLayout.X_AXIS));
            word_panel1.add((label1));
            word_panel1.add(Box.createHorizontalStrut(20));
            JTextField txtfield1 = new JTextField();
            word_panel1.add(txtfield1);
            panels_list.add(word_panel1);
            txt_list.add(txtfield1);

            JPanel word_panel2 = new JPanel();
            word_panel2.setLayout(new BoxLayout(word_panel2, BoxLayout.X_AXIS));
            word_panel2.add((label2));
            word_panel2.add(Box.createHorizontalStrut(20));
            JTextField txtfield2 = new JTextField();
            word_panel2.add(txtfield2);
            panels_list.add(word_panel2);
            txt_list.add(txtfield2);


            JPanel word_panel3 = new JPanel();
            word_panel3.setLayout(new BoxLayout(word_panel3, BoxLayout.X_AXIS));
            word_panel3.add((label3));
            word_panel3.add(Box.createHorizontalStrut(20));
            JTextField txtfield3 = new JTextField();
            word_panel3.add(txtfield3);
            panels_list.add(word_panel3);
            txt_list.add(txtfield3);

            JPanel word_panel4 = new JPanel();
            word_panel4.setLayout(new BoxLayout(word_panel4, BoxLayout.X_AXIS));
            word_panel4.add((label4));
            word_panel4.add(Box.createHorizontalStrut(20));
            JTextField txtfield4 = new JTextField();
            word_panel4.add(txtfield4);
            panels_list.add(word_panel4);
            txt_list.add(txtfield4);

            JPanel word_panel5 = new JPanel();
            word_panel5.setLayout(new BoxLayout(word_panel5, BoxLayout.X_AXIS));
            word_panel5.add((label5));
            word_panel5.add(Box.createHorizontalStrut(20));
            JTextField txtfield5 = new JTextField();
            word_panel5.add(txtfield5);
            panels_list.add(word_panel5);
            txt_list.add(txtfield5);

            JPanel word_panel6 = new JPanel();
            word_panel6.setLayout(new BoxLayout(word_panel6, BoxLayout.X_AXIS));
            word_panel6.add((label6));
            word_panel6.add(Box.createHorizontalStrut(20));
            JTextField txtfield6 = new JTextField();
            word_panel6.add(txtfield6);
            panels_list.add(word_panel6);
            txt_list.add(txtfield6);

            JPanel word_panel7 = new JPanel();
            word_panel7.setLayout(new BoxLayout(word_panel7, BoxLayout.X_AXIS));
            word_panel7.add((label7));
            word_panel7.add(Box.createHorizontalStrut(20));
            JTextField txtfield7 = new JTextField();
            word_panel7.add(txtfield7);
            panels_list.add(word_panel7);
            txt_list.add(txtfield7);

            JPanel word_panel8 = new JPanel();
            word_panel8.setLayout(new BoxLayout(word_panel8, BoxLayout.X_AXIS));
            word_panel8.add((label8));
            word_panel8.add(Box.createHorizontalStrut(20));
            JTextField txtfield8 = new JTextField();
            word_panel8.add(txtfield8);
            panels_list.add(word_panel8);
            txt_list.add(txtfield8);

            JPanel word_panel9 = new JPanel();
            word_panel9.setLayout(new BoxLayout(word_panel9, BoxLayout.X_AXIS));
            word_panel9.add((label9));
            word_panel9.add(Box.createHorizontalStrut(20));
            JTextField txtfield9 = new JTextField();
            word_panel9.add(txtfield9);
            panels_list.add(word_panel9);
            txt_list.add(txtfield9);

            JPanel word_panel10 = new JPanel();
            word_panel10.setLayout(new BoxLayout(word_panel10, BoxLayout.X_AXIS));
            word_panel10.add((label10));
            word_panel10.add(Box.createHorizontalStrut(20));
            JTextField txtfield10 = new JTextField();
            word_panel10.add(txtfield10);
            panels_list.add(word_panel10);
            txt_list.add(txtfield10);

            JPanel word_panel11 = new JPanel();
            word_panel11.setLayout(new BoxLayout(word_panel11, BoxLayout.X_AXIS));
            word_panel11.add((label11));
            word_panel11.add(Box.createHorizontalStrut(20));
            JTextField txtfield11 = new JTextField();
            word_panel11.add(txtfield11);
            panels_list.add(word_panel11);
            txt_list.add(txtfield11);
        }

        word_panels.setLayout(new BoxLayout(word_panels,BoxLayout.Y_AXIS));
        for (int i = 0; i < panels_list.size(); i++){ //패널 뒷배경, 패널에 패널리스트들 추가
            panels_list.get(i).setBackground(Color.GRAY);
            word_panels.add(panels_list.get(i));
        }

        for (int i = 0; i < txt_list.size(); i++){ //텍스트들 색,테두리제거
            txt_list.get(i).setBackground(Color.GRAY);
            txt_list.get(i).setForeground(Color.WHITE);
            txt_list.get(i).setBorder(javax.swing.BorderFactory.createEmptyBorder());

        }

        panel.add(new JLabel("------------------------------ 당신의 도시 상태입니다 --------------------------------"),BorderLayout.NORTH);

        frame.add(word_panels);

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("도시상태창");
        frame.setLocation(900,50);
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//--------------------------------------------------알림창 ---------------------------------------------------------
        JFrame frame2 = new JFrame();
        JPanel announce_panel = new JPanel();
        JTextArea txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setBackground(Color.GRAY);
        txtArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);



        announce_panel.setLayout(new BorderLayout());
        announce_panel.add(new JLabel("----------------------------------------- 알 림 창 ----------------------------------------"),BorderLayout.NORTH);
        announce_panel.add(scrollPane,BorderLayout.CENTER);
        announce_panel.setForeground(Color.WHITE);



        frame2.add(announce_panel);

        frame2.setResizable(false);
        frame2.setVisible(true);
        frame2.setTitle("알림창");
        frame2.setLocation(1190,50);
        frame2.setSize(350,700);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//----------------------------------------------------------------------------------------------------------------
        JFrame frame3 = new JFrame();
        JPanel panel3 = new JPanel();
        JPanel word_panels3 = new JPanel();
        JLabel elabel1 = new JLabel();
        JLabel elabel2 = new JLabel();
        JLabel elabel3 = new JLabel();
        JLabel elabel4 = new JLabel();
        JLabel elabel5 = new JLabel();
        JLabel elabel6 = new JLabel();
        ArrayList<JPanel> panels_list3 = new ArrayList();
        ArrayList<JTextField> txt_list3 = new ArrayList();

        elabel1.setText("도시이름  ");
        elabel2.setText("도시레벨  ");
        elabel3.setText("경제력  ");
        elabel4.setText("종교력  ");
        elabel5.setText("군사력  ");
        elabel6.setText("도시 관계  ");

        JLabel[] elabels = new JLabel[]{elabel1,elabel2,elabel3,elabel4,elabel5,elabel6};

        for (int i = 0; i < elabels.length; i++){
            elabels[i].setForeground(Color.WHITE);
        }
        {
            JPanel word_panele1 = new JPanel();
            word_panele1.setLayout(new BoxLayout(word_panele1, BoxLayout.X_AXIS));
            word_panele1.add((elabel1));
            word_panele1.add(Box.createHorizontalStrut(20));
            JTextField etxtfield1 = new JTextField();
            word_panele1.add(etxtfield1);
            panels_list3.add(word_panele1);
            txt_list3.add(etxtfield1);

            JPanel word_panele2 = new JPanel();
            word_panele2.setLayout(new BoxLayout(word_panele2, BoxLayout.X_AXIS));
            word_panele2.add((elabel2));
            word_panele2.add(Box.createHorizontalStrut(20));
            JTextField etxtfield2 = new JTextField();
            word_panele2.add(etxtfield2);
            panels_list3.add(word_panele2);
            txt_list3.add(etxtfield2);

            JPanel word_panele3 = new JPanel();
            word_panele3.setLayout(new BoxLayout(word_panele3, BoxLayout.X_AXIS));
            word_panele3.add((elabel3));
            word_panele3.add(Box.createHorizontalStrut(20));
            JTextField etxtfield3 = new JTextField();
            word_panele3.add(etxtfield3);
            panels_list3.add(word_panele3);
            txt_list3.add(etxtfield3);

            JPanel word_panele4 = new JPanel();
            word_panele4.setLayout(new BoxLayout(word_panele4, BoxLayout.X_AXIS));
            word_panele4.add((elabel4));
            word_panele4.add(Box.createHorizontalStrut(20));
            JTextField etxtfield4 = new JTextField();
            word_panele4.add(etxtfield4);
            panels_list3.add(word_panele4);
            txt_list3.add(etxtfield4);

            JPanel word_panele5 = new JPanel();
            word_panele5.setLayout(new BoxLayout(word_panele5, BoxLayout.X_AXIS));
            word_panele5.add((elabel5));
            word_panele5.add(Box.createHorizontalStrut(20));
            JTextField etxtfield5 = new JTextField();
            word_panele5.add(etxtfield5);
            panels_list3.add(word_panele5);
            txt_list3.add(etxtfield5);

            JPanel word_panele6 = new JPanel();
            word_panele6.setLayout(new BoxLayout(word_panele6, BoxLayout.X_AXIS));
            word_panele6.add((elabel6));
            word_panele6.add(Box.createHorizontalStrut(20));
            JTextField etxtfield6 = new JTextField();
            word_panele6.add(etxtfield6);
            panels_list3.add(word_panele6);
            txt_list3.add(etxtfield6);
        }

        word_panels3.setLayout(new BoxLayout(word_panels3,BoxLayout.Y_AXIS));
        for (int i = 0; i < panels_list3.size(); i++){ //패널 뒷배경, 패널에 패널리스트들 추가
            panels_list3.get(i).setBackground(Color.GRAY);
            word_panels3.add(panels_list3.get(i));
        }

        for (int i = 0; i < txt_list3.size(); i++){ //텍스트들 색,테두리제거
            txt_list3.get(i).setBackground(Color.GRAY);
            txt_list3.get(i).setForeground(Color.WHITE);
            txt_list3.get(i).setBorder(javax.swing.BorderFactory.createEmptyBorder());

        }

        panel3.add(new JLabel("------------------------------ 상대 도시 상태입니다 --------------------------------"),BorderLayout.NORTH);

        frame3.add(word_panels3);

        frame3.setResizable(false);
        frame3.setVisible(true);
        frame3.setTitle("상대 도시 상태창");
        frame3.setLocation(900,450);
        frame3.setSize(300,300);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





//----------------------------------------------------------------------------------------------------------------

        Thread t2 = mycity.rest2(mycity,txtArea);
        Thread t3 = mycity.rest3(mycity,txtArea);
        Thread t4 = mycity.rest4(mycity,masters,txtArea);
        Thread t5 = enemycity.enemygrow(enemycity,mycity,levelinfo,txtArea);
        Thread t6 = mycity.city_status(mycity,txt_list);

        Thread t7 = new Thread(new main_music(2));
        t7.setDaemon(true);
        t7.start();

        int music_num = 2;
        boolean change = true;
        boolean music_stop = false;

        while(choice){

            if (enemycity.getFriendship()>=70 && music_stop == false){
                if (music_num == 1){
                    change = false;
                }
                else {
                    music_num = 1;
                    change = true;
                }
            } else if (enemycity.getFriendship() <70 && enemycity.getFriendship() >= 30 && music_stop == false){
                if (music_num == 2){
                    change = false;
                }
                else {
                    music_num = 2;
                    change = true;
                }
            } else if (enemycity.getFriendship() <30 && enemycity.getFriendship() >= 10 && music_stop == false){
                if (music_num == 3){
                    change = false;
                }
                else {
                    music_num = 3;
                    change = true;
                }
            } else if (enemycity.getFriendship() <10 && music_stop == false) {
                if (music_num == 4){
                    change = false;
                }
                else {
                    music_num = 4;
                    change = true;
                }
            }
            if (change == true && music_stop == false){
                t7.interrupt();
                t7 = new Thread(new main_music(music_num));
                t7.setDaemon(true);
                t7.start();
            }


            if (mycity.getLevel() == 5){
                Interface.Victory(mycity,levelinfo);
                System.exit(0);
                return;
            } else if (mycity.getDay() == 100){
                Interface.Defeat_day();
                System.exit(0);
                return;
            } else if (mycity.getHappy() <= 0){
                Interface.Defeat_unhappy();
                System.exit(0);
                return;
            } else if (mycity.getPopulation() <= 0){
                Interface.Defeat_population();
                System.exit(0);
                return;
            } else if (mycity.getGold() <= -200){
                Interface.Defeat_gold();
                System.exit(0);
                return;
            } else if (enemycity.getLevel() == 5){
                Interface.Defeat_enemycity();
                System.exit(0);
                return;
            } else if (end == true) {
                System.exit(0);
                return;
            }


            choice3 = true; // 행동후 다시 들어가서 또 돌릴수있게 만들어 주기위한 변수
            choice4 = true;
            Interface.Behavior();
            int behavior = sc.nextInt();
            if (behavior == 0){
                for (int i = mycity.getLevel()-1; i < mycity.getLevel(); i++){
                    levels[i].levelshow();
                }
            } else if (behavior == 1){
                Levelup.canGrow(mycity,levels);
            }
            else if (behavior == 2){
                mycity.showcooltime();
            }
            else if (behavior == 3){
                    Interface.Getmoneylist();
                    choice2 = true;
                    while (choice2) {
                        int getmoney = sc.nextInt();
                        if (getmoney == 1) {//무역 세부사항
                            while (choice3) {
                                Trading.listshow(trades);
                                int trade_num = sc.nextInt();
                                if (trade_num == 9) {
                                    choice3 = false;
                                    continue;
                                } else {
                                    choice3 = Trading.processTrade(mycity, trade_num, trades);
                                }
                            }
                            choice2 = false;
                        } else if (getmoney == 2) {//종교 세부사항
                            while (choice3) {
                                Religious.listshow(religions);
                                int religion_num = sc.nextInt();
                                if (religion_num == 9) {
                                    choice3 = false;
                                    continue;
                                } else {
                                    choice3 = Religious.processReligion(mycity, religion_num, religions);

                                }
                            }

                            choice2 = false;
                        } else if (getmoney == 3) {//사냥 세부사항
                            while (choice3) {
                                Hunting.listshow(hunts);
                                int hunt_num = sc.nextInt();
                                if (hunt_num == 9) {
                                    choice3 = false;
                                    continue;
                                } else {
                                    choice3 = Hunting.processHunt(mycity, hunt_num, hunts);
                                }
                            }
                            choice2 = false;
                        } else if (getmoney == 4) {//징수 세부사항
                            while (choice3) {
                                Tax.listshow(taxes);
                                int tax_num = sc.nextInt();
                                if (tax_num == 9) {
                                    choice3 = false;
                                    continue;
                                } else {
                                    choice3 = Tax.processTax(mycity, tax_num, taxes);
                                }
                            }
                            choice2 = false;
                        } else if (getmoney == 5) {//축제 세부사항
                            while (choice3) {
                                Festival.listshow(festivals);
                                int festival_num = sc.nextInt();
                                if (festival_num == 9) {
                                    choice3 = false;
                                    continue;
                                } else {
                                    choice3 = Festival.processFestival(mycity, festival_num, festivals);
                                }
                            }
                            //choice = false;
                            choice2 = false;
                        } else if (getmoney == 9) {
                            System.out.println("이전메뉴로 돌아갑니다.\n");
                            choice2 = false;
                        } else {
                            System.out.println("잘못입력하셨습니다. \n메뉴중에 선택해주세요.");
                        }
                    }
            }
            else if (behavior == 4){
                Interface.Spendmoneylist();
                choice2 = true;
                while(choice2) {
                    int spendmoney = sc.nextInt();
                    if (spendmoney == 1) { //건물짓기 세부사항
                        while(choice3){
                            Interface.Building();
                            int build_num = sc.nextInt();
                            if (build_num == 1){ //건물 매수
                                while(choice4){
                                    Building.listshow(builds);
                                    build_num = sc.nextInt();
                                    if(build_num == 9){
                                        choice4 = false;
                                        continue;
                                    }
                                    else if (build_num >= 1 && build_num <=builds.length) {
                                        choice4 = Building.buy(mycity,build_num,builds);
                                    }
                                    else{
                                        System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요.");
                                    }
                                }
                                choice3 = false;
                            }
                            else if (build_num == 2){ //건물 매각
                                System.out.println("※※※※※ 주의 : 건물 매각시 건설비용의 50프로만 돌려받게 됩니다.(활동력 2소모) ※※※※※");
                                System.out.println();
                                mycity.showbuilding();
                                if (mycity.getOwnbuliding()[0] + mycity.getOwnbuliding()[1] + mycity.getOwnbuliding()[2] == 0){
                                    System.out.println("보유중인 건물이 없어서 매각을 진행할 수 없습니다. \n처음으로 돌아갑니다.");
                                }
                                else {
                                    while(choice4){
                                        System.out.println("매각할 건물의 숫자를 입력해주세요.");
                                        System.out.println("1.시장    2.신학건물    3.훈련소                 9.처음으로 돌아가기");
                                        int sell_num = sc.nextInt();
                                        if (sell_num == 9){
                                            choice4 = false;
                                        }
                                        else if (sell_num >= 1 && sell_num <=builds.length){
                                            choice4 = Building.sell(mycity,sell_num,builds);
                                        }
                                        else {
                                            System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요.");;
                                        }
                                    }
                                }
                                choice3 = false;
                            }
                            else if (build_num == 3){
                                if (attracts[0].isProduce() == true || attracts[1].isProduce() == true || attracts[2].isProduce() == true){
                                    System.out.println("이미 명소를 건설하셨기 때문에 더 건설할 수 없습니다. \n처음으로 돌아갑니다.");
                                }
                                else {
                                    while(choice4){
                                        System.out.println("※※※※※ 주의 : 명소는 도시에 딱 한개만 보유할 수 있습니다.(매각 불가) 신중하게 선택해주세요. ※※※※※");
                                        Attraction.listshow(attracts);
                                        int att_num = sc.nextInt();
                                        if (att_num == 9){
                                            choice4 = false;
                                        }
                                        else if (att_num >=1 && att_num <=attracts.length){
                                            choice4 = Attraction.build(mycity,att_num,attracts);
                                        }
                                        else {
                                            System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요.");;
                                        }
                                    }
                                }
                                choice3 = false;
                            }
                            else if (build_num == 9){
                                System.out.println("처음으로 돌아가기");
                                choice3 = false;
                            }
                            else {
                                System.out.println("잘못입력하셨습니다. \n다시 입력해주세요.");
                            }
                        }
                        choice2 = false;
                    }
                    else if (spendmoney == 2) { //인재등용 세부사항
                        while(choice3){
                            Interface.Employ();
                            int emp_num = sc.nextInt();
                            if (emp_num == 1){//전문가 고용
                                while(choice4){
                                    Expert.listshow(experts);
                                    int ex_num = sc.nextInt();
                                    if (ex_num == 9) {
                                        choice4 = false;
                                        continue;
                                    } else if (ex_num >= 1 && ex_num <= experts.length){
                                        if (ex_num == 1 && mycity.getOwnbuliding()[0] == 0){
                                            System.out.println("경제학자를 고용하기 위해선 시장(건물)이 필요합니다.");
                                        } else if (ex_num == 2 && mycity.getOwnbuliding()[1] == 0) {
                                            System.out.println("신학자를 고용하기 위해선 종교건물이 필요합니다.");
                                        } else if (ex_num == 3 && mycity.getOwnbuliding()[2] == 0) {
                                            System.out.println("군사전문가를 고용하기 위해선 훈련소(건물)가 필요합니다.");
                                        } else {
                                            choice4 = Expert.hire(mycity,ex_num,experts);
                                        }
                                    } else {
                                        System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요.");
                                    }
                                }
                                choice3 = false;
                            }
                            else if (emp_num == 2){ //전문가 해고
                                System.out.println("※※※※※ 주의 : 전문가 해고시 증가되었던 능력치들이 모두 감소합니다. ※※※※※");
                                System.out.println();
                                mycity.showemployer();
                                if ((mycity.getEmployed()[0] + mycity.getEmployed()[1] + mycity.getEmployed()[2]) == 0 ) {
                                    System.out.println("현재 고용된 전문가가 없어서 해고할 수 없습니다. \n 처음으로 돌아갑니다.");
                                }
                                else {
                                    while(choice4){
                                        System.out.println("해고할 전문가의 숫자를 입력해주세요.");
                                        System.out.println("1. 경제학자    2. 신학자    3. 군사전문가               9.처음으로 돌아가기");
                                        int fire_num = sc.nextInt();
                                        if(fire_num == 9){
                                            choice4 = false;
                                        }
                                        else if (fire_num >=1 && fire_num <= experts.length) {
                                            choice4 = Expert.fire(mycity,fire_num,experts);
                                        }
                                        else {
                                            System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요");
                                        }
                                    }
                                }
                                choice3 = false;
                            }
                            else if (emp_num == 3){
                                if(mycity.isExistattraction() == false){
                                    System.out.println("명인과 계약하기 위해서는 명소를 먼저 지어야합니다. \n처음으로 돌아갑니다.");
                                }
                                else {
                                    System.out.println("명인 헤드헌팅");
                                    if(masters[0].isContract() == true || masters[1].isContract() == true || masters[2].isContract() == true){
                                        System.out.println("이미 명인이 도시에 체류중이기 때문에 다른 명인과 계약할 수 없습니다. \n처음으로 돌아갑니다.");
                                    }
                                    else {
                                        while(choice4){
                                            System.out.println("※※※※※ 주의 : 도시는 한명의 명인과 평생계약을 맺습니다.(해고 불가) 유지비를 고려하여 신중하게 선택해주세요. ※※※※※");
                                            Expert.listshow(masters);
                                            int mas_num = sc.nextInt();
                                            if(mas_num == 9){
                                                choice4 = false;
                                            }
                                            else if (mas_num >= 1 && mas_num <= masters.length){
                                                choice4 = Master.contract(mycity,mas_num,masters);
                                            }
                                            else {
                                                System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요.");
                                            }
                                        }
                                    }
                                }
                                choice3 = false;
                            }
                            else if (emp_num == 9){
                                System.out.println("처음으로 돌아가기");
                                choice3 = false;
                            }
                            else {
                                System.out.println("잘못 입력하셨습니다. \n다시 입력해주세요.");;
                            }
                        }
                        //choice = false;
                        choice2 = false;
                    }
                    else if (spendmoney == 9) {
                        System.out.println("이전메뉴로 돌아갑니다.\n");
                        choice2 = false;
                    }
                    else {
                        System.out.println("잘못입력하셨습니다. \n메뉴중에 선택해주세요.");
                    }
                }

            }
            else if (behavior == 5){
                mycity.showbuilding(attracts);
            }
            else if (behavior == 6){
                mycity.showemployer(masters);
            }
            /*else if (behavior == 7){ //적군상태파악
                enemycity_observe.enemystatus();
            }*/
            else if (behavior == 7) {
                enemycity.search(mycity,enemycity,enemycity_observe,txtArea,txt_list3);
            }
            else if (behavior == 8){
                Interface.contact();
                choice2 = true;
                while(choice2) {
                    int contact_num = sc.nextInt();
                    if (contact_num == 1){
                        System.out.println("얼마를 기부하시겠습니까? (최소:50G)");
                        int donate_money = sc.nextInt();
                        enemycity.donate(mycity,enemycity,donate_money);
                        choice2 = false;

                    } else if (contact_num == 2){
                        if (enemycity.getFriendship() >= 70){
                            while(choice3){
                                Interface.inter();
                                int inter_num = sc.nextInt();
                                if (inter_num == 9){
                                    choice3 = false;
                                    continue;
                                }else {
                                    chance = enemycity.interact(mycity,enemycity,inter_num,chance);
                                    choice3 = false;
                                }
                            }
                        } else {
                            System.out.println("상대 도시와 우호적일때만 교류가 가능합니다.");
                        }
                        choice2 = false;
                    } else if (contact_num == 3){
                        while(choice3){
                            Interface.press();
                            int press_num = sc.nextInt();
                            if(press_num == 9){
                                choice3 = false;
                                continue;
                            } else {
                                choice3 = enemycity.pressure(mycity,enemycity,press_num);
                            }
                        }
                        choice2 = false;

                    } else if (contact_num == 4){
                        end = enemycity.war(mycity,enemycity);
                        choice2 = false;

                    } else if (contact_num == 9){
                        choice2 = false;
                    } else {
                        System.out.println("잘못 입력하셨습니다.\n다시 입력해주세요.");
                        System.out.println();
                    }
                }
            }
            else if (behavior == 9){
                if(canstop == true) {
                    System.out.println("PAUSE");
                    mycity.rest2_interrupt(t2);
                    mycity.rest3_interrupt(t3);
                    mycity.rest4_interrupt(t4);
                    mycity.enemygrow_interrupt(t5);
                    t6.interrupt();
                    canstop = false;
                }
            }
            else if (behavior == 10){
                if(canstop == false) {
                    System.out.println("RESUME");
                    t2 = mycity.rest2(mycity, txtArea); // 쿨타임 회복
                    t3 = mycity.rest3(mycity, txtArea); // 활동력 회복
                    t4 = mycity.rest4(mycity, masters, txtArea); // 일수증가,인구증가,유지비,특수능력,악재?
                    t5 = enemycity.enemygrow(enemycity, mycity, levelinfo, txtArea);
                    t6 = mycity.city_status(mycity,txt_list);
                    canstop = true;
                }
            }
            else if (behavior == 11){
                System.out.println("음악끄기");
                t7.interrupt();
                music_stop = true;
            }
            else if (behavior == 12){
                System.out.println("음악키기");
                music_num = 0;
                music_stop = false;
            }
            else {
                System.out.println("잘못입력하셨습니다.");
                System.out.println("행동 리스트에서 선택해주세요.\n");

            }
        }
    }
}