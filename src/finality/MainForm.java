package finality;



import com.cloudgarden.resource.SWTResourceManager;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainForm extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private Label label1;
	private Label labelTitle;
	public static Label labelName;
	private Button buttonExit;
	private Button buttonInvoice;
	private Button buttonItems_Sale;
	private Button buttonSignin;
	public static String Namer = "";


	/**
	* Auto-generated main method to display this
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}

	// without void Main
	// We Can Use Add showGUI(String){
// 	  in global name = sass;
//    }

	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setText(Namer+" : اسم المستخدم");
		MainForm inst = new MainForm(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public MainForm(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
		IFGuest();
	}

	// if The User Use His/Her Username have Some Widget Enabled
	private void IFGuest(){
		if(Namer.equals(""))
		{
		Namer = "";
		labelTitle.setText("");

		}
			else
		if (Namer.equals("Guest")){

			buttonInvoice.setEnabled(false);
			buttonItems_Sale.setEnabled(false);

			return;
		}
		else{


			buttonInvoice.setEnabled(true);
			buttonItems_Sale.setEnabled(true);
			return;
		}


	}
	private void initGUI() {
		try {
			this.setLayout(new FormLayout());
			this.setSize(670, 238);
			{
				labelTitle = new Label(this, SWT.NONE);
				FormData labelTitleLData = new FormData();
				labelTitleLData.width = 82;
				labelTitleLData.height = 25;
				labelTitleLData.left =  new FormAttachment(0, 1000, 338);
				labelTitleLData.top =  new FormAttachment(0, 1000, 47);
				labelTitle.setLayoutData(labelTitleLData);
				labelTitle.setText("مرحبا بك يا "+Namer);
				labelTitle.setAlignment(SWT.CENTER);
				labelTitle.setFont(SWTResourceManager.getFont("Segoe UI", 11, 1, false, false));
			}
			{
				buttonSignin = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData buttonSigninLData = new FormData();
				buttonSigninLData.width = 101;
				buttonSigninLData.height = 32;
				buttonSigninLData.left =  new FormAttachment(0, 1000, 482);
				buttonSigninLData.top =  new FormAttachment(0, 1000, 153);
				buttonSignin.setLayoutData(buttonSigninLData);
				buttonSignin.setText("\u0634\u0627\u0634\u0629 \u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645");
				buttonSignin.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						UserForm.name = Namer;
						getShell().dispose();
						UserForm.showGUI();


					}
				});
			}
			{
				label1 = new Label(this, SWT.NONE);
				label1.setText("\u0634\u0627\u0634\u0629 \u0627\u0644\u0631\u0626\u064a\u0633\u064a\u0629 \u0644\u0645\u0646\u0638\u0648\u0645\u0629 \u0627\u0644\u0645\u0628\u064a\u0639\u0627\u062a");
				FormData label1LData = new FormData();
				label1LData.width = 670;
				label1LData.height = 35;
				label1LData.left =  new FormAttachment(0, 1000, 0);
				label1LData.top =  new FormAttachment(0, 1000, 0);
				label1.setLayoutData(label1LData);
				label1.setAlignment(SWT.CENTER);
				label1.setBackground(SWTResourceManager.getColor(128,255,128));
				label1.setFont(SWTResourceManager.getFont("Segoe UI", 14, 1, false, false));
			}
			{
				buttonItems_Sale = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.width = 101;
				button1LData.height = 32;
				button1LData.left =  new FormAttachment(0, 1000, 482);
				button1LData.top =  new FormAttachment(0, 1000, 88);
				buttonItems_Sale.setLayoutData(button1LData);
				buttonItems_Sale.setText("\u0634\u0627\u0634\u0629 \u0627\u0644\u0627\u0635\u0646\u0627\u0641");
				buttonItems_Sale.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						Items_SaleForm.name = Namer;

						getShell().dispose();
						Items_SaleForm.showGUI();



					}
				});
			}
			{
				buttonInvoice = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button2LData = new FormData();
				button2LData.width = 101;
				button2LData.height = 32;
				button2LData.left =  new FormAttachment(0, 1000, 97);
				button2LData.top =  new FormAttachment(0, 1000, 88);
				buttonInvoice.setLayoutData(button2LData);
				buttonInvoice.setText("\u0634\u0627\u0634\u0629 \u0627\u0644\u0641\u0627\u062a\u0648\u0631\u0629");
				buttonInvoice.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {

						InvoiceForm.name=Namer;
						getShell().dispose();

						InvoiceForm.showGUI();

					}
				});
			}
			{
				buttonExit = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button3LData = new FormData();
				button3LData.width = 101;
				button3LData.height = 32;
				button3LData.left =  new FormAttachment(0, 1000, 97);
				button3LData.top =  new FormAttachment(0, 1000, 153);
				buttonExit.setLayoutData(button3LData);
				buttonExit.setText("\u0627\u0644\u062e\u0631\u0648\u062c");
				buttonExit.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {

						MessageBox mbox = new MessageBox (getShell(),SWT.ICON_INFORMATION | SWT.YES | SWT.NO);
						mbox.setMessage("هل انت متاكد من الخروج");
						mbox.setText("تأكيد");
						int result=mbox.open();
						if(result == SWT.YES){
							getShell().dispose();
							LoginForm.showGUI();
						}
						else
							return;



					}
				});
			}
			{
				labelName = new Label(this, SWT.NONE);
				labelName.setText(Namer);
				FormData label2LData = new FormData();
				label2LData.width = 102;
				label2LData.height = 25;
				label2LData.left =  new FormAttachment(0, 1000, 224);
				label2LData.top =  new FormAttachment(0, 1000, 47);
				labelName.setLayoutData(label2LData);
				labelName.setAlignment(SWT.RIGHT);
				labelName.setFont(SWTResourceManager.getFont("Segoe UI", 11, 1, false, false));
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
