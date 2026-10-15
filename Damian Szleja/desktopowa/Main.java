import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    JSlider czerwony = new JSlider(0, 255, 255);
    JSlider zielony = new JSlider(0, 255, 255);
    JSlider niebieski = new JSlider(0, 255, 255);
    JLabel wartoscR = new JLabel("255");
    JLabel wartoscG = new JLabel("255");
    JLabel wartoscB = new JLabel("255");
    JPanel podglad = new JPanel();
    JLabel zapisany = new JLabel("255, 255, 255");
    Color tlo = new Color(255, 248, 220);

    public Main() {
        setTitle("Wzornik kolorów RGB. Wykonał Damian Szleja");
        setSize(660, 390);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(null);
        panel.setBackground(tlo);
        setContentPane(panel);
        podglad.setBounds(30, 20, 580, 65);
        podglad.setBackground(Color.WHITE);
        panel.add(podglad);
        JLabel opis = new JLabel("Dobierz kolor suwakami i zapisz przyciskiem:");
        opis.setBounds(30, 105, 560, 25);
        panel.add(opis);
        dodajSuwak(panel, "R", czerwony, wartoscR, 140);
        dodajSuwak(panel, "G", zielony, wartoscG, 180);
        dodajSuwak(panel, "B", niebieski, wartoscB, 220);
        JButton pobierz = new JButton("Pobierz");
        pobierz.setBackground(new Color(205, 133, 63));
        pobierz.setBounds(240, 270, 160, 30);
        panel.add(pobierz);
        zapisany.setOpaque(true);
        zapisany.setBackground(Color.WHITE);
        zapisany.setBounds(240, 315, 160, 25);
        panel.add(zapisany);
        pobierz.addActionListener(e -> {
            zapisany.setBackground(kolor());
            zapisany.setText(czerwony.getValue() + ", " + zielony.getValue()
                + ", " + niebieski.getValue());
        });
    }

    void dodajSuwak(JPanel panel, String nazwa, JSlider suwak, JLabel wartosc, int y) {
        JLabel etykieta = new JLabel(nazwa);
        etykieta.setBounds(30, y, 20, 25);
        suwak.setBounds(55, y, 510, 25);
        suwak.setBackground(tlo);
        wartosc.setBounds(580, y, 40, 25);
        panel.add(etykieta);
        panel.add(suwak);
        panel.add(wartosc);
        suwak.addChangeListener(e -> {
            wartosc.setText(String.valueOf(suwak.getValue()));
            podglad.setBackground(kolor());
        });
    }

    Color kolor() {
        return new Color(czerwony.getValue(), zielony.getValue(), niebieski.getValue());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
