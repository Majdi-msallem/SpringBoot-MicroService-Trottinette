package org.esprit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.esprit.entities.Trottinette;
import org.esprit.service.trottinetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TrottinetteController {
	
	@Autowired
	private trottinetteService ts;
	@PostMapping("/uploadfile")
	public String UploadImage (@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		//String Path_Directory="C:\\Users\\majdi\\Documents\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\trottinette-microservice\\src\\main\\resources\\static";
		String Path_Directory= new ClassPathResource("static").getFile().getAbsolutePath();
		Files.copy(file.getInputStream(), Paths.get(Path_Directory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		return "Image ajouter avec success";
	}
	@PostMapping("/addtro")
    public Trottinette saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("tname") String name,
    		@RequestParam("tprice") int price,
    		@RequestParam("tesc") String desc)
    {
    	
    	return ts.saveTro(file, name, desc, price);
    }
	@GetMapping("/listtro")
	public  List<Trottinette>  AllTrottinette(Trottinette t)
	{
		return  (List<Trottinette>) (t = (Trottinette) ts.getAllTrottinette());
	}
	
    @GetMapping("/deletetro/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	 ts.deleteTrottinetteById(id);
    	 return "supprimer";
    }

}
