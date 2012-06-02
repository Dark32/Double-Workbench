package net.minecraft.src;

import codechicken.nei.API;
import codechicken.nei.IConfigureNEI;
import codechicken.nei.MultiItemRange;

public class NEIDoubleWorkbenchConfig implements IConfigureNEI{

	public void loadConfig() {
		MultiItemRange r = new MultiItemRange();
		r.add(mod_DoubleWorkbench.doubleWorkbench);
		API.addSetRange("Vazkii Mods.Double Workbench", r);
	}

}
