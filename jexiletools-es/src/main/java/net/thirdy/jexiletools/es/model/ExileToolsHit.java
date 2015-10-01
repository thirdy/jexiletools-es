package net.thirdy.jexiletools.es.model;

public class ExileToolsHit {
	String md5sum; //d5f3025826c8dba4bf8b6e182f5ca1a0
	String uuid;   //1319466:d5f3025826c8dba4bf8b6e182f5ca1a0
	
	Info info;
	Shop shop;
	Attributes attributes;
	Sockets sockets;
	@Override
	public String toString() {
		return "HitBody [md5sum=" + md5sum + ", uuid=" + uuid + ", info=" + info + ", shop=" + shop
				+ ", attributes=" + attributes + ", sockets=" + sockets + "]";
	}
	public String getMd5sum() {
		return md5sum;
	}
	public String getUuid() {
		return uuid;
	}
	public Info getInfo() {
		return info;
	}
	public Shop getShop() {
		return shop;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public Sockets getSockets() {
		return sockets;
	}
	
	
}