/*
 * Copyright (C) 2015 thirdy
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package io.jexiletools.es.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author thirdy
 *
 */
public class Properties {
	@SerializedName("Armour") Armour armour;
	@SerializedName("Card") Card card;
	@SerializedName("Currency") Currency currency;
	@SerializedName("Weapon") Weapon weapon;
	
	public static class Armour {
		@SerializedName("Armour") Integer armour;
		@SerializedName("Chance to Block") Double chanceToBlock;
		@SerializedName("Energy Shield") Integer energyShield;
		@SerializedName("Evasion Rating") Integer evasionRating;
		@SerializedName("Quality") Integer quality;
		public Integer getArmour() {
			return armour;
		}
		public void setArmour(Integer armour) {
			this.armour = armour;
		}
		public Double getChanceToBlock() {
			return chanceToBlock;
		}
		public void setChanceToBlock(Double chanceToBlock) {
			this.chanceToBlock = chanceToBlock;
		}
		public Integer getEnergyShield() {
			return energyShield;
		}
		public void setEnergyShield(Integer energyShield) {
			this.energyShield = energyShield;
		}
		public Integer getEvasionRating() {
			return evasionRating;
		}
		public void setEvasionRating(Integer evasionRating) {
			this.evasionRating = evasionRating;
		}
		public Integer getQuality() {
			return quality;
		}
		public void setQuality(Integer quality) {
			this.quality = quality;
		}
	}
	
	public static class Card {
		@SerializedName("Stack Size") Integer stackSize;
	}
	public static class Currency {
		@SerializedName("Imprinted") Integer imprinted;
		@SerializedName("Stack Size") Integer stackSize;
		public Integer getImprinted() {
			return imprinted;
		}
		public void setImprinted(Integer imprinted) {
			this.imprinted = imprinted;
		}
		public Integer getStackSize() {
			return stackSize;
		}
		public void setStackSize(Integer stackSize) {
			this.stackSize = stackSize;
		}
		
	}
	public static class Weapon {
		@SerializedName("Physical DPS") Double pDPS;
		@SerializedName("Elemental DPS") Double eleDPS;
		@SerializedName("Chaos DPS") Double chaosDPS;
		@SerializedName("Physical Damage") Range pDPSRange;
		@SerializedName("Elemental Damage") Range eleDPSRange;
		@SerializedName("Chaos Damage") Range chaosDPSRange;
		@SerializedName("Critical Strike Chance") Double critChance;
		@SerializedName("Quality") Integer quality;
		@SerializedName("Total DPS") Integer totalDPS;
		@SerializedName("Attacks per Second") Double aps;
		public Double getpDPS() {
			return pDPS;
		}
		public void setpDPS(Double pDPS) {
			this.pDPS = pDPS;
		}
		public Double getEleDPS() {
			return eleDPS;
		}
		public void setEleDPS(Double eleDPS) {
			this.eleDPS = eleDPS;
		}
		public Double getChaosDPS() {
			return chaosDPS;
		}
		public void setChaosDPS(Double chaosDPS) {
			this.chaosDPS = chaosDPS;
		}
		public Range getpDPSRange() {
			return pDPSRange;
		}
		public void setpDPSRange(Range pDPSRange) {
			this.pDPSRange = pDPSRange;
		}
		public Range getEleDPSRange() {
			return eleDPSRange;
		}
		public void setEleDPSRange(Range eleDPSRange) {
			this.eleDPSRange = eleDPSRange;
		}
		public Range getChaosDPSRange() {
			return chaosDPSRange;
		}
		public void setChaosDPSRange(Range chaosDPSRange) {
			this.chaosDPSRange = chaosDPSRange;
		}
		public Double getCritChance() {
			return critChance;
		}
		public void setCritChance(Double critChance) {
			this.critChance = critChance;
		}
		public Integer getQuality() {
			return quality;
		}
		public void setQuality(Integer quality) {
			this.quality = quality;
		}
		public Integer getTotalDPS() {
			return totalDPS;
		}
		public void setTotalDPS(Integer totalDPS) {
			this.totalDPS = totalDPS;
		}
		public Double getAps() {
			return aps;
		}
		public void setAps(Double aps) {
			this.aps = aps;
		}
		
		
	}
	public Armour getArmour() {
		return armour;
	}
	public void setArmour(Armour armour) {
		this.armour = armour;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
}
