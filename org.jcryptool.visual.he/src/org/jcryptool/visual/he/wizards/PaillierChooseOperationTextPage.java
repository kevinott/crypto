// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2011 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.visual.he.wizards;

import java.math.BigInteger;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.visual.he.Messages;
import org.jcryptool.visual.he.algo.PaillierData;
import org.jcryptool.visual.library.Lib;

/**
 * Page to enter an operation number for Paillier homomorphic visualization
 * @author Coen Ramaekers
 *
 */
public class PaillierChooseOperationTextPage extends WizardPage{

    /** unique pagename to get this page from inside a wizard. */
    private static final String PAGENAME = "Choose GH operation text Page";

    /** title of this page, displayed in the head of the wizard. */
    private static final String TITLE = Messages.GHChooseOperationTextPage_Title;

    /** holds the entered text */
    private Text text;

    /** holds the data */
    private PaillierData data;

    public PaillierChooseOperationTextPage(PaillierData data) {
    	super(PAGENAME, TITLE, null);
    	this.data = data;
    	this.setDescription(Messages.GHChooseOperationTextPage_Description);
    	this.setPageComplete(false);
    }

    public final void createControl(final Composite parent) {
    	final Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout());
        Label label;
        label = new Label(composite, SWT.NONE);
        label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
        label.setText(Messages.GHChooseOperationTextPage_Textfield + "n " + Messages.GHChooseIntialTextPage_Textfield2);
        text = new Text(composite, SWT.BORDER | SWT.WRAP);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        text.addModifyListener(new ModifyListener() {
            public void modifyText(final ModifyEvent e) {
                setPageComplete(!((Text) e.widget).getText().equals("")); //$NON-NLS-1$
                data.setOperation(new BigInteger(((Text) e.widget).getText()));
            }
        });
        text.addVerifyListener(Lib.getVerifyListener(Lib.DIGIT));

        setControl(composite);
    }

    public static String getPagename() {
        return PAGENAME;
    }

}
