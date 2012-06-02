package net.minecraft.src;

public class BlockWorkbenchDouble extends Block {

	protected BlockWorkbenchDouble(int par1) {
		super(par1, Material.wood);
	}

	public int getBlockTextureFromSide(int par1)
    {
    	if(par1 == 0) return 62;
    	else if (par1 == 1) return mod_DoubleWorkbench.cTTopTex;
    	else return mod_DoubleWorkbench.cTSideTex;
    }
    
    public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        	ModLoader.openGUI(par5EntityPlayer, new GuiDoubleCrafting(par5EntityPlayer.inventory, par1World, par2, par3, par4));
            return true;
    }

}
