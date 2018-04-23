package first;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {
	
	private JTextField tNumberOfItems, textField, tMaxWeight, tIsTaken, tPackedItems, tValue, tWeight;
	private JLabel lInstance, lNumberOfItems, lWeights, lValues, lMaxWeight, lNontrivial, lSum, lAlgorithm, lResult, lIsTaken, lPackedItems, lValue, lWeight, lTime;
	private JButton bSum, bDraw, bSolve, bClose;
	private ButtonGroup bgAlgorithm;
	private JRadioButton rbAlgNP1, rbAlgNP2, rbLibrary;
	private ArrayList<JTextField> tWeights, tValues;
	
	private int numberOfItems = 4;
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public GUI() {
		setSize(1400,400);
		setTitle("Knapsack problem solving");
		setLayout(null);
		
		lInstance = new JLabel("Instance", JLabel.LEFT);
		lInstance.setBounds(30, 10, 50, 20);
		add(lInstance);
		
		lNumberOfItems = new JLabel("number of items:", JLabel.LEFT);
		lNumberOfItems.setBounds(10, 30, 130, 20);
		add(lNumberOfItems);
		
		tNumberOfItems = new JTextField(""+getNumberOfItems());
		tNumberOfItems.setBounds(130, 30, 20, 20);
		tNumberOfItems.setToolTipText("at most 20");
		add(tNumberOfItems);
		
		lWeights = new JLabel("weights:", JLabel.LEFT);
		lWeights.setBounds(10, 50, 150, 20);
		add(lWeights);
		
		tWeights = new ArrayList<JTextField>();
		for (int i=0; i < 35; i++) {
			textField = new JTextField();
			textField.setBounds(130 + i*35, 50, 35, 20);
			add(textField);
			textField.addActionListener(this);
		    tWeights.add(textField);
		}
		
		lValues = new JLabel("values:", JLabel.LEFT);
		lValues.setBounds(10, 70, 150, 20);
		add(lValues);
		
		tValues = new ArrayList<JTextField>();
		for (int i=0; i < 35; i++) {
			textField = new JTextField();
			textField.setBounds(130 + i*35, 70, 35, 20);
			add(textField);
		    tValues.add(textField);
		}
		
		lMaxWeight = new JLabel("capacity:", JLabel.LEFT);
		lMaxWeight.setBounds(10, 90, 150, 20);
		add(lMaxWeight);
		
		tMaxWeight = new JTextField("5");
		tMaxWeight.setBounds(130, 90, 30, 20);
		tMaxWeight.setToolTipText("maximal weight of knapsack");
		add(tMaxWeight);
		
		lNontrivial = new JLabel("For nontrivial solution choose less than sum of all weights.");
		lNontrivial.setBounds(190, 90, 350, 20);
		add(lNontrivial);
		
		bSum = new JButton("Sum of weights:");
		bSum.setBounds(340, 110, 140, 20);
		bSum.addActionListener(this);
		add(bSum);
		
		lSum = new JLabel();
		lSum.setBounds(480, 110, 140, 20);
		add(lSum);
		
		lAlgorithm = new JLabel("Algorithm:");
		lAlgorithm.setBounds(10, 130, 150, 20);
		add(lAlgorithm);
		
		bgAlgorithm = new ButtonGroup();
		rbAlgNP1 = new JRadioButton("first", true);
		rbAlgNP1.setBounds(130, 130, 80, 20);
		bgAlgorithm.add(rbAlgNP1);
		rbAlgNP1.setToolTipText("a pseudo-polynomial time algorithm using dynamic programming");
		add(rbAlgNP1);	
		
		rbAlgNP2 = new JRadioButton("second", false);
		rbAlgNP2.setBounds(230, 130, 80, 20);
		bgAlgorithm.add(rbAlgNP2);
		rbAlgNP2.setToolTipText("a backtracking algorithm with recurency");
		add(rbAlgNP2);
		
		rbLibrary = new JRadioButton("third", false);
		rbLibrary.setBounds(310, 130, 80, 20);
		bgAlgorithm.add(rbLibrary);
		rbLibrary.setToolTipText("an algorithm found in java libraries");
		add(rbLibrary);
		
		bDraw = new JButton("Draw");
		bDraw.setBounds(10, 160, 80, 20);
		bDraw.addActionListener(this);
		add(bDraw);
		
		bSolve = new JButton("Solve");
		bSolve.setBounds(200, 160, 80, 20);
		bSolve.addActionListener(this);
		add(bSolve);
		
		bClose = new JButton("Close");
		bClose.setBounds(390, 160, 80, 20);
		bClose.addActionListener(this);
		add(bClose);
		
		lResult = new JLabel("Result", JLabel.LEFT);
		lResult.setBounds(30, 190, 150, 20);
		add(lResult);
		
		lIsTaken = new JLabel("Is ith item taken:", JLabel.LEFT);
		lIsTaken.setBounds(10, 210, 150, 20);
		add(lIsTaken);
		
		tIsTaken = new JTextField();
		tIsTaken.setBounds(130, 210, 800, 20);
		add(tIsTaken);
		
		lPackedItems = new JLabel("packed items:", JLabel.LEFT);
		lPackedItems.setBounds(10, 230, 150, 20);
		add(lPackedItems);
		
		tPackedItems = new JTextField();
		tPackedItems.setBounds(130, 230, 800, 20);
		add(tPackedItems);
		
		lValue = new JLabel("value of knapsack:", JLabel.LEFT);
		lValue.setBounds(10, 250, 150, 20);
		add(lValue);
		
		tValue = new JTextField();
		tValue.setBounds(130, 250, 120, 20);
		add(tValue);
		
		lWeight = new JLabel("weight of knapsack:", JLabel.LEFT);
		lWeight.setBounds(10, 270, 150, 20);
		add(lWeight);
		
		tWeight = new JTextField();
		tWeight.setBounds(130, 270, 80, 20);
		add(tWeight);
		
		lTime  = new JLabel("estimated runtime:", JLabel.LEFT);
		lTime.setBounds(10, 290, 350, 20);
		add(lTime);	
	}	
	
	public static void main(String[] args) {
		GUI app = new GUI();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		Object source = e.getSource();
		if (source == bClose)
			dispose();
		else if (source == bDraw) {
			System.out.println("Draw");
			setNumberOfItems(Integer.parseInt(tNumberOfItems.getText()));
			Instance instance = new Instance();
			instance.drawGUIInstance(numberOfItems);
			tNumberOfItems.setText(""+numberOfItems);
			int[] weights = instance.getWeights();
			double[] values = instance.getValues();
			for(i=0; i<numberOfItems; ++i) {
				tWeights.get(i).setText(String.valueOf(weights[i]));
				tValues.get(i).setText(String.valueOf(values[i]));
			}
			tMaxWeight.setText(""+instance.maxWeight);
		}
		else if (source == bSum || source == tWeights.get(numberOfItems-1)) {
			int sumOfWeights = 0;
			for(i=0; i<numberOfItems; ++i)
				sumOfWeights+=Integer.parseInt(tWeights.get(i).getText());
			lSum.setText(""+sumOfWeights);
		}
			
		else if (source == bSolve) {
			setNumberOfItems(Integer.parseInt(tNumberOfItems.getText()));
			Instance instance = new Instance(numberOfItems);
			
			int[] weights = new int[numberOfItems];			
			for (i=0; i<numberOfItems; ++i)
				weights[i] = Integer.parseInt(tWeights.get(i).getText());
			instance.setWeights(weights);
			
			double[] values = new double[numberOfItems];
			for (i=0; i<numberOfItems; ++i)
				values[i] = Double.parseDouble(tValues.get(i).getText());
			instance.setValues(values);
			
			instance.setMaxWeight(Integer.parseInt(tMaxWeight.getText()));
			
			Result result;
			
			if(rbAlgNP1.isSelected()) {
				result = AlgNP1.algNP1(instance);
				System.out.println(numberOfItems+" first  "+result.getRuntime()/1000000.0);
			}
			else if(rbAlgNP2.isSelected()) {
				result = AlgNP2.algNP2(instance);
				System.out.println(numberOfItems+" second "+result.getRuntime()/1000000.0);
			}
			else {
				result = Library.library(instance);
				System.out.println(numberOfItems+" third  "+result.getRuntime()/1000000.0);
			}
						
			tIsTaken.setText(Arrays.toString(result.getSolution()));
			tPackedItems.setText(String.valueOf(result.getPackedItems()));			
			tValue.setText(""+result.getValue());
			tWeight.setText(""+result.getWeight());
			lTime.setText("It took "+result.getRuntime()/1000000.0+" miliseconds.");		
		}
		
		
	}

}
