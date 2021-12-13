package com.miu.waaproject.controller.shoppingCartController;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Product;
import com.miu.waaproject.domain.ProductOrder;
import com.miu.waaproject.domain.ShoppingCart;
import com.miu.waaproject.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shoppingCart/")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;
    @PostMapping("addToCart")
    public ResponseEntity<ShoppingCart> addToCart(@RequestBody ShoppingCart shoppingCart, Buyer buyer, ProductOrder productOrder){
        ShoppingCart currentShoppingCart = shoppingCartService.addToCart(shoppingCart,buyer,productOrder);

       return currentShoppingCart!=null? new ResponseEntity<>(currentShoppingCart, HttpStatus.OK):
               new ResponseEntity<>(null, HttpStatus.NOT_FOUND) ;
    }
    @DeleteMapping("removeProduct")
    public ResponseEntity<ShoppingCart> removeFromCart(@RequestBody ShoppingCart shoppingCart, Product product){
        ShoppingCart currentShoppingCart = shoppingCartService.removeProduct(shoppingCart,product);

        return currentShoppingCart!=null? new ResponseEntity<>(currentShoppingCart, HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND) ;
    }

    @DeleteMapping("getProductOrder")
    public ResponseEntity<ProductOrder> getProductOrder(@RequestBody Buyer buyer){
        ProductOrder productOrder = shoppingCartService.getProductOrders(buyer);

        return productOrder!=null? new ResponseEntity<>(productOrder, HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND) ;
    }

}
