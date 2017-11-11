package com.miningmark48.stimulus.proxy;

import com.miningmark48.stimulus.init.ModRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void init(){

    }

    @Override
    public void registerRenders(){
        ModRegistry.registerRenderItems();
    }

}
