package io.jexiletools.es.model;

import java.util.Arrays;
import java.util.Optional;

public enum Currencies {
	
	chaos("Chaos Orb", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollRare.png"),
	none("NONE", null),
	fuse("Orb of Fusing" , "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollSocketLinks.png"),
	alt("Orb of Alteration", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollMagic.png"),
	alch("Orb of Alchemy", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeToRare.png"),
	ex("Exalted Orb", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyAddModToRare.png"),
	unknown("Unknown", null),
	cart("Cartographers Chisel", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyMapQuality.png"),
	jew("Jewellers Orb", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollSocketNumbers.png"),
	regal("Regal Orb", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeMagicToRare.png"),
	chance("Orb of Chance", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeRandomly.png"),
	gcp("Gemcutters Prism", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyGemQuality.png"),
	chrom("Chromatic Orb", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollSocketColours.png"),
	regret("Orb of Regret", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyPassiveSkillRefund.png"),
	divine("Divine Orb", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyModValues.png"),
	scour("Orb of Scouring", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyConvertToNormal.png"),
	vaal("Vaal Orb", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyVaal.png"),
	mirror("Mirror of Kalandra", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyDuplicate.png"),
	bless("Blessed Orb", "http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyImplicitMod.png");
	
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyAddModToMagic.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyAddModToRare.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyArmourQuality.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyConvertToNormal.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyDuplicate.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyFlaskQuality.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyGemQuality.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyIdentification.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyIdentificationFragment.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyImplicitMod.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyImprint.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyImprintOrb.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyMapQuality.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyModValues.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyPassiveSkillRefund.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyPortal.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollMagic.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollMagicShard.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollRare.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollSocketColours.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollSocketLinks.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRerollSocketNumbers.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyRhoaFeather.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeMagicToRare.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeRandomly.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeToMagic.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeToMagicShard.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeToRare.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyUpgradeToRareShard.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyVaal.png
//		http://webcdn.pathofexile.com/image/Art/2DItems/Currency/CurrencyWeaponQuality.png
	
	private String displayName;
	private String icon;

	Currencies(String displayName, String icon) {
		this.displayName = displayName;
		this.icon = icon;
	}

	public String displayName() {
		return displayName;
	}
	
	public Optional<String> icon() {
		return Optional.ofNullable(icon);
	}
	
	@Override
	public String toString() {
		return displayName;
	}
	
	public static Currencies fromDisplayName(String displayName) {
		return Arrays.asList(values())
			.stream()
			.filter(e -> e.displayName.equalsIgnoreCase(displayName))
			.findFirst()
			.orElseGet(() -> Currencies.unknown);
	}
}
