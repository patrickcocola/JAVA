
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Graph.GraphElements.Histogram;
import Graph.GraphContainer.PluggableGraph;

public class PluggableGraphTesterHistogram {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws MalformedURLException, FileNotFoundException {
		
		// Open the file
				Scanner userIn=new Scanner(System.in);
				System.out.println("WHAT YEAR");
				int year=userIn.nextInt();
				String location="";
				if (!(year==2017))
					location="/stats/player?seasonId="+year+"&seasonType=REG&Submit=Go";
				else 
					location="/stats/player";
				URL page = new URL("http", "nfl.com", location);
				
				// Create the Scanner object and scope to the entire main method
				Scanner in = null;
				ArrayList<String> inputdata=new ArrayList<String>();
				try {
					// Try to open the file
					in = new Scanner(page.openStream());
					
					try {
						// Read in the data one line at a time
						File output=new File("output.txt");
						PrintWriter printwriter=new PrintWriter(output);
						String temp;
						boolean stat=true;
						int player=0;
						while(in.hasNextLine()) {
							// Do something with this String
							
							temp=in.nextLine();
							//printwriter.write(temp);
							if (temp.contains("<a href=\"/player/"))
							{
								
								
								printwriter.write(in.nextLine()+"\r\n");
								stat=true;
								while (stat)
								{
									temp=in.nextLine();
									if(temp.contains("<li class=\"stat\">"))
									{
										printwriter.write(in.nextLine()+"\r\n");
										stat=false;
										player++;
									}
								}
								//printwriter.write(in.nextLine());
							stat=true;
							
							
							
							}
						
						}
						printwriter.close();
	
					// Fix anything that broke and clean up
					} catch (NoSuchElementException e) {
						System.err.println("Record Error: " + e.getMessage());
					} catch (IndexOutOfBoundsException e) {
						System.err.println("Parse Error: " + e.getMessage());
					} catch (NumberFormatException e) {
						System.err.println("Data Error: " + e.getMessage());
					} finally {
						in.close();
					}
					
				} catch (IOException e) {
					System.err.println("Stream Unavailable: " + e.getMessage());
				} 
		
		File input=new File("output.txt");
		Scanner inPut=null;
		in=new Scanner(input);
		
		ArrayList <String> inputArray=new ArrayList<String>();
		
		while(in.hasNextLine())
		{
			inputArray.add(in.nextLine().trim());
		}
	
		
		
		
		
		
		
		// Create a chart with some data
		Histogram chart = new Histogram();

		chart.getDataset().addValue(Integer.parseInt(inputArray.get(1)) ,inputArray.get(0), Integer.toString(year));
		chart.getDataset().addValue(Integer.parseInt(inputArray.get(3)) ,inputArray.get(2), Integer.toString(year));
		chart.getDataset().addValue(Integer.parseInt(inputArray.get(5)) ,inputArray.get(4), Integer.toString(year));
		chart.getDataset().addValue(Integer.parseInt(inputArray.get(7)) ,inputArray.get(6), Integer.toString(year));
		chart.getDataset().addValue(Integer.parseInt(inputArray.get(9)) ,inputArray.get(8), Integer.toString(year));
		chart.setTitle("More Football");
		chart.setSubTitle("Passing Yards on Season");
		chart.setHorzAxis("Year");
		chart.setVertAxis("Passing Yards");
		chart.initializeChart();
		
		// Pass in the chart to the pluggable container
		PluggableGraph window = new PluggableGraph(chart);
		window.setPanelComponent(chart.getChartPanel());
		
		// Add a menu to the pluggable application window
		JMenu mnHistogram = new JMenu("Leaders");
		window.getMenuBar().add(mnHistogram);
		
		// Add a menu item to add more data to the graph
		JMenuItem mntmPass = new JMenuItem("Passing");
		mntmPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Histogram chart = new Histogram();
				if (chart != null) {
					
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(1)) ,inputArray.get(0), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(3)) ,inputArray.get(2), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(5)) ,inputArray.get(4), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(7)) ,inputArray.get(6), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(9)) ,inputArray.get(8), Integer.toString(year));
					
					chart.setTitle("More Football");
					chart.setSubTitle("Passing Yards on Season");
					chart.setHorzAxis("Year");
					chart.setVertAxis("Passing Yards");
					
					window.setPanelComponent(chart.getChartPanel());
					window.setVisible(true);
				}
			}
		});
		//
		JMenuItem mntmRush = new JMenuItem("Rushing");
		mntmRush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Histogram chart = new Histogram();
				if (chart != null) {
					
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(11)) ,inputArray.get(10), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(13)) ,inputArray.get(12), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(15)) ,inputArray.get(14), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(17)) ,inputArray.get(16), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(19)) ,inputArray.get(18), Integer.toString(year));
					
					chart.setTitle("More Football");
					chart.setSubTitle("Rushing Yards on Season");
					chart.setHorzAxis("Year");
					chart.setVertAxis("Rushing Yards");
					
					window.setPanelComponent(chart.getChartPanel());
					window.setVisible(true);
				}
			}
		});
		//
		JMenuItem mntmRec = new JMenuItem("Receiving");
		mntmRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Histogram chart = new Histogram();
				if (chart != null) {
					
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(21)) ,inputArray.get(20), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(23)) ,inputArray.get(22), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(25)) ,inputArray.get(24), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(27)) ,inputArray.get(26), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(29)) ,inputArray.get(28), Integer.toString(year));
					
					chart.setTitle("More Football");
					chart.setSubTitle("Receiving Yards on Season");
					chart.setHorzAxis("Year");
					chart.setVertAxis("Receiving Yards");
					
					window.setPanelComponent(chart.getChartPanel());
					window.setVisible(true);
				}
			}
		});
		//
		//
		JMenuItem mntmTack = new JMenuItem("Tackles");
		mntmTack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Histogram chart = new Histogram();
				if (chart != null) {
					
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(31)) ,inputArray.get(30), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(33)) ,inputArray.get(32), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(35)) ,inputArray.get(34), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(37)) ,inputArray.get(36), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(39)) ,inputArray.get(38), Integer.toString(year));
					
					chart.setTitle("More Football");
					chart.setSubTitle("Tackles on Season");
					chart.setHorzAxis("Year");
					chart.setVertAxis("Tackles");
					
					window.setPanelComponent(chart.getChartPanel());
					window.setVisible(true);
				}
			}
		});
		//
		
		JMenuItem mntmSac = new JMenuItem("Sacks");
		mntmSac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Histogram chart = new Histogram();
				if (chart != null) {
					
					chart.getDataset().addValue(Double.parseDouble(inputArray.get(41)) ,inputArray.get(40), Integer.toString(year));
					chart.getDataset().addValue(Double.parseDouble(inputArray.get(43)) ,inputArray.get(42), Integer.toString(year));
					chart.getDataset().addValue(Double.parseDouble(inputArray.get(45)) ,inputArray.get(44), Integer.toString(year));
					chart.getDataset().addValue(Double.parseDouble(inputArray.get(47)) ,inputArray.get(46),Integer.toString(year));
					chart.getDataset().addValue(Double.parseDouble(inputArray.get(49)) ,inputArray.get(48), Integer.toString(year));
					
					chart.setTitle("More Football");
					chart.setSubTitle("Sacks on Season");
					chart.setHorzAxis("Year");
					chart.setVertAxis("Sacks");
					
					window.setPanelComponent(chart.getChartPanel());
					window.setVisible(true);
				}
			}
		});
		//
		JMenuItem mntmInt = new JMenuItem("Interceptions");
		mntmInt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Histogram chart = new Histogram();
				if (chart != null) {
					
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(51)) ,inputArray.get(50), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(53)) ,inputArray.get(52), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(55)) ,inputArray.get(54), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(57)) ,inputArray.get(56), Integer.toString(year));
					chart.getDataset().addValue(Integer.parseInt(inputArray.get(59)) ,inputArray.get(58), Integer.toString(year));
					
					chart.setTitle("More Football");
					chart.setSubTitle("Interceptions on Season");
					chart.setHorzAxis("Year");
					chart.setVertAxis("Interceptions");
					
					window.setPanelComponent(chart.getChartPanel());
					window.setVisible(true);
				}
			}
		});
		mnHistogram.add(mntmPass);
		mnHistogram.add(mntmRush);
		mnHistogram.add(mntmRec);
		mnHistogram.add(mntmTack);
		mnHistogram.add(mntmSac);
		mnHistogram.add(mntmInt);
		window.setVisible(true);

	}

}
