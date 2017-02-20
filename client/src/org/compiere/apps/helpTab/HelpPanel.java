package org.compiere.apps.helpTab;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Properties;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.plaf.AdempierePLAF;
import org.compiere.apps.AEnv;
import org.compiere.apps.AMenu;
import org.compiere.apps.AMenuStartItem;
import org.compiere.apps.AWindow;
import org.compiere.apps.form.FormFrame;
import org.compiere.apps.form.FormPanel;
import org.compiere.apps.wf.WFPanel;
import org.compiere.grid.ed.AutoCompletion;
import org.compiere.model.MQuery;
import org.compiere.model.MRole;
import org.compiere.model.MTable;
import org.compiere.plaf.CompiereColor;
import org.compiere.swing.CButton;
import org.compiere.swing.CComboBox;
import org.compiere.swing.CPanel;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;
import org.compiere.util.Util;
import org.compiere.wf.MWFNode;
import org.compiere.wf.MWFNodeNext;
import org.compiere.wf.MWorkflow;

public class HelpPanel extends CPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1333681802263624547L;
	private StyleContext context = null;
    private StyledDocument document = null;
    private Style style = null;
	private String helpText = "Text";
	
	//UI
    public HelpPanel(){
    	super();
    	context = new StyleContext();
	    document = new DefaultStyledDocument(context);

	    style = context.getStyle(StyleContext.DEFAULT_STYLE);
	    StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontSize(style, 14);
	    StyleConstants.setSpaceAbove(style, 4);
	    StyleConstants.setSpaceBelow(style, 4);
	    try {
	        document.insertString(document.getLength(), helpText, style);
	      } catch (BadLocationException badLocationException) {
	        System.err.println("Oops");
	      }
    }
    
    public StyledDocument getDocument(){
    	return document;
    }
    
    /* Create Frame after Clicked */
    public void loadView(){
    	org.compiere.Adempiere.startupEnvironment(true);
		JFrame jf = new JFrame ("General Help");
		//System.out.println("Masuk load");
		HelpPanel h = new HelpPanel();
		JTextPane textPane = new JTextPane(h.getDocument());
	    textPane.setEditable(false);
	    jf.add(textPane);
	    jf.setSize(500, 600);
		jf.setVisible(true);
    }
    
    public static void main (String[] args)
	{
	}	//	main
}
