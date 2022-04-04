package br.com.ecommerce.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.ecommerce.service.ProdutoService;

public class SpringJPATeste {
	
	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring.xml");
		
		ProdutoService produtoService = ctx.getBean(ProdutoService.class);
		
		System.out.println(produtoService.findAll());
		
		System.out.println(produtoService.findByName("Impressora HP"));
		
		ctx.close();
	}

}
