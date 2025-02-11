package com.chailotl.particular.sushi_bar;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class RegistrationHelper
{
	private final String modId;

	public RegistrationHelper(String modId)
	{
		this.modId = modId;
	}

	public Identifier id(String name)
	{
		return Identifier.of(modId, name);
	}

	public Item item(String name, Item item)
	{
		return Registry.register(Registries.ITEM, id(name), item);
	}

	public Item item(String name, Function<Item.Settings, Item> itemProvider)
	{
		return item(name, itemProvider.apply(new Item.Settings()));
	}

	public Item item(String name, Item.Settings settings)
	{
		return item(name, new Item(settings));
	}

	public Item item(String name)
	{
		return item(name, Item::new);
	}
}