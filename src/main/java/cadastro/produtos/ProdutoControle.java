package cadastro.produtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoControle {

	@Autowired
	private ProdutoServico service; 
	
	@RequestMapping("/")
	public String listar(Model model) {
		List<Produto> listProducts = service.listar();
		model.addAttribute("listaProdutos", listProducts);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String novo(Model model) {
		Produto product = new Produto();
		model.addAttribute("produto", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("produto") Produto product) {
		service.salvar(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView prepararEdicao(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Produto product = service.buscarPorId(id);
		mav.addObject("produto", product);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String apagar(@PathVariable(name = "id") int id) {
		service.apagar(id);
		return "redirect:/";		
	}
}
