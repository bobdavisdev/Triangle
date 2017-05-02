package com.project.triangle;

import com.project.triangle.ux.InputHandler;

/**
 * 
 * @author babureddy
 * entry point of the program execution.
 */
public class Application
{
    public static void main( String[] args )
    {
        InputHandler.getInstance().initializeInputHandler();
    }
}
