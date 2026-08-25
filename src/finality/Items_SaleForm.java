package finality;

/*
Name : Abdalmohimn Khaled AlGonsul
ID : 231085
*/



import java.util.List;

import com.cloudgarden.resource.SWTResourceManager;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
public class Items_SaleForm extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	
	private Label label1;
	private Button buttonNew;
	private Button buttonSave;
	private Button buttonRemove;
	private TableColumn tableColumnSell;
	private TableColumn tableColumnQuantity;
	private Label label5;
	private Text textSell;
	private Label label4;
	private Text textBuy;
	private Button buttonReturnt;
	private TableColumn tableColumnName;
	private TableColumn tableColumnID;
	private TableColumn tableColumnRT;
	private TableColumn tableColumnNULL;
	private Table tableItems;
	private Group groupButton;
	private Button button1;
	private Text textName;
	private Text textQuantity;
	private Text textID;
	private Label label3;
	private Label label2;
	private Label labelName;
	int sn =0;
	public static String name;
	private TableItem temp ; // This One Is To Get Any Row For Temproray
	protected Item TempItem;  // Just Temproray Class For List Deleting
	
	// ======= Data Base ===========
	private Transaction tr;
	private SessionFactory sf;
	private Session ss;
	

	public static void main(String[] args) {
		showGUI();
		
	}
		
	
	
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setText(name+" / منظومة المبيعات - اسم المستخدم");
		
		Items_SaleForm inst = new Items_SaleForm(shell, SWT.NULL );
		
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

	public Items_SaleForm(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
		getItems();
	}

	
	
	@SuppressWarnings({ "unchecked" })
	private void getItems(){
		openSession();

		List<Item> itemList = ss.createQuery("from Item where deleted = false").list();
		
		tableItems.removeAll();
		sn=0;
		for(Item out : itemList){
			
			TableItem it = new TableItem(tableItems , SWT.NONE);
			
			it.setText(1,String.valueOf(++sn));
			it.setText(2,String.valueOf(out.getId()));
			it.setText(3,out.getName());
			it.setText(4,String.valueOf(out.getQuantity()));
			it.setText(5,String.valueOf(out.getBuyprice()));
			it.setText(6,String.valueOf(out.getSellprice()));

				
				
			}
			
			ss.close();
			
		}
		
	
	
	// Create Method data base 
	
	@SuppressWarnings({ "deprecation" })
	private void openSession (){
		// Step 1 SessionFactory
		sf = new Configuration().configure("finality/hibernate.cfg.xml").buildSessionFactory();
		
		// Step 2 Session
		ss = sf.openSession();
		
		// Step 3 Transaction = Get SessionTransaction
		tr = ss.getTransaction();
		
		// Step 4 Start
		tr.begin();
			
		
		
		
		
		
	}
	
	// Checking ID Duplicated

	@SuppressWarnings("unchecked")
	private boolean CheckID(){
		
		openSession();
		
		// Get ID
		int id = Integer.valueOf(textID.getText());
		
		// Call DataBase And Tell Him I need Data That Have ID And Store it Into List
		List<Item> admin = ss.createQuery("from Item where id ='"+id+"'").list();
		
		if(admin.size()>0){
			return true;
			
			
		}
		
		ss.close();
		
		return false;
		
		
	}
	
	
	private void initGUI() {
		try {
			this.setLayout(new FormLayout());
			this.setSize(801, 398);
			{
				FormData groupButtonLData = new FormData();
				groupButtonLData.width = 102;
				groupButtonLData.height = 191;
				groupButtonLData.left =  new FormAttachment(0, 1000, 12);
				groupButtonLData.top =  new FormAttachment(0, 1000, 127);
				groupButton = new Group(this, SWT.NONE);
				groupButton.setLayout(null);
				groupButton.setLayoutData(groupButtonLData);
				{
					buttonNew = new Button(groupButton, SWT.PUSH | SWT.CENTER);
					buttonNew.setText("\u062c\u062f\u064a\u062f");
					buttonNew.setBounds(12, 20, 84, 37);
					buttonNew.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							
							MessageBox mbox = new MessageBox(getShell(),SWT.YES | SWT.NO | SWT.ICON_QUESTION);
							mbox.setMessage("هل انت متأكد من حذف جميع بيانات جدول ؟");
							mbox.setText("رسالة تاكيد");
							int result = mbox.open();
							if(result == SWT.YES){
								textID.setText("");
								textName.setText("");
								textQuantity.setText("");
								textSell.setText("");
								textBuy.setText("");
								buttonRemove.setEnabled(false);
								tableItems.removeAll();
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
					button1 = new Button(groupButton, SWT.PUSH | SWT.CENTER);
					button1.setText("\u0627\u063a\u0644\u0627\u0642");
					button1.setBounds(12, 163, 84, 34);
					button1.addSelectionListener(new SelectionAdapter() {
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
				{
					buttonSave = new Button(groupButton, SWT.PUSH | SWT.CENTER);
					buttonSave.setText("\u062d\u0641\u0638");
					buttonSave.setBounds(12, 69, 84, 35);
					// Data Base Get Items
					
					
					buttonSave.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							
							
							if(buttonSave.getText().equals("حفظ")){

								
								// if The All Data Item Is Set into textbox then check it !
								
								if(textID.getText().isEmpty()||textQuantity.getText().isEmpty() || textSell.getText().isEmpty() || textBuy.getText().isEmpty() || textName.getText().isEmpty())
								{
									MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_WARNING);
									mbox.setMessage("يرجي تعبئة البيانات بشكل كامل");
									mbox.setText("! تنبيه ");
									mbox.open();
									
									
								}
								else {
									
									
									// Checking If ID Was IN Data Base
									if(CheckID()){
										
										MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_INFORMATION);
										mbox.setMessage("اذا الرقم تم تخزينه مسبقا");
										mbox.setText(" رسالة تنبيه ");
										mbox.open();
										
										return;  // Stop Doing Down Compilor
									}
									
									
									// Call Data Base Now And Sent The Attribute
									openSession();
									Item i = new Item();
									
									// id
									i.setId(Integer.valueOf(String.valueOf(textID.getText())));
									
									// Name
									i.setName(textName.getText());
									
							// Sell Price
							i.setSellprice(Double.valueOf(textSell.getText()));
							
							// Buy Price
							i.setBuyprice(Double.valueOf(textBuy.getText()));
							
							// is deleted ?
									i.setDeleted(false);
							
							// Quantity
							i.setQuantity(Integer.valueOf(textQuantity.getText()));
							
							
							
							// Now Added The Data Into Table
							
							TableItem it = new TableItem(tableItems , SWT.NONE);
							
							/* R . T */		it.setText(1 , String.valueOf(++sn));
							/* ID   */		it.setText(2 , String.valueOf(i.getId()));
							/* Name */		it.setText(3 , i.getName());
							/* Quantity */	    it.setText(4 , String.valueOf(i.getQuantity()));
							/* Buy */		it.setText(5 , String.valueOf(i.getBuyprice()));
							/* Sell */		it.setText(6 , String.valueOf(i.getSellprice()));
							
							
							// Save Now The Data INTO DATABASE And Close it
							ss.save(i);
							tr.commit();
							ss.close();
							
							// Massion Completed !!!
							MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_WORKING);
							mbox.setMessage("تمت العملية الاضافة بنجاج");
							mbox.setText(" رسالة ");
							mbox.open();
							
								}
								
								
								
							}
							else{

								if(textID.getText().isEmpty()||textQuantity.getText().isEmpty() || textSell.getText().isEmpty() || textBuy.getText().isEmpty() || textName.getText().isEmpty())
								{
									MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_WARNING);
									mbox.setMessage("يرجي تعبئة البيانات بشكل كامل");
									mbox.setText("! تنبيه ");
									mbox.open();
									
									
								}
								

								
								
								
								openSession();
								
								int id = Integer.valueOf(temp.getText(2));
								List<Item> list = ss.createQuery("from Item where id ='"+id+"'").list();
								if(list.size()>0){
									
									// Create Item With Insert List ID
									Item it = list.get(0);
									
									// ممنوع تغيير رقم مفتاح الرئيسي
									
									// Name
									it.setName(textName.getText());
									
									// Quantity
									it.setQuantity(Integer.valueOf(textQuantity.getText()));
									
									// BuyPrice
									it.setBuyprice(Double.valueOf(textBuy.getText()));
									
									// SellPrice
									it.setSellprice(Double.valueOf(textSell.getText()));
									
									ss.update(it);
									
									
								}
								tr.commit();
								ss.close();
								

								// Massion Completed !!!
								MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_WORKING);
								mbox.setMessage("تمت العملية التعديل بنجاج");
								mbox.setText(" رسالة ");
								mbox.open();
								getItems();
								buttonSave.setText("حفظ");
							}
							
							
							
							
							
						}
					});
				}
				{
					buttonRemove = new Button(groupButton, SWT.PUSH | SWT.CENTER);
					buttonRemove.setEnabled(false);
					buttonRemove.setText("\u062d\u0630\u0641");
					buttonRemove.setBounds(12, 116, 84, 38);
					buttonRemove.addSelectionListener(new SelectionAdapter() {
						@SuppressWarnings("unchecked")
						public void widgetSelected(SelectionEvent evt) {
							
							// Selection From Idx Selection Item IN Table
							int index = tableItems.getSelectionIndex();
							
							// try{
								if(index == -1){
									MessageBox m = new MessageBox(getShell(), SWT.ICON_WARNING);
									m.setText("تنبيه");
									m.setMessage("اختر موظف من الجدول أولاً");
									m.open();
									return;
								}else{
									
									MessageBox m = new MessageBox(getShell(),SWT.ICON_QUESTION|SWT.YES|SWT.NO);
									m.setMessage("هل أنت متأكد من حذف هذا الصنف");
									m.setText("تنبيه");
									int answer=m.open();
									if(answer== SWT.YES){
										openSession();
										
										// Calling Temp From TableItem
										
										temp=tableItems.getItem(index);
										
										
										// Get Data From Selection Data
										int id = Integer.valueOf(temp.getText(2));
										tableItems.remove(index);
										
										// Get ID From Data Base
										List<Item> admin = ss.createQuery("from Item where id ='"+id+"'").list();
										TempItem = admin.get(0);
										TempItem.setDeleted(true);
										
										// Delete it
										ss.update(TempItem);
										tr.commit();
										ss.close();
										sn--;
										
								m = new MessageBox(getShell(),SWT.ICON_INFORMATION);
								m.setMessage("تمت عملية الحذف بنجاح");
								m.setText("معلومة");
								m.open();
								buttonRemove.setEnabled(false);
								
								for (int i =0; i <tableItems.getItemCount(); i++){
									tableItems.getItem(i).setText(1,String.valueOf(++i));
								}
									}
									
						
									
									
								}
							}
						});
					}
				}
			{
				FormData tableItemsLData = new FormData();
				tableItemsLData.width = 646;
				tableItemsLData.height = 243;
				tableItemsLData.left =  new FormAttachment(0, 1000, 131);
				tableItemsLData.top =  new FormAttachment(0, 1000, 132);
				tableItems = new Table(this, SWT.RIGHT_TO_LEFT | SWT.FULL_SELECTION);
				tableItems.setLinesVisible(true);
				tableItems.setHeaderVisible(true);
				
				tableItems.setLayoutData(tableItemsLData);
				
				tableItems.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						
						// GetIndex By Selection 
						int idx = tableItems.getSelectionIndex();
						temp = tableItems.getItem(idx);
						
						// Throw it Into Text Box
						
						// id
						textID.setText(temp.getText(2));
						
						// Name
						textName.setText(temp.getText(3));
						
						// Quantity
						textQuantity.setText(temp.getText(4));
						
						// Sell Price
						textSell.setText(temp.getText(5));
						
						// Buy Price
						textBuy.setText(temp.getText(6));

						
						buttonRemove.setEnabled(true);
						
						
						buttonSave.setText("تعديل");
						
						
						
					}
				});
				{
					tableColumnNULL = new TableColumn(tableItems, SWT.NONE);
					tableColumnNULL.setText("");
					tableColumnNULL.setWidth(0);
					tableColumnNULL.setResizable(false);
				}
				{
					tableColumnRT = new TableColumn(tableItems, SWT.CENTER);
					tableColumnRT.setText("\u0631.\u062a");
					tableColumnRT.setWidth(54);
					tableColumnRT.setResizable(false);

				}
				{
					tableColumnID = new TableColumn(tableItems, SWT.CENTER);
					tableColumnID.setText("\u0631\u0642\u0645 \u0627\u0644\u0635\u0646\u0641");
					tableColumnID.setWidth(106);
					tableColumnID.setResizable(false);

				}
				{
					tableColumnName = new TableColumn(tableItems, SWT.CENTER);
					tableColumnName.setText("\u0627\u0644\u0627\u0633\u0645");
					tableColumnName.setWidth(142);
					tableColumnName.setResizable(false);

				}
				{
					tableColumnQuantity = new TableColumn(tableItems, SWT.CENTER);
					tableColumnQuantity.setText("\u0627\u0644\u0643\u0645\u064a\u0629");
					tableColumnQuantity.setWidth(90);
					tableColumnQuantity.setResizable(false);

				}
				{
					tableColumnSell = new TableColumn(tableItems, SWT.CENTER);
					tableColumnSell.setText("\u0633\u0639\u0631 \u0627\u0644\u0628\u064a\u0639");
					tableColumnSell.setWidth(117);
					tableColumnSell.setResizable(false);

				}
				{
					tableColumnID = new TableColumn(tableItems, SWT.CENTER);
					tableColumnID.setText("\u0633\u0639\u0631 \u0627\u0644\u0634\u0631\u0627\u0621");
					tableColumnID.setWidth(154);
					tableColumnID.setResizable(false);

				}
			}
			{
				FormData textSalaryLData = new FormData();
				textSalaryLData.width = 124;
				textSalaryLData.height = 25;
				textSalaryLData.left =  new FormAttachment(0, 1000, 298);
				textSalaryLData.top =  new FormAttachment(0, 1000, 51);
				textID = new Text(this, SWT.CENTER);
				textID.setLayoutData(textSalaryLData);
				textID.setBackground(SWTResourceManager.getColor(128, 255, 128));
				textID.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
				textID.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {

						char key = evt.character;
						if(Character.isDigit(key) || key == SWT.BS){}
						else
							evt.doit = false;
						if(key == SWT.CR){
							
							if(CheckID()){
								
								MessageBox mbox = new MessageBox(getShell(), SWT.OK | SWT.ICON_INFORMATION);
								mbox.setMessage("اذا الرقم تم تخزينه مسبقا");
								mbox.setText(" رسالة تنبيه ");
								mbox.open();
								return;
							}
							
							textBuy.setFocus();
						}
					
					}
				});
			}
			{
				labelName = new Label(this, SWT.NONE);
				FormData labelNameLData = new FormData();
				labelNameLData.width = 99;
				labelNameLData.height = 25;
				labelNameLData.left =  new FormAttachment(0, 1000, 695);
				labelNameLData.top =  new FormAttachment(0, 1000, 51);
				labelName.setLayoutData(labelNameLData);
				labelName.setText(": \u0627\u0644\u0627\u0633\u0645 \u0627\u0644\u0635\u0646\u0641");
				labelName.setAlignment(SWT.RIGHT);
				labelName.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
			}
			{
				label1 = new Label(this, SWT.NONE);
				label1.setText("\u0634\u0627\u0634\u0629 \u0627\u0644\u0627\u0635\u0646\u0627\u0641");
				FormData label1LData = new FormData();
				label1LData.width = 801;
				label1LData.height = 34;
				label1LData.left =  new FormAttachment(0, 1000, 0);
				label1LData.top =  new FormAttachment(0, 1000, 0);
				label1.setLayoutData(label1LData);
				label1.setAlignment(SWT.CENTER);
				label1.setBackground(SWTResourceManager.getColor(128,255,128));
				label1.setFont(SWTResourceManager.getFont("Segoe UI", 14, 1, false, false));
			}
			{
				label2 = new Label(this, SWT.NONE);
				label2.setText(": \u0627\u0644\u0643\u0645\u064a\u0629");
				FormData label2LData = new FormData();
				label2LData.width = 47;
				label2LData.height = 25;
				label2LData.left =  new FormAttachment(0, 1000, 232);
				label2LData.top =  new FormAttachment(0, 1000, 51);
				label2.setLayoutData(label2LData);
				label2.setAlignment(SWT.RIGHT);
				label2.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
			}
			{
				label3 = new Label(this, SWT.NONE);
				label3.setText(": \u0631\u0642\u0645 \u0627\u0644\u0635\u0646\u0641 ");
				FormData label3LData = new FormData();
				label3LData.width = 88;
				label3LData.height = 25;
				label3LData.left =  new FormAttachment(0, 1000, 434);
				label3LData.top =  new FormAttachment(0, 1000, 51);
				label3.setLayoutData(label3LData);
				label3.setAlignment(SWT.RIGHT);
				label3.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
			}
			{
				textQuantity = new Text(this, SWT.CENTER);
				FormData text1LData = new FormData();
				text1LData.width = 123;
				text1LData.height = 25;
				text1LData.left =  new FormAttachment(0, 1000, 92);
				text1LData.top =  new FormAttachment(0, 1000, 51);
				textQuantity.setLayoutData(text1LData);
				textQuantity.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
				textQuantity.setBackground(SWTResourceManager.getColor(128, 255, 128));
				textQuantity.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
					
						char key = evt.character;
						if(Character.isDigit(key) || key == SWT.BS){}
						else
							evt.doit = false;
						if(key == SWT.CR)
							textID.setFocus();
					
					
					
					}
				});
			}
			{
				textName = new Text(this, SWT.RIGHT_TO_LEFT);
				FormData text2LData = new FormData();
				text2LData.width = 143;
				text2LData.height = 25;
				text2LData.left =  new FormAttachment(0, 1000, 544);
				text2LData.top =  new FormAttachment(0, 1000, 51);
				textName.setLayoutData(text2LData);
				textName.setFont(SWTResourceManager.getFont("Segoe UI", 11, 0, false, false));
				textName.setBackground(SWTResourceManager.getColor(128, 255, 128));
				textName.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
					
					char key = evt.character;
					if(Character.isLetter(key) || key == SWT.BS){}
					else
						evt.doit = false;
					if(key == SWT.CR)
					textQuantity.setFocus();
					
					
					}
				});
			}
			{
				buttonReturnt = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData buttonConfirmLData = new FormData();
				buttonConfirmLData.width = 109;
				buttonConfirmLData.height = 44;
				buttonConfirmLData.left =  new FormAttachment(0, 1000, 11);
				buttonConfirmLData.top =  new FormAttachment(0, 1000, 348);
				buttonReturnt.setLayoutData(buttonConfirmLData);
				buttonReturnt.setText("\u0627\u0644\u0634\u0627\u0634\u0629 \u0627\u0644\u0631\u0626\u064a\u0633\u064a\u0629");
				buttonReturnt.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						
						
								getShell().dispose();
								MainForm.showGUI();
								
								
							
					}
				});
			}
			{
				textBuy = new Text(this, SWT.CENTER);
				FormData text1LData1 = new FormData();
				text1LData1.width = 115;
				text1LData1.height = 25;
				text1LData1.left =  new FormAttachment(0, 1000, 578);
				text1LData1.top =  new FormAttachment(0, 1000, 95);
				textBuy.setLayoutData(text1LData1);
				textBuy.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
				textBuy.setBackground(SWTResourceManager.getColor(128,255,128));
				textBuy.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						if (Character.isDigit(key) || key == SWT.BS || key == SWT.CR ){
						evt.doit = true;
					}
						else //-----------------------------------------
							
							
						if(key == '.'){
							
					
						if (textBuy.getText () .contains("."))
						evt.doit = false;
						
						}
						else
							evt.doit = false;
					//----------------------------------------------------
					
						if(key == SWT.CR)
							textSell.setFocus();
					}
					
					
				});
			}
			{
				label4 = new Label(this, SWT.NONE);
				label4.setText(" : \u0627\u0644\u0633\u0639\u0631 \u0627\u0644\u0634\u0631\u0627\u0621");
				FormData label4LData = new FormData();
				label4LData.width = 87;
				label4LData.height = 25;
				label4LData.left =  new FormAttachment(0, 1000, 707);
				label4LData.top =  new FormAttachment(0, 1000, 95);
				label4.setLayoutData(label4LData);
				label4.setAlignment(SWT.RIGHT);
				label4.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
			}
			{
				textSell = new Text(this, SWT.CENTER);
				FormData text2LData1 = new FormData();
				text2LData1.width = 115;
				text2LData1.height = 25;
				text2LData1.left =  new FormAttachment(0, 1000, 341);
				text2LData1.top =  new FormAttachment(0, 1000, 95);
				textSell.setLayoutData(text2LData1);
				textSell.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
				textSell.setBackground(SWTResourceManager.getColor(128,255,128));
				textSell.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						
						char key = evt.character;
						if (Character.isDigit(key) || key == SWT.BS || key == SWT.CR ){
						evt.doit = true;
					}
						else //-----------------------------------------
							
							
						if(key == '.'){
							
					
						if (textSell.getText () .contains("."))
						evt.doit = false;
						
						}
						else
							evt.doit = false;
					//----------------------------------------------------
					
					
					
					}
				});
			}
			{
				label5 = new Label(this, SWT.NONE);
				label5.setText(" : \u0627\u0644\u0633\u0639\u0631 \u0627\u0644\u0628\u064a\u0639");
				FormData label5LData = new FormData();
				label5LData.width = 84;
				label5LData.height = 25;
				label5LData.left =  new FormAttachment(0, 1000, 465);
				label5LData.top =  new FormAttachment(0, 1000, 95);
				label5.setLayoutData(label5LData);
				label5.setAlignment(SWT.RIGHT);
				label5.setFont(SWTResourceManager.getFont("Segoe UI",11,0,false,false));
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
