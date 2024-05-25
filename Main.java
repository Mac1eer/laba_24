package com.company;

public class Main {

    public static void main(String[] args) {
        PowerSource v380 = new Voltage380V();
        Charger c220 = new Charger220V();
        Adapter adapter = new Adapter(v380);
        adapter.provide();
    }
}
interface Charger{
    void provide();
}
interface PowerSource{
    void provide();
}
class Voltage380V implements PowerSource{
    @Override
    public void provide(){
        System.out.println("Используется разетка 380V");
    }
}
class Charger220V implements Charger{
    @Override
    public void provide(){
        System.out.println("Используется зарядное устройство 220V");
    }
}
class Adapter implements Charger{
    PowerSource powerSource;
    public Adapter(PowerSource powerSource){
        this.powerSource = powerSource;
    }
    public void provide(){
        powerSource.provide();
        System.out.println("Используется зарядное утстройство: 220V\nИзмерение изменилось с 380V до 220V");
    }
}