package min.point.dto;

public class PointChargeDTO {
	private String name; //거래상품
	private int amount; //거래금액
	private String pay_method; //거래방식
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	
	@Override
	public String toString() {
		return "PointCharge [name=" + name + ", amount=" + amount + ", pay_method=" + pay_method + "]";
	}
	
	
}
