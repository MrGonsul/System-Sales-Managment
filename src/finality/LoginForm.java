package finality;
import java.util.List;






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

/*
 Name : Abdalmohimn Khaled AlGonsul
 ID : 231085
 */




public class LoginForm extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	SessionFactory sf;
	Session ss;
	Transaction tr;
	private Label loginLabel;
	private Label label1;
	private Combo comboUsername;
	private Button buttonMGuest;
	private Button buttonNew;
	private Button buttonConfirm;
	private Text textPassword;
	private Label label2;
	private Label labelName;

	
	public static void main(String[] args) {
		showGUI();
	}
		
	
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setText("تسجيل دخول");
		LoginForm inst = new LoginForm(shell, SWT.NULL);
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

	public LoginForm(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
		
	@SuppressWarnings({ "unchecked" })
	private void getUser() {
		openSession () ;
		comboUsername.removeAll();
		List<User> list =ss.createQuery("From User").list();
		if(list.size()>0) {
			int i=0;
			while(i<list.size()) {
				User u=list.get(i);
				comboUsername.add(u.getName());
				comboUsername.setData (String.valueOf(i),u); // SetData -> Return [ Index As Each One Row + Store List Data In DB  ]
				i++;

			}}
		}
		
	// Methods Here ->
	
	@SuppressWarnings("deprecation")
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

	private void initGUI() {
		try {
			this.setLayout(new FormLayout());
			this.setSize(597, 326);
			{
				buttonConfirm = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData buttonConfirmLData = new FormData();
				buttonConfirmLData.width = 88;
				buttonConfirmLData.height = 35;
				buttonConfirmLData.left =  new FormAttachment(0, 1000, 218);
				buttonConfirmLData.top =  new FormAttachment(0, 1000, 268);
				buttonConfirm.setLayoutData(buttonConfirmLData);
				buttonConfirm.setEnabled(false);
				buttonConfirm.setText("\u0645\u0648\u0627\u0641\u0642");
				buttonConfirm.addSelectionListener(new SelectionAdapter() {
					@SuppressWarnings("unchecked")
					public void widgetSelected(SelectionEvent evt) {
					
						
						if(!comboUsername.getText().isEmpty() || !textPassword.getText().isEmpty()){
							openSession();
							
							int id = Integer.valueOf(textPassword.getText());

							// From User --> Not From User Were Password 
							List<User> list =
								ss.createQuery("from User where Password='" + id + "'").list();

							if(!list.isEmpty()){
								
							MainForm.Namer =comboUsername.getText();
							getShell().dispose();
							MainForm.showGUI();
							
							
						}
							else{
								MessageBox mbox = new MessageBox (getShell(),SWT.ICON_ERROR);
								mbox.setMessage("يرجي التاكد من ان بياناتك مسجلة");
								mbox.setText("حدث خطا");
								mbox.open();
							}
							
						}
						else{
							MessageBox mbox = new MessageBox (getShell(),SWT.ICON_WARNING);
							mbox.setMessage("يرجي تعبئة البيانات");
							mbox.setText("خطا");
						}
						
						
						ss.close();
						
					}

					
				});
			}
			{
				FormData comboUsernameLData = new FormData();
				comboUsernameLData.width = 157;
				comboUsernameLData.height = 28;
				comboUsernameLData.left =  new FormAttachment(0, 1000, 162);
				comboUsernameLData.top =  new FormAttachment(0, 1000, 110);
				comboUsername = new Combo(this, SWT.READ_ONLY);
				comboUsername.setLayoutData(comboUsernameLData);
				comboUsername.setVisibleItemCount(2);
				comboUsername.setTextLimit(30);
				getUser();
				comboUsername.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
				comboUsername.setBackground(SWTResourceManager.getColor(128, 255, 128));
			
				comboUsername.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						

						
					
					}
				});
				comboUsername.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						if(key==SWT.CR )
							textPassword.setFocus();
						
						
						
						
					}
				});
			}
			{
				FormData textPasswordLData = new FormData();
				textPasswordLData.width = 183;
				textPasswordLData.height = 23;
				textPasswordLData.left =  new FormAttachment(0, 1000, 165);
				textPasswordLData.top =  new FormAttachment(0, 1000, 184);
				textPassword = new Text(this, SWT.PASSWORD);
				textPassword.setLayoutData(textPasswordLData);
				
				textPassword.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
				textPassword.setBackground(SWTResourceManager.getColor(128, 255, 128));
				textPassword.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						if(Character.isDigit(key) || key==SWT.CR || key==SWT.BS)
							evt.doit = true;
						else
							evt.doit = false;
						
						
						if(key == SWT.CR){
							
						}
							
						
						
					}
				});
				textPassword.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent evt) {
						
						if (textPassword.getText().length() > 3)
							buttonConfirm.setEnabled(true);
						
					}
				});
			}
			{
				labelName = new Label(this, SWT.NONE);
				FormData labelNameLData = new FormData();
				labelNameLData.width = 120;
				labelNameLData.height = 28;
				labelNameLData.left =  new FormAttachment(0, 1000, 343);
				labelNameLData.top =  new FormAttachment(0, 1000, 112);
				labelName.setLayoutData(labelNameLData);
				labelName.setText(": \u0627\u0633\u0645 \u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645");
				labelName.setFont(SWTResourceManager.getFont("Segoe UI", 12, 0, false, false));
				labelName.setAlignment(SWT.CENTER);
			}
			{
				loginLabel = new Label(this, SWT.NONE);
				FormData loginLabelLData = new FormData();
				loginLabelLData.width = 585;
				loginLabelLData.height = 23;
				loginLabelLData.left =  new FormAttachment(0, 1000, 6);
				loginLabelLData.top =  new FormAttachment(0, 1000, 12);
				loginLabel.setLayoutData(loginLabelLData);
				loginLabel.setText("Sales Managment System");
				loginLabel.setAlignment(SWT.CENTER);
				loginLabel.setBackground(SWTResourceManager.getColor(128, 255, 128));
				loginLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, 1, false, false));
			}
			{
				label1 = new Label(this, SWT.NONE);
				label1.setText("Login");
				FormData label1LData = new FormData();
				label1LData.width = 585;
				label1LData.height = 23;
				label1LData.left =  new FormAttachment(0, 1000, 6);
				label1LData.top =  new FormAttachment(0, 1000, 35);
				label1.setLayoutData(label1LData);
				label1.setAlignment(SWT.CENTER);
				label1.setBackground(SWTResourceManager.getColor(128, 255, 128));
				label1.setFont(SWTResourceManager.getFont("Segoe UI", 11, 1, false, false));
			}
			{
				label2 = new Label(this, SWT.NONE);
				label2.setText(": \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631");
				FormData label2LData = new FormData();
				label2LData.width = 107;
				label2LData.height = 28;
				label2LData.left =  new FormAttachment(0, 1000, 356);
				label2LData.top =  new FormAttachment(0, 1000, 182);
				label2.setLayoutData(label2LData);
				label2.setAlignment(SWT.CENTER);
				label2.setFont(SWTResourceManager.getFont("Segoe UI", 12, 0, false, false));
			}
			{
				buttonNew = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.width = 88;
				button1LData.height = 35;
				button1LData.left =  new FormAttachment(0, 1000, 318);
				button1LData.top =  new FormAttachment(0, 1000, 269);
				buttonNew.setLayoutData(button1LData);
				buttonNew.setText("\u062c\u062f\u064a\u062f");
				buttonNew.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						
						textPassword.setText("");
						comboUsername.setText("");
						buttonConfirm.setEnabled(false);
					}
				});
			}
			{
				buttonMGuest = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData1 = new FormData();
				button1LData1.width = 95;
				button1LData1.height = 22;
				button1LData1.left =  new FormAttachment(0, 1000, 261);
				button1LData1.top =  new FormAttachment(0, 1000, 216);
				buttonMGuest.setLayoutData(button1LData1);
				buttonMGuest.setText("\u062f\u062e\u0648\u0644 \u0627\u0644\u064a \u0639\u0636\u0648");
				buttonMGuest.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						MainForm.Namer = "Guest";
						getShell().dispose();
						MainForm.showGUI();

					}
				});
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
