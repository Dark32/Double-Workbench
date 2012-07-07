package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class BlockWorkbenchDouble extends Block implements ITextureProvider{

	protected BlockWorkbenchDouble(int par1) {
		super(par1, Material.wood);
	}

	public int getBlockTextureFromSide(int par1)
    {
    	if(par1 == 0) return 2;
    	else if (par1 == 1) return 1;
    	else return 0;
    }
    
    public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        	ModLoader.openGUI(par5EntityPlayer, new GuiDoubleCrafting(par5EntityPlayer.inventory, par1World, par2, par3, par4));
            return true;
    }
    
    public String getTextureFile(){
    	return "/vazkii/doublecrafting/sprites.png";
    }

}
