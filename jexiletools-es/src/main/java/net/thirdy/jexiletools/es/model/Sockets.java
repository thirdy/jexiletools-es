package net.thirdy.jexiletools.es.model;

import com.google.gson.annotations.SerializedName;

public class Sockets {
	Sockets.SortedLinkGroup sortedLinkGroup;
	String allSockets;
    String allSocketsSorted;
    Integer largestLinkGroup;
    Integer socketCount;
    
	@Override
	public String toString() {
		return "Sockets [sortedLinkGroup=" + sortedLinkGroup + ", allSockets=" + allSockets + ", allSocketsSorted="
				+ allSocketsSorted + ", largestLinkGroup=" + largestLinkGroup + ", socketCount=" + socketCount
				+ "]";
	}

	public static class SortedLinkGroup {
		@SerializedName("1") String lg1;
		@SerializedName("2") String lg2;
		@SerializedName("3") String lg3;
		@SerializedName("4") String lg4;
		@SerializedName("5") String lg5;
		@Override
		public String toString() {
			return "SortedLinkGroup [lg1=" + lg1 + ", lg2=" + lg2 + ", lg3=" + lg3 + ", lg4=" + lg4 + ", lg5=" + lg5
					+ "]";
		}
	}
}