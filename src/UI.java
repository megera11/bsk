import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UI extends javax.swing.JFrame {

    boolean action = true;
    String data = "";

    private javax.swing.JComboBox<String> algorithmComboBox;
    private javax.swing.ButtonGroup optionGroup;
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JRadioButton decryptRadioButton;
    private javax.swing.JRadioButton encryptRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane resultTextPane;
    private javax.swing.JButton runButton;
    private javax.swing.JTextField dataInputTextField;
    private javax.swing.JTextField codeInputTextField;
    private javax.swing.JFileChooser fileChooser;


    public UI() {
        initComponents();
        int cos[] = new int[4];
        this.setResizable(false);
    }


    private void initComponents() {


        //tworzenie componentow
        optionGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        decryptRadioButton = new javax.swing.JRadioButton();
        encryptRadioButton = new javax.swing.JRadioButton();
        algorithmComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        chooseFileButton = new javax.swing.JButton();
        dataInputTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        runButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codeInputTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTextPane = new javax.swing.JTextPane();
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        optionGroup.add(decryptRadioButton);
        decryptRadioButton.setText("Deszyfruj");
        decryptRadioButton.setMaximumSize(new java.awt.Dimension(60, 20));
        decryptRadioButton.setMinimumSize(new java.awt.Dimension(60, 20));
        decryptRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptRadioButtonActionPerformed(evt);
            }
        });

        optionGroup.add(encryptRadioButton);
        encryptRadioButton.setText("Szyfruj");
        encryptRadioButton.setSelected(true);
        encryptRadioButton.setMaximumSize(new java.awt.Dimension(60, 20));
        encryptRadioButton.setMinimumSize(new java.awt.Dimension(60, 20));
        encryptRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptRadioButtonActionPerformed(evt);
            }
        });

        algorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Rail fence", "Przestawienie A", "Przestawienie B"}));

        jLabel1.setText("Wybierz algorytm");

        chooseFileButton.setText("Wybierz plik");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    chooseFileButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Wpisz tekst:");

        jLabel3.setText("lub wybierz plik");

        runButton.setText("Wykonaj");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Wybrany plik :");

        jLabel4.setText("Wpisz klucz");

        jLabel6.setText("Wynik");

        resultTextPane.setEditable(false);
        jScrollPane1.setViewportView(resultTextPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(encryptRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(decryptRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dataInputTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(codeInputTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(chooseFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(encryptRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(algorithmComboBox)
                                        .addComponent(decryptRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codeInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dataInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chooseFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        jLabel5.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("tab1", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// generowany kod ----------------------------------------------------------------

    private void readFile(File file) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(file.getPath()));
            this.data = new String(encoded, StandardCharsets.US_ASCII);
        } catch (IOException e) {
            System.out.println("");
        }
    }

    private boolean isRailKeyValid() {
        String key = codeInputTextField.getText();
        if(key.matches("")){
            resultTextPane.setText("Klucz musi być podany");
            return false;
        }
        if (key.length() > 1) {
            resultTextPane.setText("Zakres klucza dla algorytmu railfence 1-9");
            return false;
        }
        if (key.charAt(0) >= '1' && key.charAt(0) <= '9') {
            return true;
        }else{
            resultTextPane.setText("Wpisałeś znak zamiast liczbę");
            return false;
        }

    }

    private boolean isMatrixAKeyValid() {
        String key = codeInputTextField.getText();
        if(key.matches("")){
            resultTextPane.setText("Klucz musi być podany");
            return false;
        }
        for (int i = 0; i < key.length();i++) {
            if(i%2==0 && key.charAt(i) >= '1' && key.charAt(i) <= '9'){

            }else if (i%2!=0 && key.charAt(i)=='-'){

            }else{
                resultTextPane.setText("Format dla klucza dla algorytmu MacierzA powinien wygladac: 2-4-3-1");
                return false;
            }
        }
        return true;
    }

    private void decryptRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        action = false;
    }

    private void encryptRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        action = true;
    }

    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int i = fileChooser.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            jLabel5.setText("Wybrany plik: " + f.getName());
            readFile(f);
        }
    }



    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int index = algorithmComboBox.getSelectedIndex();
        resultTextPane.setText("");
        switch (index) {
            case 0:
                if(isRailKeyValid()) {
                    RailFence railFence = new RailFence(Integer.parseInt(codeInputTextField.getText()));
                    if(!dataInputTextField.getText().matches("")) {
                        if (action) {
                            resultTextPane.setText(railFence.getEncryptedData(dataInputTextField.getText()));
                        } else {
                            resultTextPane.setText(railFence.getDecryptedData(dataInputTextField.getText()));
                        }
                    }else{
                        if (action) {
                            resultTextPane.setText(railFence.getEncryptedData(this.data));
                        } else {
                            resultTextPane.setText(railFence.getDecryptedData(this.data));
                        }
                    }
                }
                break;
            case 1:
                if(isMatrixAKeyValid()) {
                    MatrixAPs1 matrixA = new MatrixAPs1(codeInputTextField.getText());
                    if(!dataInputTextField.getText().matches("")) {
                        if (action) {
                            resultTextPane.setText(matrixA.getEncryptedData(dataInputTextField.getText()));
                        } else {
                            resultTextPane.setText(matrixA.getDecryptedData(dataInputTextField.getText()));
                        }
                    }else {
                        if (action) {
                            resultTextPane.setText(matrixA.getEncryptedData(this.data));
                        } else {
                            resultTextPane.setText(matrixA.getDecryptedData(this.data));
                        }
                    }
                }
                break;
            case 2:
                if(!dataInputTextField.getText().matches("")) {
                    MatrixBPs1 matrixB = new MatrixBPs1(codeInputTextField.getText());
                    if (action) {
                        //resultTextPane.setText( matrixB.getEncryptedData(dataInputTextField.getText()));
                    } else {
                        //resultTextPane.setText( matrixB.getDecryptedData(dataInputTextField.getText()));
                    }
                }else{
                    if (action) {
                        //resultTextPane.setText( matrixB.getEncryptedData(this.data));
                    } else {
                        //resultTextPane.setText( matrixB.getDecryptedData(this.data));
                    }
                }
                break;
            default:
                System.out.println("Problem z wybranym algorytmem");
                break;
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }


}
