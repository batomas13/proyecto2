    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author diemo
 */
public class Tablero extends javax.swing.JFrame {
    public static final int BUTTON_SIZE = 110;
    public static final int BOARD_SIZE = 28;
    private JButton buttonArray[] = new JButton[BOARD_SIZE];
    private String[] listaCasillas = {
        "Carcel", "Tubo1", "Tubo2",
        "Tubo3", "Estrella", "FlorFuego", "FlorHielo",
        "Cola", "Gato", "Gato", "Sopa", "Sopa",
        "Path", "Path", "Memory", "Memory", "Catch",
        "Catch", "Bomber", "Bomber", "Guess", "Guess",
        "Coins", "Coins", "Cards", "Cards"
    };
    private List<String> arrayCasillas;
    
    private int turno = 1;
    private ArrayList<Jugador> playerArray = new ArrayList<Jugador>();    
    /**
     * Creates new form Tablero
     */
    public Tablero(ArrayList<Jugador> Jugadores){
        initComponents();
        playerArray = Jugadores;
        for (int i = 0; i < playerArray.size(); i++){
            jPanel1.add(playerArray.get(i).getRefButton());
            playerArray.get(i).refButton.setBounds(0, i * 20, 40, 20);
        }
        initRandomTiles();
        initBoard();
        
    } 
    
    public void initRandomTiles() {
        arrayCasillas = new ArrayList<>(Arrays.asList(listaCasillas));
        Collections.shuffle(arrayCasillas);
        arrayCasillas.add(0, "Inicio");
        arrayCasillas.add("Fin");
        System.out.println("Lista randomizada: " + arrayCasillas);
        System.out.println("Tamaño: " + arrayCasillas.size());
    }
    
    public void initBoard(){
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i] = new JButton((i+1)+"");
            jPanel1.add(buttonArray[i]);
            
            if (i <= 8)
                buttonArray[i].setBounds(i*BUTTON_SIZE, 0, BUTTON_SIZE, BUTTON_SIZE);
            else if (i >=9 && i <= 14)
                buttonArray[i].setBounds(880, (i-8) * BUTTON_SIZE, BUTTON_SIZE, BUTTON_SIZE);
            else if (i >=14 && i <= 21)
                buttonArray[i].setBounds(880-(i-14)* BUTTON_SIZE, 660 , BUTTON_SIZE, BUTTON_SIZE);
            else
                buttonArray[i].setBounds(0, 660-(i-22)* BUTTON_SIZE, BUTTON_SIZE, BUTTON_SIZE);
            buttonArray[i].setText(arrayCasillas.get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDados = new javax.swing.JButton();
        txfDados = new javax.swing.JTextField();
        lblTurno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1121, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );

        btnDados.setText("Lanzar dados");
        btnDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosActionPerformed(evt);
            }
        });

        txfDados.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        lblTurno.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTurno.setText("Turno 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDados)
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txfDados, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfDados, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosActionPerformed
        Jugador jugadorActual = playerArray.get(turno-1);
        // Verifica si esta en la carcel y cuanto le falta
        if (jugadorActual.isCarcel() == true){
            jugadorActual.setTimeinjail();   // Le suma uno
            if (jugadorActual.getTimeinjail() == 2){
                jugadorActual.setTimeinjail(0);
                jugadorActual.setCarcel(false);
            }
            else{
                return;
            }
        }
        // Si perdio repite
        if (jugadorActual.isEsGanador()){
            try {
                moverFicha(jugadorActual.getDado());
            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
            pintarTurno();
            return;
        }
        // Verifica el castigo de los dados
        if (jugadorActual.isCanMove() == false){
            jugadorActual.setCanMove(true);
            return;
        }
        int valorDados = this.lanzarDados();
        jugadorActual.setDado(valorDados);
        switch (valorDados) {
            case -1 -> {
                jugadorActual.setCanMove(false);
                 pintarTurno();
                break;
            }
            case -2 -> {
                jugadorActual.setCarcel(true);
                jugadorActual.setTimeinjail(0);
                 pintarTurno();
                break;
            }
            default -> {
                // continue con la vida normal
                if(jugadorActual.isCanMove() == true && jugadorActual.isCarcel() == false){
                    try {
                        moverFicha(valorDados);
                    } catch (IOException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pintarTurno();
                }
                break;
            }
        }
        this.txfDados.setText(valorDados + "");
    }//GEN-LAST:event_btnDadosActionPerformed

    
    private void moverFicha(int avance) throws IOException{
        Jugador jugadorActual = playerArray.get(turno-1);
        jugadorActual.avanzarCasillaActual(avance);
        JButton botonFicha = playerArray.get(turno-1).getRefButton();
        Point pto = botonFicha.getLocation();
        
        //ubicacion de la casilla donde cayo. x,y
        Point ptoCasilla = buttonArray[jugadorActual.getCasillaActual()-1].getLocation();

        botonFicha.setLocation(ptoCasilla.x, ptoCasilla.y + jugadorActual.getIndex() * 20);
        
        //activa la casilla en que cae el jugador
        activaCasilla(jugadorActual);
        
        // verifica si alguien llegó al final
        if (jugadorActual.getCasillaActual() == 28) {
            System.out.println("GANO");
            JOptionPane.showMessageDialog(null, "Ganó el jugador " + turno, "Ganador", 1);
            this.dispose();
        }
        
    }
    
    private void devolver(Jugador devuelto){
        devuelto.refButton.setLocation(0, 0);
    }
    
    private void setNextTurno(){
        turno++;
        if(turno > playerArray.size())
            turno = 1;
    }
    
    private int lanzarDados(){
        int dado1 = (new Random()).nextInt(6) + 1;
        int dado2 = (new Random()).nextInt(6) + 1;
        if (dado1 == 6 || dado2 == 6) {
            if (dado1 == 6 && dado2 == 6) {
                // castigo de dos turnos
                return -2;
            }
            // castigo de un turno
            return -1;
        }
        return dado1+dado2;
    }
    
    private void pintarTurno(){
        setNextTurno();
        lblTurno.setText("Turno " + this.turno);
    }
    
    private void activaCasilla(Jugador jugadorActivador) throws IOException {
        System.out.println("Jugador: " + turno + ", casilla: " + jugadorActivador.getCasillaActual());
        System.out.println("Casilla: " + arrayCasillas.get(jugadorActivador.getCasillaActual() - 1));
        
        String tipoCasilla = arrayCasillas.get(jugadorActivador.getCasillaActual() - 1);
        
        JuegoGenerico nuevaVentanaJuego;
        int UsuarioRandom = new Random().nextInt(playerArray.size());
        int nuevoAvance;
        switch (tipoCasilla) {
            case "Gato" -> {try {
                // aqui seleccionar un contrincante aleatorio
                nuevaVentanaJuego = new Juego_gato(jugadorActivador, playerArray.get(UsuarioRandom));
                nuevaVentanaJuego.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
            }
            // peticion de sv
            case "Tubo1" -> {
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                if(!jugadorActivador.getActivoTubo()) {
                    System.out.println("Jugador no ha activado un tubo anteriormente");
                    jugadorActivador.setActivoTubo(true);
                    int posTubo2 = arrayCasillas.indexOf("Tubo2") + 1;
                    nuevoAvance = posTubo2 - jugadorActivador.getCasillaActual();
                    moverFicha(nuevoAvance);
                } else {
                    jugadorActivador.setActivoTubo(false);
                    System.out.println("Jugador ya ha activado un tubo anteriormente");
                }
            }
            case "Tubo2" -> {
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                if(!jugadorActivador.getActivoTubo()) {
                    System.out.println("Jugador no ha activado un tubo anteriormente");
                    jugadorActivador.setActivoTubo(true);
                    int posTubo3 = arrayCasillas.indexOf("Tubo3") + 1;
                    nuevoAvance = posTubo3 - jugadorActivador.getCasillaActual();
                    moverFicha(nuevoAvance);
                } else {
                    jugadorActivador.setActivoTubo(false);
                    System.out.println("Jugador ya ha activado un tubo anteriormente");
                }
            }
            case "Tubo3" -> {
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                if(!jugadorActivador.getActivoTubo()) {
                    System.out.println("Jugador no ha activado un tubo anteriormente");
                    jugadorActivador.setActivoTubo(true);
                    int posTubo1 = arrayCasillas.indexOf("Tubo1") + 1;
                    nuevoAvance = posTubo1 - jugadorActivador.getCasillaActual();
                    moverFicha(nuevoAvance);
                } else {
                    jugadorActivador.setActivoTubo(false);
                    System.out.println("Jugador ya ha activado un tubo anteriormente");
                }
            }
            case "Estrella" -> {
                // volver a lanzar dados
                lanzarDados();
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
            }
            case "FlorFuego" ->{ // lanzar a un jugador a la casilla 1
                String nomCliente = JOptionPane.showInputDialog("Introducir a quien quire devolver");
                int jugadordevuelto = Integer.getInteger(nomCliente);
                devolver(playerArray.get(jugadordevuelto));
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
            }
            case "FlorHielo" ->{ // Hace que un jugador pierda 2 turnos
                String nomCliente = JOptionPane.showInputDialog("Introducir a quien quire congelar");
                int jugadordevuelto = Integer.getInteger(nomCliente);
                playerArray.get(jugadordevuelto).setCarcel(true);
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
            }
            case "Cola" -> {
                // Jugador escoge en rando +-3 de casillas para moverse
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                nuevoAvance = -3 + (int)(Math.random() * ((3 - -3) + 1));
                System.out.println("Cola: Salto random de: " + nuevoAvance);
                moverFicha(nuevoAvance);
            }
            case "Sopa" -> {
                // juego de sopa de letras
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                nuevaVentanaJuego = new Juego_Sopa(jugadorActivador);
            }
            case "Path" -> {
                // juego de memory path
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                nuevaVentanaJuego = new Juego_Path(jugadorActivador);
                nuevaVentanaJuego.setVisible(true);
            }
            case "Memory" ->{ // juego de card memory   
                nuevaVentanaJuego = new Juego_Memory(jugadorActivador, playerArray.get(UsuarioRandom));
                nuevaVentanaJuego.setVisible(true);
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
            }
            case "Catch" -> {
                // juego de catch the cat
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                nuevaVentanaJuego = new Juego_Catch(jugadorActivador);
                nuevaVentanaJuego.setVisible(true);
            }
            case "Bomber" -> {
                // juego de bombermario
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                nuevaVentanaJuego = new Juego_bombermario(jugadorActivador);
                nuevaVentanaJuego.setVisible(true);
            }
            case "Guess" -> {
                // juego de guess who
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                try {
                    nuevaVentanaJuego = new Juego_Who(jugadorActivador);
                    nuevaVentanaJuego.setVisible(true);
                } catch (IOException e) {
                    System.out.println("Algo paso mal con el juego de guess who");
                }
            }
            case "Coins" -> {
                // juego de collect the coins
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
                nuevaVentanaJuego = new Juego_Coins(jugadorActivador);
                nuevaVentanaJuego.setVisible(true);
            }
            case "Cards" ->{ // juego de mario cards, TODOS los jugadores participan
                nuevaVentanaJuego = new Juego_Cards(playerArray, jugadorActivador);
                nuevaVentanaJuego.setVisible(true);
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
            // pedirle al sv que abra un Juego_Cards a todos
            }
            default -> // caso default, no debería caer aquí excepto por final que no hace nada más que ganar el juego
                // o la casilla del inicio si se regresa
                System.out.println("Activasión: jugador " + jugadorActivador.getNombre() + " activa casilla de " + tipoCasilla);
        }
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JTextField txfDados;
    // End of variables declaration//GEN-END:variables
}
