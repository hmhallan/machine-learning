package util;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;


public class ModelGenerator {

    public Instances loadDataset(InputStream path) throws Exception {
        Instances dataset = ConverterUtils.DataSource.read(path);
        if (dataset.classIndex() == -1) {
            dataset.setClassIndex(dataset.numAttributes() - 1);
        }
        return dataset;
    }

    public Classifier buildClassifier(Instances traindataset) throws Exception {
        MultilayerPerceptron m = new MultilayerPerceptron();
        m.buildClassifier(traindataset);
        return m;
    }

    public String evaluateModel(Classifier model, Instances traindataset, Instances testdataset)  throws Exception {
        Evaluation eval = new Evaluation(traindataset);
        eval.evaluateModel(model, testdataset);
        return eval.toSummaryString("", true);
    }

    public void saveModel(Classifier model, String modelpath)  throws Exception {
        SerializationHelper.write(modelpath, model);
    }

}
