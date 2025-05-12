package example.store;

import example.account.AccountManager;
import example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StoreImplTest {
    @Test
    public void successBuy(){
        Product product = Mockito.mock(Product.class);
        Customer customer = Mockito.mock(Customer.class);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(),anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        when(product.getQuantity()).thenReturn(4);
        store.buy(product, customer);
        verify(product).setQuantity(3);
    }
    @Test
    public void givenProductOutOfStock_whenBuyProduct_thenTrowException(){
        Product product = Mockito.mock(Product.class);
        Customer customer = Mockito.mock(Customer.class);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        Store store = new StoreImpl(accountManager);
        when(product.getQuantity()).thenReturn(0);
        try {
            store.buy(product, customer);
            Assertions.fail("");
        }catch (Exception ex){
            Assertions.assertEquals("Product out of stock",ex.getMessage());
        }
    }
    @Test
    public void givenCantWithdraw_whenBuyProduct_thenTrowException(){
        Product product = Mockito.mock(Product.class);
        Customer customer = Mockito.mock(Customer.class);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(),anyInt())).thenReturn("insufficient account balance");
        Store store = new StoreImpl(accountManager);
        when(product.getQuantity()).thenReturn(4);
        try {
            store.buy(product, customer);
            Assertions.fail("");
        }catch (Exception ex){
            Assertions.assertEquals("Payment failure: insufficient account balance",ex.getMessage());
        }
    }
}
