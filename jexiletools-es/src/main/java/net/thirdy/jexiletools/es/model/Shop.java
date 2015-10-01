package net.thirdy.jexiletools.es.model;

public class Shop {
	  Long	added;
      Double amount;
      Double chaosEquiv;
	  String currency;
	  String forumID;
      String generatedWith;
	  String lastUpdateDB; // "format" : "yyyy-MM-dd HH:mm:ss"
      Long modified;
      Double priceChanges;
	  String sellerAccount;
      String sellerIGN;
	  String threadid;
      Long updated;
      String verified;
	@Override
	public String toString() {
		return "Shop [added=" + added + ", amount=" + amount + ", chaosEquiv=" + chaosEquiv + ", currency="
				+ currency + ", forumID=" + forumID + ", generatedWith=" + generatedWith + ", lastUpdateDB="
				+ lastUpdateDB + ", modified=" + modified + ", priceChanges=" + priceChanges + ", sellerAccount="
				+ sellerAccount + ", sellerIGN=" + sellerIGN + ", threadid=" + threadid + ", updated=" + updated
				+ ", verified=" + verified + "]";
	}
}