package com.miningmark48.stimulus.proxy;

import com.miningmark48.stimulus.init.ModItems;

public class ClientProxy extends CommonProxy{

    @Override
    public void init(){

    }

    @Override
    public void registerRenders(){
        ModItems.registerRenders();
    }

}
