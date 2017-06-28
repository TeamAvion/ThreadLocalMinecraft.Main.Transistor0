package org.teamavion.transistor.client;

import org.teamavion.transistor.common.CommonProxy;
import org.teamavion.transistor.common.items.ModItems;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        ModItems.registerRenders();
    }

}
