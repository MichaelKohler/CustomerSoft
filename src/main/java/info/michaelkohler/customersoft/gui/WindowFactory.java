package info.michaelkohler.customersoft.gui;

import info.michaelkohler.customersoft.gui.AbstractOverviewWindow.ButtonLayout;

/*
 * CustomerSoft
 * Copyright (C) 2012  Michael Kohler <michaelkohler@linux.com>

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * The factory which delivers us the different windows. This can be used for
 * every window of this application. An instance of it should be injected in
 * every class which uses windows. This is a singleton object and therefore
 * instantiated ones and then gives already the same object back.   
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */
public class WindowFactory {

    private static WindowFactory _instance = null;

    /**
     * Empty constructor since we will call the methods. This is private because
     * it shouldn't be instantiated since it is a singleton object.
     */
    private WindowFactory() {
    }
    
    /**
     * returns the instance of the WindowFactory
     * 
     * @return _instance which is a singleton object
     */
    public static WindowFactory getInstance() {
        if (_instance == null)
            _instance = new WindowFactory();
        return _instance;
    }
    
    /**
     * returns a new Shortcut window
     * 
     * @param aWindowFactory which needs to be injected to the shortcut window
     * @return new shortcut window
     */
   public ShortcutWindow createNewShortcutWindow(WindowFactory aWindowFactory) {
       return new ShortcutWindow(aWindowFactory);
   }
   
   /**
    * returns a new CustomerOverview window
    * 
    * @param aWindowFactory which needs to be injected to the shortcut window
    * @return new shortcut window
    */
  public CustomerOverviewWindow createNewCustomerOverviewWindow(WindowFactory aWindowFactory) {
      return new CustomerOverviewWindow(450, 300, ButtonLayout.CANCEL_BUTTON);
  }
}
