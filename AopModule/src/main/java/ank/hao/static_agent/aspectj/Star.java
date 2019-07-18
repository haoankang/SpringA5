package ank.hao.static_agent.aspectj;

public class Star {

    void say(){
        System.out.println("Star say..");
    }

    public static void main(String[] args) {
        new Star().say();
    }
}
