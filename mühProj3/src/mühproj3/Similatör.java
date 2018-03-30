/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mühproj3;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import javax.swing.JToggleButton;


public class Similatör extends JFrame {

	private JPanel contentPane;
	private LGSpanel lgsPanel = new LGSpanel();
	private toolBox toolbox = new toolBox();
	

	/**
	 * Uygulama başlangıç yeri
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Similatör frame = new Similatör();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ,pencere oluşturma
	 */
	public Similatör() {
		

		tetik();
		
	}
        
        public void tetik(){
            
            setResizable(false);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Murat Can ALBAYRAKLIOĞLU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 800, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 0));
		setContentPane(contentPane);
		
		contentPane.add(lgsPanel, BorderLayout.CENTER);
		lgsPanel.setLayout(null);
		contentPane.add(toolbox, BorderLayout.WEST);
		lgsPanel.setToolbox(toolbox);
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnHelp = new JMenu("Yardım");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("Hakkında");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Bozkurt simülatör, sürüm 1.8.8.1");
			}
		});
		mnHelp.add(mntmAbout);
		
            
            
        }
}
