package ank.hao.spring_aop;

import org.springframework.stereotype.Component;

@Component
public class Wang implements Tenant {
    @Override
    public void rent(String renter) {
        System.out.println(renter + "rent the house");
    }
}
