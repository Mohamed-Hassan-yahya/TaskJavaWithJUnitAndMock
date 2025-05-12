package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class AccountManagerImplTest {
    AccountManager accountManager = new AccountManagerImpl();
    @Test
    public void givenCustomerWithEnoughBalance_whenWithdraw_thenSucceed(){
//        Customer customer = new Customer();
//        customer.setBalance(100);
//        String Result = accountManager.withdraw(customer,50);
//        Assertions.assertEquals("success", Result);
//        Assertions.assertEquals(50,customer.getBalance());
        Customer customer=Mockito.mock(Customer.class);
        when(customer.getBalance()).thenReturn(100);
        String Result = accountManager.withdraw(customer,50);
        Assertions.assertEquals("success", Result);
        verify(customer).setBalance(50);

    }
    @Test
    public void givenCustomerWithoutEnoughBalanceAndNotCreditAllowed_whenWithdraw_thenFailed(){
//        Customer customer = new Customer();
//        customer.setBalance(100);
//        customer.setCreditAllowed(false);
//        String Result = accountManager.withdraw(customer,150);
//        Assertions.assertEquals("insufficient account balance", Result);
            Customer customer=Mockito.mock(Customer.class);
            when(customer.getBalance()).thenReturn(100);
            when(customer.isCreditAllowed()).thenReturn(false);
            String Result = accountManager.withdraw(customer,150);
            Assertions.assertEquals("insufficient account balance", Result);
    }
    @Test
    public void givenCustomerWithoutEnoughBalanceAndCreditAllowedButMaximimCreditExceededAndCustomerNotVip_whenWithdraw_thenFailed(){
//        Customer customer = new Customer();
//        customer.setBalance(100);
//        customer.setCreditAllowed(true);
//        customer.setVip(false);
//        String Result = accountManager.withdraw(customer,2000);
//        Assertions.assertEquals("maximum credit exceeded", Result);
        Customer customer=Mockito.mock(Customer.class);
        when(customer.getBalance()).thenReturn(100);
        when(customer.isCreditAllowed()).thenReturn(true);
        when(customer.isVip()).thenReturn(false);
        String Result = accountManager.withdraw(customer,2000);
        Assertions.assertEquals("maximum credit exceeded", Result);
    }
    @Test
    public void givenCustomerWithoutEnoughBalanceAndCreditAllowedButMaximimCreditExceededAndCustomerVip_whenWithdraw_thenFailed(){
//        Customer customer = new Customer();
//        customer.setBalance(100);
//        customer.setCreditAllowed(true);
//        customer.setVip(true);
//        String Result = accountManager.withdraw(customer,2000);
//        Assertions.assertEquals("success", Result);
//        Assertions.assertEquals(-1900,customer.getBalance());
        Customer customer=Mockito.mock(Customer.class);
        when(customer.getBalance()).thenReturn(100);
        when(customer.isCreditAllowed()).thenReturn(true);
        when(customer.isVip()).thenReturn(true);
        String Result = accountManager.withdraw(customer,2000);
        Assertions.assertEquals("success", Result);
        verify(customer).setBalance(-1900);
    }
    @Test
    public void givenCustomerWithoutEnoughBalanceAndCreditAllowedAndMaximimCreditNotExceededAndCustomerNotVip_whenWithdraw_thenFailed(){
//        Customer customer = new Customer();
//        customer.setBalance(100);
//        customer.setCreditAllowed(true);
//        customer.setVip(false);
//        String Result = accountManager.withdraw(customer,150);
//        Assertions.assertEquals("success", Result);
//        Assertions.assertEquals(-50,customer.getBalance());
        Customer customer=Mockito.mock(Customer.class);
        when(customer.getBalance()).thenReturn(100);
        when(customer.isCreditAllowed()).thenReturn(true);
        when(customer.isVip()).thenReturn(false);
        String Result = accountManager.withdraw(customer,150);
        Assertions.assertEquals("success", Result);
        verify(customer).setBalance(-50);
    }
    @Test
    public void givenCustomerWithoutEnoughBalanceAndCreditAllowedAndMaximimCreditNotExceededAndCustomerVip_whenWithdraw_thenFailed(){
//        Customer customer = new Customer();
//        customer.setBalance(100);
//        customer.setCreditAllowed(true);
//        customer.setVip(true);
//        String Result = accountManager.withdraw(customer,150);
//        Assertions.assertEquals("success", Result);
//        Assertions.assertEquals(-50,customer.getBalance());
        Customer customer=Mockito.mock(Customer.class);
        when(customer.getBalance()).thenReturn(100);
        when(customer.isCreditAllowed()).thenReturn(true);
        when(customer.isVip()).thenReturn(true);
        String Result = accountManager.withdraw(customer,150);
        Assertions.assertEquals("success", Result);
        verify(customer).setBalance(-50);
    }
    @Test
    public void SeccessDeposit(){
//        Customer customer = new Customer();
//        customer.setBalance(100);
//        accountManager.deposit(customer, 100);
//        Assertions.assertEquals(200,customer.getBalance());
        Customer customer=Mockito.mock(Customer.class);
        when(customer.getBalance()).thenReturn(100);
        accountManager.deposit(customer, 100);
        verify(customer).setBalance(200);
    }
}
