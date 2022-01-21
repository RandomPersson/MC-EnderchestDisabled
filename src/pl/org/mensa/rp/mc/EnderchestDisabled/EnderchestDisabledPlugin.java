package pl.org.mensa.rp.mc.EnderchestDisabled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderchestDisabledPlugin extends JavaPlugin {
	private static EnderchestDisabledPlugin instance;
	
	private List<Recipe> recipes;
	
	public EnderchestDisabledPlugin() {
		instance = this;
		recipes = new ArrayList<Recipe>(1);
	}
	
	public static EnderchestDisabledPlugin getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new EnderchestListener(this), this);
		
		removeRecipes();
	}
	@Override
	public void onDisable() {
		addRecipes();
	}
	
	
	public void removeRecipes() {
		Iterator<Recipe> it = getServer().recipeIterator();
		
		while (it.hasNext()) {
			Recipe recipe = it.next();
			
			if (recipe.getResult().getType() == Material.ENDER_CHEST) {
				recipes.add(recipe);
				it.remove();
			}
		}
	}
	public void addRecipes() {
		for (Recipe recipe : recipes) {
			getServer().addRecipe(recipe);
		}
		
		recipes.clear();
	}
}
