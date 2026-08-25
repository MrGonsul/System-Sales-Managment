package finality;
import java.util.Calendar;
import java.util.List;
// For Date Data
import java.sql.Date;

import com.cloudgarden.resource.SWTResourceManager;
import com.sun.istack.internal.Nullable;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
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

import sun.security.jca.GetInstance;

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
public class InvoiceForm extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	
	private Label label1;
	private TableColumn tableColumnBuy;
	private TableColumn tableColumnQuantity;
	private TableColumn tableColumnName;
	private TableColumn tableColumnID;
	private TableColumn tableColumnRT;
	private TableColumn tableNull;
	private Label label8;
	private Text textTotal;
	private Button buttonRemove;
	private Button buttonInsert;
	private Label label7;
	private Text textRequirement;
	private Label label6;
	private Label label5;
	private Label textSeller;
	private Label textQuantity;
	private Label label4;
	private Label label3;
	private Combo comboItems;
	private Label textDate;
	private Label label2;
	private Text textName;
	private Label labelName;
	private Table tableVoice;
	private Group groupButton;
	private Button buttonClose;
	private Label label9;
	private Button buttonNew;
	private Button buttonSave;
	private Button buttonReturn;
	private TableColumn tableColumnTotal;
    public 	TableItem currentItem;
	public static String name;
	private InvoiceT inn;
	int index;
	int sn =0;
	double Total=0;
	int x; // For copy GET ID INCREMENT
	int indx; // FOR DELETE ITEM FORM TABLE NOT DATA BASE
	
	
	protected Item temp;
	
	// Data base
	private Transaction tr;
	private SessionFactory sf;
	private Session ss;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	
	// public static void Showgui(String name);
	
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
		InvoiceForm inst = new InvoiceForm(shell, SWT.NULL);
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

	public InvoiceForm(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
		getItems();
		calcDate();
	}
	

	
	// Calc Date
	private void calcDate(){
		

		// Create Calendar For Date / Time
		Calendar cc = Calendar.getInstance();
		int year = cc.get(Calendar.YEAR);
		int month = cc.get(Calendar.MONTH) + 1; // Month Started From 0
		int day = cc.get(Calendar.DAY_OF_MONTH);

		textDate.setText(day + "-" + month + "-" + year);	
		
	}

	// Show Table
	private void ShowTable(){
		
		
		
		
		
		
		
		// if The All Data Item Is Set into textbox then check it !
		
		if(textName.getText().isEmpty()||textQuantity.getText().isEmpty() ||  textSeller.getText().isEmpty() || comboItems.getText().isEmpty() || textRequirement.getText().isEmpty())
		{
			MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_WARNING);
			mbox.setMessage("يرجي تعبئة البيانات بشكل كامل");
			mbox.setText("! تنبيه ");
			mbox.open();
			
			
		}
		else {
			
			
	
	
		
		int idx =Integer.valueOf(comboItems.getSelectionIndex());
		Item Temp1 =(Item) comboItems.getData(String.valueOf(idx));
		
		// باش نهرب من قصة السالب
		if(sn < 0)
		    sn=0;
		
		
		// Now Added The Data Into Table
		
		TableItem it = new TableItem(tableVoice , SWT.NONE);
		
/* R . T */		it.setText(1 , String.valueOf(++sn));
/* ID   */		it.setText(2 , String.valueOf(Temp1.getId()));
/* Name */		it.setText(3 , String.valueOf(Temp1.getName()));
/* Quantity */	it.setText(4 , textRequirement.getText());
/* Buy */		it.setText(5 , String.valueOf(Temp1.getSellprice()));
/* Sell */		it.setText(6 , String.valueOf(Temp1.getSellprice()*Integer.valueOf(textRequirement.getText())));
				Total = Total+Double.valueOf((Temp1.getSellprice()*Integer.valueOf(textRequirement.getText())));

				
				if (Total == 0)
					textTotal.setText("0");
				else
					textTotal.setText(String.valueOf(Total));

				for(int i=0; i<tableVoice.getItemCount(); i++){

				    tableVoice.getItem(i)
				    .setText(1, String.valueOf(i+1));
				}
		// Massion Completed !!!
		MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_WORKING);
		mbox.setMessage("تمت العملية الاضافة بنجاج");
		mbox.setText(" رسالة ");
		mbox.open();
		
		}
		
		
	}
	
	
	// Check Quantity
	private void Qty(){
		
		if(textRequirement.getText().trim().isEmpty())
		    return;
			
			if(temp == null)
				return;
			
			if(Integer.valueOf(textRequirement.getText().trim())>temp.getQuantity()){
				
				MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_ERROR);
				mbox.setMessage(".القيمة المذخلة اكبر من الي في المخزون");
				mbox.setText(" رسالة تنبيه ");
				mbox.open();
				textRequirement.setText("");
				textRequirement.setFocus();
				return;
				
				
			}
		
	}

	// Open Session
	@SuppressWarnings("deprecation")
	private void openSession(){
		
		sf = new Configuration().configure("finality/hibernate.cfg.xml").buildSessionFactory();
		
		ss=sf.openSession();
		
		tr=ss.getTransaction();
		tr.begin();
		
		
	}
	@SuppressWarnings("unchecked")
	private void getItems() {
		openSession () ;
		comboItems.removeAll();
		List<Item> list =ss.createQuery("From Item where deleted = false").list();
		if(list.size()>0) {
			int i=0;
			while(i<list.size()) {
				Item u=list.get(i);
				comboItems.add(u.getName());
				comboItems.setData (String.valueOf(i),u); // SetData -> Return [ Index As Each One Row + Store List Data In DB  ]
				i++;

			}
			
		}
		
		ss.close();
		}
	
	private void initGUI() {
		try {
			this.setLayout(new FormLayout());
			this.setSize(842, 518);
			{
				FormData groupButtonLData = new FormData();
				groupButtonLData.width = 101;
				groupButtonLData.height = 177;
				groupButtonLData.left =  new FormAttachment(0, 1000, 18);
				groupButtonLData.top =  new FormAttachment(0, 1000, 214);
				groupButton = new Group(this, SWT.NONE);
				groupButton.setLayout(null);
				groupButton.setLayoutData(groupButtonLData);
				{
					buttonNew = new Button(groupButton, SWT.PUSH | SWT.CENTER);
					buttonNew.setText("\u062c\u062f\u064a\u062f");
					buttonNew.setBounds(12, 21, 83, 40);
					buttonNew.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							
							MessageBox mbox = new MessageBox(getShell(),SWT.YES | SWT.NO | SWT.ICON_QUESTION);
							mbox.setMessage("هل انت متأكد من حذف جميع بيانات ؟");
							mbox.setText("رسالة تاكيد");
							int result = mbox.open();
							if(result == SWT.YES){
								textName.setText("");
								textQuantity.setText("");
								textSeller.setText("");
								buttonRemove.setEnabled(false);
								textDate.setText("");
								calcDate();
								MessageBox R = new MessageBox(getShell(),SWT.OK | SWT.ICON_WORKING);
								R.setText("تم تاكيد");
								R.setMessage("تمت العملية بنجاح");
								R.open();
								textName.setFocus();

								
							}
							else
								return;
							
							
							
							
							
						}
					});
				}
				{
					buttonSave = new Button(groupButton, SWT.PUSH | SWT.CENTER);
					buttonSave.setText("\u062d\u0641\u0638");
					buttonSave.setEnabled(false);
					buttonSave.setBounds(12, 79, 83, 39);
					buttonSave.addSelectionListener(new SelectionAdapter() {
						@SuppressWarnings("unchecked")
						public void widgetSelected(SelectionEvent evt) {
							
							
								
								
								
							openSession();
							InvoiceT inv = new InvoiceT();
							inv.setCostumer(textName.getText());
							inv.setDate(Date.valueOf(textDate.getText()));
							inv.setTotalPrice(Total);
							ss.save(inv);
							ss.flush();
							x = inv.getId();
							
							Qty();
							
							
							for(int i = 0; i < tableVoice.getItemCount(); i++) {
								
								 int itemId =
									 Integer.valueOf(tableVoice.getItem(i).getText(2));
								 
								    List<ItemInvoice> list = ss.createQuery("from ItemInvoice where id="+ itemId + " and invoiceId="+ inv.getId()).list();
								    
								    if(list.size()==0){
								    	
								        ItemInvoice iv = new ItemInvoice();
								        
								        iv.setInvoiceId(inv.getId());
								        iv.setItemId(itemId);
								        
								        iv.setQty(Integer.valueOf(tableVoice.getItem(i).getText(4)));
								        
								        iv.setPrice(Double.valueOf(tableVoice.getItem(i).getText(6)));
								        
								        ss.save(iv);
								    }
							}
							tr.commit();
							ss.close();
							buttonSave.setEnabled(false);
							MessageBox mbox = new MessageBox(getShell(),SWT.OK | SWT.ICON_WORKING);
							mbox.setMessage("تمت العملية بنجاح");
							mbox.setText("رسالة");
							mbox.open();
							
							
							
							
						}
						
						
						
					});
				}
				{
					buttonClose = new Button(groupButton, SWT.PUSH | SWT.CENTER);
					buttonClose.setText("\u0627\u063a\u0644\u0627\u0642");
					buttonClose.setBounds(12, 135, 83, 38);
					buttonClose.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							
							
							MessageBox mbox = new MessageBox (getShell(),SWT.ICON_INFORMATION | SWT.YES | SWT.NO);
							mbox.setMessage("هل انت متاكد من الخروج");
							mbox.setText("تأكيد");
							int result=mbox.open();
							if(result == SWT.YES){
								getShell().dispose();
							}
							else
								return;
							
							
						}
					});
				}
			}
			{
				buttonInsert = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData buttonInsertLData = new FormData();
				buttonInsertLData.width = 132;
				buttonInsertLData.height = 25;
				buttonInsertLData.left =  new FormAttachment(0, 1000, 685);
				buttonInsertLData.top =  new FormAttachment(0, 1000, 146);
				buttonInsert.setLayoutData(buttonInsertLData);
				buttonInsert.setText("\u0627\u0636\u0627\u0641\u0629 \u0635\u0646\u0641 \u0627\u0644\u064a \u0627\u0644\u0641\u0627\u062a\u0648\u0631\u0629");
				buttonInsert.addSelectionListener(new SelectionAdapter() {
					private int x;

					public void widgetSelected(SelectionEvent evt) {
						
						// Now Show The Table
						
						ShowTable();
							buttonSave.setEnabled(true);
					}
				});
			}
			{
				FormData comboItemsLData = new FormData();
				comboItemsLData.width = 103;
				comboItemsLData.height = 28;
				comboItemsLData.left =  new FormAttachment(0, 1000, 610);
				comboItemsLData.top =  new FormAttachment(0, 1000, 99);
				comboItems = new Combo(this, SWT.READ_ONLY);
				comboItems.setLayoutData(comboItemsLData);
				comboItems.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
				comboItems.setBackground(SWTResourceManager.getColor(128, 255, 128));
				comboItems.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						
						int index = comboItems.getSelectionIndex();
						
						temp = (Item) comboItems.getData(String.valueOf(index));
						textSeller.setText(String.valueOf(temp.getSellprice()));
						textQuantity.setText(String.valueOf(temp.getQuantity()));
					
						
						
					}
				});
			}
			{
				FormData textNameLData = new FormData();
				textNameLData.width = 141;
				textNameLData.height = 26;
				textNameLData.left =  new FormAttachment(0, 1000, 592);
				textNameLData.top =  new FormAttachment(0, 1000, 51);
				textName = new Text(this, SWT.RIGHT_TO_LEFT);
				textName.setLayoutData(textNameLData);
				textName.setFont(SWTResourceManager.getFont("Segoe UI", 10, 0, false, false));
				textName.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						if(Character.isLetter(key)|| key == SWT.BS){}
						else
							evt.doit=false;
						
						if(key == SWT.CR)
							textRequirement.setFocus();
						
						
					}
				});
			}
			{
				labelName = new Label(this, SWT.NONE);
				FormData labelNameLData = new FormData();
				labelNameLData.width = 97;
				labelNameLData.height = 23;
				labelNameLData.left =  new FormAttachment(0, 1000, 741);
				labelNameLData.top =  new FormAttachment(0, 1000, 52);
				labelName.setLayoutData(labelNameLData);
				labelName.setText(" : \u0627\u0644\u0627\u0633\u0645 \u0627\u0644\u0632\u0628\u0648\u0646");
				labelName.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
			}
			{
				FormData tableVoiceLData = new FormData();
				tableVoiceLData.width = 663;
				tableVoiceLData.height = 261;
				tableVoiceLData.left =  new FormAttachment(0, 1000, 162);
				tableVoiceLData.top =  new FormAttachment(0, 1000, 183);
				tableVoice = new Table(this, SWT.RIGHT_TO_LEFT | SWT.FULL_SELECTION);
				tableVoice.setLinesVisible(true);
				tableVoice.setHeaderVisible(true);
				tableVoice.setLayoutData(tableVoiceLData);
				tableVoice.addSelectionListener(new SelectionAdapter() {

				    public void widgetSelected(SelectionEvent evt) {
				    	
				    	
				        int indx = tableVoice.getSelectionIndex();

				        if(indx == -1)
				            return;

				        TableItem currentItem = tableVoice.getItem(indx);

				      
				        comboItems.setText(currentItem.getText(3));      // اسم الصنف
				        textRequirement.setText(currentItem.getText(4)); // الكمية
				        textSeller.setText(currentItem.getText(5));      // سعر البيع
				       
				        int index = comboItems.getSelectionIndex();
				        Item it = (Item) comboItems.getData(String.valueOf(index));
				        
				       textQuantity.setText(String.valueOf(it.getQuantity()));

				        // تفعيل زر التعديل
				        buttonRemove.setEnabled(true);


				    }
				    
				
				});
				{
					tableNull = new TableColumn(tableVoice, SWT.NONE);
					tableNull.setWidth(0);
					tableNull.setResizable(false);
				}
				{
					tableColumnRT = new TableColumn(tableVoice, SWT.CENTER);
					tableColumnRT.setText("\u0631.\u062a");
					tableColumnRT.setWidth(60);
					tableColumnRT.setResizable(false);
					
				}
				{
					tableColumnID = new TableColumn(tableVoice, SWT.CENTER);
					tableColumnID.setText("\u0631\u0642\u0645 \u0627\u0644\u0635\u0646\u0641");
					tableColumnID.setWidth(122);
					tableColumnID.setResizable(false);

				}
				{
					tableColumnName = new TableColumn(tableVoice, SWT.CENTER);
					tableColumnName.setText("\u0627\u0644\u0627\u0633\u0645 \u0627\u0644\u0635\u0646\u0641");
					tableColumnName.setWidth(157);
					tableColumnName.setResizable(false);

				}
				{
					tableColumnQuantity = new TableColumn(tableVoice, SWT.CENTER);
					tableColumnQuantity.setText("\u0627\u0644\u0643\u0645\u064a\u0629");
					tableColumnQuantity.setWidth(102);
					tableColumnQuantity.setResizable(false);

				}
				{
					tableColumnBuy = new TableColumn(tableVoice, SWT.CENTER);
					tableColumnBuy.setText("\u0633\u0639\u0631 \u0627\u0644\u0628\u064a\u0639");
					tableColumnBuy.setWidth(115);
					tableColumnBuy.setResizable(false);

				}
				{
					tableColumnTotal = new TableColumn(tableVoice, SWT.CENTER);
					tableColumnTotal.setText("\u0627\u062c\u0645\u0627\u0644\u064a");
					tableColumnTotal.setWidth(124);
					tableColumnTotal.setResizable(false);
				}
			}
			{
				label1 = new Label(this, SWT.NONE);
				label1.setText("\u0634\u0627\u0634\u0629 \u0627\u0635\u062f\u0627\u0631 \u0627\u0644\u0641\u0627\u062a\u0648\u0631\u0629");
				FormData label1LData = new FormData();
				label1LData.width = 842;
				label1LData.height = 40;
				label1LData.left =  new FormAttachment(0, 1000, 0);
				label1LData.top =  new FormAttachment(0, 1000, 0);
				label1.setLayoutData(label1LData);
				label1.setAlignment(SWT.CENTER);
				label1.setBackground(SWTResourceManager.getColor(128,255,128));
				label1.setFont(SWTResourceManager.getFont("Traditional Arabic", 19, 1, false, false));
			}
			{
				label2 = new Label(this, SWT.NONE);
				FormData label2LData = new FormData();
				label2LData.width = 92;
				label2LData.height = 23;
				label2LData.left =  new FormAttachment(0, 1000, 457);
				label2LData.top =  new FormAttachment(0, 1000, 51);
				label2.setLayoutData(label2LData);
				label2.setText(": \u062a\u0627\u0631\u064a\u062e \u0627\u0644\u0641\u0648\u0627\u062a\u064a\u0631 ");
				label2.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
			}
			{
				textDate = new Label(this, SWT.CENTER);
				FormData text1LData = new FormData();
				text1LData.width = 117;
				text1LData.height = 26;
				text1LData.left =  new FormAttachment(0, 1000, 328);
				text1LData.top =  new FormAttachment(0, 1000, 51);
				textDate.setLayoutData(text1LData);
				textDate.setFont(SWTResourceManager.getFont("Segoe UI", 10, 0, false, false));
				textDate.setBackground(SWTResourceManager.getColor(128, 255, 128));
			}
			{
				label3 = new Label(this, SWT.NONE);
				FormData label3LData = new FormData();
				label3LData.width = 97;
				label3LData.height = 23;
				label3LData.left =  new FormAttachment(0, 1000, 739);
				label3LData.top =  new FormAttachment(0, 1000, 99);
				label3.setLayoutData(label3LData);
				label3.setText(" : \u0627\u0633\u0645 \u0627\u0644\u0635\u0646\u0641");
				label3.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
			}
			{
				label4 = new Label(this, SWT.NONE);
				FormData label4LData = new FormData();
				label4LData.width = 127;
				label4LData.height = 23;
				label4LData.left =  new FormAttachment(0, 1000, 174);
				label4LData.top =  new FormAttachment(0, 1000, 51);
				label4.setLayoutData(label4LData);
				label4.setText(" : \u0627\u0644\u0643\u0645\u064a\u0629 \u0641\u064a \u0627\u0644\u0645\u062e\u0632\u0646");
				label4.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
			}
			{
				textQuantity = new Label(this, SWT.CENTER);
				FormData text2LData = new FormData();
				text2LData.width = 117;
				text2LData.height = 26;
				text2LData.left =  new FormAttachment(0, 1000, 45);
				text2LData.top =  new FormAttachment(0, 1000, 51);
				textQuantity.setLayoutData(text2LData);
				textQuantity.setFont(SWTResourceManager.getFont("Segoe UI",10,0,false,false));
				textQuantity.setBackground(SWTResourceManager.getColor(128, 255, 128));
			}
			{
				textSeller = new Label(this, SWT.CENTER);
				FormData text3LData = new FormData();
				text3LData.width = 101;
				text3LData.height = 26;
				text3LData.left =  new FormAttachment(0, 1000, 388);
				text3LData.top =  new FormAttachment(0, 1000, 99);
				textSeller.setLayoutData(text3LData);
				textSeller.setFont(SWTResourceManager.getFont("Segoe UI",10,0,false,false));
				textSeller.setBackground(SWTResourceManager.getColor(128, 255, 128));
			}
			{
				label5 = new Label(this, SWT.NONE);
				FormData label5LData = new FormData();
				label5LData.width = 86;
				label5LData.height = 23;
				label5LData.left =  new FormAttachment(0, 1000, 501);
				label5LData.top =  new FormAttachment(0, 1000, 99);
				label5.setLayoutData(label5LData);
				label5.setText(" : \u0633\u0639\u0631 \u0627\u0644\u0628\u064a\u0639");
				label5.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
			}
			{
				label6 = new Label(this, SWT.NONE);
				FormData label6LData = new FormData();
				label6LData.width = 36;
				label6LData.height = 23;
				label6LData.left =  new FormAttachment(0, 1000, 352);
				label6LData.top =  new FormAttachment(0, 1000, 98);
				label6.setLayoutData(label6LData);
				label6.setText("\u062f\u064a\u0646\u0627\u0631");
				label6.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
			}
			{
				textRequirement = new Text(this, SWT.CENTER);
				FormData text4LData = new FormData();
				text4LData.width = 117;
				text4LData.height = 26;
				text4LData.left =  new FormAttachment(0, 1000, 57);
				text4LData.top =  new FormAttachment(0, 1000, 101);
				textRequirement.setLayoutData(text4LData);
				textRequirement.setFont(SWTResourceManager.getFont("Segoe UI",10,0,false,false));
				textRequirement.setBackground(SWTResourceManager.getColor(128, 255, 128));
				textRequirement.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						if(Character.isDigit(key)|| key == SWT.BS){}
						else
							evt.doit=false;
						
						
					}
				});
				textRequirement.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent evt) {
						
						if(textRequirement.getText().trim().isEmpty())
					    return;
						
						if(temp == null)
							return;
						
						if(Integer.valueOf(textRequirement.getText().trim())>temp.getQuantity()){
							
							MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_ERROR);
							mbox.setMessage(".القيمة المذخلة اكبر من الي في المخزون");
							mbox.setText(" رسالة تنبيه ");
							mbox.open();
							
							
							textRequirement.setText("");
							textRequirement.setFocus();

							return;
						}
						
						
					}
				});
			}
			{
				label7 = new Label(this, SWT.NONE);
				FormData label7LData = new FormData();
				label7LData.width = 121;
				label7LData.height = 23;
				label7LData.left =  new FormAttachment(0, 1000, 186);
				label7LData.top =  new FormAttachment(0, 1000, 101);
				label7.setLayoutData(label7LData);
				label7.setText(" : \u0627\u0644\u0643\u0645\u064a\u0629 \u0627\u0644\u0645\u0637\u0644\u0648\u0628\u0629");
				label7.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
			}
			{
				buttonRemove = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.width = 132;
				button1LData.height = 25;
				button1LData.left =  new FormAttachment(0, 1000, 487);
				button1LData.top =  new FormAttachment(0, 1000, 146);
				buttonRemove.setLayoutData(button1LData);
				buttonRemove.setEnabled(false);
				buttonRemove.setText("\u0627\u0644\u063a\u0627\u0621 \u0635\u0646\u0641 \u0645\u0646 \u0627\u0644\u0641\u0627\u062a\u0648\u0631\u0629");
				buttonRemove.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						
						if (indx == -1)
							return;
						
						TableItem tt = tableVoice.getItem(indx);
					
					    Total= Total-Double.valueOf(tt.getText(6));	
						
					    tableVoice.remove(indx);
					--sn;
						textTotal.setText(String.valueOf(Total));
						
						for(int i = 0; i<tableVoice.getItemCount(); i++){
						tableVoice.getItem(i).setText(1, String.valueOf(i+1));

							
							
							
						}
						buttonRemove.setEnabled(false);
						buttonSave.setEnabled(false);
						buttonSave.setText("حفظ");

							}
				});
			}
			{
				textTotal = new Text(this, SWT.READ_ONLY | SWT.CENTER);
				FormData text5LData = new FormData();
				text5LData.width = 117;
				text5LData.height = 26;
				text5LData.left =  new FormAttachment(0, 1000, 364);
				text5LData.top =  new FormAttachment(0, 1000, 473);
				textTotal.setLayoutData(text5LData);
				textTotal.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
				textTotal.setBackground(SWTResourceManager.getColor(128, 255, 128));
			}
			{
				label8 = new Label(this, SWT.NONE);
				FormData label8LData = new FormData();
				label8LData.width = 113;
				label8LData.height = 23;
				label8LData.left =  new FormAttachment(0, 1000, 497);
				label8LData.top =  new FormAttachment(0, 1000, 474);
				label8.setLayoutData(label8LData);
				label8.setText(" : \u0627\u062c\u0645\u0627\u0644\u064a \u0627\u0644\u0641\u0627\u062a\u0648\u0631\u0629");
				label8.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
			}
			{
				buttonReturn = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button4LData = new FormData();
				button4LData.width = 107;
				button4LData.height = 47;
				button4LData.left =  new FormAttachment(0, 1000, 18);
				button4LData.top =  new FormAttachment(0, 1000, 449);
				buttonReturn.setLayoutData(button4LData);
				buttonReturn.setText("\u0627\u0644\u0634\u0627\u0634\u0629 \u0627\u0644\u0631\u0626\u064a\u0633\u064a\u0629");
				buttonReturn.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						
						
						
						getShell().dispose();
						MainForm.showGUI();
					
					
					
					}
				});
			}
			{
				label9 = new Label(this, SWT.NONE);
				FormData label9LData = new FormData();
				label9LData.width = 36;
				label9LData.height = 23;
				label9LData.left =  new FormAttachment(0, 1000, 322);
				label9LData.top =  new FormAttachment(0, 1000, 473);
				label9.setLayoutData(label9LData);
				label9.setText("\u062f\u064a\u0646\u0627\u0631");
				label9.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
