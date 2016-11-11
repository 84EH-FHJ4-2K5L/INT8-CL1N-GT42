/**package inttech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

class ItemConstructor {
	static Item ItemGenerated;
	static String[][] NewCollection = new String[64][64];
	static String[] ICollection = { "Copper", "Iron", "Steel", "Adamantium" };

	public static void init() {
		ItemConstruction.getCollection(ICollection, NewCollection, ItemGenerated);
	}

}

class ItemConstruction {
	static String[] ITypeCollection = { "Screw", "Bolt", "Rod", "Plate", "Ingot", "Pin", "Paste", "Ring", "Roll" };
	 * public static String[][] getCollectionGenerated(String[][] NewCollection)
	 * { or(int i=0; i<Collection.length; i++) { for(int j=0;
	 * j<ITypeCollection.length; j++) { NewCollection[i][j]=+""; return
	 * NewCollection; }
	

	public static String[][] getCollection(String[] Collection, String[][] NewCollection, Item ItemGenerated) {
		for (int i = 0; i < Collection.length; i++) {
			for (int j = 0; j < ITypeCollection.length; j++) {
				NewCollection[i][j] = Collection[i] + ITypeCollection[j];
				if (NewCollection[i][j] != null) {
					ItemGenerated = new Item().setUnlocalizedName(NewCollection[i][j])
							.setTextureName(NewCollection[i][j]).setCreativeTab(CreativeTabs.tabMisc);
					GameRegistry.registerItem(ItemGenerated, NewCollection[i][j]);
				}
			}
		}
		return NewCollection;
	}
}*/