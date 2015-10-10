package io.jexiletools.es.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExileToolsHit {
	public ExileToolsHit() { }
	String md5sum; //d5f3025826c8dba4bf8b6e182f5ca1a0
	String uuid;   //1319466:d5f3025826c8dba4bf8b6e182f5ca1a0
	
	Info info;
	Shop shop;
	Attributes attributes;
	Sockets sockets;
	Requirements requirements;
	Properties properties;
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

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
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
		List<Mod> result = new ArrayList<>();
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
}