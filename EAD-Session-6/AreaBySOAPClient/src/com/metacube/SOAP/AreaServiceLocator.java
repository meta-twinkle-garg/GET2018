/**
 * AreaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.SOAP;

public class AreaServiceLocator extends org.apache.axis.client.Service implements com.metacube.SOAP.AreaService {

    public AreaServiceLocator() {
    }


    public AreaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AreaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Area
    private java.lang.String Area_address = "http://localhost:8081/AreaBySOAP/services/Area";

    public java.lang.String getAreaAddress() {
        return Area_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AreaWSDDServiceName = "Area";

    public java.lang.String getAreaWSDDServiceName() {
        return AreaWSDDServiceName;
    }

    public void setAreaWSDDServiceName(java.lang.String name) {
        AreaWSDDServiceName = name;
    }

    public com.metacube.SOAP.Area getArea() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Area_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getArea(endpoint);
    }

    public com.metacube.SOAP.Area getArea(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.metacube.SOAP.AreaSoapBindingStub _stub = new com.metacube.SOAP.AreaSoapBindingStub(portAddress, this);
            _stub.setPortName(getAreaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAreaEndpointAddress(java.lang.String address) {
        Area_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.metacube.SOAP.Area.class.isAssignableFrom(serviceEndpointInterface)) {
                com.metacube.SOAP.AreaSoapBindingStub _stub = new com.metacube.SOAP.AreaSoapBindingStub(new java.net.URL(Area_address), this);
                _stub.setPortName(getAreaWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Area".equals(inputPortName)) {
            return getArea();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://SOAP.metacube.com", "AreaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://SOAP.metacube.com", "Area"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Area".equals(portName)) {
            setAreaEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
