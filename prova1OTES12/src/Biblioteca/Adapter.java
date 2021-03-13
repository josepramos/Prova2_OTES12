package Biblioteca;

public class Adapter extends VendasRegiao{
	
	 public Adapter(String Funcionario, String Trimestre, String Regiao, float Vendas) {
		super(Funcionario, Trimestre, Regiao, Vendas);
	}	 

	public void CidadeRegiaoAdapterNorte (Registros r1) {
		VendasRegiao vr1 = new VendasRegiao(this.Funcionario, this.Trimestre, "Norte", this.Vendas);
		
		r1.addVendas(r1, Funcionario, Trimestre, "Norte", Vendas);
	 }

}
