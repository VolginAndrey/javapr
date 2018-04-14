package demogame.view;

import demogame.viewmodel.BaseViewModel;
import java.awt.Color;

/**
 * @author zhaka
 */
public class BaseView extends javax.swing.JPanel
{
    private BaseViewModel _viewModel;
    
    public BaseView()
    {
        initComponents();
    }
    
    public void bindBase(BaseViewModel viewModel)
    {
        _viewModel = viewModel;
        _viewModel.getPropertyChanged().addCallback(
                propName ->
                {
                    switch (propName)
                    {
                        case "HitPoints":
                            hitPointsLabel.setText(String.valueOf(viewModel.getHitPoints()));
                            break;
                        
                        case "IsDestroyed":
                            setBackground(_viewModel.getIsDestroyed() ? Color.red : Color.gray);
                            break;
                    }
                });
        
        hitPointsLabel.setText(String.valueOf(viewModel.getHitPoints()));
        setBackground(_viewModel.getIsDestroyed() ? Color.red : Color.gray);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hitPointsLabel = new javax.swing.JLabel();

        jLabel1.setText("BASE");

        jLabel2.setText("Hit points:");

        hitPointsLabel.setText("HP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hitPointsLabel)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hitPointsLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hitPointsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}