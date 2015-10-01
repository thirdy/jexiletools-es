package net.thirdy.jexiletools.es.model;

public class Attributes {
	String baseItemType;
	Boolean corrupted;
	Integer cosmeticModCount;
	Integer craftedModCount;
	String equipType;
	Integer explicitModCount;
	Integer explictModCount;
	Integer frameType;
	Boolean identified;
	Integer implicitModCount;
	Integer inventoryHeight;
	Integer inventoryWidth;
	String itemType;
	String league;
	Boolean lockedToCharacter;
	Boolean mirrored;
	String rarity;
	Boolean support;
	@Override
	public String toString() {
		return "Attributes [baseItemType=" + baseItemType + ", corrupted=" + corrupted + ", cosmeticModCount="
				+ cosmeticModCount + ", craftedModCount=" + craftedModCount + ", equipType=" + equipType
				+ ", explicitModCount=" + explicitModCount + ", explictModCount=" + explictModCount + ", frameType="
				+ frameType + ", identified=" + identified + ", implicitModCount=" + implicitModCount
				+ ", inventoryHeight=" + inventoryHeight + ", inventoryWidth=" + inventoryWidth + ", itemType="
				+ itemType + ", league=" + league + ", lockedToCharacter=" + lockedToCharacter + ", mirrored="
				+ mirrored + ", rarity=" + rarity + ", support=" + support + "]";
	}
}