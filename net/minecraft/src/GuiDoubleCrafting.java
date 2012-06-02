package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiDoubleCrafting extends GuiContainer {
	
	public GuiDoubleCrafting(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
        super(new ContainerWorkbenchDouble(par1InventoryPlayer, par2World, par3, par4, par5));  
	}

    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
	
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
        int var4 = this.mc.renderEngine.getTexture("/vazkii/doublecrafting/gui.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	}

}
