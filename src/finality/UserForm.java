package finality;

/*
Name : Abdalmohimn Khaled AlGonsul
ID : 231085
*/


import com.cloudgarden.resource.SWTResourceManager;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
@SuppressWarnings("unused")
public class UserForm extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	
	private Label label1;
	private Button buttonSave;
	private Text textName;
	private Button buttonReturn;
	private Label label3;
	private Text textPasswordCon;
	private Label label2;
	private Text textPassword1;
	private Label labelName;
	private SessionFactory sf;
	private Session ss;
	private Transaction tr;
	public static String name;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setText(name+" / منظومة المبيعات - اسم المستخدم");
		UserForm inst = new UserForm(shell, SWT.NULL);
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

	public UserForm(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new FormLayout());
			this.setSize(559, 184);
			{
				label1 = new Label(this, SWT.NONE);
				label1.setText("\u0634\u0627\u0634\u0629 \u062a\u0639\u0631\u064a\u0641 \u0648 \u0627\u0636\u0627\u0641\u0629 \u0645\u0633\u062a\u062e\u062f\u0645 ");
				FormData label1LData = new FormData();
				label1LData.width = 559;
				label1LData.height = 36;
				label1LData.left =  new FormAttachment(0, 1000, 0);
				label1LData.top =  new FormAttachment(0, 1000, 0);
				label1.setLayoutData(label1LData);
				label1.setAlignment(SWT.CENTER);
				label1.setBackground(SWTResourceManager.getColor(128,255,128));
				label1.setFont(SWTResourceManager.getFont("Segoe UI", 14, 1, false, false));
			}
			{
				textName = new Text(this, SWT.NONE);
				textName.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
				textName.setTextLimit(30);
				FormData comboUsernameLData = new FormData();
				comboUsernameLData.width = 182;
				comboUsernameLData.height = 28;
				comboUsernameLData.left =  new FormAttachment(0, 1000, 131);
				comboUsernameLData.top =  new FormAttachment(0, 1000, 52);
				textName.setLayoutData(comboUsernameLData);
				textName.setBackground(SWTResourceManager.getColor(128,255,128));
				textName.setTextLimit(22); // Optinal
				textName.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						
						if(Character.isLetter(key) || key == SWT.BS){}
						else
							evt.doit=false;
						
						
						if(key==SWT.CR )
							textPassword1.setFocus();
						
						
						
						
					}
				});
			}
			{
				labelName = new Label(this, SWT.NONE);
				labelName.setText(": \u0627\u0633\u0645 \u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645");
				FormData labelNameLData = new FormData();
				labelNameLData.width = 120;
				labelNameLData.height = 28;
				labelNameLData.left =  new FormAttachment(0, 1000, 320);
				labelNameLData.top =  new FormAttachment(0, 1000, 48);
				labelName.setLayoutData(labelNameLData);
				labelName.setAlignment(SWT.CENTER);
				labelName.setFont(SWTResourceManager.getFont("Segoe UI",12,0,false,false));
			}
			{
				textPassword1 = new Text(this, SWT.NONE);
				FormData textPasswordLData = new FormData();
				textPasswordLData.width = 180;
				textPasswordLData.height = 29;
				textPasswordLData.left =  new FormAttachment(0, 1000, 131);
				textPasswordLData.top =  new FormAttachment(0, 1000, 87);
				textPassword1.setLayoutData(textPasswordLData);
				textPassword1.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
				textPassword1.setTextLimit(22); // Optinal
				textPassword1.setBackground(SWTResourceManager.getColor(128,255,128));
				textPassword1.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						if(Character.isDigit(key) || key==SWT.CR || key==SWT.BS)
							evt.doit = true;
						else
							evt.doit = false;
						
						
						if(key == SWT.CR)
							textPasswordCon.setFocus();
						
					}
				});
				textPassword1.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent evt) {
						
						if (textPassword1.getText().length() > 3 && textName.getText().length()>3){
						
							buttonSave.setEnabled(true);
							
						}
						else{
							buttonSave.setEnabled(false);
							
						}
					}
				});
			}
			{
				label2 = new Label(this, SWT.NONE);
				label2.setText(": \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631");
				FormData label2LData = new FormData();
				label2LData.width = 107;
				label2LData.height = 28;
				label2LData.left =  new FormAttachment(0, 1000, 330);
				label2LData.top =  new FormAttachment(0, 1000, 88);
				label2.setLayoutData(label2LData);
				label2.setAlignment(SWT.CENTER);
				label2.setFont(SWTResourceManager.getFont("Segoe UI",12,0,false,false));
			}
			{
				textPasswordCon = new Text(this, SWT.NONE);
				FormData text1LData = new FormData();
				text1LData.width = 182;
				text1LData.height = 28;
				text1LData.left =  new FormAttachment(0, 1000, 131);
				text1LData.top =  new FormAttachment(0, 1000, 123);
				textPasswordCon.setLayoutData(text1LData);
				textPasswordCon.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
				textPasswordCon.setTextLimit(22); // Optinal

				textPasswordCon.setBackground(SWTResourceManager.getColor(128,255,128));
				textPasswordCon.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						if(Character.isDigit(key) || key==SWT.CR || key==SWT.BS)
							evt.doit = true;
						else
							evt.doit = false;
						
						
						
						
					}
				});
				textPasswordCon.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent evt) {
						
						if (textPassword1.getText().length() > 3)
							buttonSave.setEnabled(true);
						
						
					}
				});
			}
			{
				label3 = new Label(this, SWT.NONE);
				label3.setText(": \u062a\u0623\u0643\u064a\u062f \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631");
				FormData label3LData = new FormData();
				label3LData.width = 151;
				label3LData.height = 28;
				label3LData.left =  new FormAttachment(0, 1000, 321);
				label3LData.top =  new FormAttachment(0, 1000, 123);
				label3.setLayoutData(label3LData);
				label3.setAlignment(SWT.CENTER);
				label3.setFont(SWTResourceManager.getFont("Segoe UI",12,0,false,false));
			}
			{
				buttonReturn = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData buttonConfirmLData = new FormData();
				buttonConfirmLData.width = 88;
				buttonConfirmLData.height = 35;
				buttonConfirmLData.left =  new FormAttachment(0, 1000, 12);
				buttonConfirmLData.top =  new FormAttachment(0, 1000, 142);
				buttonReturn.setLayoutData(buttonConfirmLData);
				buttonReturn.setText("\u0627\u0644\u0634\u0627\u0634\u0629 \u0627\u0644\u0631\u0626\u064a\u0633\u064a\u0629");
				buttonReturn.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						
						
						
						getShell().dispose();
						MainForm.showGUI();
						
						
						
						
					}
				});
			}
			{
				buttonSave = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.width = 88;
				button1LData.height = 35;
				button1LData.left =  new FormAttachment(0, 1000, 12);
				button1LData.top =  new FormAttachment(0, 1000, 95);
				buttonSave.setLayoutData(button1LData);
				buttonSave.setText("\u062d\u0641\u0638");
				buttonSave.setEnabled(false);
				buttonSave.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {

						
						if(textName.getText().isEmpty() || textPassword1.getText().isEmpty() || textPasswordCon.getText().isEmpty()){
							
							MessageBox mbox = new MessageBox (getShell(),SWT.ICON_WARNING);
							mbox.setMessage("يرجي تعبئة البيانات");
							mbox.setText("خطا");
							mbox.open();
							return;
							
							
						}
						else{
							if(Integer.valueOf(textPassword1.getText()).equals(Integer.valueOf(textPasswordCon.getText()))){
							openSession();
							
							
							
							User u = new User();
							u.setName(textName.getText());
							u.setPassword(Integer.valueOf(textPassword1.getText()));
						ss.save(u);
							MessageBox mbox = new MessageBox (getShell(),SWT.ICON_WORKING);
							mbox.setMessage("تمت التعبئة بنجاح");
							mbox.setText("اكتمل");
							mbox.open();
							tr.commit();
							getShell().dispose();
							MainForm.showGUI();
							

							
							}
							else{
								
								MessageBox mbox = new MessageBox (getShell(),SWT.ICON_WARNING);
								mbox.setMessage("تأكد من ادخالك كلمة السر صحيحة");
								mbox.setText("خطا");
								mbox.open();
								return;
							}
						}
						
						ss.close();
					}
				});
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Methods Here ->
	@SuppressWarnings({ "deprecation" })
	private void openSession () {
		sf=new Configuration () .configure ("finality/hibernate.cfg.xml").buildSessionFactory ();
		ss=sf.openSession();
		tr=ss.getTransaction();
		tr.begin();

		// Note That
		// SS => Type Session
		// tr => Type Transaction
		// SF => Type SessionFactory
	}

	
}
