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

import java.util.Map;

/**
 * @author thirdy
 *
 */
public class Mod {
	
	String name;
	
	boolean isValueRanged; // true for mods like Adds #-# Lightning Damage to Attacks
	
	Double value;
	Range range;
	
	public static Mod fromRaw(String name, Object value) {
		Mod mod = new Mod();
		mod.setName(name);
		if (Double.class.isInstance(value)) {
			mod.setValueRanged(false);
			mod.setValue((Double)value);
		} else if (Map.class.isInstance(value)) {
			mod.setValueRanged(true);
			@SuppressWarnings("unchecked")
			Map<String, Double> m =  (Map<String, Double>) value;
			Range r = new Range(m);
			mod.setRange(r);
		}
		return mod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValueRanged() {
		return isValueRanged;
	}

	public void setValueRanged(boolean isValueRanged) {
		this.isValueRanged = isValueRanged;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mod [name=");
		builder.append(name);
		builder.append(", isValueRanged=");
		builder.append(isValueRanged);
		builder.append(", value=");
		builder.append(value);
		builder.append(", range=");
		builder.append(range);
		builder.append("]");
		return builder.toString();
	}
	
	
}
