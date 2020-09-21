package com.zj.dubboprovider.provider;

import com.zj.dubbo.DubboService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0",interfaceClass = DubboService.class)
public class ProviderService implements DubboService {
    @Override
    public void ins() {
        System.out.println("=======>ProviderService <======ins");
    }

    @Override
    public void insert() {
        System.out.println("=======>ProviderService <======insert");
    }

    @Override
    public void upd() {
        System.out.println("=======>ProviderService <======upd");
    }
}
