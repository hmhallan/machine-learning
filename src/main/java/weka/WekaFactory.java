package weka;

import weka.classifiers.AbstractClassifier;
import weka.core.Instances;

import javax.enterprise.inject.Produces;

public class WekaFactory {

    @Produces
    public AbstractClassifier getAbstractClassifierInstance(){
        return WekaInitializer.CLASSIFIER;
    }

    @Produces
    public Instances getInstancesInstance(){
        return WekaInitializer.INSTANCES;
    }
}
