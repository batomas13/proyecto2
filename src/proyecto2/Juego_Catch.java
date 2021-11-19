/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Adrian
 */
public class Juego_Catch extends JuegoGenerico {

    public static final int BUTTON_SIZE = 65;
    private JButton[][] ButtonArray = new JButton[11][11];
    private Jugador jugador;
    private JButton gato = new JButton("G");
    private int[] distancias = new int[]{0,0,0,0,0,0,0,0};
    private int filaGato = 5, columnaGato = 5;
    
    /**
     * Creates new form Juego_Catch
     */
    public Juego_Catch(Jugador jugador) {
        this.jugador = jugador;
        initComponents();
        this.setName("CATCH THE CAT!");
        generateBoard();
        //PanelPrincipal.add(gato);
        //gato.setBounds(ButtonArray[6][6].getX()/BUTTON_SIZE, ButtonArray[6][6].getY()/BUTTON_SIZE, 30, 30);
        actualizaDistancias();
        //pintaGato();
        paintBoard();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void generateBoard() {
        int valorAleatorio;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                ButtonArray[i][j] = new JButton();
                PanelPrincipal.add(ButtonArray[i][j]);
                ButtonArray[i][j].setBounds(j * BUTTON_SIZE, i * BUTTON_SIZE, BUTTON_SIZE, BUTTON_SIZE);
                ButtonArray[i][j].setBackground(new Color(150 + i, 220 + j, 120 + (j - i)));
                ButtonArray[i][j].addActionListener(listenerBoton);
                
                //System.out.print(tablero[i][j] + " ");
            }
            //System.out.println("");
        }
    }
    
    public boolean intentaDerecha(int fila, int columna) {
        try {
            return ButtonArray[fila][columna].isEnabled() && ButtonArray[fila][columna + 1].isEnabled();
        } catch(IndexOutOfBoundsException ex) {
            return true;
        }
    }
    
    public boolean intentaIzquierda(int fila, int columna) {
        try {
            return ButtonArray[fila][columna].isEnabled() && ButtonArray[fila][columna - 1].isEnabled();
        } catch(IndexOutOfBoundsException ex) {
            return true;
        }
    }
    
    public boolean intentaArriba(int fila, int columna) {
        try {
            return ButtonArray[fila][columna].isEnabled() && ButtonArray[fila - 1][columna].isEnabled();
        } catch(IndexOutOfBoundsException ex) {
            return true;
        }
    }
    
    public boolean intentaAbajo(int fila, int columna) {
        try {
            return ButtonArray[fila][columna].isEnabled() && ButtonArray[fila + 1][columna].isEnabled();
        } catch(IndexOutOfBoundsException ex) {
            return true;
        }
    }
    
    public boolean intentaAbajoDerecha(int fila, int columna) {
        try {
            return ButtonArray[fila][columna].isEnabled() && ButtonArray[fila + 1][columna + 1].isEnabled();
        } catch(IndexOutOfBoundsException ex) {
            return true;
        }
    }
    
    public boolean intentaAbajoIzquierda(int fila, int columna) {
        try {
            return ButtonArray[fila][columna].isEnabled() && ButtonArray[fila + 1][columna - 1].isEnabled();
        } catch(IndexOutOfBoundsException ex) {
            return true;
        }
    }
    
    public boolean intentaArribaDerecha(int fila, int columna) {
        try {
            return ButtonArray[fila][columna].isEnabled() && ButtonArray[fila - 1][columna + 1].isEnabled();
        } catch(IndexOutOfBoundsException ex) {
            return true;
        }
    }
    
    public boolean intentaArribaIzquierda(int fila, int columna) {
        try {
            return ButtonArray[fila][columna].isEnabled() && ButtonArray[fila - 1][columna - 1].isEnabled();
        } catch(IndexOutOfBoundsException ex) {
            return true;
        }
    }
    
    public boolean hayCamino(int fila, int col) {
        if (intentaDerecha(fila, col)) {
            if (intentaIzquierda(fila, col)) {
                if (intentaArriba(fila, col)) {
                    if (intentaAbajo(fila, col)) {
                        if (intentaArribaDerecha(fila, col)) {
                            if (intentaArribaIzquierda(fila, col)) {
                                if (intentaAbajoDerecha(fila, col)) {
                                    if (intentaAbajoIzquierda(fila, col)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public boolean hayCaminoDos(int fila, int col) {
        if (intentaDerecha(fila, col) || intentaIzquierda(fila, col)
            || intentaArriba(fila, col) || intentaAbajo(fila, col)
            || intentaArribaDerecha(fila, col) || intentaArribaIzquierda(fila, col)
            || intentaAbajoDerecha(fila, col) || intentaAbajoIzquierda(fila, col)) {
            return true;
        }
        return false;
    }
    
    public int distanciaDerecha(int fila, int columna) {
        return 10 - columna;
    }
    
    public int distanciaIzquierda(int fila, int columna) {
        return columna;
    }
    
    public int distanciaAbajo(int fila, int columna) {
        return 10 - fila;
    }
    
    public int distanciaArriba(int fila, int columna) {
        return fila;
    }
    
    public int distanciaAbajoDerecha(int fila, int columna) {
        int count = 0;
        for (int i = fila; i < 11; i++) {
            for (int j = columna; j < 11; j++) {
                count++;
            }
        }
        return count;
    }
    
    public int distanciaAbajoIzquierda(int fila, int columna) {
        int count = 0;
        for (int i = fila; i < 11; i++) {
            for (int j = columna; j >= 0; j--) {
                count++;
            }
        }
        return count;
    }
    
    public int distanciaArribaDerecha(int fila, int columna) {
        int count = 0;
        for (int i = fila; i >= 0; i--) {
            for (int j = columna; j < 11; j++) {
                count++;
            }
        }
        return count;
    }
    
    public int distanciaArribaIzquierda(int fila, int columna) {
        int count = 0;
        for (int i = fila; i >= 0; i--) {
            for (int j = columna; j >= 0; j--) {
                count++;
            }
        }
        return count;
    }
    
    public void actualizaDistancias() {
        // ojo como se ordenan
        if(intentaDerecha(filaGato, columnaGato)) {
            distancias[0] = distanciaDerecha(filaGato, columnaGato);
        } else {
            distancias[0] = 999;
        }
        
        if (intentaIzquierda(filaGato, columnaGato)) {
            distancias[1] = distanciaIzquierda(filaGato, columnaGato);
        } else {
            distancias[1] = 999;
        }
        
        if (intentaAbajo(filaGato, columnaGato)) {
            distancias[2] = distanciaAbajo(filaGato, columnaGato);
        } else {
            distancias[2] = 999;
        }
        
        if (intentaArriba(filaGato, columnaGato)) {
            distancias[3] = distanciaArriba(filaGato, columnaGato);
        } else {
            distancias[3] = 999;
        }
        
        if (intentaAbajoDerecha(filaGato, columnaGato)) {
            distancias[4] = distanciaAbajoDerecha(filaGato, columnaGato);
        } else {
            distancias[4] = 999;
        }
        
        if (intentaAbajoIzquierda(filaGato, columnaGato)) {
            distancias[5] = distanciaAbajoIzquierda(filaGato, columnaGato);
        } else {
            distancias[5] = 999;
        }
        
        if (intentaArribaDerecha(filaGato, columnaGato)) {
            distancias[6] = distanciaArribaDerecha(filaGato, columnaGato);
        } else {
            distancias[6] = 999;
        }
        
        if (intentaArribaIzquierda(filaGato, columnaGato)) {
            distancias[7] = distanciaArribaIzquierda(filaGato, columnaGato);
        } else {
            distancias[7] = 999;
        }
    }
    
    public boolean saleTablero() {
        int val = 999;
        for (int i = 0; i < distancias.length; i++) {
            if (distancias[i] < val) {
                val = distancias[i];
            }
        }
        
        if (val <= 0) {
            return true;
        }
        return false;
    }
    
    public void mueveGato() {
        int min_index = 0;
        int min_val = distancias[min_index];
        for (int i = 0; i < distancias.length; i++) {
            if (distancias[i] < min_val) {
                min_index = i;
                min_val = distancias[i];
            }
        }
        
        switch (min_index) {
            // derecha
            case 0 -> {
                if (intentaDerecha(filaGato, columnaGato)) {
                    columnaGato++;
                }
                break;
            }
            // izquierda
            case 1 -> {
                if (intentaIzquierda(filaGato, columnaGato)) {
                    columnaGato--;
                }
                break;
            }
            // abajo
            case 2 -> {
                if (intentaAbajo(filaGato, columnaGato)) {
                    filaGato++;
                }
                break;
            }
            // arriba
            case 3 -> {
                if (intentaArriba(filaGato, columnaGato)) {
                    filaGato--;
                }
                break;
            }
            // abajo-derecha
            case 4 -> {
                if (intentaAbajoDerecha(filaGato, columnaGato)) {
                    filaGato++;
                    columnaGato++;
                }
                break;
            }
            // abajo-izquierda
            case 5 -> {
                if (intentaAbajoIzquierda(filaGato, columnaGato)) {
                    filaGato++;
                    columnaGato--;
                }
                break;
            }
            // arriba-derecha
            case 6 -> {
                if (intentaArribaDerecha(filaGato, columnaGato)) {
                    filaGato--;
                    columnaGato++;
                }
                break;
            }
            // arriba-izquierda
            case 7 -> {
                if (intentaArribaIzquierda(filaGato, columnaGato)) {
                    filaGato--;
                    columnaGato--;
                }
                break;
            }
        }
        System.out.println("El gato se movió a la posición: " + filaGato + ", " +columnaGato);
        actualizaDistancias();
    }
    
    public void paintBoard() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == filaGato && j == columnaGato) {
                    ButtonArray[i][j].setBackground(Color.red);
                } else {
                    ButtonArray[i][j].setBackground(Color.green);
                }
            }
        }
    }
    
    public void saleJuego(boolean gano) {
        if (gano) {
            JOptionPane.showMessageDialog(null, "Aquí hay gato encerrado, ¡ganó!", "Ganador", 1);
            
        } else {
            JOptionPane.showMessageDialog(null, "El gato salió ¡Perdió el juego!", "Perdedor", 0);
            jugador.setEsGanador(false);  // EsPededor
        }
        dispose();
    }
    
    ActionListener listenerBoton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                // primeri deshabilite el boton y luego verifique
                ((JButton) e.getSource()).setEnabled(false);
                
                
                if (hayCaminoDos(filaGato, columnaGato)) {
                    mueveGato();
                    //pintaGato();
                } else {
                    saleJuego(true);
                }
                
                if (saleTablero()) {
                    saleJuego(false);
                }
                paintBoard();
            }
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setEnemigo(String nombreEnemigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
