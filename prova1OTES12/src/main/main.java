package main;
import java.util.Scanner;

import Biblioteca.*;
import RequestsREST.ServicoDeAPI;

public class main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Escolha 1 para rodar com exposicao ou qualquer outro valor para rodar sem exposicao");
		Scanner sc2 = new Scanner (System.in);
		int escolhaComoRodar = sc2.nextInt();
		
		if(escolhaComoRodar == 1) {
			rodarComExposicao();
		} else {
			rodarSemExposicao();
		}
		sc2.close();
	
	}
	
	public static void rodarComExposicao() throws Exception {
		//Cria o scanner para fazer o input
		Scanner sc = new Scanner (System.in);
		
		//Input do login:
		System.out.println("Digite o seu usuário para fazer login:");
		String usuarioLogin = sc.nextLine();
		
		//Input da senha:
		System.out.println("Digite a senha do seu usuário para fazer login:");
		String senhaLogin = sc.nextLine();

		//Chamada da API:
		String path = "/login/" + usuarioLogin + "/" + senhaLogin;
		String retornoJson = ServicoDeAPI.chamaAPIGet(path);
        System.out.println(retornoJson);

        if (!retornoJson.equals("{\"usuario\" : \"Jose\", \"senha\": \"123456\", \"auth\": \"Acesso autorizado\", \"total_vendas_do_mes\":23000}")) {
            System.out.println("Acesso nao autorizado");
        }
        else {
            //Faz o cadastro da venda:
    		System.out.println("");
    		System.out.println("");

    		System.out.println("Cadastre uma venda:");
    		System.out.println("Digite a data que a venda foi realizada:");
            String data = sc.nextLine();
            
    		System.out.println("Digite cidade do cliente que fez a compra:");
            String cidade = sc.nextLine();
            
    		System.out.println("Digite o valor da venda:");
            int valor = sc.nextInt();
    		
    		//Criar uma lista de registro das vendas:
    		Registros r1 = new Registros();
    	
    		//Criar uma Venda:
    		Vendas venda1 = new Vendas (usuarioLogin, data, cidade, valor);

    		//Adaptador agindo, transformando a Venda com parâmetro de cidade para parâmetro de Região
    		//O adaptador já faz cria o registro da lista de registro de vendas
    		Adapter a1 = new Adapter (usuarioLogin, data, cidade, valor);
    		a1.CidadeRegiaoAdapterNorte(r1);
    		System.out.println("Venda cadastrada no Banco de Dados após passar pelo adapter, transformando em regiao a cidade.");

    		//Confere a Venda criada no Registro (BD):
    		System.out.println();
    		r1.getRegistrosVendas(r1);
    		System.out.println();
    		
    		//Confere o meu total de Vendas:
    		System.out.println("Faz o get das vendas:");
    		path = "/getVendas/" + usuarioLogin + "/" + r1.getValorUltimaVenda(r1);
    		retornoJson = ServicoDeAPI.chamaAPIGet(path);
            System.out.println(retornoJson);
        }
        
        //Fecha o scanner
        sc.close();
	}

	public static void rodarSemExposicao() throws Exception {
		//Cria o scanner para fazer o input
		Scanner sc = new Scanner (System.in);
		
		//Input do login:
		System.out.println("Digite o seu usuário para fazer login:");
		String usuarioLogin = sc.nextLine();
		
		//Input da senha:
		System.out.println("Digite a senha do seu usuário para fazer login:");
		String senhaLogin = sc.nextLine();

		//Chamada da API:
		String path = "/loginSeguro/" + usuarioLogin + "/" + senhaLogin;
		String retornoJson = ServicoDeAPI.chamaAPIGet(path);
        System.out.println(retornoJson);

        if (!retornoJson.equals("{\"usuario\" : \"Jose\", \"senha\": \"123456\", \"auth\": \"Acesso autorizado\"}")) {
            System.out.println("Acesso nao autorizado, encerrando aplicacao");
        }
        else {
            //Faz o cadastro da venda:
    		System.out.println("");
    		System.out.println("");

    		System.out.println("Cadastre uma venda:");
    		System.out.println("Digite a data que a venda foi realizada:");
            String data = sc.nextLine();
            
    		System.out.println("Digite cidade do cliente que fez a compra:");
            String cidade = sc.nextLine();
            
    		System.out.println("Digite o valor da venda:");
            int valor = sc.nextInt();
    		
    		//Criar uma lista de registro das vendas:
    		Registros r1 = new Registros();
    	
    		//Criar uma Venda:
    		Vendas venda1 = new Vendas (usuarioLogin, data, cidade, valor);

    		//Adaptador agindo, transformando a Venda com parâmetro de cidade para parâmetro de Região
    		//O adaptador já faz cria o registro da lista de registro de vendas
    		Adapter a1 = new Adapter (usuarioLogin, data, cidade, valor);
    		a1.CidadeRegiaoAdapterNorte(r1);
    		System.out.println("Venda cadastrada no Banco de Dados após passar pelo adapter, transformando em regiao a cidade.");

    		//Confere a Venda criada no Registro (BD):
    		System.out.println();
    		r1.getRegistrosVendas(r1);
    		System.out.println();
    		
    		//Confere o meu total de Vendas:
    		System.out.println("Faz o get das vendas:");
    		path = "/getVendasSeguro/" + usuarioLogin + "/" + r1.getValorUltimaVenda(r1);
    		retornoJson = ServicoDeAPI.chamaAPIGet(path);
            System.out.println(retornoJson);
            
    		System.out.println("");
    		System.out.println("Deseja saber as vendas do grupo? 1 para Sim ou qualquer outro valor para Nao");
    		
    		int VisualizarVendasDoGrupo = sc.nextInt();
    		
    		if (VisualizarVendasDoGrupo == 1) {
        		path = "/getVendasDoGrupoSeguro/" + usuarioLogin + "/" + r1.getValorUltimaVenda(r1);
        		retornoJson = ServicoDeAPI.chamaAPIGet(path);
                System.out.println(retornoJson);
    		} else {
    			System.out.println("Escolhido nao visualizar as vendas do grupo");
    		}
        }
        
        //Fecha o scanner
        sc.close();
	}

}