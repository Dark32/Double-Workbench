package net.minecraft.src;

import java.util.List;

import vazkii.um.UpdateManagerMod;

import net.minecraft.client.Minecraft;

public class mod_DoubleWorkbench extends BaseMod{
	public String getVersion() {
		return "by Vazkii. Version [1.0.2] for 1.2.5";
	}

	public void load() {
		ModLoader.registerBlock(doubleWorkbench);
		ModLoader.addName(doubleWorkbench, "Double Workbench");
		ModLoader.setInGUIHook(this, true, true);
		
        ModLoader.addRecipe(new ItemStack(doubleWorkbench, 1), new Object[] {
            "RGR", "WCW", "SSS", Character.valueOf('S'), Block.cobblestone, Character.valueOf('W'), Block.workbench, Character.valueOf('C'), Block.chest, Character.valueOf('R'), Item.redstone, Character.valueOf('G'), new ItemStack(Item.dyePowder, 1, 8)
        });
        
        new UpdateHandler(this);
	}
	
    public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen guiscreen)
    {
        if((guiscreen instanceof GuiContainerCreative) && !(lastGuiOpen instanceof GuiContainerCreative) && !minecraft.theWorld.isRemote)
        {
            Container container = ((GuiContainer)guiscreen).inventorySlots;
            List itemList = ((ContainerCreative)container).itemList;
            	itemList.add(new ItemStack(doubleWorkbench, 1));
        }
        lastGuiOpen = guiscreen;
        return true;
    }
	
	@MLProp public static int doubleWorkbenchID = 214;
	
	public static final Block doubleWorkbench = (new BlockWorkbenchDouble(doubleWorkbenchID)).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setBlockName("doubleWorkbench");

	private static GuiScreen lastGuiOpen;

	public class UpdateHandler extends UpdateManagerMod{
	
		public UpdateHandler(cpw.mods.fml.common.modloader.BaseMod m) {
			super(m);
		}

		public String getModName() {
			return "Double Workbench";
		}

		public String getChangelogURL() {
			return "https://dl.dropbox.com/u/34938401/Mods/On%20Topic/Mods/Double%20Workbench/Changelog.txt";
		}

		public String getUpdateURL() {
			return "https://dl.dropbox.com/u/34938401/Mods/On%20Topic/Mods/Double%20Workbench/Version.txt";
		}

		public String getModURL() {
			return "http://www.minecraftforum.net/topic/528166-123-mlforge-vazkiis-mods-ebonapi-last-updated-12512/";
		}
		
		public String getUMVersion(){
			return "1.0.2";
		}
	}
}
