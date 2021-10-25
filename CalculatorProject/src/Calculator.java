import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame{
    private JTextField textField1;
    private JPanel fullArea, mainArea, textArea, digitsArea, topDigitsArea, bottomDigitsArea, buttonsArea, operationsArea;
    private JButton buttonTwoPowerX, buttonXPowerThree, buttonThreeRootX, buttonCos, buttonCosh, buttonSciNotation,
            buttonReciprocal, buttonFactorial, buttonRadians, buttonXPowerTwo, buttonTwoRootX, buttonSin, buttonSinh,
            buttonClear, buttonPosNeg, buttonPercentage, buttonDivide, buttonXPowerY, buttonYrootX, buttonTan, buttonTanh,
            buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonZero, buttonFullstop, buttonEquals,
            buttonAddition, buttonMinus, buttonMultiply, buttonNine, buttonEight, buttonSeven, buttonTenPowerX, buttonLogBaseTen,
            buttonPi, buttonEulersNumber, buttonModulus, buttonRandomZeroAndOne, buttonEPowerX, buttonLn;
    private Font textFieldFont;
    private Font calculatorFont;
    double firstNumber;
    double secondNumber;
    double operationResult;
    int operationSign;
    boolean operationSignSingle = false;

    public Calculator() {
        fullArea = new JPanel();
        fullArea.setBackground(new Color(3289650));
        BoxLayout boxVertical = new BoxLayout(fullArea, BoxLayout.Y_AXIS);
        fullArea.setLayout(boxVertical);

        textField1 = new JTextField();
        Font textFieldFont = new Font("SansSerif", Font.BOLD, 25);
        textField1.setFont(textFieldFont);
        textField1.setHorizontalAlignment(JTextField.RIGHT);
        textField1.setForeground(new Color(-1));
        textField1.setBackground(new Color(3289650));
        textField1.setPreferredSize(new Dimension(0,75));

        textArea = new JPanel();
        textArea.setOpaque(false);
        textArea.setLayout(new GridLayout(1, 1));
        textArea.add(textField1);

        Font calculatorFont = new Font("Helvetica", Font.PLAIN, 15);

        buttonsArea = new JPanel();
        buttonsArea.setOpaque(false);
        buttonsArea.setLayout(new GridLayout(5, 5, 2, 2));

        topDigitsArea = new JPanel();
        topDigitsArea.setOpaque(false);
        topDigitsArea.setLayout(new GridLayout(3, 3, 2, 2));

        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        bottomDigitsArea = new JPanel();
        bottomDigitsArea.setOpaque(false);
        bottomDigitsArea.setLayout(gridBag);
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(1, 1, 1, 0);

        digitsArea = new JPanel();
        digitsArea.setOpaque(false);
        BoxLayout digitsBoxVertical = new BoxLayout(digitsArea, BoxLayout.Y_AXIS);
        digitsArea.setLayout(digitsBoxVertical);
        digitsArea.add(topDigitsArea);
        digitsArea.add(bottomDigitsArea);

        operationsArea = new JPanel();
        operationsArea.setOpaque(false);
        operationsArea.setLayout(new GridLayout(5, 1, 2, 2));

        mainArea = new JPanel();
        mainArea.setOpaque(false);
        BoxLayout boxHorizontal = new BoxLayout(mainArea, BoxLayout.X_AXIS);
        mainArea.setLayout(boxHorizontal);
        mainArea.add(buttonsArea);
        mainArea.add(Box.createRigidArea(new Dimension(1, 0)));
        mainArea.add(digitsArea);
        mainArea.add(Box.createRigidArea(new Dimension(1, 0)));
        mainArea.add(operationsArea);

        JButton buttonRadians = new JButton("Rad");
        buttonRadians.setBackground(new Color(-11711155));
        buttonRadians.setMargin(new Insets(5,5,5,5));
        buttonRadians.setFont(calculatorFont);
        buttonRadians.setForeground(new Color(-1));
        buttonRadians.setText("Rad");
        buttonRadians.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        if(e.getSource() == buttonRadians)
                        {
                            if(buttonRadians.getText().equals("Rad")) {
                                buttonRadians.setText("Deg");
                                textField1.setText("" + Math.toRadians(firstNumber));
                            }
                            else {
                                buttonRadians.setText("Rad");
                                textField1.setText("" + Math.toDegrees(firstNumber));
                            }
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonRadians);

        JButton buttonTwoPowerX = new JButton();
        buttonTwoPowerX.setBackground(new Color(-11711155));
        buttonTwoPowerX.setMargin(new Insets(5,5,5,5));
        buttonTwoPowerX.setFont(calculatorFont);
        buttonTwoPowerX.setForeground(new Color(-1));
        buttonTwoPowerX.setText("2^x");
        buttonTwoPowerX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = Math.pow(2, firstNumber);
                        textField1.setText("" + operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonTwoPowerX);

        JButton buttonSciNotation = new JButton();
        buttonSciNotation.setBackground(new Color(-11711155));
        buttonSciNotation.setMargin(new Insets(5,5,5,5));
        buttonSciNotation.setFont(calculatorFont);
        buttonSciNotation.setForeground(new Color(-1));
        buttonSciNotation.setText("EE");
        buttonSciNotation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        textField1.setText("");
                        operationSign = 7;
                        operationSignSingle = !operationSignSingle;
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonSciNotation);

        JButton buttonFactorial = new JButton();
        buttonFactorial.setBackground(new Color(-11711155));
        buttonFactorial.setMargin(new Insets(5,5,5,5));
        buttonFactorial.setFont(calculatorFont);
        buttonFactorial.setForeground(new Color(-1));
        buttonFactorial.setText("x!");
        buttonFactorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        int factorial = 1;
                        int i;
                        firstNumber=Double.parseDouble(textField1.getText());
                        for(i = 1; i <= firstNumber; i++){
                            factorial = factorial * i;
                        }
                        textField1.setText(String.valueOf(factorial));
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonFactorial);

        JButton buttonReciprocal = new JButton();
        buttonReciprocal.setBackground(new Color(-11711155));
        buttonReciprocal.setMargin(new Insets(5,5,5,5));
        buttonReciprocal.setFont(calculatorFont);
        buttonReciprocal.setForeground(new Color(-1));
        buttonReciprocal.setText("1/x");
        buttonReciprocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("1/x")) {
                            textField1.setText("" + 1/(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonReciprocal);

        JButton buttonXPowerTwo = new JButton();
        buttonXPowerTwo.setBackground(new Color(-11711155));
        buttonXPowerTwo.setMargin(new Insets(5,5,5,5));
        buttonXPowerTwo.setFont(calculatorFont);
        buttonXPowerTwo.setForeground(new Color(-1));
        buttonXPowerTwo.setText("x^2");
        buttonXPowerTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = Math.pow(firstNumber, 2);
                        textField1.setText("" + operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonXPowerTwo);

        JButton buttonXPowerThree = new JButton();
        buttonXPowerThree.setBackground(new Color(-11711155));
        buttonXPowerThree.setMargin(new Insets(5,5,5,5));
        buttonXPowerThree.setFont(calculatorFont);
        buttonXPowerThree.setForeground(new Color(-1));
        buttonXPowerThree.setText("x^3");
        buttonXPowerThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = Math.pow(firstNumber, 3);
                        textField1.setText(""+ operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonXPowerThree);

        JButton buttonXPowerY = new JButton();
        buttonXPowerY.setBackground(new Color(-11711155));
        buttonXPowerY.setMargin(new Insets(5,5,5,5));
        buttonXPowerY.setFont(calculatorFont);
        buttonXPowerY.setForeground(new Color(-1));
        buttonXPowerY.setText("x^y");
        buttonXPowerY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationSign = 5;
                        operationSignSingle = !operationSignSingle;
                        textField1.setText("");
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonXPowerY);

        JButton buttonEPowerX = new JButton();
        buttonEPowerX.setBackground(new Color(-11711155));
        buttonEPowerX.setMargin(new Insets(5,5,5,5));
        buttonEPowerX.setFont(calculatorFont);
        buttonEPowerX.setForeground(new Color(-1));
        buttonEPowerX.setText("e^x");
        buttonEPowerX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = Math.exp(firstNumber);
                        textField1.setText(""+ operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonEPowerX);

        JButton buttonTenPowerX = new JButton();
        buttonTenPowerX.setBackground(new Color(-11711155));
        buttonTenPowerX.setMargin(new Insets(5,5,5,5));
        buttonTenPowerX.setFont(calculatorFont);
        buttonTenPowerX.setForeground(new Color(-1));
        buttonTenPowerX.setText("10^x");
        buttonTenPowerX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = Math.pow(10, firstNumber);
                        textField1.setText(""+ operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonTenPowerX);

        JButton buttonTwoRootX = new JButton();
        buttonTwoRootX.setBackground(new Color(-11711155));
        buttonTwoRootX.setMargin(new Insets(5,5,5,5));
        buttonTwoRootX.setFont(calculatorFont);
        buttonTwoRootX.setForeground(new Color(-1));
        buttonTwoRootX.setText("√x");
        buttonTwoRootX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("√x")) {
                            textField1.setText("" +Math.sqrt(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonTwoRootX);

        JButton buttonThreeRootX = new JButton();
        buttonThreeRootX.setBackground(new Color(-11711155));
        buttonThreeRootX.setMargin(new Insets(5,5,5,5));
        buttonThreeRootX.setFont(calculatorFont);
        buttonThreeRootX.setForeground(new Color(-1));
        buttonThreeRootX.setText("3√x");
        buttonThreeRootX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("3√x")) {
                            textField1.setText("" +Math.cbrt(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonThreeRootX);

        JButton buttonYrootX = new JButton();
        buttonYrootX.setBackground(new Color(-11711155));
        buttonYrootX.setMargin(new Insets(5,5,5,5));
        buttonYrootX.setFont(calculatorFont);
        buttonYrootX.setForeground(new Color(-1));
        buttonYrootX.setText("y√x");
        buttonYrootX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationSign = 6;
                        operationSignSingle = !operationSignSingle;
                        textField1.setText("");
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonYrootX);

        JButton buttonLn = new JButton();
        buttonLn.setBackground(new Color(-11711155));
        buttonLn.setMargin(new Insets(5,5,5,5));
        buttonLn.setFont(calculatorFont);
        buttonLn.setForeground(new Color(-1));
        buttonLn.setText("ln");
        buttonLn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = Math.log1p(firstNumber);
                        textField1.setText(""+ operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonLn);

        JButton buttonLogBaseTen = new JButton();
        buttonLogBaseTen.setBackground(new Color(-11711155));
        buttonLogBaseTen.setMargin(new Insets(5,5,5,5));
        buttonLogBaseTen.setFont(calculatorFont);
        buttonLogBaseTen.setForeground(new Color(-1));
        buttonLogBaseTen.setText("log10");
        buttonLogBaseTen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = Math.log10(firstNumber);
                        textField1.setText(""+ operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonLogBaseTen);

        JButton buttonSin = new JButton();
        buttonSin.setBackground(new Color(-11711155));
        buttonSin.setMargin(new Insets(5,5,5,5));
        buttonSin.setFont(calculatorFont);
        buttonSin.setForeground(new Color(-1));
        buttonSin.setText("sin");
        buttonSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("sin")) {
                            textField1.setText("" +Math.sin(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonSin);

        JButton buttonCos = new JButton();
        buttonCos.setBackground(new Color(-11711155));
        buttonCos.setMargin(new Insets(5,5,5,5));
        buttonCos.setFont(calculatorFont);
        buttonCos.setForeground(new Color(-1));
        buttonCos.setText("cos");
        buttonCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("cos")) {
                            textField1.setText("" +Math.cos(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonCos);

        JButton buttonTan = new JButton();
        buttonTan.setBackground(new Color(-11711155));
        buttonTan.setMargin(new Insets(5,5,5,5));
        buttonTan.setFont(calculatorFont);
        buttonTan.setForeground(new Color(-1));
        buttonTan.setText("tan");
        buttonTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("tan")) {
                            textField1.setText("" +Math.tan(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonTan);

        JButton buttonEulersNumber = new JButton();
        buttonEulersNumber.setBackground(new Color(-11711155));
        buttonEulersNumber.setMargin(new Insets(5,5,5,5));
        buttonEulersNumber.setFont(calculatorFont);
        buttonEulersNumber.setForeground(new Color(-1));
        buttonEulersNumber.setText("e");
        buttonEulersNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Math.exp(1.0);
                textField1.setText(""+ firstNumber);
            }
        });
        buttonsArea.add(buttonEulersNumber);

        JButton buttonModulus = new JButton();
        buttonModulus.setBackground(new Color(-11711155));
        buttonModulus.setMargin(new Insets(5,5,5,5));
        buttonModulus.setFont(calculatorFont);
        buttonModulus.setForeground(new Color(-1));
        buttonModulus.setText("Mod");
        buttonModulus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textField1.getText().equals("")) {
                        throw new ArithmeticException();
                    } else {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationSign = 8;
                        operationSignSingle = !operationSignSingle;
                        textField1.setText("");
                    }
                } catch (ArithmeticException exception) {
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonModulus);

        JButton buttonSinh = new JButton();
        buttonSinh.setBackground(new Color(-11711155));
        buttonSinh.setMargin(new Insets(5,5,5,5));
        buttonSinh.setFont(calculatorFont);
        buttonSinh.setForeground(new Color(-1));
        buttonSinh.setText("sinh");
        buttonSinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("sinh")) {
                            textField1.setText("" + Math.sinh(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonSinh);

        JButton buttonCosh = new JButton();
        buttonCosh.setBackground(new Color(-11711155));
        buttonCosh.setMargin(new Insets(5,5,5,5));
        buttonCosh.setFont(calculatorFont);
        buttonCosh.setForeground(new Color(-1));
        buttonCosh.setText("cosh");
        buttonCosh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("cosh")) {
                            textField1.setText("" +Math.cosh(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonCosh);

        JButton buttonTanh = new JButton();
        buttonTanh.setBackground(new Color(-11711155));
        buttonTanh.setMargin(new Insets(5,5,5,5));
        buttonTanh.setFont(calculatorFont);
        buttonTanh.setForeground(new Color(-1));
        buttonTanh.setText("tanh");
        buttonTanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        String displayText  = textField1.getText();
                        if (e.getActionCommand().equals("tanh")) {
                            textField1.setText("" +Math.tanh(Double.valueOf(displayText).doubleValue()));
                        }
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        buttonsArea.add(buttonTanh);

        JButton buttonPi = new JButton();
        buttonPi.setBackground(new Color(-11711155));
        buttonPi.setMargin(new Insets(5,5,5,5));
        buttonPi.setFont(calculatorFont);
        buttonPi.setForeground(new Color(-1));
        buttonPi.setText("π");
        buttonPi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Math.PI * (1);
                textField1.setText(""+ firstNumber);
            }
        });
        buttonsArea.add(buttonPi);

        JButton buttonRandomZeroAndOne = new JButton();
        buttonRandomZeroAndOne.setBackground(new Color(-11711155));
        buttonRandomZeroAndOne.setMargin(new Insets(5,5,5,5));
        buttonRandomZeroAndOne.setFont(calculatorFont);
        buttonRandomZeroAndOne.setForeground(new Color(-1));
        buttonRandomZeroAndOne.setText("Rand");
        buttonRandomZeroAndOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Math.random();
                textField1.setText(textField1.getText() + firstNumber);
            }
        });
        buttonsArea.add(buttonRandomZeroAndOne);

        // top digits area
        JButton buttonClear = new JButton();
        buttonClear.setBackground(new Color(-11711155));
        buttonClear.setMargin(new Insets(5,15,5,15));
        buttonClear.setFont(calculatorFont);
        buttonClear.setForeground(new Color(-1));
        buttonClear.setText("C");
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
            }
        });
        topDigitsArea.add(buttonClear);

        JButton buttonPosNeg = new JButton();
        buttonPosNeg.setBackground(new Color(-11711155));
        buttonPosNeg.setMargin(new Insets(5,15,5,15));
        buttonPosNeg.setFont(calculatorFont);
        buttonPosNeg.setForeground(new Color(-1));
        buttonPosNeg.setText("+/-");
        buttonPosNeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = firstNumber * -1;
                        textField1.setText(""+ operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        topDigitsArea.add(buttonPosNeg);

        JButton buttonPercentage = new JButton();;
        buttonPercentage.setBackground(new Color(-11711155));
        buttonPercentage.setMargin(new Insets(5,15,5,15));
        buttonPercentage.setFont(calculatorFont);
        buttonPercentage.setForeground(new Color(-1));
        buttonPercentage.setText("%");
        buttonPercentage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationResult = firstNumber/100;
                        textField1.setText(""+ operationResult);
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        topDigitsArea.add(buttonPercentage);

        JButton buttonSeven = new JButton();
        buttonSeven.setBackground(new Color(-6513508));
        buttonSeven.setMargin(new Insets(5,15,5,15));
        buttonSeven.setForeground(new Color(-1));
        buttonSeven.setFont(calculatorFont);
        buttonSeven.setText("7");
        buttonSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "7");
            }
        });
        topDigitsArea.add(buttonSeven);

        JButton buttonEight = new JButton();
        buttonEight.setBackground(new Color(-6513508));
        buttonEight.setMargin(new Insets(5,15,5,15));
        buttonEight.setForeground(new Color(-1));
        buttonEight.setFont(calculatorFont);
        buttonEight.setText("8");
        buttonEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "8");
            }
        });
        topDigitsArea.add(buttonEight);

        JButton buttonNine = new JButton();
        buttonNine.setBackground(new Color(-6513508));
        buttonNine.setMargin(new Insets(5,15,5,15));
        buttonNine.setForeground(new Color(-1));
        buttonNine.setFont(calculatorFont);
        buttonNine.setText("9");
        buttonNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "9");
            }
        });
        topDigitsArea.add(buttonNine);

        JButton buttonFour = new JButton();
        buttonFour.setBackground(new Color(-6513508));
        buttonFour.setMargin(new Insets(5,15,5,15));
        buttonFour.setForeground(new Color(-1));
        buttonFour.setFont(calculatorFont);
        buttonFour.setText("4");
        buttonFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "4");
            }
        });
        topDigitsArea.add(buttonFour);

        JButton buttonFive = new JButton();
        buttonFive.setBackground(new Color(-6513508));
        buttonFive.setMargin(new Insets(5,15,5,15));
        buttonFive.setForeground(new Color(-1));
        buttonFive.setFont(calculatorFont);
        buttonFive.setText("5");
        buttonFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "5");
            }
        });
        topDigitsArea.add(buttonFive);

        JButton buttonSix = new JButton();
        buttonSix.setBackground(new Color(-6513508));
        buttonSix.setMargin(new Insets(5,15,5,15));
        buttonSix.setForeground(new Color(-1));
        buttonSix.setFont(calculatorFont);
        buttonSix.setText("6");
        buttonSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "6");
            }
        });
        topDigitsArea.add(buttonSix);

        JButton buttonOne = new JButton();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        gridBag.setConstraints(buttonOne, c);
        buttonOne.setBackground(new Color(-6513508));
        buttonOne.setMargin(new Insets(5,15,5,15));
        buttonOne.setForeground(new Color(-1));
        buttonOne.setFont(calculatorFont);
        buttonOne.setText("1");
        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "1");
            }
        });
        bottomDigitsArea.add(buttonOne);

        JButton buttonTwo = new JButton();
        c.gridx = 1;
        gridBag.setConstraints(buttonTwo, c);
        buttonTwo.setBackground(new Color(-6513508));
        buttonTwo.setMargin(new Insets(5,15,5,15));
        buttonTwo.setForeground(new Color(-1));
        buttonTwo.setFont(calculatorFont);
        buttonTwo.setText("2");
        buttonTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "2");
            }
        });
        bottomDigitsArea.add(buttonTwo);

        JButton buttonThree = new JButton();
        c.gridx = 2;
        gridBag.setConstraints(buttonThree, c);
        buttonThree.setBackground(new Color(-6513508));
        buttonThree.setMargin(new Insets(5,15,5,15));
        buttonThree.setForeground(new Color(-1));
        buttonThree.setFont(calculatorFont);
        buttonThree.setText("3");
        buttonThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "3");
            }
        });
        bottomDigitsArea.add(buttonThree);

        JButton buttonZero = new JButton();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        gridBag.setConstraints(buttonZero, c);
        buttonZero.setBackground(new Color(-6513508));
        buttonZero.setForeground(new Color(-1));
        buttonZero.setFont(calculatorFont);
        buttonZero.setText("0");
        buttonZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + "0");
            }
        });
        bottomDigitsArea.add(buttonZero);

        JButton buttonFullstop = new JButton();
        c.gridx = 2;
        c.gridwidth = 1;
        gridBag.setConstraints(buttonFullstop, c);
        buttonFullstop.setBackground(new Color(-6513508));
        buttonFullstop.setForeground(new Color(-1));
        buttonFullstop.setFont(calculatorFont);
        buttonFullstop.setText(".");
        buttonFullstop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + ".");
            }
        });
        bottomDigitsArea.add(buttonFullstop);

        // operation buttons
        JButton buttonDivide = new JButton();
        buttonDivide.setBackground(new Color(-417245));
        buttonDivide.setMargin(new Insets(5,15,5,15));
        buttonDivide.setFont(calculatorFont);
        buttonDivide.setForeground(new Color(-1));
        buttonDivide.setText("÷");
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationSign = 1;
                        operationSignSingle = !operationSignSingle;
                        textField1.setText("");
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        operationsArea.add(buttonDivide);

        JButton buttonMultiply = new JButton();
        buttonMultiply.setBackground(new Color(-417245));
        buttonMultiply.setMargin(new Insets(5,15,5,15));
        buttonMultiply.setFont(calculatorFont);
        buttonMultiply.setForeground(new Color(-1));
        buttonMultiply.setText("×");
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationSign = 2;
                        operationSignSingle = !operationSignSingle;
                        textField1.setText("");
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        operationsArea.add(buttonMultiply);

        JButton buttonMinus = new JButton();
        buttonMinus.setBackground(new Color(-417245));
        buttonMinus.setMargin(new Insets(5,15,5,15));
        buttonMinus.setFont(calculatorFont);
        buttonMinus.setForeground(new Color(-1));
        buttonMinus.setText("-");
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationSign = 3;
                        operationSignSingle = !operationSignSingle;
                        textField1.setText("");
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        operationsArea.add(buttonMinus);

        JButton buttonAddition = new JButton();
        buttonAddition.setBackground(new Color(-417245));
        buttonAddition.setMargin(new Insets(5,15,5,15));
        buttonAddition.setFont(calculatorFont);
        buttonAddition.setForeground(new Color(-1));
        buttonAddition.setText("+");
        buttonAddition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textField1.getText());
                        operationSign = 4;
                        operationSignSingle = !operationSignSingle;
                        textField1.setText("");
                    }
                }
                catch(ArithmeticException exception){
                    textField1.setText("ERROR: NO NUMBER INPUT");
                }
            }
        });
        operationsArea.add(buttonAddition);

        JButton buttonEquals = new JButton();
        buttonEquals.setBackground(new Color(-417245));
        buttonEquals.setForeground(new Color(-1));
        buttonEquals.setText("=");
        buttonEquals.setMargin(new Insets(5,15,5,15));
        buttonEquals.setFont(calculatorFont);
        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(textField1.getText().equals("")){
                        throw new ArithmeticException();
                    }
                    else
                    {
                        secondNumber = Double.parseDouble(textField1.getText());
                        try {
                            if (operationSignSingle == false) {
                                throw new ArithmeticException();
                            }
                            else {
                                switch (operationSign) {
                                    case 1: // x / y
                                        try {
                                            if (secondNumber == 0) {
                                                throw new ArithmeticException();
                                            } else {
                                                operationResult = firstNumber / secondNumber;
                                                textField1.setText("" + operationResult);
                                                operationSignSingle = false;
                                            }
                                        } catch (ArithmeticException exception) {
                                            textField1.setText("ERROR: DIVISION BY ZERO");
                                        }
                                        break;
                                    case 2: // x * y
                                        operationResult = firstNumber * secondNumber;
                                        textField1.setText("" + operationResult);
                                        operationSignSingle = false;
                                        break;
                                    case 3: // x - y
                                        operationResult = firstNumber - secondNumber;
                                        textField1.setText("" + operationResult);
                                        operationSignSingle = false;
                                        break;
                                    case 4: // x + y
                                        operationResult = firstNumber + secondNumber;
                                        textField1.setText("" + operationResult);
                                        operationSignSingle = false;
                                        break;
                                    case 5: // x power y
                                        operationResult = Math.pow(firstNumber, secondNumber);
                                        textField1.setText("" + operationResult);
                                        operationSignSingle = false;
                                        break;
                                    case 6: // y root x
                                        operationResult = Math.pow(secondNumber, (1 / firstNumber));
                                        textField1.setText("" + operationResult);
                                        operationSignSingle = false;
                                        break;
                                    case 7: // x * 100 ^ y
                                        operationResult = (firstNumber) * (Math.pow(10, secondNumber));
                                        textField1.setText("" + operationResult);
                                        operationSignSingle = false;
                                        break;
                                    case 8: // x % y
                                        operationResult = firstNumber % secondNumber;
                                        textField1.setText("" + operationResult);
                                        operationSignSingle = false;
                                        break;
                                }
                            }
                        }
                        catch(ArithmeticException exception){
                            textField1.setText("ERROR: MORE THAN ONE OPERATOR");
                        }
                    }
                }
                catch (ArithmeticException exception){
                    textField1.setText("ERROR: OPERATOR AT END");
                }
            }
        });
        operationsArea.add(buttonEquals);

        this.setContentPane(fullArea);
        fullArea.add(textArea);
        fullArea.add(mainArea);

        this.setTitle("Calculator");
    }

    public static void main(String[] args) {
        Calculator frame = new Calculator();
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(3289650));
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


