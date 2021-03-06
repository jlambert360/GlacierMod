

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GlacierCreativeTab extends CreativeTabs{

	private int tabIndexID;
	private String tabName;
	
	public GlacierCreativeTab(int par1, int par2, String par2Str, String par3Str, String par4Str) {
		super(par1, par3Str);
		
		this.tabName = par4Str;
		this.tabIndexID = par2;
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex(){
		return tabIndexID;
		
	}
	
	public String getTranslatedTabLabel(){
		return this.tabName;
	}
	
}