import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;


class ProductTest {

    Mockito mockito= new Mockito();
    ParisTradedProductsActual parisTradedProductsActual;
    Product product;
    ProductPricingService productPricingService;

    @BeforeEach
    void init(){

        ParisTradedProductsActual parisTradedProductsActual = new ParisTradedProductsActual();

        Product product =  mockito.mock(Product.class);
        mockito.when(product.getID()).thenReturn("775");

        ProductPricingService productPricingService =  mockito.mock(ProductPricingService.class);

        mockito.when(productPricingService.price(anyString(),anyString())).thenReturn(102.5);

        mockito.when(productPricingService.price(anyString(),anyString(),anyInt(),anyInt())).thenReturn(77.5);

    }

    @Test
    void ifProductCanBeAddedWhenItAlreadyExistsInProductRegister() throws ProductAlreadyRegisteredException {
        ParisTradedProductsActual parisTradedProductsActual = new ParisTradedProductsActual();
       Assertions.assertThrows(ProductAlreadyRegisteredException.class,()->parisTradedProductsActual.addNewProduct(product),"You See this Exception because       this product is a duplicate");
      }

      @Test
      void ifAProductCanBeTraded() throws ProductAlreadyRegisteredException{
        ParisTradedProductsActual parisTradedProductsActual = new ParisTradedProductsActual();
        parisTradedProductsActual.addNewProduct(product);
        parisTradedProductsActual.trade(product,200);
    }

    @Test
     void ifTradeQuantityIsValid(){

    }

    @Test
    void ifTotalValueOfDaysTradedProductsIsCorrect(){

    }

}