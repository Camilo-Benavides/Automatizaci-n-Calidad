package co.edu.udea.certificacion.taller.utils;

public class WaitTime {

    static WaitTime waitTime;

    Integer millis;

    public WaitTime(Integer millis){

        try {

            Thread.sleep(millis);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        this.millis=millis;

    }

    public static WaitTime putWaitTimeOf(Integer millis){

        waitTime = new WaitTime(millis);

        return waitTime;

    }
}