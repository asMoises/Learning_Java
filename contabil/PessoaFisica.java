package contabil;

public class PessoaFisica extends contribuinte {

	private double gastoSaude;
	

	public PessoaFisica(String name, Double rendaAnual, double gastoSaude) {
		super(name, rendaAnual);
		this.gastoSaude = gastoSaude;
	}


	public double getGastoSaude() {
		return gastoSaude;
	}


	public void setGastoSaude(double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}


	@Override
	public Double calcRenda() {
		double rendaAnual = getRendaAnual();
		double gastoSaude = getGastoSaude();
		if(rendaAnual > 20000) {
			rendaAnual += (rendaAnual * 0.15);
			if(gastoSaude > 0) {
				
			}
		}
		
		return 0.0;
	}
}
