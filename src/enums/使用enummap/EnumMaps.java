package enums.使用enummap;

import java.util.EnumMap;
import java.util.Map;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书603案例
 *
 * @ Date: Created in 2018-02-08
 * @ Modified:
 **/
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("bathroom fire!");
            }
        });
        em.put(AlarmPoints.LOBBY, new Command() {
            @Override
            public void action() {
                System.out.println("lobby fire!");
            }
        });

        for (Map.Entry<AlarmPoints,Command> e:em.entrySet()){
            System.out.println(e.getKey()+"");
            e.getValue().action();
        }
        try {
            em.get(AlarmPoints.STAIR1).action();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
