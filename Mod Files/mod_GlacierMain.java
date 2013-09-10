
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class mod_GlacierMain extends BaseMod {

	public static final String version = "Beta v1.0";
	public static final String name = "Glacier Mod";
	public static final String description = "Adds a new Biome called the Glacier Biome!";
	public static final String authors = "Cobra_Fett, Jlambert360";
	
	public static BiomeGenBase GlacierBiome;
	
	static int startEntityId = 300;
	
	//Enum Register                                                          Name, Level, Uses, Efficiency, Damage -4, Enchant Level Max
	public static EnumToolMaterial TuskSpear = EnumHelper.addToolMaterial("TuskSpear", 3, 200, 0.8F, 2.0F, 30);
	
	//Creative Tabs
	public static CreativeTabs tabGlacier = new GlacierCreativeTab(CreativeTabs.getNextID(), Block.ice.blockID, "tabGlacier", "GlacierTab", "Glacier");
	
	//Items										   //id - food restore - saturation - wolf food\\
	public static Item itemboartusk = new ItemBoarTusk(5000).setCreativeTab(CreativeTabs.tabFood).setUnlocalizedName("Boar Tusk").func_111206_d("boar_tusk");
	public static Item itemheartofdarkness = new ItemHeartofDarkness(5002).setCreativeTab(CreativeTabs.tabFood).setUnlocalizedName("Heart of Darkness").func_111206_d("heart_darkness");
	
	//Sword
	public static Item itemtuskspear = new ItemTuskSpear(5001, TuskSpear).setCreativeTab(tabGlacier).setUnlocalizedName("Tusk Spear").func_111206_d("tusk_spear");
	
	//Generate Mobs
	public static int getUniqueEntityId(){
		do {
			startEntityId++;
		}
		while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId++;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor){
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
	public void load() {
		itemboartusk.setCreativeTab(tabGlacier);
		itemtuskspear.setCreativeTab(tabGlacier);
		itemheartofdarkness.setCreativeTab(tabGlacier);
		
		//Spawn Eggs
		LanguageRegistry.instance().addStringLocalization("entity.Yeti.name", "en_US", "Yeti");
		LanguageRegistry.instance().addStringLocalization("entity.Eskimo.name", "en_US", "Eskimo");
		LanguageRegistry.instance().addStringLocalization("entity.Evil Eskimo.name", "en_US", "Evil Eskimo");
		LanguageRegistry.instance().addStringLocalization("entity.Deadly Yeti.name", "en_US", "Deadly Yeti");
		LanguageRegistry.instance().addStringLocalization("entity.Frost Skelly.name", "en_US", "Frost Skelly");
		LanguageRegistry.instance().addStringLocalization("entity.Ghostly Remnant.name", "en_US", "Ghostly Remnant");
		LanguageRegistry.instance().addStringLocalization("entity.Wild Boar.name", "en_US", "Wild Boar");
		
		//Items
		GameRegistry.registerItem(itemboartusk, "Boar Tusk");
		GameRegistry.registerItem(itemtuskspear, "Tusk Spear");
		GameRegistry.registerItem(itemheartofdarkness, "Heart of Darkness");
		
		//Items
		LanguageRegistry.addName(itemboartusk, "Boar Tusk");
		LanguageRegistry.addName(itemtuskspear, "Tusk Spear");
		LanguageRegistry.addName(itemheartofdarkness, "Heart of Darkness");
		
		//Crafting Recipies
		GameRegistry.addRecipe(new ItemStack(itemtuskspear), new Object[] {
			" B ",
			" S ",
			" S ",
			'S', Item.stick , 'B', itemboartusk 
		});
		
		//Biomes
		GlacierBiome = new BiomeGlacierBiome(150).setBiomeName("Glacier").setDisableRain().setMinMaxHeight(1.1F, 5.5F);
		
		GameRegistry.addBiome(GlacierBiome);
		
		//Mob Yeti
		EntityRegistry.registerGlobalEntityID(EntityYeti.class, "Yeti", 1);
		EntityRegistry.addSpawn(EntityYeti.class, 10, 2, 4, EnumCreatureType.monster, GlacierBiome);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityYeti.class, 0x3c768c, 0xb50000);//Background, Foreground
		RenderingRegistry.registerEntityRenderingHandler(EntityYeti.class, new RenderYeti(new Yeti(), 0.3F));
		
		//Mob Eskimo
		EntityRegistry.registerGlobalEntityID(EntityEskimo.class, "Eskimo", 2);
		EntityRegistry.addSpawn(EntityEskimo.class, 10, 2, 4, EnumCreatureType.creature, GlacierBiome);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityEskimo.class, 0x001eff, 0xffae00);
		RenderingRegistry.registerEntityRenderingHandler(EntityEskimo.class, new RenderEskimo(new Eskimo(), 0.3F));
		
		//Mob Evil Eskimo
		EntityRegistry.registerGlobalEntityID(EntityEvilEskimo.class, "Evil Eskimo", 3);
		EntityRegistry.addSpawn(EntityEvilEskimo.class, 10, 2, 4, EnumCreatureType.monster, GlacierBiome);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityEvilEskimo.class, 0x001eff, 0xd40707);
		RenderingRegistry.registerEntityRenderingHandler(EntityEvilEskimo.class, new RenderEvilEskimo(new EvilEskimo(), 0.3F));
		
		//Mob Deadly Yeti
		EntityRegistry.registerGlobalEntityID(EntityDeadlyYeti.class, "Deadly Yeti", 4);
		EntityRegistry.addSpawn(EntityDeadlyYeti.class, 10, 2, 4, EnumCreatureType.monster, GlacierBiome);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityDeadlyYeti.class, 0xd503a1, 0x94ef05);
		RenderingRegistry.registerEntityRenderingHandler(EntityDeadlyYeti.class, new RenderDeadlyYeti(new DeadlyYeti(), 0.3F));
		
		//Mob Frost Kelly
		EntityRegistry.registerGlobalEntityID(EntityFrostSkelly.class, "Frost Skelly", 5);
		EntityRegistry.addSpawn(EntityFrostSkelly.class, 10, 2, 4, EnumCreatureType.monster, GlacierBiome);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityFrostSkelly.class, 0x00b6dd, 0x06b930);
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostSkelly.class, new RenderFrostSkelly(new FrostSkelly(), 0.3F));
		
		//Mob Ghostly Remnant
		EntityRegistry.registerGlobalEntityID(EntityGhostlyRemnant.class, "Ghostly Remnant", 6);
		EntityRegistry.addSpawn(EntityGhostlyRemnant.class, 10, 2, 4, EnumCreatureType.monster, GlacierBiome);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityGhostlyRemnant.class, 0x999b99, 0xb70000);
		RenderingRegistry.registerEntityRenderingHandler(EntityGhostlyRemnant.class, new RenderGhostlyRemnant(new GhostlyRemnant(), 0.3F));
		
		//Mob Wild Boar
		EntityRegistry.registerGlobalEntityID(EntityWildBoar.class, "Wild Boar", 7);
		EntityRegistry.addSpawn(EntityWildBoar.class, 10, 1, 3, EnumCreatureType.monster, GlacierBiome);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityWildBoar.class, 0xd38b00, 0x0079b7);
		RenderingRegistry.registerEntityRenderingHandler(EntityWildBoar.class, new RenderWildBoar(new WildBoar(), 0.3F));
	}

public String getVersion() {
		
		return version;
	}

	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	public String getAuthors(){
		return authors;
	}
}
