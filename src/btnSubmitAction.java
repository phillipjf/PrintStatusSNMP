import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class btnSubmitAction implements ActionListener{
	public static final String READ_COMMUNITY = "public";
	public static final int    mSNMPVersion = 0; // 0 represents SNMP version=1
	public static final String BASE_IP = "131.204.116.";
	public static final String OID_BASE_LEVEL = "1.3.6.1.2.1.43.11.1.1.9.";
	public static final String OID_BLACK = "1.1";
	public static final String OID_YELLOW = "1.2";
	public static final String OID_CYAN = "1.3";
	public static final String OID_MAGENTA = "1.4";
	
	static DefaultListModel model;
	static JList list;
	
	public void actionPerformed (ActionEvent e){
        if (!printGUI.model.isEmpty()) {
        	printGUI.model.clear();
        }
        printGUI.model.addElement(printGUI.printerName.getText());
		PrintStatus objSNMP = new PrintStatus();
		objSNMP.snmpGet(BASE_IP+printGUI.ipComp.getText(), READ_COMMUNITY, mSNMPVersion, OID_BASE_LEVEL+OID_BLACK);
		objSNMP.snmpGet(BASE_IP+printGUI.ipComp.getText(), READ_COMMUNITY, mSNMPVersion, OID_BASE_LEVEL+OID_YELLOW);
		objSNMP.snmpGet(BASE_IP+printGUI.ipComp.getText(), READ_COMMUNITY, mSNMPVersion, OID_BASE_LEVEL+OID_CYAN);
		objSNMP.snmpGet(BASE_IP+printGUI.ipComp.getText(), READ_COMMUNITY, mSNMPVersion, OID_BASE_LEVEL+OID_MAGENTA);
	}
}