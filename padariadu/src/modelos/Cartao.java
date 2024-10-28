package modelos;

public class Cartao extends MetodoPagamento{
	private double credito;
	private double debito;
	
	public Cartao() {}
	
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	public double getDebito() {
		return debito;
	}
	public void setDebito(double debito) {
		this.debito = debito;
	}
}
