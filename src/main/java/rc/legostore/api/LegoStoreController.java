package rc.legostore.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rc.legostore.model.LegoSet;
import rc.legostore.persistence.LegoSetRepository;

@RestController

@RequestMapping("legostore/api")
public class LegoStoreController {
	@Autowired
	private MongoTemplate mongoTemplete;
	@Autowired
	private LegoSetRepository legoSetRepository;
	
	@PostMapping
    public void insert(@RequestBody LegoSet legoSet){
        this.legoSetRepository.insert(legoSet);
    }

    @PutMapping
    public void update(@RequestBody LegoSet legoSet){
        this.legoSetRepository.save(legoSet);
    }

   @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        this.legoSetRepository.deleteById(id);
    }

    @GetMapping("/all")
    public Collection<LegoSet> all(){
       Sort sortByThemeAsc = Sort.by("theme").ascending();
//    	System.out.println("this.legoSetRepository");
//    	System.out.println(this.legoSetRepository);
        Collection<LegoSet> legosets = this.legoSetRepository.findAll(sortByThemeAsc);
        
        return legosets; 
    }

    @GetMapping("/{id}")
    public LegoSet byId(@PathVariable String id){
        LegoSet legoSet = this.legoSetRepository.findById(id).orElse(null);
        return legoSet;
    }
    @GetMapping("/byTheme/{theme}")
    public Collection<LegoSet> byTheme(@PathVariable String theme){
    	Sort sortByThemeAsc = Sort.by("theme").ascending();
//        Sort sortByThemeAsc = Sort.by("theme").ascending();
        return this.legoSetRepository.findAllByThemeContains(theme, sortByThemeAsc);
    }
    @GetMapping("byDeliveryFeeLessThan/{price}")
    public Collection<LegoSet> byDeliveryFeeLessThan(@PathVariable int price){
        return this.legoSetRepository.findAllByDeliveryPriceLessThan(price);
    }
    @GetMapping("greatReviews")
    public Collection<LegoSet> byGreatReviews(){
        return this.legoSetRepository.findAllByGreatReviews();
    }
	

}
