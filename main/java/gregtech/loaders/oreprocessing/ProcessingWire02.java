package gregtech.loaders.oreprocessing;


import gregtech.GT_Mod;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProcessingWire02 implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingWire02() {
        OrePrefixes.wireGt02.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {

        if (aMaterial == Materials.Cobalt || aMaterial == Materials.Lead || aMaterial == Materials.Tin || aMaterial == Materials.Zinc || aMaterial == Materials.SolderingAlloy) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L), new Object[]{aOreDictName, new ItemStack(Blocks.carpet, 1, 15), new ItemStack(Items.string, 1)});
            GT_Values.RA.addBoxingRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), new ItemStack(Blocks.carpet, 1, 15), GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L), 100, 8);
            GT_Values.RA.addUnboxingRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L), GT_Utility.copyAmount(1L, new Object[]{aStack}), new ItemStack(Blocks.carpet, 1, 15), 100, 8);
        } else if (aMaterial == Materials.RedAlloy) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L), new Object[]{aOreDictName, OrePrefixes.plate.get(Materials.Paper)});
            GT_Values.RA.addBoxingRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 1L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L), 100, 8);
            GT_Values.RA.addUnboxingRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L), GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 1L), 100, 8);

        } else {
            GT_Values.RA.addAssemblerRecipe(aStack, ItemList.Circuit_Integrated.getWithDamage(0L, 24L, new Object[0]), Materials.Rubber.getMolten(144L), GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L), 100, 8);
            GT_Values.RA.addUnboxingRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt02, aMaterial, 1L), GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1L), 100, 8);
        }

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 2L), new Object[]{aOreDictName});
        GT_ModHandler.addShapelessCraftingRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), new Object[]{OrePrefixes.wireGt01.get(aMaterial), OrePrefixes.wireGt01.get(aMaterial)});

        
    }
}
