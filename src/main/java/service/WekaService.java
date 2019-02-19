package service;

import entity.Flor;
import weka.classifiers.AbstractClassifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Path("/weka")
public class WekaService {

    @Inject
    AbstractClassifier classifier;

    @Inject
    Instances instances;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/classificar")
    public String classificar(Flor flor) throws Exception {

        //cria uma nova instancia de um elemento
        Instance novo = new DenseInstance(5);
        novo.setDataset(this.instances);

        novo.setValue(0, flor.getLarguraSepala());
        novo.setValue(1, flor.getAlturaSepala());
        novo.setValue(2, flor.getLarguraPetala());
        novo.setValue(3, flor.getAlturaPetala());

        //classifica a flor q chegou
        double tipo = classifier.classifyInstance(novo);
        int index = (int)tipo;

        //probabilidades
        double [] probabilidades = classifier.distributionForInstance(novo);
        double percentual = probabilidades[index];

        //nome
        String nomeTipo = this.instances.attribute(4).value( index );

        return String.format("%s (%.2f%%)", nomeTipo, (percentual*100) );
    }

}



