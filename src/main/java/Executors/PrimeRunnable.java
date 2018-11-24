package Executors;

import java.util.concurrent.Callable;

class NumberPrime{


    Integer number;
    Boolean isPrime;

    NumberPrime(Integer number,boolean isPrime){

        this.isPrime = isPrime;
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getPrime() {
        return isPrime;
    }

    public void setPrime(Boolean prime) {
        isPrime = prime;
    }
}

public class PrimeRunnable implements Callable<NumberPrime> {



    Integer num;
    PrimeRunnable(Integer number){

        this.num = number;


    }

    public NumberPrime call() throws Exception {


            for(int i=2;i<num;i++) {
                if(num%i==0)
                    return new NumberPrime(num,false);
            }
            return new NumberPrime(num,true);
        }
    }

