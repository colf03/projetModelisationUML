private void jcbVendableItemStateChanged(java.awt.event.ItemEvent evt) {                                             
        if (evt.getStateChange() == 1) {
            jftfPrixVente.setEditable(true);
            jlblPrixVente.setForeground(Color.black);
        } else if (evt.getStateChange() == 2) {
            jftfPrixVente.setEditable(false);
            jlblPrixVente.setForeground(SystemColor.textInactiveText);
        }

    }                                            

    private void jbtnConfirmerActionPerformed(java.awt.event.ActionEvent evt) {                                              
        resetErrors();
        try {

            String titre = jtfTitre.getText();
            String description = jtaDescription.getText();
            String genre = jtfGenre.getText();

            if (titre.isEmpty()) {
                throw new RequiredException(jtfTitre);
            }
            if (description.isEmpty()) {
                throw new RequiredException(jtaDescription);
            }
            if (genre.isEmpty()) {
                throw new RequiredException(jtfGenre);
            }
            if (jftfQtee.getValue() == null) {
                throw new RequiredException(jftfQtee);
            }
            if (jftfDureeLocation.getValue() == null) {
                throw new RequiredException(jftfDureeLocation);
            }
            if (jftfPrixLocation.getValue() == null) {
                throw new RequiredException(jftfPrixLocation);
            }
            float prixVente = 0;
            if (jcbVendable.isSelected()) {
                if (jftfPrixVente.getValue() == null) {
                    throw new RequiredException(jftfPrixVente);
                }
                prixVente = ((Number)jftfPrixVente.getValue()).floatValue();
                if (prixVente < 0) {
                    throw new RequiredException(jftfPrixVente);
                }
            }
            int qtee = ((Number)jftfQtee.getValue()).intValue();
            int dureeLocation = ((Number)jftfDureeLocation.getValue()).intValue();
            float prixLocation = ((Number)jftfPrixLocation.getValue()).floatValue();

            if (qtee < 0)
                throw new RequiredException(jftfQtee);
            if (dureeLocation < 1) {
                throw new RequiredException(jftfDureeLocation);
            }
            if (prixLocation < 0) {
                throw new RequiredException(jftfPrixLocation);
            }

            Film.ajouterFilm(new Film(titre, description, genre));
            FilmVideotheque.ajouterFilmVideotheque(new FilmVideotheque(Film.rechercheFilm(titre).get(0), jcbVendable.isSelected(), qtee, dureeLocation, prixLocation, prixVente));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventairePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InventairePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RequiredException ex) {

        }
        updateTable("");
    }                                             

    private void jbtnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {                                            
        emptyFields();
        resetErrors();
    }