package view;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.table.AbstractTableModel;

import model.EducationUserDAO;
import model.rec.EducationUserVO;


import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;

public class EducationUserView extends JPanel implements ActionListener {

   public JFrame frame;
   private JTextField tfEducationSearch;
   private JTextField tfebName;
   private JTextField tfebStartDate;
   private JTextField tfebContent;
   private JTextField tfebTarget;
   private JTextField tfebLocation;
   private JTextField tfebEndDate;
   private JTextField tfebParticipants;

   EducationUserDAO dao;
   EducationBusinessModel ebModel;
   AssignModel aModel;
   JComboBox comEducationSearch;
   public JTable eduListTable;
   public JTable assignListTable;
   public JTextField tfUserName;
   JButton btnebInsert;
   private JTable eaListTable;

   /**
    * Launch the application.
    */

   /**
    * Create the application.
    */
   public EducationUserView() {
      try {
         dao = new EducationUserDAO();
         comEducationSearch = new JComboBox();
         ebModel = new EducationBusinessModel();
         aModel = new AssignModel();
         eduListTable = new JTable();
         initialize();
         eventProc();
         System.out.println("????????? ?????? ?????? ??????");
      } catch (Exception e) {
         // TODO: handle exception
         JOptionPane.showMessageDialog(null, "????????? ???????????? ?????? : " + e.getMessage());
      }

   }

   /**
    * Initialize the contents of the frame.
    */
   public void initialize() {
      frame = new JFrame("???????????? ?????????");
      frame.getContentPane().setBackground(new Color(85, 170, 255));
      frame.setBackground(new Color(0, 128, 255));
      frame.setSize(1100, 550);

      // ???????????? ?????? ???????????? ??????
      frame.setLocationRelativeTo(null);

      // ???????????? ????????? ??? ??????????????? ??????????????? ??????
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JLabel lblNewLabel = new JLabel("???????????? ????????? (?????????)");
      lblNewLabel.setBounds(235, 0, 138, 15);
      frame.getContentPane().add(lblNewLabel);

      JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane_2.setBounds(613, 0, 471, 476);
      frame.getContentPane().add(tabbedPane_2);

      JPanel eduInfoPanel = new JPanel();
      tabbedPane_2.addTab("\uAD50\uC721\uC0AC\uC5C5 \uC0C1\uC138\uC815\uBCF4", null, eduInfoPanel, null);
      eduInfoPanel.setBackground(new Color(255, 255, 255));
      eduInfoPanel.setLayout(null);

      JLabel lblNewLabel_3 = new JLabel("\uAD50\uC721\uC774\uB984 : ");
      lblNewLabel_3.setBounds(12, 10, 70, 15);
      eduInfoPanel.add(lblNewLabel_3);

      JLabel lblNewLabel_2 = new JLabel("\uAD50\uC721\uAE30\uAC04 : ");
      lblNewLabel_2.setBounds(12, 60, 70, 15);
      eduInfoPanel.add(lblNewLabel_2);

      JLabel lblNewLabel_2_1 = new JLabel("\uAD50\uC721\uB0B4\uC6A9 : ");
      lblNewLabel_2_1.setBounds(12, 160, 70, 15);
      eduInfoPanel.add(lblNewLabel_2_1);

      JLabel lblNewLabel_2_3 = new JLabel("\uAD50\uC721\uB300\uC0C1 : ");
      lblNewLabel_2_3.setBounds(12, 265, 70, 15);
      eduInfoPanel.add(lblNewLabel_2_3);

      JLabel lblNewLabel_2_4 = new JLabel("\uAD50\uC721\uC9C0\uC5ED : ");
      lblNewLabel_2_4.setBounds(12, 315, 70, 15);
      eduInfoPanel.add(lblNewLabel_2_4);

      tfebName = new JTextField();
      tfebName.setBounds(80, 7, 373, 21);
      eduInfoPanel.add(tfebName);
      tfebName.setColumns(10);

      tfebStartDate = new JTextField();
      tfebStartDate.setBounds(81, 57, 140, 21);
      tfebStartDate.setColumns(10);
      eduInfoPanel.add(tfebStartDate);

      tfebContent = new JTextField();
      tfebContent.setBounds(80, 160, 373, 71);
      tfebContent.setColumns(10);
      eduInfoPanel.add(tfebContent);

      tfebTarget = new JTextField();
      tfebTarget.setBounds(80, 262, 373, 21);
      tfebTarget.setColumns(10);
      eduInfoPanel.add(tfebTarget);

      tfebLocation = new JTextField();
      tfebLocation.setBounds(80, 312, 373, 21);
      tfebLocation.setColumns(10);
      eduInfoPanel.add(tfebLocation);

      tfebEndDate = new JTextField();
      tfebEndDate.setBounds(313, 57, 140, 21);
      tfebEndDate.setColumns(10);
      eduInfoPanel.add(tfebEndDate);

      JLabel lblNewLabel_4 = new JLabel("~");
      lblNewLabel_4.setBounds(260, 60, 15, 15);
      eduInfoPanel.add(lblNewLabel_4);

      JLabel lblNewLabel_5 = new JLabel("\uAD50\uC721\uC778\uC6D0 : ");
      lblNewLabel_5.setBounds(12, 110, 60, 15);
      eduInfoPanel.add(lblNewLabel_5);

      tfebParticipants = new JTextField();
      tfebParticipants.setBounds(80, 107, 373, 21);
      eduInfoPanel.add(tfebParticipants);
      tfebParticipants.setColumns(10);

      JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane_1.setBounds(153, 42, -32, -53);
      eduInfoPanel.add(tabbedPane_1);

      // ???????????? ????????????
      btnebInsert = new JButton("????????????");
      btnebInsert.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String userName = tfUserName.getText();
            try {
               int row = eduListTable.getSelectedRow();
               int col = 0;
               int eb_Num = (Integer) eduListTable.getValueAt(row, col);
               dao.EducationBusinessAssign(userName, eb_Num);
               selectTable();
               System.out.println("????????????");

            } catch (Exception e1) {
               // TODO Auto-generated catch block
               JOptionPane.showMessageDialog(null, "?????? ?????? : " + e1.getMessage());
            }
         }
         
         void selectTable()
            {
              
               try {
                 dao = new EducationUserDAO();
                 aModel = new AssignModel();
                 String id = tfUserName.getText();
                  ArrayList list = dao.showAssignList(id);
                  aModel.data = list;
                  eaListTable.setModel(aModel);
                  aModel.fireTableDataChanged(); //?????? ???????????? ????????? ???????????????
                  
                  
               } catch (Exception e) {
                  // TODO: handle exception
                  JOptionPane.showMessageDialog(null, "?????? ?????? : " + e.getMessage());

               }
            }

      });
         
      
      
      

      btnebInsert.setBounds(332, 352, 122, 30);
      eduInfoPanel.add(btnebInsert);
      btnebInsert.setBackground(new Color(83, 156, 217));

      JPanel currentPanel = new JPanel();
      currentPanel.setBackground(new Color(255, 255, 255));
      tabbedPane_2.addTab("\uC2E0\uCCAD\uD604\uD669", null, currentPanel, null);
      currentPanel.setLayout(null);

      JButton btnebCancel = new JButton("????????????");
      btnebCancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            if (o == btnebCancel) {
               int row = eaListTable.getSelectedRow();
               int col = 0;
               int er_num = (Integer) eaListTable.getValueAt(row, col);
               try {
                  dao.erCancel(er_num);
                  selectTable();
                  System.out.println("?????? ??????");
                  //selectTable();
               } catch (Exception e1) {
                  // TODO: handle exception
                  System.out.println("?????? ??????" + e1.getMessage());
               }
            }
         }
         void selectTable()
            {
              
               try {
                 dao = new EducationUserDAO();
                 aModel = new AssignModel();
                 String id = tfUserName.getText();
                  ArrayList list = dao.showAssignList(id);
                  aModel.data = list;
                  eaListTable.setModel(aModel);
                  aModel.fireTableDataChanged(); //?????? ???????????? ????????? ???????????????
                  
                  
               } catch (Exception e) {
                  // TODO: handle exception
                  JOptionPane.showMessageDialog(null, "?????? ?????? : " + e.getMessage());

               }
            }

      });
   
      btnebCancel.setBounds(316, 407, 138, 30);
      currentPanel.add(btnebCancel);
      btnebCancel.setBackground(new Color(83, 156, 217));

      JPanel ErPanel = new JPanel();
      ErPanel.setBounds(12, 21, 442, 359);
      currentPanel.add(ErPanel);
      ErPanel.setLayout(null);

      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(12, 10, 418, 339);
      ErPanel.add(scrollPane_1);

      eaListTable = new JTable();
      scrollPane_1.setViewportView(eaListTable);
      try {
    	  String id = tfUserName.getText();
         ArrayList list = dao.showAssignList(id);
         System.out.println(list);
         aModel.data = list;
         eaListTable.setModel(aModel);
      } catch (Exception e) {
         // TODO: handle exception
      }

      JPanel SearchPanel = new JPanel();
      SearchPanel.setBounds(12, 20, 589, 28);
      SearchPanel.setBackground(new Color(255, 255, 255));
      frame.getContentPane().add(SearchPanel);
      SearchPanel.setLayout(null);

      comEducationSearch = new JComboBox();

      comEducationSearch.setBounds(12, 6, 55, 21);
      SearchPanel.add(comEducationSearch);
      comEducationSearch.setModel(
            new DefaultComboBoxModel(new String[] { "\uC81C \uBAA9", "\uAD50\uC721\uB300\uC0C1", "\uB0B4\uC6A9" }));
      comEducationSearch.setSelectedIndex(0);
      comEducationSearch.setToolTipText("");

      tfEducationSearch = new JTextField();
      tfEducationSearch.setBounds(79, 6, 305, 21);
      SearchPanel.add(tfEducationSearch);
      tfEducationSearch.setColumns(10);

      // ?????? ?????? ?????????
      JButton btnSearch = new JButton("??????");
      btnSearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            // TODO Auto-generated method stub
            Object oj = e.getSource();

            if (oj == btnSearch) {
               int sel = comEducationSearch.getSelectedIndex();

               String text = tfEducationSearch.getText();

               try {
                  System.out.println("????????????");
                  ArrayList list = dao.EducationSearch(sel, text);
                  ebModel.data = list;
                  eduListTable.setModel(ebModel);
                  ebModel.fireTableDataChanged();
               } catch (Exception e2) {
                  JOptionPane.showMessageDialog(null, "?????? ?????? ??????:" + e2.getMessage());
               }
            }
         }
      });

      btnSearch.setBounds(396, 5, 97, 23);
      SearchPanel.add(btnSearch);

      JPanel EbPanel = new JPanel();
      EbPanel.setBounds(10, 58, 591, 417);
      frame.getContentPane().add(EbPanel);
      EbPanel.setLayout(null);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(12, 5, 567, 402);
      EbPanel.add(scrollPane);

      eduListTable = new JTable();
      scrollPane.setViewportView(eduListTable);

      try {
         ArrayList list = dao.showEducationList();
         eduListTable.setModel(ebModel);
       //???????????? ?????????
         tfUserName = new JTextField();
         tfUserName.setEnabled(false);
         tfUserName.setBounds(472, -3, 116, 21);
         frame.getContentPane().add(tfUserName);
         tfUserName.setColumns(10);

         JLabel lblNewLabel_1 = new JLabel("???");
         lblNewLabel_1.setBounds(589, 0, 12, 15);
         frame.getContentPane().add(lblNewLabel_1);
         ebModel.data = list;
      } catch (Exception e) {
         // TODO: handle exception
      }
   }

   void eventProc() {
      tfEducationSearch.addActionListener(this);

      eduListTable.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            int row = eduListTable.getSelectedRow();
            int col = 0;
            int eb_num = (Integer) eduListTable.getValueAt(row, col);
            EducationUserVO vo = new EducationUserVO();

            try {
               vo = dao.findByNum(eb_num);
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(null, "?????? ??????" + e2.getMessage());
            }
            tfebName.setText(vo.getName());
            tfebStartDate.setText(vo.getStartDate());
            tfebEndDate.setText(vo.getEndDate());
            tfebContent.setText(vo.getContent());
            tfebTarget.setText(vo.getTarget());
            tfebLocation.setText(String.valueOf(vo.getLocation()));
            tfebParticipants.setText(String.valueOf(vo.getParticipants()));
         }

      });
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub

   }

   private void clearScreen() {
//      tfReviewNum.setText("");
//      tfReviewTitle.setText("");
//      tfReviewContents.setText("");
//      comInsertScore.setSelectedItem("");
   }

   void selectTable() throws Exception {

      
      
      //????????? ????????????
      dao = new EducationUserDAO();
      ebModel = new EducationBusinessModel();
      aModel = new AssignModel();
      
      int sel = comEducationSearch.getSelectedIndex();
      String text = tfEducationSearch.getText();

      try {
         System.out.println("????????????");
         ArrayList list = dao.EducationSearch(sel, text);
         ebModel.data = list;
         eduListTable.setModel(ebModel);
         ebModel.fireTableDataChanged();
      } catch (Exception e2) {
         JOptionPane.showMessageDialog(null, "?????? ?????? ??????:" + e2.getMessage());
      }
   }
}

//??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????

// ???????????? ?????????
class EducationBusinessModel extends AbstractTableModel {

   ArrayList data = new ArrayList();
   String[] columnNames = { "????????????", "?????? ??????", "??????????????????", "??????????????????", "??????????????????", "????????????", "????????????", "??????" };

   public int getColumnCount() {
      return columnNames.length;
   }

   public int getRowCount() {
      return data.size();
   }

   public Object getValueAt(int row, int col) {
      ArrayList temp = (ArrayList) data.get(row);
      return temp.get(col);
   }

   public String getColumnName(int col) {
      return columnNames[col];
   }

}

//???????????? ?????????
class AssignModel extends AbstractTableModel {

   ArrayList data = new ArrayList();
   String[] columnNames = { "????????????", "???????????????", "????????????", "????????????" };

   public int getColumnCount() {
      return columnNames.length;
   }

   public int getRowCount() {
      return data.size();
   }

   public Object getValueAt(int row, int col) {
      ArrayList temp = (ArrayList) data.get(row);
      return temp.get(col);
   }

   public String getColumnName(int col) {
      return columnNames[col];
   }

}