/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Adrian
 */
public class Juego_Memory extends JuegoGenerico {

    private JButton buttonArray_fotos[][] = new JButton[6][3];
    private JButton ButtonListo[] = new JButton[18];
    private JButton ButtonUP[] = new JButton[2];
    private Jugador jugador1;
    private Jugador jugador2;
    private int ButtonSize = 92;
    private int vueltas = 0;
    private int puntos = 0;
    private int punto2 = 0;
    private int turno = 0;
    private int cantidad_turnos = 0;
    private File Path = new File ("Imagenes_Memory_Game");
    private File[]  allFiles = Path.listFiles();
    private Image[] Personaje = new Image[18];
    private List<JButton> imagenes;
    private Icon[][] Icon_Boton = new Icon[6][3];
    private int count = 0;
    
    
    /**
     * Creates new form Juego_Memory
     * @throws java.io.IOException
     */
    public Juego_Memory(Jugador Jugador1, Jugador Jugador2) throws IOException {
        this.jugador1 = Jugador1;
        this.jugador2 = Jugador2;
        for (int i = 0; i < 18; i++){
            Personaje[i] = ImageIO.read(allFiles[i]);
        }
        initComponents();
        initTablero();
        imagenes = new ArrayList<> (Arrays.asList(ButtonListo));
        Collections.shuffle(imagenes);
        System.out.println("   ");
        poner_Botones();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTablero = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelPuntos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelPuntos1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNombre.setText("Jugador 0 ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Puntos Jugador 1:");

        labelPuntos.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelPuntos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPuntos.setText("0");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Turno:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puntos Jugador 2:");

        labelPuntos1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelPuntos1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPuntos1.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(PanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelPuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNombre)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPuntos1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void initTablero(){
        String Name = "";
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 3; j++){
                buttonArray_fotos[i][j] = new JButton();
                ImageIcon icon = new ImageIcon(Personaje[count]);
                System.out.println(count);
                switch (count){
                    case 0 -> Name = "Toad";
                    case 1 -> Name = "Mario";
                    case 2 -> Name = "Mario";
                    case 3 -> Name = "Peach";
                    case 4 -> Name = "Mario Const";
                    case 5 -> Name = "Wario";
                    case 6 -> Name = "Goomba";
                    case 7 -> Name = "Toad car";
                    case 8 -> Name = "Yoshi car";
                    case 9 -> Name = "Luigi";
                    case 10 -> Name = "Peach";
                    case 11 -> Name = "Mario Const";
                    case 12 -> Name = "Wario";
                    case 13 -> Name = "Goomba";
                    case 14 -> Name = "Toad car";
                    case 15 -> Name = "Yoshi car";
                    case 16 -> Name = "Luigi";
                    case 17 -> Name = "Toad";
                }
                buttonArray_fotos[i][j].setName(Name);
                buttonArray_fotos[i][j].setIcon(icon);
                ButtonListo[count] = buttonArray_fotos[i][j];
                count++;
                 
            }
        }
    }
    
    private void juego(int x, int y){
        Icon icon = (Icon_Boton[x][y]);
        if (vueltas != 2){
            buttonArray_fotos[x][y].setIcon(icon);
            ButtonUP[vueltas] = buttonArray_fotos[x][y];
            ButtonUP[vueltas].setName(buttonArray_fotos[x][y].getName());
        }
        else{
            if (ButtonUP[0].getName().equals(ButtonUP[1].getName())){
                PanelTablero.remove(ButtonUP[0]);
                PanelTablero.remove(ButtonUP[1]);
                if (turno == 1){
                    puntos++;
                    labelPuntos.setText(puntos + " ");
                }
                else{
                    punto2++;
                    labelPuntos1.setText(punto2 + " ");
                }
                System.out.println(cantidad_turnos);
                if (cantidad_turnos == 8){
                    ganar();
                    JOptionPane.showMessageDialog(null, "Ha ganado el jugador " + turno);
                    super.dispose();
                }
                cantidad_turnos++;
                ButtonUP[0] = buttonArray_fotos[x][y];
                buttonArray_fotos[x][y].setIcon(icon);
                
            }
            else{
                ButtonUP[0].setIcon(null);
                ButtonUP[0] = buttonArray_fotos[x][y];
                ButtonUP[1].setIcon(null);
                ButtonUP[1] = null;
                buttonArray_fotos[x][y].setIcon(icon);
                if (turno == 1){
                    turno = 0;
                }
                else{
                    turno++;
                }
                labelNombre.setText("Jugador " + turno);
            }
            vueltas = 0;
            
        }
        vueltas++;
        
    }
    
    private void poner_Botones(){
        int count = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 3; j++){
                buttonArray_fotos[i][j] = imagenes.get(count);
                Icon_Boton[i][j] = buttonArray_fotos[i][j].getIcon();
                buttonArray_fotos[i][j].setIcon(null);
                buttonArray_fotos[i][j].addActionListener(listener);
                buttonArray_fotos[i][j].setBounds(i * ButtonSize, j * ButtonSize, ButtonSize, ButtonSize); 
                PanelTablero.add(buttonArray_fotos[i][j]);
                count++;
            }
        }
    }
    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int x, y;
            if (e.getSource() instanceof JButton jButton) {  
                x = jButton.getX() / 92;
                y = jButton.getY() / 92;
               
                juego(x, y);
            }
        }
    };

    private void ganar (){
        if (punto2 > puntos){
            JOptionPane.showMessageDialog(this,"Gano" + jugador2.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
            super.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Gano" + jugador1.getNombre(), "Ganador", JOptionPane.INFORMATION_MESSAGE);
            super.dispose();
            jugador1.setEsGanador(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTablero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JLabel labelPuntos1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setEnemigo(String nombreEnemigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
