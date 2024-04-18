package Models;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBarExample extends JFrame {


    public MenuBarExample() {
        setTitle("Exemplo de Barra de Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria uma barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Cria os menus
        JMenu fileMenu = new JMenu("Arquivo");
        JMenu editMenu = new JMenu("Editar");
        JMenu helpMenu = new JMenu("Ajuda");

        // Cria os itens do menu "Arquivo"
        JMenuItem newItem = new JMenuItem("Novo");
        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Salvar");
        JMenuItem exitItem = new JMenuItem("Sair");

        // Adiciona os itens ao menu "Arquivo"
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Adiciona uma linha separadora
        fileMenu.add(exitItem);

        // Cria os itens do menu "Editar"
        JMenuItem cutItem = new JMenuItem("Recortar");
        JMenuItem copyItem = new JMenuItem("Copiar");
        JMenuItem pasteItem = new JMenuItem("Colar");

        // Adiciona os itens ao menu "Editar"
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Cria o item do menu "Ajuda"
        JMenuItem aboutItem = new JMenuItem("Sobre");

        // Adiciona o item ao menu "Ajuda"
        helpMenu.add(aboutItem);

        // Adiciona os menus à barra de menu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Define a barra de menu para a janela
        setJMenuBar(menuBar);

        // Adiciona um ActionListener para o item "Sair"
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adiciona um ActionListener para o item "Sobre"
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MenuBarExample.this, "Este é um exemplo de barra de menu em Java Swing", "Sobre", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuBarExample example = new MenuBarExample();
                example.setVisible(true);
            }
        });
    }
}
