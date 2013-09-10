
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;


public class BiomeGlacierBiome extends BiomeGenBase{

	public BiomeGlacierBiome(int par1) {
		super(par1);
		this.topBlock = (byte)Block.blockSnow.blockID;
		this.fillerBlock = (byte)Block.ice.blockID;
	}

}
