package myclient.main;

import bankservice.Account;
import bankservice.MyService;
import bankservice.MyServiceServiceLocator;

public class MainThread {
    public static void main(String[] argv) {
        try {
            MyServiceServiceLocator locator = new MyServiceServiceLocator();
            MyService service = locator.getMyServicePort();
            Account account = new Account();
            account.setUsername("xuanhung");
            account.setPassword("123");
            account.setBalance(2000);
            Account result = service.createAccount(account);
            if (result == null) {
                System.out.println("Can't create account.");
            } else {
                System.out.printf("Created account success with id %d", result.getId());
            }
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
