package com.gokibe.facejs.real;

import org.apache.shiro.authc.UsernamePasswordToken;

public class AdminToken extends UsernamePasswordToken
{
    /**
     * Constructs a new UsernamePasswordToken encapsulating the username and password submitted
     * during an authentication attempt, with a <tt>null</tt> {@link #getHost() host} and
     * a <tt>rememberMe</tt> default of <tt>false</tt>
     * <p/>
     * <p>This is a convenience constructor and maintains the password internally via a character
     * array, i.e. <tt>password.toCharArray();</tt>.  Note that storing a password as a String
     * in your code could have possible security implications as noted in the class JavaDoc.</p>
     *
     * @param adminAccount the username submitted for authentication
     * @param adminPassword the password string submitted for authentication
     */
    public AdminToken(String adminAccount, String adminPassword)
    {
        super(adminAccount, adminPassword);
    }
}
