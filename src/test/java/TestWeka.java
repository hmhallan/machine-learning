import entity.Flor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import weka.WekaInitializer;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Debug;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;

import javax.inject.Inject;
import java.io.InputStream;
import java.util.Arrays;

public class TestWeka {

    AbstractClassifier classifier;
    Instances instances;

    @Before
    public void setUp(){
        WekaInitializer initializer = new WekaInitializer();
        initializer.contextInitialized(null);

        this.instances = WekaInitializer.INSTANCES;
        this.classifier = WekaInitializer.CLASSIFIER;
    }

    @Test
    public void testa_input_setosa() throws Exception {
        //5.1,3.5,1.4,0.2
        Flor flor = new Flor(5.1, 3.5, 1.4, 0.2);
        Assert.assertEquals("Iris-setosa", this.classificar(flor));
    }

    @Test
    public void testa_input_versicolor() throws Exception {
        //7,3.2,4.7,1.4,Iris-versicolor
        Flor flor = new Flor(7, 3.2, 4.7, 1.4);
        Assert.assertEquals("Iris-versicolor", this.classificar(flor));
    }

    @Test
    public void testa_input_virginica() throws Exception {
        //5.8,2.7,5.1,1.9,Iris-virginica
        Flor flor = new Flor(5.7, 2.8, 5.1, 1.9);
        Assert.assertEquals("Iris-virginica", this.classificar(flor));
    }

    private String classificar(Flor flor) throws Exception {

        //cria uma nova instancia de um elemento
        Instance novo = new DenseInstance(5);
        novo.setDataset(this.instances);

        novo.setValue(0, flor.getLarguraSepala());
        novo.setValue(1, flor.getAlturaSepala());
        novo.setValue(2, flor.getLarguraPetala());
        novo.setValue(3, flor.getAlturaPetala());

        //classifica a flor q chegou
        double tipo = classifier.classifyInstance(novo);

        return this.instances.attribute(4).value( (int)tipo);
    }



}

