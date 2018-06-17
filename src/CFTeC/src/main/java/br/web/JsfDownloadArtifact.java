/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import br.data.entity.Artifact;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


/**
 *
 * @author alexandrelerario
 */
@ManagedBean
@RequestScoped
public class JsfDownloadArtifact {

    public void download(Artifact art) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();

            externalContext.responseReset();
            externalContext.setResponseContentType(art.getArquivo_type());
            externalContext.setResponseHeader("Content-Disposition", "attachment;filename="+art.getArquivo_name());

            OutputStream outputStream = externalContext.getResponseOutputStream();

            outputStream.write(art.getArquivo());

            context.responseComplete();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
