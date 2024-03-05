package locadoraveiculos.client;

import locadoraveiculos.gui.TelaPrincipal;
import bancolib.SqlUtil;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import entity.Fabricante;
import java.util.List;
import javax.swing.UIManager;

public class LocadoraClient {
    public static SqlUtil sqlUtil = new SqlUtil("localhost", "5432", "locadora_veiculos", "postgres", "12345");
    
    public static void main(String[] args) {
        setLookAndFeel();
        
        List<Fabricante> lista = sqlUtil.selectPorClasse(Fabricante.class, null);
        
        for (Fabricante fabricante : lista) {
            System.out.println(fabricante.toString());
            
        }
        
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        
        System.out.println("Fim");
    }
    
    private static void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            
        } catch (Exception ex) {
            System.out.println("Failed to initialize laf");
            }
        /*} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
    }
}
