package package_com.sliit.mtit.osgi.hotelbeveragepulisher;

public class BevarageDetails {
	String conBuy;
	String bev;
	int amount;

	public BevarageDetails(String conBuy, String bev, int amount) {
		this.conBuy = conBuy;
		this.bev = bev;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BevarageDetails{" + "conBuy='" + conBuy + '\'' + ", bev='" + bev + '\'' + ", amount=" + amount + '}';
	}

	public String getConBuy() {
		return conBuy;
	}

	public void setConBuy(String conBuy) {
		this.conBuy = conBuy;
	}

	public String getBev() {
		return bev;
	}

	public void setBev(String bev) {
		this.bev = bev;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
