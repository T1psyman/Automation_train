package ru.sbrf.learnqa.soxshop.generationdata;


import java.time.Year;

public class GenerationExpiryData {


    public String generationExpiryDataMonth(){
        int m1 = (int)(Math.random()*(2));
        int m2;
        if (m1 == 1){
            m2 = (int) (Math.random()*(3));
        }else {
            m2 = (int) (Math.random()*(9)+1);
        }
    return m1 + "" + m2;
    }
    public int generationExpiryDataYear(){
        int year = Year.now().getValue();
        int y1 = (int) (Math.random()*(5)+1);
    return (year - 2000 + y1);
    }
}
