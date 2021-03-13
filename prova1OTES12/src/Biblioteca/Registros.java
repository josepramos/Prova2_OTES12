package Biblioteca;

import java.util.ArrayList;

public class Registros {
	private ArrayList<VendasRegiao> registrosVendas = new ArrayList();
	private ArrayList<Cota> registrosCotas = new ArrayList();

	public void addVendas (Registros r1, String Funcionario, String Trimestre, String Regiao, float Vendas) {
		 r1.registrosVendas.add(new VendasRegiao(Funcionario, Trimestre, Regiao, Vendas));
	}
	
	public void addCota (Registros r1, String Funcionario, String Trimestre, String Regiao, float Cota) {
		 r1.registrosCotas.add(new Cota(Funcionario, Trimestre, Regiao, Cota));
	}
	
	public void getRegistrosVendas(Registros r1) {
		System.out.println("Funcionario: "+ r1.registrosVendas.get(0).Funcionario);
		System.out.println("Trimestre: "+ r1.registrosVendas.get(0).Trimestre);
		System.out.println("Regiao: "+ r1.registrosVendas.get(0).Regiao);
		System.out.println("Vendas: "+ r1.registrosVendas.get(0).Vendas);
	}
	
	public int getValorUltimaVenda(Registros r1) {
		return (int) r1.registrosVendas.get(0).Vendas;
	}
	
	public void getRegistrosCotas(Registros r1) {
		System.out.println("Funcionario: "+ r1.registrosCotas.get(0).Funcionario);
		System.out.println("Trimestre: "+ r1.registrosCotas.get(0).Trimestre);
		System.out.println("Regiao: "+ r1.registrosCotas.get(0).Regiao);
		System.out.println("Cota: "+ r1.registrosCotas.get(0).Cota);
	}


}
