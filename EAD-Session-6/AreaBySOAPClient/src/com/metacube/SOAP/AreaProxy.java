package com.metacube.SOAP;

public class AreaProxy implements com.metacube.SOAP.Area {
  private String _endpoint = null;
  private com.metacube.SOAP.Area area = null;
  
  public AreaProxy() {
    _initAreaProxy();
  }
  
  public AreaProxy(String endpoint) {
    _endpoint = endpoint;
    _initAreaProxy();
  }
  
  private void _initAreaProxy() {
    try {
      area = (new com.metacube.SOAP.AreaServiceLocator()).getArea();
      if (area != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)area)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)area)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (area != null)
      ((javax.xml.rpc.Stub)area)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.SOAP.Area getArea() {
    if (area == null)
      _initAreaProxy();
    return area;
  }
  
  public double areaOfTriangle(int a, int b, int c) throws java.rmi.RemoteException{
    if (area == null)
      _initAreaProxy();
    return area.areaOfTriangle(a, b, c);
  }
  
  
}