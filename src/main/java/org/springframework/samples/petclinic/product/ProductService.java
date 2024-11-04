package org.springframework.samples.petclinic.product;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    ProductRepository pr;

    @Autowired
    public ProductService(ProductRepository pr){
        this.pr=pr;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        // TODO: CHANGE TO SOLVE TEST 4!
        return pr.findAll();
    }

    @Transactional(readOnly=true)
    public Product getProductById(Integer id){
        Optional<Product> p = pr.findById(id);
        return p.isEmpty() ? null : p.get();
    }  

    @Transactional
    public void save(Product p) throws UnfeasibleProductUpdate{
        // TODO: CHANGE TO SOLVE TEST 4!
        Product oldProduct = getProductById(p.getId());
        if(oldProduct!=null){
            if (p.getPrice() > 2*oldProduct.getPrice()){
                throw new UnfeasibleProductUpdate();
            }
        }
        pr.save(p);
    }

    @Transactional(readOnly=true)
    public ProductType getProductType(String name){
        // TODO: CHANGE TO SOLVE TEST 5!
        return pr.findProductTypeByName(name);
    }

    @Transactional(readOnly=true)
    public List<Product> getProductsCheaperThan(Integer value){
        // TODO: CHANGE TO SOLVE TEST 6!
        return pr.findProductsCheaperThan(value);
    }
}
