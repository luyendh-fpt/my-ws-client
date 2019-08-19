/**
 * MyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package bankservice;

public interface MyService extends java.rmi.Remote {
    public bankservice.Account deposit(java.lang.String arg0, java.lang.String arg1, double arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public bankservice.Account createAccount(bankservice.Account arg0) throws java.rmi.RemoteException;
}
