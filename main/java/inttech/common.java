package inttech;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = common.MODID)
public class common
{
    public static final String MODID = "inttech";   
    @SidedProxy(clientSide="inttech.ClientProxy", serverSide="inttech.ServerProxy")
    public static CommonProxy proxy;
@EventHandler
public void preInit(FMLPreInitializationEvent e) { 
	ItemConstructor.init();
proxy.preInit(e);
}
@EventHandler
public void Init(FMLInitializationEvent e) {
proxy.Init(e);
}
@EventHandler
public void PostInit(FMLPostInitializationEvent e) {
proxy.PostInit(e);	
}
}
