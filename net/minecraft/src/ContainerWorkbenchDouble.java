package net.minecraft.src;

public class ContainerWorkbenchDouble extends Container
{
	/**
	 * Vazkii Message:
	 * Javadocs are still here because I'm lazy to remove them, but they may help
	 * if you're reading the code.
	/*
	
    /** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public InventoryCraftingDouble craftMatrix2 = new InventoryCraftingDouble(this, 3, 3);

    /** The crafting result, size 1. */
    public IInventory craftResult = new InventoryCraftResult();
    public IInventory craftResult2 = new InventoryCraftResult();
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerWorkbenchDouble(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
    {
        this.worldObj = par2World;
        this.posX = par3;
        this.posY = par4;
        this.posZ = par5;
        this.addSlot(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 79, 11));
        this.addSlot(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix2, this.craftResult2, 0, 79, 55));
        int var6;
        int var7;

        for (var6 = 0; var6 < 3; ++var6)
        {
            for (var7 = 0; var7 < 3; ++var7)
            {
                this.addSlot(new Slot(this.craftMatrix, var7 + var6 * 3, 8 + var7 * 18, 15 + var6 * 18));
            }
        }
        
        for (var6 = 0; var6 < 3; ++var6)
        {
            for (var7 = 0; var7 < 3; ++var7)
            {
                this.addSlot(new Slot(this.craftMatrix2, var7 + var6 * 3, 116 + var7 * 18, 15 + var6 * 18));
            }
        }

        for (var6 = 0; var6 < 3; ++var6)
        {
            for (var7 = 0; var7 < 9; ++var7)
            {
                this.addSlot(new Slot(par1InventoryPlayer, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
            }
        }

        for (var6 = 0; var6 < 9; ++var6)
        {
            this.addSlot(new Slot(par1InventoryPlayer, var6, 8 + var6 * 18, 142));
        }

        this.onCraftMatrix2Changed(this.craftMatrix2);
        this.onCraftMatrixChanged(this.craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix));
    }
    
    public void onCraftMatrix2Changed(IInventory par1IInventory)
    {
        this.craftResult2.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix2));
    }

    /**
     * Callback for when the crafting gui is closed.
     */
    public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
    {
        super.onCraftGuiClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int var2 = 0; var2 < 9; ++var2)
            {
                ItemStack var3 = this.craftMatrix.getStackInSlotOnClosing(var2);

                if (var3 != null)
                {
                    par1EntityPlayer.dropPlayerItem(var3);
                }
            }
            for (int var2 = 0; var2 < 9; ++var2)
            {
                ItemStack var3 = this.craftMatrix2.getStackInSlotOnClosing(var2);

                if (var3 != null)
                {
                    par1EntityPlayer.dropPlayerItem(var3);
                }
            }
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != mod_DoubleWorkbench.doubleWorkbench.blockID ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }

    /**
     * Called to transfer a stack from one inventory to the other eg. when shift clicking.
     */
    public ItemStack transferStackInSlot(int par1)
    {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.inventorySlots.get(par1);

        if (var3 != null && var3.getHasStack())
        {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();

            if (par1 == 0 || par1 == 1)
            {
                if (!this.mergeItemStack(var4, 10, 46, true))
                {
                    return null;
                }

                var3.func_48433_a(var4, var2);
            }
            else if (par1 >= 10 && par1 < 37)
            {
                if (!this.mergeItemStack(var4, 37, 46, false))
                {
                    return null;
                }
            }
            else if (par1 >= 37 && par1 < 46)
            {
                if (!this.mergeItemStack(var4, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var4, 10, 46, false))
            {
                return null;
            }

            if (var4.stackSize == 0)
            {
                var3.putStack((ItemStack)null);
            }
            else
            {
                var3.onSlotChanged();
            }

            if (var4.stackSize == var2.stackSize)
            {
                return null;
            }

            var3.onPickupFromSlot(var4);
        }

        return var2;
    }
}
