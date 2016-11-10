package gregtech.api.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class FoodValues
{
	public final int hunger;
	public final float saturationModifier;

	public FoodValues(int hunger, float saturationModifier)
	{
		this.hunger = hunger;
		this.saturationModifier = saturationModifier;
	}

	public FoodValues(FoodValues other)
	{
		this(other.hunger, other.saturationModifier);
	}

	/**
	 * @return The amount of saturation that the food values would provide.
	 */
	public float getSaturationIncrement()
	{
		return Math.min(20, hunger * saturationModifier * 2f);
	}

	/**
	 * See {@link IAppleCoreAccessor#getUnmodifiedFoodValues}
	 */
	

	/**
	 * See {@link IAppleCoreAccessor#getFoodValues}
	 */
	public FoodValues getFV(ItemStack itemStack)
	{
		return getFV(itemStack);
	}

	/**
	 * See {@link IAppleCoreAccessor#getFoodValuesForPlayer}
	 */
	

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + hunger;
		result = prime * result + Float.floatToIntBits(saturationModifier);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodValues other = (FoodValues) obj;
		if (hunger != other.hunger)
			return false;
		if (Float.floatToIntBits(saturationModifier) != Float.floatToIntBits(other.saturationModifier))
			return false;
		return true;
	}

}