package io.jexiletools.es.model;

public class ExileToolsHit {
	public ExileToolsHit() { }
	String md5sum; //d5f3025826c8dba4bf8b6e182f5ca1a0
	String uuid;   //1319466:d5f3025826c8dba4bf8b6e182f5ca1a0
	
	Info info;
	Shop shop;
	Attributes attributes;
	Sockets sockets;
	
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

	
	
}