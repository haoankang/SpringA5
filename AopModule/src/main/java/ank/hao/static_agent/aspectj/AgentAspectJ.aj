package ank.hao.static_agent.aspectj;

import ank.hao.static_agent.Singer;

public aspect AgentAspectJ {

    pointcut singPointCut():call(* Star.say());

    before():singPointCut(){
        System.out.println("get money by agentaspectj");
    }

    after():singPointCut(){
        System.out.println("write receipt by agentaspectj");
    }
}
