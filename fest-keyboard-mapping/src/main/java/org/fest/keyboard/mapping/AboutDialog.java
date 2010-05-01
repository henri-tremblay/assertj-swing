/*
 * Created on Apr 14, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.keyboard.mapping;

import static java.util.Calendar.YEAR;

import java.util.GregorianCalendar;

/**
 * Understands an "About" dialog.
 *
 * @author Alex Ruiz
 */
public class AboutDialog extends javax.swing.JDialog {

  private static final long serialVersionUID = 1L;

  private final Platform platform = Platform.instance();
  private final Messages messages = new Messages();

  /**
   * Creates a new </code>{@link AboutDialog}</code>.
   * @param parent the parent frame.
   * @param modal indicates whether the dialog should be modal or not.
   */
  public AboutDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    updateDescriptionPane();
  }

  private void updateDescriptionPane() {
    updateAboutText();
    BrowseUrlHyperlinkListener.install(descriptionPane, platform);
  }

  private void updateAboutText() {
    StringBuilder b = new StringBuilder();
    b.append("<html><head></head><body style=\"").append(fontStyle()).append("\">")
     .append("<strong>FEST Keyboard Mapping Tool</strong>")
     .append("<p>Copyright @").append(copyrightYears()).append(" FEST<br/>")
     .append("(Fixtures for Easy Software Testing)<br/></p>")
     .append("<p>").append(hyperlinkFor("http://fest.easytesting.org")).append("</p>")
     .append("</body></html>");
    descriptionPane.setText(b.toString());
  }

  private String fontStyle() {
    return messages.fontStyleAsCSS(logoLabel.getFont());
  }

  private String copyrightYears() {
    return messages.copyrightYears(new GregorianCalendar().get(YEAR));
  }

  private String hyperlinkFor(String url) {
    return messages.hyperlink(platform, url);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    closeButton = new javax.swing.JButton();
    logoLabel = new javax.swing.JLabel();
    descriptionScrollPane = new javax.swing.JScrollPane();
    descriptionPane = new javax.swing.JEditorPane();

    setTitle("About");
    setModal(true);
    setName("aboutDialog"); // NOI18N
    setResizable(false);

    closeButton.setMnemonic('C');
    closeButton.setText("Close");
    closeButton.setName("closeButton"); // NOI18N
    closeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        closeWindow(evt);
      }
    });

    logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fest64.png"))); // NOI18N

    descriptionScrollPane.setBorder(null);

    descriptionPane.setBorder(null);
    descriptionPane.setContentType("text/html");
    descriptionPane.setEditable(false);
    descriptionPane.setOpaque(false);
    descriptionScrollPane.setViewportView(descriptionPane);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(logoLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(descriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
          .addComponent(closeButton, javax.swing.GroupLayout.Alignment.TRAILING))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(logoLabel)
          .addComponent(descriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(closeButton)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void closeWindow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeWindow
    setVisible(false);
  }//GEN-LAST:event_closeWindow

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton closeButton;
  private javax.swing.JEditorPane descriptionPane;
  private javax.swing.JScrollPane descriptionScrollPane;
  private javax.swing.JLabel logoLabel;
  // End of variables declaration//GEN-END:variables

}
