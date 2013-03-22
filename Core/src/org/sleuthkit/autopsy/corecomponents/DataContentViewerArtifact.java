/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * DataContentViewerArtifact.java
 *
 * Created on Feb 9, 2012, 1:40:11 PM
 */
package org.sleuthkit.autopsy.corecomponents;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.sleuthkit.autopsy.coreutils.Logger;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import org.sleuthkit.autopsy.corecomponentinterfaces.DataContentViewer;
import org.sleuthkit.autopsy.datamodel.ArtifactStringContent;
import org.sleuthkit.autopsy.datamodel.StringContent;
import org.sleuthkit.datamodel.BlackboardArtifact;
import org.sleuthkit.datamodel.Content;
import org.sleuthkit.datamodel.TskException;

/**
 * Viewer displays Artifacts associated with Contents
 */
@ServiceProvider(service = DataContentViewer.class, position=3)
public class DataContentViewerArtifact extends javax.swing.JPanel implements DataContentViewer{
    
    private static int currentPage = 1;
    private List<BlackboardArtifact> artifacts;
    private final static Logger logger = Logger.getLogger(DataContentViewerArtifact.class.getName());

    /** Creates new form DataContentViewerArtifact */
    public DataContentViewerArtifact() {
        initComponents();
        customizeComponents();
        resetComponent();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightClickMenu = new javax.swing.JPopupMenu();
        copyMenuItem = new javax.swing.JMenuItem();
        selectAllMenuItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputViewPane = new JTextPane(){
            public boolean getScrollableTracksViewportWidth() {
                return (getSize().width < 400);
            }};
            totalPageLabel = new javax.swing.JLabel();
            ofLabel = new javax.swing.JLabel();
            currentPageLabel = new javax.swing.JLabel();
            pageLabel = new javax.swing.JLabel();
            nextPageButton = new javax.swing.JButton();
            pageLabel2 = new javax.swing.JLabel();
            prevPageButton = new javax.swing.JButton();

            copyMenuItem.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.copyMenuItem.text")); // NOI18N
            rightClickMenu.add(copyMenuItem);

            selectAllMenuItem.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.selectAllMenuItem.text")); // NOI18N
            rightClickMenu.add(selectAllMenuItem);

            setPreferredSize(new java.awt.Dimension(622, 424));

            jPanel1.setPreferredSize(new java.awt.Dimension(622, 424));

            outputViewPane.setEditable(false);
            outputViewPane.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
            outputViewPane.setPreferredSize(new java.awt.Dimension(700, 400));
            jScrollPane1.setViewportView(outputViewPane);

            totalPageLabel.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.totalPageLabel.text")); // NOI18N

            ofLabel.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.ofLabel.text")); // NOI18N

            currentPageLabel.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.currentPageLabel.text")); // NOI18N
            currentPageLabel.setMaximumSize(new java.awt.Dimension(18, 14));
            currentPageLabel.setMinimumSize(new java.awt.Dimension(18, 14));
            currentPageLabel.setPreferredSize(new java.awt.Dimension(18, 14));

            pageLabel.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.pageLabel.text")); // NOI18N
            pageLabel.setMaximumSize(new java.awt.Dimension(33, 14));
            pageLabel.setMinimumSize(new java.awt.Dimension(33, 14));
            pageLabel.setPreferredSize(new java.awt.Dimension(33, 14));

            nextPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/corecomponents/btn_step_forward.png"))); // NOI18N
            nextPageButton.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.nextPageButton.text")); // NOI18N
            nextPageButton.setBorderPainted(false);
            nextPageButton.setContentAreaFilled(false);
            nextPageButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/corecomponents/btn_step_forward_disabled.png"))); // NOI18N
            nextPageButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
            nextPageButton.setPreferredSize(new java.awt.Dimension(23, 23));
            nextPageButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/corecomponents/btn_step_forward_hover.png"))); // NOI18N
            nextPageButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nextPageButtonActionPerformed(evt);
                }
            });

            pageLabel2.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.pageLabel2.text")); // NOI18N
            pageLabel2.setMaximumSize(new java.awt.Dimension(29, 14));
            pageLabel2.setMinimumSize(new java.awt.Dimension(29, 14));
            pageLabel2.setPreferredSize(new java.awt.Dimension(29, 14));

            prevPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/corecomponents/btn_step_back.png"))); // NOI18N
            prevPageButton.setText(org.openide.util.NbBundle.getMessage(DataContentViewerArtifact.class, "DataContentViewerArtifact.prevPageButton.text")); // NOI18N
            prevPageButton.setBorderPainted(false);
            prevPageButton.setContentAreaFilled(false);
            prevPageButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/corecomponents/btn_step_back_disabled.png"))); // NOI18N
            prevPageButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
            prevPageButton.setPreferredSize(new java.awt.Dimension(23, 23));
            prevPageButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/corecomponents/btn_step_back_hover.png"))); // NOI18N
            prevPageButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    prevPageButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(currentPageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ofLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(totalPageLabel)
                    .addGap(41, 41, 41)
                    .addComponent(pageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(prevPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(nextPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(366, Short.MAX_VALUE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentPageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofLabel)
                            .addComponent(totalPageLabel))
                        .addComponent(nextPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prevPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pageLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, 0)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }// </editor-fold>//GEN-END:initComponents

    private void nextPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPageButtonActionPerformed
        currentPage = currentPage+1;
        setDataView(artifacts, currentPage);
    }//GEN-LAST:event_nextPageButtonActionPerformed

    private void prevPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPageButtonActionPerformed
        currentPage = currentPage-1;
        setDataView(artifacts, currentPage);
    }//GEN-LAST:event_prevPageButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JLabel currentPageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextPageButton;
    private javax.swing.JLabel ofLabel;
    private javax.swing.JTextPane outputViewPane;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JLabel pageLabel2;
    private javax.swing.JButton prevPageButton;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JMenuItem selectAllMenuItem;
    private javax.swing.JLabel totalPageLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setNode(Node selectedNode) {
        if (selectedNode != null) {
            Lookup lookup = selectedNode.getLookup();
            Content content = lookup.lookup(Content.class);
            BlackboardArtifact artifact = lookup.lookup(BlackboardArtifact.class);
            if (content != null) {
                try {
                    this.setDataView(content.getAllArtifacts(), 1);
                } catch (TskException ex) {
                    logger.log(Level.WARNING, "Couldn't get artifacts: ", ex);
                }
            }
            if (artifact != null) {
                this.setSelectedArtifact(artifact);
            }
        } else {
            this.setDataView(new ArrayList<BlackboardArtifact>(), 1);
        }
    }

    @Override
    public String getTitle() {
        return "Result View";
    }

    @Override
    public String getToolTip() {
        return "Displays Results associated with the file";
    }

    @Override
    public DataContentViewer createInstance() {
        return new DataContentViewerArtifact();
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public void resetComponent() {
        // clear / reset the fields
        currentPage = 1;
        this.artifacts = new ArrayList<BlackboardArtifact>();
        currentPageLabel.setText("");
        totalPageLabel.setText("");
        prevPageButton.setEnabled(false);
        nextPageButton.setEnabled(false);
        setComponentsVisibility(false); // hides the components that not needed
    }
    
    /**
     * To set the visibility of specific components in this class.
     *
     * @param isVisible  whether to show or hide the specific components
     */
    private void setComponentsVisibility(boolean isVisible) {
        currentPageLabel.setVisible(isVisible);
        totalPageLabel.setVisible(isVisible);
        ofLabel.setVisible(isVisible);
        prevPageButton.setVisible(isVisible);
        nextPageButton.setVisible(isVisible);
        pageLabel.setVisible(isVisible);
        pageLabel2.setVisible(isVisible);
        outputViewPane.setVisible(isVisible);
    }

    @Override
    public boolean isSupported(Node node) {
        if (node == null) {
            return false;
        }

        ArtifactStringContent artifact = node.getLookup().lookup(ArtifactStringContent.class);
        Content content = node.getLookup().lookup(Content.class);
        
        if(artifact != null) {
            return true;
        }
        if(content != null) {
            try {
                long size = content.getAllArtifactsCount();
                return size > 0;
            } catch (TskException ex) {
                logger.log(Level.WARNING, "Couldn't get All Blackboard Artifacts Count", ex);
            }
        }
        return false;
    }

    @Override
    public int isPreferred(Node node, boolean isSupported) {
        BlackboardArtifact art = node.getLookup().lookup(BlackboardArtifact.class);
        if(isSupported) {
            if(art == null) {
                return 3;
            } else {
                return 5;
            }
        } else {
            return 0;
        }
    }

    private void customizeComponents(){
        outputViewPane.setComponentPopupMenu(rightClickMenu);
        ActionListener actList = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JMenuItem jmi = (JMenuItem) e.getSource();
                if(jmi.equals(copyMenuItem))
                    outputViewPane.copy();
                else if(jmi.equals(selectAllMenuItem))
                    outputViewPane.selectAll();
            }
        };
        copyMenuItem.addActionListener(actList);
        selectAllMenuItem.addActionListener(actList);
        outputViewPane.setContentType("text/html");
    }

    private void setDataView(List<BlackboardArtifact> artifacts, int offset) {
        // change the cursor to "waiting cursor" for this operation
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        if(artifacts.isEmpty()){
            setComponentsVisibility(false);
            this.setCursor(null);
            outputViewPane.setText("");
            return;
        }
        this.artifacts = artifacts;
        StringContent artifactString = new ArtifactStringContent(artifacts.get(offset-1));
        String text = artifactString.getString();
        
        int pages = artifacts.size();
        
        nextPageButton.setEnabled(offset < pages);
        prevPageButton.setEnabled(offset > 1);
        
        currentPage = offset;
        
        totalPageLabel.setText(Integer.toString(pages));
        currentPageLabel.setText(Integer.toString(currentPage));
        outputViewPane.setText(text);
        setComponentsVisibility(true);
        outputViewPane.moveCaretPosition(0);
        this.setCursor(null);
    }
    
    private void setSelectedArtifact(BlackboardArtifact artifact) {
        if(artifacts.contains(artifact)) {
            int index = artifacts.indexOf(artifact);
            setDataView(artifacts, index+1);
        }
    }
}
