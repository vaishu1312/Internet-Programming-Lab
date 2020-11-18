package Bean;

public class ansbean{
	private String ans[] = new String[5];

	public void setAns(int i, String ch) {
		this.ans[i] = ch;
	}
	
	public String getAns(int i) {
		return ans[i];
	}
}
