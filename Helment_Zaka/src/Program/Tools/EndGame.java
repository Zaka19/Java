package Program.Tools;

import Program.Objects.Players;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EndGame {

    public JDialog f;
    JSONArray lista;
    JTextField _text1;
    String playerName;
    Frame _frame;

    public void introduceName(int points, Frame fr){
       /* JPanel p = new JPanel();
        JLabel lab1 = new JLabel("User Name", JLabel.LEFT);
        JLabel GameOver = new JLabel("GAME OVER");
        JButton _button = new JButton("Ok");
        _text1 = new JTextField();

        p.setLayout(null);

        _button.setBounds(95,120,100,30);
        _button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
                p.setVisible(false);
                try {
                    LoadStory();
                    AddPoints(points);
                    MostrarResultat();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (org.json.simple.parser.ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        GameOver.setBounds(90,1, 100, 50);
        lab1.setBounds(30,10, 150, 100);
        _text1.setBounds(100,52, 150,20);
        p.add(lab1);
        p.add(GameOver);
        p.add(_button);
        p.add(_text1);
        f = new JDialog();
        f.setSize(300, 200);
        f.add(p);
        f.setVisible(true);*/
       playerName = JOptionPane.showInputDialog("NickName:");
       _frame = fr;

        try {
            LoadStory();
            AddPoints(points);
            MostrarResultat();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    private void LoadStory() throws IOException, ParseException, org.json.simple.parser.ParseException { //Comprobo si el fitxer existeix, si no el creo

        File file = new File("storyHelmet.json");
        JSONParser parser = new JSONParser();

        if(file.exists()) {
            FileReader rd = new FileReader(file);
            BufferedReader fs = new BufferedReader(rd);
            if(fs.readLine() != null) {
                lista = (JSONArray) parser.parse(new FileReader("storyHelmet.json"));
            }
        }

        else {
            file.createNewFile();
            lista = new JSONArray();
        }
    }

    private void AddPoints(int points) throws FileNotFoundException, IOException, ParseException {
        try {
            JSONObject obj = new JSONObject();
            if(playerName.equals(null) || playerName.equals("")){
                obj.put("Name", "Anonimo");
            }
            else {
                obj.put("Name", playerName);
            }
            obj.put("Points", points);
            lista.add(obj);
            SaveChanges();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SaveChanges() throws IOException { // Aplico els canvis
        try {
            FileWriter sc = new FileWriter("storyHelmet.json");
            sc.write(lista.toJSONString());
            sc.flush();
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void MostrarResultat() throws FileNotFoundException, IOException, ParseException
    {
        JPanel p = new JPanel();

        ArrayList<Players> _players = new ArrayList<>();
        String[] _lista = new String[lista.size()];

        for (int a = 0; a < lista.size(); a++) {
            JSONObject obj = (JSONObject) lista.get(a);
            String name = obj.get("Name").toString();
            String paraula2 = obj.get("Points").toString();

            int points = Integer.parseInt(paraula2);
            Players _player = new Players(name, points);
            //_lista[a] = _player.toString();
            _players.add(new Players(name, points));
        }

        if(_players.size() > 5) {

            Players max = null;

            /*for (int c = 0; c < 5; c++) {

                max = _players.get(0);
                for (int a = 0; a < _players.size(); a++) {
                    //System.out.println(max.toString() + " = " + _players.get(a).toString());
                    if (max.getPoints() < _players.get(a).getPoints()) {
                        System.out.println("Entro: " + _players.get(a).toString());
                        max = _players.get(a);
                    }
                }

                for (int b = 0; b < _players.size(); b++) {
                    System.out.println(max.toString() + " = " + _players.get(b).toString());
                    if (max.getName().equals(_players.get(b).getName())) {
                        _players.remove(_players.get(b));
                    }
                }

                _lista[c] = max.toString();
            }*/

            Comparator<Players> compareByScore = Comparator.comparing(Players::getPoints);
            Collections.sort(_players, compareByScore.reversed());

            for(int a = 0; a < 5; a++){
                _lista[a] = _players.get(a).toString();
            }
        }
        else{
            int a = 0;
            for (Players player:
                _players ) {
                _lista[a] = player.toString();
                a++;
            }
        }

        JList _list = new JList(_lista);
        JLabel _title = new JLabel("Puntuacion");
        JButton _button = new JButton("Ok");
        _button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
                /*_frame._panel._finish = false;
                _frame._panel._start = false;
                _frame._panel.helmet.setPoints(95);
                _frame._panel.helmet.set_life(3);*/
               System.exit(0);
            }
        });
        p.add(_button);
        p.add(_title);
        p.add(_list);
        f = new JDialog();
        f.setSize(300, 200);
        f.add(p);
        f.setVisible(true);
    }
}
