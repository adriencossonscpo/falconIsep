//package com.falcon.avisep.controllers;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

//import com.falcon.avisep.model.Module;
//import com.falcon.avisep.model.UserAvis;
//import com.falcon.avisep.repository.ModuleRepository;

/**
 * REST controller for managing Module.
 */
//@RestController
//@RequestMapping("/api")
//public class ModuleResource {

//    private final Logger log = LoggerFactory.getLogger(ModuleResource.class);

//    private static final String ENTITY_NAME = "module";
        
//    private final ModuleRepository moduleRepository;

//  public ModuleResource(ModuleRepository moduleRepository) {
//        this.moduleRepository = moduleRepository;
//    }
    
    // Create and display new users
//    @RequestMapping("displayModules")
//	public String consultModule(Model model){
//    	Iterable<UserAvis> userAvis = null;
//		if(moduleRepository.findAll()!=null){
//			module = moduleRepository.findAll();
//			model.addAttribute("modules", module);
//		}else {model.addAttribute("modules", null);}
		
//		return "displayModules";
//	}
    
    // Creating some modules
// 	@RequestMapping(value = "saveModule", method = RequestMethod.POST )
// 	public String saveModule(@RequestParam("name") String name, @RequestParam("description")String description, Model model){
// 		
// 		Module module =new Module(name,description,null,null);
// 		moduleRepository.saveAndFlush(module);
		//new EmailService().enviar(nome, email);
 		
// 		Iterable<Module> module1 = moduleRepository.findAll();
 		
 		
// 		model.addAttribute("module", module1);
 		
// 		return "displayModules";
// 	}

    

//}
