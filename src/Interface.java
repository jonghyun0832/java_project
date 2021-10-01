public class Interface {

    public static void Behavior(){
        System.out.println();
        System.out.println("---------------행동을 선택해주세요---------------");
        System.out.println("0. 도시 레벨 조건확인");
        System.out.println("1. 도시 레벨업");
        System.out.println("2. 쿨타임체크");
        System.out.println("3. 도시 활동(활동력소모)");
        System.out.println("4. 도시 발전(활동력소모)");
        System.out.println("5. 보유건물현황");
        System.out.println("6. 보유인재현황");
        System.out.println("7. 적 정찰");
        System.out.println("8. 외교");
        System.out.println("9. 일시정지");
        System.out.println("10. 계속하기");
        System.out.println("11. 음악정지");
        System.out.println("12. 음악키기");
        System.out.println("----------------------------------------------");
        System.out.println();
    }

    public static void Getmoneylist(){
        System.out.println("----------------도시 활동---------------------");
        System.out.println("1. 무역진행");
        System.out.println("2. 종교행사");
        System.out.println("3. 몬스터사냥");
        System.out.println("4. 징수하기");
        System.out.println("5. 축제열기");
        System.out.println();
        System.out.println("9. 이전 선택지로 돌아가기");
        System.out.println("--------------------------------------------");
    }

    public static void Spendmoneylist(){
        System.out.println("----------------도시 발전---------------------");
        System.out.println("1. 인프라(건물)");
        System.out.println("2. 인재");
        System.out.println();
        System.out.println("9. 이전 선택지로 돌아가기");
        System.out.println("--------------------------------------------");
    }

    public static void Startwindow(){
        System.out.println();
        System.out.println("===============================================================================");
        System.out.println();
        System.out.println(" ---------------------------------도시 키우기------------------------------------");
        System.out.println();
        System.out.println("===============================================================================");
        System.out.println();
        System.out.println("------------------시작하시려면 아무숫자나 입력해주세요. (종료 : 0) ------------------");
    }

    public static void Explaination(){
        System.out.println("----------------------------------------도시 키우기---------------------------------------");
        System.out.println("도시를 키워서 나라 최고의 도시를 만들어보자.");
        System.out.println("도시레벨 1부터 시작해 최고 레벨인 5를 만들면 게임에서 승리하게 됩니다.");
        System.out.println("도시레벨업은 특성수치가 일정값 이상으로 오르게되면 레벨업할 수 있습니다.");
        System.out.println("특성수치는 건물을 만들거나 시민을 사면 오르게 됩니다.");
        System.out.println("건물과 시민을 사는데는 돈이 사용됩니다.");
        System.out.println("여러가지 행동을 통해서 돈을 벌 수 있습니다,");
        System.out.println("★★주의★★ : 특성 수치가 너무 많이 떨어지면 악재 이벤트가 일어날 수 있으니 잘 관리하는걸 추천드립니다.");
        System.out.println("악재 이벤트는 상대 도시와의 관계가 적대적일떄부터 발생합니다.");
        System.out.println("상대 도시의 성장과 관계를 주의하며 플레이하시는걸 추천드립니다.");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void startMessage(){
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("게임을 시작하겠습니다");
        System.out.println("훌룡한 도시를 만들어 게임에서 승리하시길 바랍니다.");
        System.out.println("취향에 맞는 시작 도시를 선택하세요 \n 각 도시마다 장단점이 있으니 신중하게 선택해주세요.");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void Gamestart(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆게임을 시작하겠습니다.☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public static void Building(){
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("1. 건물 건설");
        System.out.println("2. 건물 매각");
        System.out.println("3. 명소 건설");
        System.out.println();
        System.out.println("9. 처음으로 돌아가기");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");

    }

    public static void Employ(){
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("1. 전문가 고용");
        System.out.println("2. 전문가 해고");
        System.out.println("3. 명인 계약");
        System.out.println();
        System.out.println("9. 처음으로 돌아가기");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");

    }


    public static void Victory(City mycity, int[] arr){
        int[] array = new int[]{mycity.getEconomy(),mycity.getReligion(),mycity.getForce()};
        int max =array[0];
        int maxindex = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
                maxindex = i;
            }
        }

        if (maxindex == 0){
            System.out.println();
            System.out.println();
            System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★경 제 승 리★★★★★★★★★★★★★★★★★★★★★★★★★★");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("축하드립니다.\n당신의 도시는 막강한 경제력을 바탕으로 레벨 5 도시가 되어 최고의 부를 소유한 도시가 되었습니다.");
            System.out.println("게임에서 승리하였습니다.");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

        } else if (maxindex == 1){
            System.out.println();
            System.out.println();
            System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★종 교 승 리★★★★★★★★★★★★★★★★★★★★★★★★★★");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("축하드립니다.\n당신의 도시는 막강한 종교력을 바탕으로 레벨 5 도시가 되어 자타공인 최고의 종교 도시가 되었습니다.");
            System.out.println("게임에서 승리하였습니다.");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

        } else if (maxindex == 2){
            System.out.println();
            System.out.println();
            System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★국 방 승 리★★★★★★★★★★★★★★★★★★★★★★★★★★");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("축하드립니다.\n당신의 도시는 막강한 전투력을 바탕으로 레벨 5 도시가 되어 자타공인 최고의 치안 도시가 되었습니다.");
            System.out.println("게임에서 승리하였습니다.");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

        }
    }

    public static void Defeat_day(){
        System.out.println();
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println();
        System.out.println("-------------------------------------- 패 배 ------------------------------------------------");
        System.out.println();
        System.out.println("너무 오랜 시간이 걸려서 잊혀진 도시가 되었습니다.");
        System.out.println("세상은 1등이 아니면 기억해주지 않습니다.");
        System.out.println();
        System.out.println("게임 분석 : 좀 더 구체적인 전략이 필요할것같습니다");
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
    }

    public static void Defeat_population(){
        System.out.println();
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println();
        System.out.println("-------------------------------------- 패 배 ------------------------------------------------");
        System.out.println();
        System.out.println("주민이 없는 도시는 도시라고 할 수 없습니다.");
        System.out.println(" - 천하가 비록 편안하더라도, 전쟁을 잊으면 반드시 위태로워진다. - ");
        System.out.println();
        System.out.println("게임 분석 : 발전도 중요하지만 국방에도 신경을 써야합니다.");
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
    }

    public static void Defeat_unhappy(){
        System.out.println();
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println();
        System.out.println("-------------------------------------- 패 배 ------------------------------------------------");
        System.out.println();
        System.out.println("주민들의 행복도가 너무 낮아져 쿠데타가 일어났습니다.");
        System.out.println(" - 무능한 지휘관은 적군보다 무섭다. - ");
        System.out.println();
        System.out.println("게임 분석 : 공짜로 얻을 수 있는 돈은 없습니다.");
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
    }

    public static void Defeat_gold(){
        System.out.println();
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println();
        System.out.println("-------------------------------------- 패 배 ------------------------------------------------");
        System.out.println();
        System.out.println("도시 재정이 파탄났습니다.");
        System.out.println(" - 무능한 지휘관은 적군보다 무섭다. - ");
        System.out.println();
        System.out.println("게임 분석 : 무분별한 고용은 재정파탄으로 이어집니다.");
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
    }

    public static void Defeat_war(){
        System.out.println();
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println();
        System.out.println("-------------------------------------- 패 배 ------------------------------------------------");
        System.out.println();
        System.out.println("상대 도시와의 전쟁에서 패배했습니다.");
        System.out.println(" - 무능한 지휘관은 적군보다 무섭다. - ");
        System.out.println();
        System.out.println("게임 분석 : 상대 도시의 군사력을 잘 봐가며 선전포고를 해야합니다.");
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
    }

    public static void Defeat_enemycity(){
        System.out.println();
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
        System.out.println();
        System.out.println("-------------------------------------- 패 배 ------------------------------------------------");
        System.out.println();
        System.out.println("상대 도시가 먼저 레벨 5를 달성했습니다.");
        System.out.println();
        System.out.println();
        System.out.println("게임 분석 : 상대 도시의 성장을 억제하는것도 좋은 승리 전략입니다.");
        System.out.println();
        System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
    }

    public static void contact() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("1. 회유하기(기부)");
        System.out.println("2. 교류하기");
        System.out.println("3. 압박하기");
        System.out.println("4. 전쟁");
        System.out.println();
        System.out.println("9. 처음으로 돌아가기");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");

    }

    public static void inter(){
        System.out.println("----------------------------상대도시와 교류는 딱 한번만 가능합니다-------------------------------------");
        System.out.println();
        System.out.println("1.경제교류");
        System.out.println("2.종교교류");
        System.out.println("3.군사교류");
        System.out.println();
        System.out.println("9. 처음으로 돌아가기");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");

    }

    public static void press(){
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("1. 경제압박 (상대도시 경제 - 10%)");
        System.out.println("2. 종교압박 (상대도시 종교 - 10%)");
        System.out.println("3. 군사압박 (상대도시 군사 - 10%)");
        System.out.println();
        System.out.println("9. 처음으로 돌아가기");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------");

    }

}
