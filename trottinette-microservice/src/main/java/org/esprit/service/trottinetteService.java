package org.esprit.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.esprit.entities.Trottinette;
import org.esprit.repositories.trottinetteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;


@Service
public class trottinetteService {

	@Autowired
	private trottinetteRepo tr;
	public Trottinette  saveTro(MultipartFile file,String name,String description
			,int price)
	{
		Trottinette t = new Trottinette();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a  valid file");
		}
		try {
			t.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		t.setDescription(description);
        t.setName(name);
        t.setPrice(price);
     
        tr.save(t);
        return t;
	}
	
	public List<Trottinette> getAllTrottinette()
	{
		return tr.findAll();
	}
    public void deleteTrottinetteById(Long id)
    {
    	tr.deleteById(id);
    }
    
    
}
