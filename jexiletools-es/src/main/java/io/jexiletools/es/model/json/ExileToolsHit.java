package io.jexiletools.es.model.json;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.elasticsearch.common.lang3.StringUtils;

import io.jexiletools.es.model.BaseItemType;
import io.jexiletools.es.model.Mod;
import io.jexiletools.es.model.Price;

public class ExileToolsHit {
	public ExileToolsHit() { }
	String md5sum; //d5f3025826c8dba4bf8b6e182f5ca1a0
	String uuid;   //1319466:d5f3025826c8dba4bf8b6e182f5ca1a0
	
	Info info;
	Shop shop;
	Attributes attributes;
	Sockets sockets;
	Requirements requirements;
	Map<String, Map<String, Object>> properties;
	Map<String, Object> mods;
	Map<String, Object> modsTotal;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExileToolsHit [");
		builder.append(System.lineSeparator());
		builder.append("md5sum=");
		builder.append(md5sum);
		builder.append(System.lineSeparator());
		builder.append("uuid=");
		builder.append(uuid);
		builder.append(System.lineSeparator());
		builder.append("info=");
		builder.append(info);
		builder.append(System.lineSeparator());
		builder.append("shop=");
		builder.append(shop);
		builder.append(System.lineSeparator());
		builder.append("attributes=");
		builder.append(attributes);
		builder.append(System.lineSeparator());
		builder.append("sockets=");
		builder.append(sockets);
		builder.append(System.lineSeparator());
		builder.append("]");
		return builder.toString();
	}

	public String getMd5sum() {
		return md5sum;
	}

	public void setMd5sum(String md5sum) {
		this.md5sum = md5sum;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public Sockets getSockets() {
		return sockets;
	}

	public void setSockets(Sockets sockets) {
		this.sockets = sockets;
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}

	public Map<String, Map<String, Object>> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Map<String, Object>> properties) {
		this.properties = properties;
	}

	public Map<String, Object> getMods() {
		return mods;
	}

	public void setMods(Map<String, Object> mods) {
		this.mods = mods;
	}

	public Map<String, Object> getModsTotal() {
		return modsTotal;
	}

	public void setModsTotal(Map<String, Object> modsTotal) {
		this.modsTotal = modsTotal;
	}

	@SuppressWarnings("unchecked")
	public List<Mod> getExplicitMods() {
		List<Mod> result = Collections.emptyList();
		Map<String, Object> _mods = getMods();
		if (_mods != null && !_mods.isEmpty()) {
			Map<String, Object> itemTypeMods = (Map<String, Object>) _mods.get(getAttributes().getItemType());
			Map<String, Object> explicitMods = (Map<String, Object>) itemTypeMods.get("explicit");
			if (explicitMods != null) {
				result = explicitMods
						.entrySet()
						.stream()
						.map(e -> Mod.fromRaw(e.getKey(), e.getValue()))
						.collect(Collectors.toList());
			}
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Mod> getImplicitMod() {
		Optional<Mod> result = Optional.empty();
		Map<String, Object> _mods = getMods();
		if (_mods != null && !_mods.isEmpty()) {
			Map<String, Object> itemTypeMods = (Map<String, Object>) _mods.get(getAttributes().getItemType());
			Map<String, Object> implicitMods = (Map<String, Object>) itemTypeMods.get("implicit");
			if (implicitMods != null) {
				result = implicitMods
						.entrySet()
						.stream()
						.map(e -> Mod.fromRaw(e.getKey(), e.getValue()))
						.findFirst();
			}
		}
		return result;
	}

	public BaseItemType getBaseItemType() {
		return BaseItemType.fromDisplayName(getAttributes().getBaseItemType());
	}
	
	public Optional<Double> getArmour() {
		return getDoubleFromProperties("Armour");
	}
	
	public Optional<Double> getEnergyShield() {
		return getDoubleFromProperties("Energy Shield");
	}
	
	public Optional<Double> getEvasionRating() {
		return getDoubleFromProperties("Evasion Rating");
	}
	
	public Optional<Double> getChanceToBlock() {
		return getDoubleFromProperties("Chance to Block");
	}
	
	public Optional<Double> getAPS() {
		return getDoubleFromProperties("Attacks per Second");
	}
	
	public Optional<Double> getChaosDPS() {
		return getDoubleFromProperties("Chaos DPS");
	}
	
	public Optional<Range> getChaosDamage() {
		return getRangeFromProperties("Chaos Damage");
	}

	public Optional<Double> getQuality() {
		return getDoubleFromProperties("Quality");
	}
	
	public Optional<Double> getCriticalStrikeChance() {
		return getDoubleFromProperties("Critical Strike Chance");
	}

	public Optional<Double> getTotalDPS() {
		return getDoubleFromProperties("Total DPS");
	}
	
	public Optional<Double> getPhysicalDPS() {
		return getDoubleFromProperties("Physical DPS");
	}
	
	public Optional<Range> getPhysicalDamage() {
		return getRangeFromProperties("Physical Damage");
	}
	
	public Optional<Double> getElementalDPS() {
		return getDoubleFromProperties("Elemental DPS");
	}
	
	public Optional<Range> getElementalDamage() {
		return getRangeFromProperties("Elemental Damage");
	}
	
	private Optional<Double> getDoubleFromProperties(String key) {
		Optional<Map<String, Map<String, Object>>> props = Optional.ofNullable(getProperties());
		
		Optional<Double> quality = props
			.map(e -> e.get(getBaseItemType().displayName()))
			.map(e -> {
				return e.get(key);
			})
			.map(e -> (Double) e);
		return quality;
	}
	
	private Optional<Range> getRangeFromProperties(String key) {
		Optional<Map<String, Map<String, Object>>> props = Optional.ofNullable(getProperties());
		
		@SuppressWarnings("unchecked")
		Optional<Range> quality = props
				.map(e -> e.get(getBaseItemType().displayName()))
				.map(e -> (Map<String, Double>) e.get(key))
				.map(e -> new Range(e));
		return quality;
	}

	public String toWTB() {
		Optional<String> sellerIGN = Optional.ofNullable(StringUtils.trimToNull(getShop().getSellerIGN()));
		Optional<Price> price = getShop().getPrice();
		DecimalFormat df = new DecimalFormat("#.##");
		String priceStr = price.isPresent() ?
				String.format(" listed for %s %s", df.format(price.get().getAmount()), price.get().getCurrency().displayName())
				: "" ;
		
		return sellerIGN.map(ign -> 
			String.format("@%s Hi, I would like to buy your %s%s in %s",
					ign, getInfo().getFullName(), priceStr, getAttributes().getLeague()))
				.orElse(
						"https://www.pathofexile.com/forum/view-thread/" + getShop().getThreadid() 
				);
	}

}