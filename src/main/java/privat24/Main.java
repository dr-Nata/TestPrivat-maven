package com.privat24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    private List<Broadcast> broadcastList;
    private List<RadioHost> radioHostList;
    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        broadcastList = createBroadcastList();
        radioHostList = createRadioHostList();
        showMenu();
    }

    private List<RadioHost> createRadioHostList() {
        List<RadioHost> list = new ArrayList<>();
        List<Broadcast> broadcastListRadioHost = new ArrayList<>();
        broadcastListRadioHost.add(broadcastList.get(1-1));
        broadcastListRadioHost.add(broadcastList.get(2-1));
        list.add(new RadioHost("Макс Назаров",broadcastListRadioHost,true,5));
        list.add(new RadioHost("Панченко",broadcastListRadioHost,true,7));
        broadcastListRadioHost = new ArrayList<>();
        broadcastListRadioHost.add(broadcastList.get(2-1));
        broadcastListRadioHost.add(broadcastList.get(4-1));
        broadcastListRadioHost.add(broadcastList.get(5-1));
        list.add(new RadioHost("Шустер",broadcastListRadioHost,false,"Так себе"));

        return list;
    }

    private List<Broadcast> createBroadcastList() {
        List<Broadcast> list = new ArrayList<>();
        List<PartBroadcast> partList = new ArrayList<>();
        partList.add(new Song("Светофор","В.Леонтьев",6*60+53));
        partList.add(new Reclame("Coca-Cola",25));
        partList.add(new Song("Дельтаплан","В.Леонтьев",6*60+53));
        partList.add(new Interview("Kuzya",15*60));

        list.add(new Broadcast(50,partList));
        partList = new ArrayList<>();
        partList.add(new Song("Black Or White","М.Джексон",3*60+19));
        partList.add(new Reclame("Coca-Cola",25));
        partList.add(new Song("You Are Not Alone","М.Джексон",4*60+34));
        partList.add(new Interview("Арнольд Шварценегер",25*60));
        list.add(new Broadcast(30,partList));
        list.add(new Broadcast(60,partList));
        list.add(new Broadcast(40,partList));
        list.add(new Broadcast(50,partList));
        return list;
    }

    private void showMenu() {
        System.out.println("╔═════════════M E N U═════════════╗");
        System.out.println("║ 1. Показать все трансляции      ║");
        System.out.println("║ 2. Добавить часть в трансляцию  ║");
        System.out.println("║ 3. Показать доход трансляции №  ║");
        System.out.println("║ 4. Показать части трансляции №  ║");
        System.out.println("║ 5. Показать список ведущих      ║");
        System.out.println("║ 0. Выход                        ║");
        System.out.println("╚═════════════════════════════════╝");
        System.out.print("Введите номер пункта: ");

        int item = scanner.nextInt();
        switch (item){
            case 0:
                System.exit(0);
                break;
            case 1:
                showAllBroadcast();
                break;
            case 2:
                addPartToBroadcast();
                break;
            case 3:
                showIncomeBroadcast();
                break;
            case 4:
                showPartsBroadcast();
                break;
            case 5:
                showListRadioHost();
                break;
        }
        showMenu();
    }

    private void showListRadioHost() {
        /*5. Показать список ведущих*/
        for (RadioHost radioHost : radioHostList) {
            boolean mainTime = radioHost.isMainTime();
            System.out.printf("%s | %s | %s%n", radioHost.getName(), mainTime ? "Стаж:" + radioHost.getExperience() : "Стаж не указан", !mainTime ? "Резюме:" + radioHost.getResume() : "Резюме не хранится");
            for (Broadcast broadcast : radioHost.getBroadcastList()) {
                System.out.printf("  Передача № %d%n", broadcastList.indexOf(broadcast) + 1);
            }

        }
    }

    private void showPartsBroadcast() {
        /*4. Показать части трансляции №*/
        System.out.print("Введите номер трансляции: ");
        int nt = scanner.nextInt();
        Broadcast broadcast = broadcastList.get(nt - 1);
        List<PartBroadcast> partBroadcastList = broadcast.getPartBroadcastList();
        System.out.printf("Трансляция №%d[%dмин]%n", nt, broadcast.getDurationMin());
        for (PartBroadcast partBroadcast : partBroadcastList) {
            System.out.println(partBroadcast.getInfo());
        }
    }

    private void showIncomeBroadcast() {
        /*3. Показать доход трансляции №*/
        System.out.print("Введите номер трансляции: ");
        int nt = scanner.nextInt();
        System.out.printf("Доход: %d%n", broadcastList.get(nt - 1).getIncome());
    }

    private void addPartToBroadcast() {
        /* 2. Добавить часть в трансляцию*/
        System.out.print("Введите номер трансляции: ");
        int nt = scanner.nextInt();
        PartBroadcast pt = showMenuAddPart(broadcastList.get(nt-1).getDurationMin(),
                broadcastList.get(nt-1).getSumDuration(),
                broadcastList.get(nt-1).getDurationPaidContent());
        if (pt != null) {
            broadcastList
                    .get(nt-1)
                    .getPartBroadcastList()
                    .add(pt);
            System.out.println("╔══════════ ADD═══════════════╗");
            System.out.printf ("║ Часть: %20s ║\n",pt.getInfo().substring(0, pt.getInfo().indexOf("{")));
            System.out.printf ("║ добавлена в трансляцию № %2d ║\n",nt);
            System.out.println("╚═════════════════════════════╝");
        }
    }

    private PartBroadcast showMenuAddPart(int durationMin,int sumDuration,int durationPaidContent ) {
        System.out.println("╔═══T Y P E═════╗");
        System.out.println("║ 1. Песня      ║");
        System.out.println("║ 2. Реклама    ║");
        System.out.println("║ 3. Интервью   ║");
        System.out.println("╚═══════════════╝");
        System.out.print("Выберите тип части трансляции: ");
        int type = scanner.nextInt();
        System.out.print("Введите длительность части трансляции(sec): ");
        int duration = scanner.nextInt();
        if (duration+sumDuration>durationMin*60L) {
            System.err.println("╔═══════Not ADD═══════════════╗");
            System.out.println("║ общее количество минут      ║");
            System.out.println("║ частей трансляции больше,   ║");
            System.out.println("║ чем длина всей трансляции.  ║");
            System.err.println("╚═════════════════════════════╝");
            return null;
        }
        if (durationPaidContent>durationMin*60L / 2) {
            System.err.println("╔═══════Not ADD═══════════════╗");
            System.out.println("║ продолжительность платного  ║");
            System.out.println("║ контента не может превышать ║");
            System.out.println("║ 50% от общей продолжитель-. ║");
            System.out.println("║ ности трансляции.           ║");
            System.err.println("╚═════════════════════════════╝");
            return null;
        }
        switch (type){
            case 1:
                System.out.print("Введите название песни: ");
                String song = scanner.next();
                System.out.print("Введите Имя исполнителя: ");
                String sing = scanner.next();
                return new Song(song,sing,duration);
            case 2:
                System.out.print("Введите название рекламируемого продукта: ");
                String title = scanner.next();
                return new Reclame(title,duration);
            case 3:
                System.out.print("Введите имя интервьюируемого: ");
                String name = scanner.next();
                return new Interview(name,duration);
        }
       return null;
    }

    private void showAllBroadcast() {
       /* 1. Показать все трансляции  */
        int tr = 1;
        for (Broadcast broadcast : broadcastList) {
            System.out.printf("Трансляция №%d[%dмин]%n", tr++, broadcast.getDurationMin());
            List<PartBroadcast> partBroadcastList = broadcast.getPartBroadcastList();
            for (PartBroadcast partBroadcast : partBroadcastList) {
                System.out.printf("%sмин \n"
//                        ,partBroadcast.
                        ,partBroadcast.getDuration()/60 + ":"+partBroadcast.getDuration()%60);
            }


        }
    }
}
