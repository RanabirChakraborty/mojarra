/*
 * $Id: SelectBoolean_CheckboxTag.java,v 1.48 2003/10/06 19:06:48 horwat Exp $
 */

/*
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.faces.taglib.html_basic;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectBoolean;

import com.sun.faces.taglib.BaseComponentTag;

/**
 * This class is the tag handler that evaluates the 
 * <code>select_boolean</code> custom tag.
 */

public class SelectBoolean_CheckboxTag extends BaseComponentTag
{
    //
    // Protected Constants
    //

    //
    // Class Variables
    //

    //
    // Instance Variables
    //

    // Attribute Instance Variables
    
    // Relationship Instance Variables

    //
    // Constructors and Initializers    
    //

    public SelectBoolean_CheckboxTag()
    {
        super();
    }

    //
    // Class methods
    //

    // 
    // Accessors
    //


    //
    // General Methods
    //

    public String getRendererType() { 
        return "Checkbox"; 
    }
    public String getComponentType() { 
        return "SelectBooleanCheckbox"; 
    }

    protected void overrideProperties(UIComponent component) {
	super.overrideProperties(component);
	UISelectBoolean checkbox = (UISelectBoolean) component;
	
        if (null != checked) {
            checkbox.setSelected(true);
        } 
       
        if (null != size) {
	    checkbox.getAttributes().put("size", size);
	}
        if (null != readonly) {
	    checkbox.getAttributes().put("readonly", readonly);
	}
        if (null != alt) {
	    checkbox.getAttributes().put("alt", alt);
	}
        if (null != onselect) {
	    checkbox.getAttributes().put("onselect", onselect);
	}
        if (null != onchange) {
	    checkbox.getAttributes().put("onchange", onchange);
	}
    }
    
    //
    // Methods from TagSupport
    // 


} // end of class SelectBoolean_CheckboxTag
