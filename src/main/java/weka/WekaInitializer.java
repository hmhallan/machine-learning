package weka;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils.DataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WekaInitializer implements ServletContextListener {

    private static final String DATASET_PATH = "/iris.csv";

    public static Instances INSTANCES;
    public static AbstractClassifier CLASSIFIER;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        CSVLoader csv = new CSVLoader();
        try {
            csv.setSource(this.getClass().getResourceAsStream(DATASET_PATH));
            INSTANCES = csv.getDataSet();

            //indice do atributo que é 'classe'
            INSTANCES.setClassIndex(4);

            CLASSIFIER = new NaiveBayes();
            CLASSIFIER.buildClassifier(INSTANCES);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
