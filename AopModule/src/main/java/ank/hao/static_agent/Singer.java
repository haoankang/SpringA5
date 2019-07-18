package ank.hao.static_agent;

public class Singer implements ShowInterface {
    public void sing() {
        System.out.println("singer sing..");
    }

    public static void main(String[] args) {
        new Singer().sing();
    }
}
