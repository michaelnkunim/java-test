import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class ProductTest {

    Mockito mockito= new Mockito();
    ParisTradedProductsActual parisTradedProductsActual;
    Product product;
    ProductPricingService productPricingService;

    @BeforeEach
    void init(){

        ParisTradedProductsActual parisTradedProductsActual = new ParisTradedProductsActual();

        Product product =  mockito.mock(Product.class);
        when(product.getID()).thenReturn("775");

        ProductPricingService productPricingService =  mockito.mock(ProductPricingService.class);

        when(productPricingService.price(anyString(),anyString())).thenReturn(102.5);

        when(productPricingService.price(anyString(),anyString(),anyInt(),anyInt())).thenReturn(77.5);

    }

    @Test
    void ifProductCanBeAddedWhenItAlreadyExistsInProductRegister() throws ProductAlreadyRegisteredException {
        ParisTradedProductsActual parisTradedProductsActual = new ParisTradedProductsActual();
       Assertions.assertThrows(ProductAlreadyRegisteredException.class,()-> parisTradedProductsActual.addNewProduct(product),
               "You See this Exception because this product is a duplicate");
      }

      @Test
      void ifAProductCanBeTraded() throws ProductAlreadyRegisteredException{
        ParisTradedProductsActual parisTradedProductsActual = new ParisTradedProductsActual();
        parisTradedProductsActual.addNewProduct(product);
        parisTradedProductsActual.trade(product,200);
    }


    @Test
     void ifTradeQuantityIsValid() throws ProductAlreadyRegisteredException {
        ParisTradedProductsActual parisTradedProductsActual = new ParisTradedProductsActual();
        Product product = mockito.mock(Product.class);
        when(product.getID()).thenReturn("775");

        parisTradedProductsActual.addNewProduct(product);

        parisTradedProductsActual.trade(product, 75);
        System.out.println(parisTradedProductsActual.tradesRegister);
        //Albert and Joy - 5,
        assertEquals(75, parisTradedProductsActual.totalTradeQuantityForDay(), "Product traded quantity is not valid");
    }

    @Test
    void ifTotalValueOfDaysTradedProductsIsCorrect() throws ProductAlreadyRegisteredException {
        ParisTradedProductsActual parisTradedProductsActual = new ParisTradedProductsActual();

        //b - price - 2, 5 = 10
        Product future = new Future("444", "nyse", "f12f11", 8, 8, productPricingService);
        parisTradedProductsActual.addNewProduct(future);
        parisTradedProductsActual.trade(future, 5);
        assertEquals(45, parisTradedProductsActual.totalValueOfDaysTradedProducts(), "Total value of days traded products is not valid");
    }

}