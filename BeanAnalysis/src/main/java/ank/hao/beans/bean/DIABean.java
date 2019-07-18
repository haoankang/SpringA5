package ank.hao.beans.bean;

public class DIABean {

    private DIBBean dibBean;

    public void setDibBean(DIBBean dibBean){
        System.out.println("dia set..");
        this.dibBean = dibBean;
    }

    public DIABean(){
        System.out.println("dia init..");
    }
}
