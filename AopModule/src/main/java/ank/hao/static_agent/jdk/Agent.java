package ank.hao.static_agent.jdk;

import ank.hao.static_agent.ShowInterface;
import ank.hao.static_agent.Singer;

public class Agent implements ShowInterface {

    private ShowInterface showInterface;

    public Agent(ShowInterface showInterface){
        this.showInterface = showInterface;
    }

    @Override
    public void sing() {
        System.out.println("get money");
        showInterface.sing();
        System.out.println("write receipt");
    }

    public static void main(String[] args) {
        Singer singer = new Singer();
        Agent agent = new Agent(singer);
        agent.sing();
    }
}
