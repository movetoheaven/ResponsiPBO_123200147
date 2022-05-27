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
        }
        
        
    }
    
    
    
}
