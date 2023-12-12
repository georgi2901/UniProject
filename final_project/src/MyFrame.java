import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSetInternal;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;


public class MyFrame extends JFrame {
	
	JTable tableA = new JTable();
	TableColumnModel modelA = tableA.getColumnModel();
	JScrollPane scrollerA = new JScrollPane(tableA);
	JTable tableB = new JTable();
	TableColumnModel modelB = tableB.getColumnModel();
	JScrollPane scrollerB = new JScrollPane(tableB);
	JTable tableC = new JTable();
	TableColumnModel modelC = tableC.getColumnModel();
	JScrollPane scrollerC = new JScrollPane(tableC);
	JTable tableD = new JTable();
	TableColumnModel modelD = tableD.getColumnModel();
	JScrollPane scrollerD = new JScrollPane(tableD);
	
	
	private Connection connA = null;
	private PreparedStatement stateA = null;
	private Connection connB = null;
	private PreparedStatement stateB = null;
	private Connection connC = null;
	private PreparedStatement stateC = null;
	int idA = -1;
	int idB = -1;
	int idC = -1;
	int idAUpdate = -1;
	int idBUpdate = -1;
	int idCUpdate = -1;
	public static ResultSet result = null;
	
	JTabbedPane tab=new JTabbedPane();
	
	JPanel areaP=new JPanel();
	JPanel upÀPanel=new JPanel();
	JPanel midÀPanel=new JPanel();
	JPanel downÀPanel=new JPanel();
	JPanel poolP=new JPanel();
	JPanel upPPanel=new JPanel();
	JPanel midPPanel=new JPanel();
	JPanel downPPanel=new JPanel();
	JPanel responsibleP=new JPanel();
	JPanel upRPanel=new JPanel();
	JPanel midRPanel=new JPanel();
	JPanel downRPanel=new JPanel();
	JPanel sprP=new JPanel();
	JPanel upSprPanel=new JPanel();
	JPanel downSprPanel=new JPanel();
	
	JLabel nameL=new JLabel("Èìå:");
	JLabel areaL=new JLabel("Ïëîù:");
	JLabel populationL=new JLabel("Íàñåëåíèå:");
	JLabel namePL=new JLabel("Èìå:");
	JLabel areaPL=new JLabel("Ïëîù:");
	JLabel depthL=new JLabel("Äúëáî÷èíà:");
	JLabel regionL=new JLabel("Îáëàñò:");
	JLabel fnameL=new JLabel("Èìå:");
	JLabel lnameL=new JLabel("Ôàìèëèÿ:");
	JLabel ageL=new JLabel("Âúçðàñò:");
	JLabel textL=new JLabel("Êîìåíòàð:");
	JLabel poolL=new JLabel("Âîäîåì:");
	
	
	JTextField nameTF=new JTextField();
	JTextField areaTF=new JTextField();
	JTextField populationTF=new JTextField();
	JTextField namePTF=new JTextField();
	JTextField areaPTF=new JTextField();
	JTextField depthTF=new JTextField();
	JTextField regionTF=new JTextField();
	JTextField fnameTF=new JTextField();
	JTextField lnameTF=new JTextField();
	JTextField ageTF=new JTextField();
	JTextField textTF=new JTextField();
	
	
	JButton addABtn=new JButton("Äîáàâè");
	JButton delABtn=new JButton("Èçòðèé");
	JButton chgABtn=new JButton("Ïðîìåíè");
	JButton addPBtn=new JButton("Äîáàâè");
	JButton delPBtn=new JButton("Èçòðèé");
	JButton chgPBtn=new JButton("Ïðîìåíè");
	JButton addRBtn=new JButton("Äîáàâè");
	JButton delRBtn=new JButton("Èçòðèé");
	JButton chgRBtn=new JButton("Ïðîìåíè");
	JComboBox<String> searchComboRegion = new JComboBox<String>();
	JComboBox<String> searchIdComboRegion = new JComboBox<String>();
	JComboBox<String> regionCB = new JComboBox<String>();
	JComboBox<String> regionIdCB = new JComboBox<String>();
	JButton searchABtn=new JButton("Òúðñè");
	JComboBox<String> searchComboPool = new JComboBox<String>();
	JComboBox<String> searchIdComboPool = new JComboBox<String>();
	JButton searchBBtn=new JButton("Òúðñè");
	JComboBox<String> poolCB = new JComboBox<String>();
	JComboBox<String> poolIdCB = new JComboBox<String>();
	JComboBox<String> searchComboResponsible = new JComboBox<String>();
	JComboBox<String> searchIdComboResponsible = new JComboBox<String>();
	JButton searchCBtn=new JButton("Òúðñè");
	JComboBox<String> chooseComboRegionSpr = new JComboBox<String>();
	JComboBox<String> chooseComboPoolSpr = new JComboBox<String>();
	JComboBox<String> chooseComboIdRegionSpr = new JComboBox<String>();
	JComboBox<String> chooseComboIdPoolSpr = new JComboBox<String>();
	JButton searchSprBtn=new JButton("Òúðñè");
	
	
	
	MyFrame() {
		
		this.setSize(600, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tab.add(areaP, "Îáëàñòè");
		tab.add(poolP, "Âîäîåìè");
		tab.add(responsibleP, "Îòãîâîðíèöè");
		tab.add(sprP, "Ðàçøèðåíî òúðñåíå");
		
		this.add(tab);
		this.setVisible(true);
		
		//1st panel----------------
		
		areaP.setLayout(new GridLayout(3,1));
		
		areaP.add(upÀPanel);
		areaP.add(midÀPanel);
		areaP.add(downÀPanel);
		
		
		upÀPanel.setLayout(new GridLayout(3,2));
		upÀPanel.add(nameL);
		upÀPanel.add(nameTF);
		upÀPanel.add(areaL);
		upÀPanel.add(areaTF);
		upÀPanel.add(populationL);
		upÀPanel.add(populationTF);
		
		midÀPanel.add(addABtn);
		midÀPanel.add(delABtn);
		midÀPanel.add(chgABtn);
		midÀPanel.add(searchComboRegion);
		midÀPanel.add(searchABtn);
		
		addABtn.addActionListener(new AddActionArea());
		delABtn.addActionListener(new DeleteActionArea());
		chgABtn.addActionListener(new UpdateActionArea());
		DBHelper.fillRegionCombo(searchComboRegion);
		DBHelper.fillRegionComboId(searchIdComboRegion);
		searchABtn.addActionListener(new SearchActionArea());
		
		
		downÀPanel.add(scrollerA);
		scrollerA.setPreferredSize(new Dimension(450,150));
		tableA.setModel(DBHelper.getAllDataRegion());
		modelA.removeColumn(modelA.getColumn(0));
		tableA.addMouseListener(new TableAListener());
		
		
		//2nd panel-----------
		
		poolP.setLayout(new GridLayout(3,1));
		
		poolP.add(upPPanel);
		poolP.add(midPPanel);
		poolP.add(downPPanel);
		
		upPPanel.setLayout(new GridLayout(4,2));
		upPPanel.add(namePL);
		upPPanel.add(namePTF);
		upPPanel.add(areaPL);
		upPPanel.add(areaPTF);
		upPPanel.add(depthL);
		upPPanel.add(depthTF);
		upPPanel.add(regionL);
		//upPPanel.add(regionTF);
		upPPanel.add(regionCB);
		DBHelper.fillRegionCombo(regionCB);
		DBHelper.fillRegionComboId(regionIdCB);
		
		midPPanel.add(addPBtn);
		midPPanel.add(delPBtn);
		midPPanel.add(chgPBtn);
		midPPanel.add(searchComboPool);
		midPPanel.add(searchBBtn);
		
		addPBtn.addActionListener(new AddActionPool());
		delPBtn.addActionListener(new DeleteActionPool());
		chgPBtn.addActionListener(new UpdateActionPool());
		DBHelper.fillPoolACombo(searchComboPool);
		DBHelper.fillPoolAComboId(searchIdComboPool);
		searchBBtn.addActionListener(new SearchActionPool());
		
		downPPanel.add(scrollerB);
		scrollerB.setPreferredSize(new Dimension(450,150));
		tableB.setModel(DBHelper.getAllDataPool());
		modelB.removeColumn(modelB.getColumn(0));
		tableB.addMouseListener(new TableBListener());
		
		
		//3rd panel--------------
		
		responsibleP.setLayout(new GridLayout(3,1));
		
		responsibleP.add(upRPanel);
		responsibleP.add(midRPanel);
		responsibleP.add(downRPanel);
		
		upRPanel.setLayout(new GridLayout(5,2));
		upRPanel.add(fnameL);
		upRPanel.add(fnameTF);
		upRPanel.add(lnameL);
		upRPanel.add(lnameTF);
		upRPanel.add(ageL);
		upRPanel.add(ageTF);
		upRPanel.add(textL);
		upRPanel.add(textTF);
		upRPanel.add(poolL);
		upRPanel.add(poolCB);
		DBHelper.fillPoolCombo(poolCB);
		DBHelper.fillPoolComboId(poolIdCB);
		
		midRPanel.add(addRBtn);
		midRPanel.add(delRBtn);
		midRPanel.add(chgRBtn);
		midRPanel.add(searchComboResponsible);
		midRPanel.add(searchCBtn);
		
		addRBtn.addActionListener(new AddActionResponsible());
		delRBtn.addActionListener(new DeleteActionResponsible());
		chgRBtn.addActionListener(new UpdateActionResponsible());
		DBHelper.fillSearchResponsible(searchComboResponsible);
		DBHelper.fillSearchIdResponsible(searchIdComboResponsible);
		searchCBtn.addActionListener(new SearchActionResponsible());
		
		downRPanel.add(scrollerC);
		scrollerC.setPreferredSize(new Dimension(450,150));
		tableC.setModel(DBHelper.getAllDataResponsible());
		modelC.removeColumn(modelC.getColumn(0));
		tableC.addMouseListener(new TableCListener());
		
		//4th panel
		
		sprP.setLayout(new GridLayout(2,1));
		
		sprP.add(upSprPanel);
		sprP.add(downSprPanel);
		
		upSprPanel.setLayout(new GridLayout(1,3));
		upSprPanel.add(chooseComboRegionSpr);
		DBHelper.fillSprRegionCombo(chooseComboRegionSpr);
		DBHelper.fillSprRegionComboId(chooseComboIdRegionSpr);
		upSprPanel.add(chooseComboPoolSpr);
		DBHelper.fillSprPoolCombo(chooseComboPoolSpr);
		DBHelper.fillSprPoolComboId(chooseComboIdPoolSpr);
		upSprPanel.add(searchSprBtn);
		
		searchSprBtn.addActionListener(new SearchActionSpr());
		
		downSprPanel.add(scrollerD);
		scrollerD.setPreferredSize(new Dimension(450,150));
		tableD.setModel(DBHelper.getAllDataPool());
		modelD.removeColumn(modelD.getColumn(0));
		
		
	}


	public void clearForm() {
		
		nameTF.setText("");
		areaTF.setText("");
		populationTF.setText("");
		namePTF.setText("");
		areaPTF.setText("");
		depthTF.setText("");
		regionTF.setText("");
		fnameTF.setText("");
		lnameTF.setText("");
		ageTF.setText("");
		textTF.setText("");
		
	}//end clear form
	
	class AddActionArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameTF.getText();
			int area = Integer.parseInt(areaTF.getText());
			int population = Integer.parseInt(populationTF.getText());
			
			connA = DBHelper.getConnection();
			try {
				stateA = connA.prepareStatement("insert into region values(null, ?, ?, ?);");
				stateA.setString(1, name);
				stateA.setInt(2, area);
				stateA.setInt(3, population);
				stateA.execute();
				tableA.setModel(DBHelper.getAllDataRegion());
				modelA.removeColumn(modelA.getColumn(0));
				DBHelper.fillRegionCombo(searchComboRegion);
				DBHelper.fillRegionComboId(searchIdComboRegion);
				DBHelper.fillRegionCombo(regionCB);
				DBHelper.fillRegionComboId(regionIdCB);
				DBHelper.fillSprRegionCombo(chooseComboRegionSpr);
				DBHelper.fillSprRegionComboId(chooseComboIdRegionSpr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					stateA.close();
					connA.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			clearForm();
		}
   }
	
	class AddActionPool implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nameP = namePTF.getText();
			int areaP = Integer.parseInt(areaPTF.getText());
			int depth = Integer.parseInt(depthTF.getText());
			int item = Integer.parseInt(regionIdCB.getItemAt(regionCB.getSelectedIndex()));
			
			connB = DBHelper.getConnection();
			try {
				stateB = connB.prepareStatement("insert into pool values(null, ?, ?, ?, ?, null);");
				stateB.setString(1, nameP);
				stateB.setInt(2, areaP);
				stateB.setInt(3, depth);
				stateB.setInt(4, item);
				stateB.execute();
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
				DBHelper.fillPoolACombo(searchComboPool);
				DBHelper.fillPoolAComboId(searchIdComboPool);
				DBHelper.fillPoolCombo(poolCB);
				DBHelper.fillPoolComboId(poolIdCB);
				DBHelper.fillSprPoolCombo(chooseComboPoolSpr);
				DBHelper.fillSprPoolComboId(chooseComboIdPoolSpr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					stateB.close();
					connB.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			clearForm();
		}
   }
	
	class AddActionResponsible implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String fname = fnameTF.getText();
			String lname = lnameTF.getText();
			int age = Integer.parseInt(ageTF.getText());
			String text =  textTF.getText();
			int item = Integer.parseInt(poolIdCB.getItemAt(poolCB.getSelectedIndex()));
			
			connC = DBHelper.getConnection();
			try {
				stateC = connC.prepareStatement("insert into responsible values(null, ?, ?, ?, ?, ?);");
				stateC.setString(1, fname);
				stateC.setString(2, lname);
				stateC.setInt(3, age);
				stateC.setString(4, text);
				stateC.setInt(5, item);
				stateC.execute();
				stateC = connC.prepareStatement("select id from responsible order by id desc limit 1");
				result = stateC.executeQuery();
				result.next();
				int pr = Integer.parseInt(result.getObject(1).toString());
				stateC = connC.prepareStatement("update pool set pool_responsible="+pr+" where id="+item);
				stateC.execute();
				tableC.setModel(DBHelper.getAllDataResponsible());
				modelC.removeColumn(modelC.getColumn(0));
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
				DBHelper.fillSearchResponsible(searchComboResponsible);
				DBHelper.fillSearchIdResponsible(searchIdComboResponsible);
				DBHelper.fillPoolCombo(poolCB);
				DBHelper.fillPoolComboId(poolIdCB);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					stateC.close();
					connC.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			clearForm();
		}
   }

	class DeleteActionArea implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			connA = DBHelper.getConnection();
			String sql = "delete from pool where region_name_id=?";
			String sql2 = "delete from region where id=?";
			try {
				stateA = connA.prepareStatement(sql);
				stateA.setInt(1, idA);
				stateA.execute();
				stateA = connA.prepareStatement(sql2);
				stateA.setInt(1, idA);
				stateA.execute();
				tableA.setModel(DBHelper.getAllDataRegion());
				modelA.removeColumn(modelA.getColumn(0));
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
				DBHelper.fillRegionCombo(searchComboRegion);
				DBHelper.fillRegionCombo(regionCB);
				DBHelper.fillRegionComboId(regionIdCB);
				DBHelper.fillSprRegionCombo(chooseComboRegionSpr);
				DBHelper.fillSprRegionComboId(chooseComboIdRegionSpr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class DeleteActionPool implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			connB = DBHelper.getConnection();
			String sql = "delete from pool where id=?";
			try {
				stateB = connB.prepareStatement("update responsible set responsible_pool=null where responsible_pool="+idB);
				stateB.execute();
				stateB = connB.prepareStatement(sql);
				stateB.setInt(1, idB);
				stateB.execute();
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
				DBHelper.fillPoolACombo(searchComboPool);
				DBHelper.fillPoolAComboId(searchIdComboPool);
				DBHelper.fillPoolCombo(poolCB);
				DBHelper.fillPoolComboId(poolIdCB);
				DBHelper.fillSprPoolCombo(chooseComboPoolSpr);
				DBHelper.fillSprPoolComboId(chooseComboIdPoolSpr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	class DeleteActionResponsible implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			connC = DBHelper.getConnection();
			String sql = "delete from responsible where id=?";
			try {
				stateC = connC.prepareStatement("update pool set pool_responsible=null where pool_responsible="+idC);
				stateC.execute();
				stateC = connC.prepareStatement(sql);
				stateC.setInt(1, idC);
				stateC.execute();
				tableC.setModel(DBHelper.getAllDataResponsible());
				modelC.removeColumn(modelC.getColumn(0));
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
				DBHelper.fillSearchResponsible(searchComboResponsible);
				DBHelper.fillSearchIdResponsible(searchIdComboResponsible);
				DBHelper.fillPoolCombo(poolCB);
				DBHelper.fillPoolComboId(poolIdCB);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	class TableAListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==1) {
				int rowA = tableA.getSelectedRow();
				idA = Integer.parseInt(tableA.getModel().getValueAt(rowA, 0).toString());
				
			}
			
			if (e.getClickCount()==2) {
				int rowA = tableA.getSelectedRow();
				idAUpdate = Integer.parseInt(tableA.getModel().getValueAt(rowA, 0).toString());
			}
			
			if (e.getClickCount()==3) {
				tableA.setModel(DBHelper.getAllDataRegion());
				modelA.removeColumn(modelA.getColumn(0));
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class TableBListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==1) {
				int rowB = tableB.getSelectedRow();
				idB = Integer.parseInt(tableB.getModel().getValueAt(rowB, 0).toString());
			}
			
			if (e.getClickCount()==2) {
				int rowB = tableB.getSelectedRow();
				idBUpdate = Integer.parseInt(tableB.getModel().getValueAt(rowB, 0).toString());
			}
			
			if (e.getClickCount()==3) {
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class TableCListener implements MouseListener {

		@Override
		 public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==1) {
				int rowC = tableC.getSelectedRow();
				idC = Integer.parseInt(tableC.getModel().getValueAt(rowC, 0).toString());
			}
			
			if (e.getClickCount()==2) {
				int rowC = tableC.getSelectedRow();
				idCUpdate = Integer.parseInt(tableC.getModel().getValueAt(rowC, 0).toString());
			}
			
			if (e.getClickCount()==3) {
				tableC.setModel(DBHelper.getAllDataResponsible());
				modelC.removeColumn(modelC.getColumn(0));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class UpdateActionArea implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			//String name = nameTF.getText();
			//int area = Integer.parseInt(areaTF.getText());
			//int population = Integer.parseInt(populationTF.getText());
			
			connA = DBHelper.getConnection();
			try {
				stateA = connA.prepareStatement("update region  set name='" + nameTF.getText() +"', area='" + Integer.parseInt(areaTF.getText())
                                                 +"', population='" + Integer.parseInt(populationTF.getText()) +"' where id=?;");
				stateA.setInt(1, idAUpdate);
				stateA.execute();
				tableA.setModel(DBHelper.getAllDataRegion());
				modelA.removeColumn(modelA.getColumn(0));
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
				DBHelper.fillRegionCombo(searchComboRegion);
				DBHelper.fillRegionCombo(regionCB);
				DBHelper.fillRegionComboId(regionIdCB);
				DBHelper.fillSprRegionCombo(chooseComboRegionSpr);
				DBHelper.fillSprRegionComboId(chooseComboIdRegionSpr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearForm();
		}
		
	}
	
	class UpdateActionPool implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			connB = DBHelper.getConnection();
			try {
				stateB = connB.prepareStatement("update pool  set name='" + namePTF.getText() +"', area='" + Integer.parseInt(areaPTF.getText())
				                                 +"', depth='" + Integer.parseInt(depthTF.getText()) +"' where id=?;");
				stateB.setInt(1, idBUpdate);
				stateB.execute();
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
				DBHelper.fillPoolACombo(searchComboPool);
				DBHelper.fillPoolAComboId(searchIdComboPool);
				DBHelper.fillPoolCombo(poolCB);
				DBHelper.fillPoolComboId(poolIdCB);
				DBHelper.fillSprPoolCombo(chooseComboPoolSpr);
				DBHelper.fillSprPoolComboId(chooseComboIdPoolSpr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearForm();
		}
		
	}
	
	class UpdateActionResponsible implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			connC = DBHelper.getConnection();
			try {
				stateC = connC.prepareStatement("update responsible  set fname='" + fnameTF.getText() +"', lname='" + lnameTF.getText()
                                                 +"', age='" + Integer.parseInt(ageTF.getText()) +"', text='" + textTF.getText() +"' where id=?;");
				stateC.setInt(1, idCUpdate);
				stateC.execute();
				tableC.setModel(DBHelper.getAllDataResponsible());
				modelC.removeColumn(modelC.getColumn(0));
				tableB.setModel(DBHelper.getAllDataPool());
				modelB.removeColumn(modelB.getColumn(0));
				DBHelper.fillSearchResponsible(searchComboResponsible);
				DBHelper.fillSearchIdResponsible(searchIdComboResponsible);
				DBHelper.fillPoolCombo(poolCB);
				DBHelper.fillPoolComboId(poolIdCB);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearForm();
		}
		
	}
	
	class SearchActionArea implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int item = Integer.parseInt(searchIdComboRegion.getItemAt(searchComboRegion.getSelectedIndex()));
			
			
			connA = DBHelper.getConnection();
			String sql = "select * from region where id=?";
			try {
				stateA = connA.prepareStatement(sql);
				stateA.setInt(1, item);
				result = stateA.executeQuery();
				tableA.setModel(new MyModel(result));
				modelA.removeColumn(modelA.getColumn(0));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	class SearchActionResponsible implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int item = Integer.parseInt(searchIdComboResponsible.getItemAt(searchComboResponsible.getSelectedIndex()));
			
			connC = DBHelper.getConnection();
			String sql = "select * from responsible where id=?";
			try {
				stateC = connC.prepareStatement(sql);
				stateC.setInt(1, item);
				result = stateC.executeQuery();
				tableC.setModel(new MyModel(result));
				modelC.removeColumn(modelC.getColumn(0));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	class SearchActionPool implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int item = Integer.parseInt(searchIdComboPool.getItemAt(searchComboPool.getSelectedIndex()));
			
			connB = DBHelper.getConnection();
			String sql = "select * from pool where id=?";
			try {
				stateB = connB.prepareStatement(sql);
				stateB.setInt(1, item);
				result = stateB.executeQuery();
				tableB.setModel(new MyModel(result));
				modelB.removeColumn(modelB.getColumn(0));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	class SearchActionSpr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int itemA = Integer.parseInt(chooseComboIdRegionSpr.getItemAt(chooseComboRegionSpr.getSelectedIndex()));
			int itemB = Integer.parseInt(chooseComboIdPoolSpr.getItemAt(chooseComboPoolSpr.getSelectedIndex()));
			
			connC = DBHelper.getConnection();
			String sql = "SELECT pool.ID, POOL.NAME, pool.AREA, DEPTH, REGION.NAME, responsible.fname FROM POOL join region on pool.region_name_id = region.id left join responsible on pool_responsible = responsible.id where pool.id="+itemB+" and region_name_id="+itemA;
			try {
				stateC = connC.prepareStatement(sql);
				result = stateC.executeQuery();
				tableD.setModel(new MyModel(result));
				modelD.removeColumn(modelD.getColumn(0));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}
	
}

