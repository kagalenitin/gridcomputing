package com.olivelabs.gridcomputing.common.rmi;

public abstract class RmiStarter {

    /**
     *
     * @param clazzToAddToServerCodebase a class that should be in the java.rmi.server.codebase property.
     */
    @SuppressWarnings("rawtypes")
	public RmiStarter(Class clazzToAddToServerCodebase) {

        System.setProperty("java.rmi.server.codebase", clazzToAddToServerCodebase
            .getProtectionDomain().getCodeSource().getLocation().toString());

        System.setProperty("java.security.policy", PolicyFileLocator.getLocationOfPolicyFile());

        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        handleRMI();
    }

    /**
     * extend this class and do RMI handling here
     */
    public abstract void handleRMI();

}
