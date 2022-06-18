package tim7.ISAMRSproject.dto;

public class LoyaltyDTO {

	String rankName;
	int minPoints;
	int maxPoints;
	float discountRate;
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public int getMinPoints() {
		return minPoints;
	}
	public void setMinPoints(int minPoints) {
		this.minPoints = minPoints;
	}
	public int getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
	public float getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}
	
	
}
