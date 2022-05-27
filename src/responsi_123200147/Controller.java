/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123200147;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author lenovo
 */
public class Controller {
    Model modelMovie;
    MovieView moview;
    public String datas;

    public Controller(Model modelMovie, MovieView moview, String datas) {
        this.modelMovie = modelMovie;
        this.moview = moview;
        
        if (modelMovie.getDataMany()!= 0) {
            String movieData[][] = modelMovie.readMovie();
            moview.table.setModel((new JTable(movieData,moview.columnName)).getModel());
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Data none");
        }
        
        moview.btnAdd.addActionListener(new ActionListener(){
            @Override
             public void actionPerformed(ActionEvent ae){
                 String Title = moview.getJudul();
                 double Plot = Double.parseDouble(moview.getAlur());
                 double Character = Double.parseDouble(moview.getPenokohan());
                 double Acting = Double.parseDouble(moview.getAkting());
                 double Score = (Plot+Character+Acting)/3;
                 modelMovie.insertMovie(Title, Plot, Character, Acting, Score);
                 
                 String movieData[][] = modelMovie.readMovie();
                 moview.table.setModel((new JTable(movieData,moview.columnName)).getModel());
                 
             }   
            
        });
        
        moview.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                moview.tfTitle.setText("");
                moview.tfPlot.setText("");
                moview.tfChararter.setText("");
                moview.tfActing.setText("");
            }
        });
        
        
        
    }
    
    
    
}
