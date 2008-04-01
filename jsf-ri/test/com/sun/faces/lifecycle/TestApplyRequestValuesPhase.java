/*
 * $Id: TestApplyRequestValuesPhase.java,v 1.6 2002/08/08 16:24:56 rkitain Exp $
 */

/*
 * Copyright 2002 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

// TestApplyRequestValuesPhase.java

package com.sun.faces.lifecycle;

import org.apache.cactus.WebRequest;

import org.mozilla.util.Assert;
import org.mozilla.util.ParameterCheck;

import javax.faces.FacesException;
import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.lifecycle.Phase;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;

import com.sun.faces.ServletFacesTestCase;

/**
 *
 *  <B>TestApplyRequestValuesPhase</B> is a class ...
 *
 * <B>Lifetime And Scope</B> <P>
 *
 * @version $Id: TestApplyRequestValuesPhase.java,v 1.6 2002/08/08 16:24:56 rkitain Exp $
 * 
 * @see	Blah
 * @see	Bloo
 *
 */

public class TestApplyRequestValuesPhase extends ServletFacesTestCase
{
//
// Protected Constants
//

public static final String TEST_URI = "/components.jsp";

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

    public TestApplyRequestValuesPhase() {
	super("TestApplyRequestValuesPhase");
    }

    public TestApplyRequestValuesPhase(String name) {
	super(name);
    }

//
// Class methods
//

//
// General Methods
//

public void beginCallback(WebRequest theRequest)
{
    theRequest.setURL("localhost:8080", null, null, TEST_URI, null);
    theRequest.addParameter("/basicForm/userName", "jerry");
}

public void testCallback()
{
    int rc = Phase.GOTO_NEXT;
    UIComponent root = null;
    String value = null;
    Phase 
        reconstituteTree = new ReconstituteRequestTreePhase(null,
            Lifecycle.RECONSTITUTE_REQUEST_TREE_PHASE),
	applyValues = new ApplyRequestValuesPhase(null, 
					Lifecycle.APPLY_REQUEST_VALUES_PHASE);

    // 1. Set the root of the tree ...
    //
    int result = -1;
    try {
        result = reconstituteTree.execute(getFacesContext());
    }
    catch (Throwable e) {
        e.printStackTrace();
        assertTrue(false);
    }
    assertTrue(Phase.GOTO_NEXT == result);
    assertTrue(null != getFacesContext().getRequestTree());

    // 2. Add components to tree
    //
    root = getFacesContext().getRequestTree().getRoot();
    UIForm basicForm = new UIForm();
    basicForm.setComponentId("basicForm");
    UIInput userName = new UIInput();
    userName.setComponentId("userName");
    root.addChild(basicForm);
    basicForm.addChild(userName);

    // 3. Apply values
    //
    rc = applyValues.execute(getFacesContext());
    assertTrue(Phase.GOTO_NEXT == rc);
    
    root = getFacesContext().getRequestTree().getRoot();
    try {
	userName = (UIInput) root.findComponent("/basicForm/userName");
    }
    catch (Throwable e) {
	System.out.println(e.getMessage());
	assertTrue("Can't find userName in tree", false);
    }
    assertTrue(null != userName);
    assertTrue(null != (value = (String) userName.getValue()));
    assertTrue(value.equals("jerry"));
}




} // end of class TestApplyRequestValuesPhase
