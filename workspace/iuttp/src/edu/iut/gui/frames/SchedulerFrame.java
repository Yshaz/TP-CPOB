package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;


public class SchedulerFrame extends JFrame {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;	
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;
	
	protected void setupUI() {
		
		contentPane = new JPanel();
		layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
		agendaPanelFactory = new AgendaPanelFactory();
		dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
		weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
		monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);
		
		contentPane.add(dayView,ActiveView.DAY_VIEW.name());
		contentPane.add(weekView,ActiveView.WEEK_VIEW.name());
		contentPane.add(monthView,ActiveView.MONTH_VIEW.name());
	
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
		this.setContentPane(splitPane);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile, menuEdit, menuHelp;		
		JMenuItem mILoad, mISave, mIQuit, mIView, mIMonth, mIWeek, mIDay, mIDisplay, mIAbout;
		
		/* File Menu */
		
		menuFile = new JMenu("File");
		
		mILoad = new JMenuItem("Load", KeyEvent.VK_T);
		mILoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mILoad.getAccessibleContext().setAccessibleDescription("Load a file");
		menuFile.add(mILoad);
		
		mISave = new JMenuItem("Save", KeyEvent.VK_T);
		mISave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mISave.getAccessibleContext().setAccessibleDescription("Save the file");
		menuFile.add(mISave);
		
		mIQuit = new JMenuItem("Quit", KeyEvent.VK_T);
		mIQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mIQuit.getAccessibleContext().setAccessibleDescription("Exit the application");
		menuFile.add(mIQuit);
		
		/* Edit Menu */
		
		menuEdit = new JMenu("Edit");
		
		mIView = new JMenuItem("View", KeyEvent.VK_T);
		mIView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuEdit.add(mIView);
		
		mIMonth = new JMenuItem("Month", KeyEvent.VK_T);
		mIMonth.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mIView.add(mIMonth);
		
		mIWeek = new JMenuItem("Week", KeyEvent.VK_T);
		mIWeek.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mIView.add(mIWeek);
		
		mIDay = new JMenuItem("Day", KeyEvent.VK_T);
		mIDay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mIView.add(mIDay);
		
		/* Help Menu */
		
		menuHelp = new JMenu("Help");
		
		mIDisplay = new JMenuItem("Display", KeyEvent.VK_T);
		mIDisplay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuHelp.add(mIDisplay);
		
		mIAbout = new JMenuItem("About", KeyEvent.VK_T);
		mIAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuHelp.add(mIAbout);

		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);

		this.setJMenuBar(menuBar);
		this.pack();
		
		layerLayout.next(contentPane);
	}
	
	public SchedulerFrame() {
		super();
		
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		contentPane = null;
		dayView = null;
		weekView = null;
		monthView = null;
		agendaPanelFactory = null;
		setupUI();

	}
	
	public SchedulerFrame(String title) {
		super(title);
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		setupUI();
	}
	
}
