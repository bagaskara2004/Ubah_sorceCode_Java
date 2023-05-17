class Supplyer extends Member{
	private int qty;

	void setQty(int qty){
		this.qty = qty;
	}
	public int getQty(){
		return this.qty;
	}

	@Override
	public void popUp(){
		System.out.println("terimakasih");
	}

}