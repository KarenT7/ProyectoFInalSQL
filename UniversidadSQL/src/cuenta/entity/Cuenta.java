package cuenta.entity;

public class Cuenta {
	
	private int codigoCuenta;
	private double  saldoApagar;
	private double importePagado;
	private double descuentoBeca;
	private String planDePagos;
	
	public Cuenta(int codigoCuenta, double saldoApagar, double importePagado, double descuentoBeca,
			String planDePagos) {
		super();
		this.codigoCuenta = codigoCuenta;
		this.saldoApagar = saldoApagar;
		this.importePagado = importePagado;
		this.descuentoBeca = descuentoBeca;
		this.planDePagos = planDePagos;
	}

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(int codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public double getSaldoApagar() {
		return saldoApagar;
	}

	public void setSaldoApagar(double saldoApagar) {
		this.saldoApagar = saldoApagar;
	}

	public double getImportePagado() {
		return importePagado;
	}

	public void setImportePagado(double importePagado) {
		this.importePagado = importePagado;
	}

	public double getDescuentoBeca() {
		return descuentoBeca;
	}

	public void setDescuentoBeca(double descuentoBeca) {
		this.descuentoBeca = descuentoBeca;
	}

	public String getPlanDePagos() {
		return planDePagos;
	}

	public void setPlanDePagos(String planDePagos) {
		this.planDePagos = planDePagos;
	}
	

	@Override
	public String toString() {
		return "Cuenta [codigoCuenta=" + codigoCuenta + ", saldoApagar=" + saldoApagar + ", importePagado="
				+ importePagado + ", descuentoBeca=" + descuentoBeca + ", planDePagos=" + planDePagos + "]";
	}

	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Cuenta cuenta = (Cuenta) o;
			if(this.getCodigoCuenta()==cuenta.getCodigoCuenta()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getCodigoCuenta().hashCode();
	}
	

}
