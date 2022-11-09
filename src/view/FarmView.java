package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.FarmDAO;
import model.rec.sidoVO;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ItemListener;
import oracle.net.jdbc.TNSAddress.AddressList;
import java.awt.ScrollPane;




public class FarmView extends JPanel {

	/**
	 * Create the panel.
	 */
	private FarmDAO dao;
	
	private JTable table;
	
	private JPanel panel_2;
	
	private JComboBox cbx_sido;
	private JComboBox cbx_sigungu;
	
	private JButton btn_search;
	private JButton btn_workconn;
	private JButton btn_ed;
	private JButton btn_sell;
	
	private ScrollPane scrollPane;
	
	private sidoTable rsidoTable;
	
	private JPanel panel_1_1;
	
	private JComboBox comboBox;
	private Connection con = null;

    private PreparedStatement ps = null;      

    private ResultSet rs = null;  
    
    
	public FarmView() {
		try {
			dao = new FarmDAO();
			System.out.println("FARM 연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "farm연결 실패 : " + e.getMessage());
		}
		
		setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(36, 10, 520, 526);
		add(panel_2);
		panel_2.setLayout(null);
		
		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(24, 25, 406, 30);
		panel_2.add(panel_1_1);
		
		
		
		
		
		cbx_sido = new JComboBox();
		cbx_sido.setBounds(0, 0, 86, 30);
		panel_1_1.add(cbx_sido);
		cbx_sido.addItem("시.도 선택");
		
		displaySido();
		
		
		cbx_sido.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	if(e.getStateChange()==ItemEvent.SELECTED)
            		System.out.println("아이템!");
					selectSido(cbx_sido.getSelectedItem().toString());
                  

            }

		});

		cbx_sido.setToolTipText("");

  
		
		
		
		
		
		btn_search = new JButton("검색");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb_sido = cbx_sido.getSelectedItem().toString();
				String cb_sigungu = cbx_sigungu.getSelectedItem().toString();
				int sel = comboBox.getSelectedIndex();
				if (sel == 1) {
					try {
						ArrayList list = dao.projSearch(cb_sido, cb_sigungu);
						rsidoTable.data = list;
						table.setModel(rsidoTable);
						rsidoTable.fireTableDataChanged();
						} catch (Exception e2) {
						// TODO: handle exception
			                  JOptionPane.showMessageDialog(null, "이름 검색 실패:" + e2.getMessage());
					}
				}
				else if(sel == 0) {
					try {
						ArrayList list = dao.edubSearch(cb_sido, cb_sigungu);				
						rsidoTable.data = list;
						table.setModel(rsidoTable);
						rsidoTable.fireTableDataChanged();
					} catch (Exception e2) {
					// TODO: handle exception
						}
				}
				
			}
		});
		btn_search.setBounds(326, 0, 68, 30);
		panel_1_1.add(btn_search);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"귀농/귀촌", "일손교류"}));
		comboBox.setBounds(220, 0, 86, 30);
		panel_1_1.add(comboBox);
		
		cbx_sigungu = new JComboBox();
		cbx_sigungu.setBounds(111, 0, 80, 30);
		panel_1_1.add(cbx_sigungu);
		
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(24, 80, 415, 424);
		panel_2.add(scrollPane);
		
		table = new JTable();
//		scrollPane.setViewportView(table);
	
		
		btn_workconn = new JButton("일손교류");
		btn_workconn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_workconn.setBounds(677, 145, 97, 23);
		add(btn_workconn);
		
//		cbx_sigungu.addItemListener(new ItemListener() {
//
//            public void itemStateChanged(ItemEvent e) {
//
//                   if(e.getStateChange()==ItemEvent.SELECTED)
//
//                           selectGugun(cbx_sido.getSelectedItem().toString() ,cbx_sigungu.getSelectedItem().toString());
//
//            }
//
//    });
		
		
		
		btn_ed = new JButton("귀농/귀촌");
		btn_ed.setBounds(568, 145, 97, 23);
		add(btn_ed);
		
		
		btn_sell = new JButton("부동산");
		btn_sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_sell.setBounds(786, 145, 97, 23);
		add(btn_sell);
		
		btn_ed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
//		try {
//			dao = new FarmDAO();
//			System.out.println("비디오 디비 연결 성공");
//		} catch (Exception e) {
//			// TODO: handle exception
//			JOptionPane.showMessageDialog(null, "비디오 DB연결 실패 : " + e.getMessage());
//		}

	}
	
	

	public void displaySido(){
		System.out.println("시도 디스플레이!");

		//선언
		
		FarmDAO dao = new FarmDAO();
		dao.connectDB();
		System.out.println("디비연결");
		ArrayList<sidoVO> sidoList = dao.searchSido();
		System.out.println("리스트확인");

		for(int i = 0 ; i < sidoList.size() ; i++){
 
//      		sidoVO sv = new sidoVO();
    	    
			//ArrayList arr = (ArrayList) sidoList.get(i);
//			sv = sidoList.get(i);
//            cbx_sido.addItem(sidoVO.getSidoName());
//			sidoVO sv = new sidoVO();
			sidoVO sv = sidoList.get(i); 
			cbx_sido.addItem(sv.getSidoName());

			}             

    //DB연결 해제

		dao.disconnectDB();
		

	}
	
	public void selectSido(String sido){

        System.out.println(sido);

        FarmDAO dao = new FarmDAO();

        //DB연결

        dao.connectDB();             

        //

        ArrayList<sidoVO> gugunList = dao.searchGugun(sido);

        cbx_sigungu.removeAllItems();


        cbx_sigungu.addItem("구.군 선택");
        
        for(int i = 0 ; i < gugunList.size() ; i++){

                sidoVO sicode = gugunList.get(i);

                cbx_sigungu.insertItemAt(sicode.getSigunguName(), i);

        }

//        table.setModel(new sidoTable());

        //DB연결 해제

        dao.disconnectDB();

	}
//	void selectTable() {
//	      try {
//	         ArrayList list = dao.sidosearch();
//	         rsidoTable.data = list;
//	         table.setModel(rsidoTable);
//	         rsidoTable.fireTableDataChanged();
//	         
//	      } catch (Exception e) {
//	         // TODO: handle exception
//	         JOptionPane.showMessageDialog(null, "테이블 출력 실패 : " + e.getMessage());
//	      }
//	      
//	   }
	
	class sidoTable extends AbstractTableModel{
		ArrayList data = new ArrayList();
		 String[] columNames = {"동네","프로젝트","시작날짜","끝나는날짜","인 원"};
		
		 public sidoTable() {
			 
		}
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}
		public String getColumnName(int rowIndex) {
			return columNames[rowIndex];
		}
		 
	}
	
}