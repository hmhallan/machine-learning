import org.junit.Test;
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;

public class TestClassifier {


    @Test
    public void test(){

    }


    private Instances loadDataset(String path) throws Exception {
        Instances dataset = ConverterUtils.DataSource.read(path);
        if (dataset.classIndex() == -1) {
            dataset.setClassIndex(dataset.numAttributes() - 1);
        }
        return dataset;
    }

    private Classifier buildClassifier(Instances traindataset) throws Exception {
        MultilayerPerceptron m = new MultilayerPerceptron();
        m.buildClassifier(traindataset);
        return m;
    }

    private String evaluateModel(Classifier model, Instances traindataset, Instances testdataset)  throws Exception {
        Evaluation eval = new Evaluation(traindataset);
        eval.evaluateModel(model, testdataset);
        return eval.toSummaryString("", true);
    }

    public void saveModel(Classifier model, String modelpath)  throws Exception {
        SerializationHelper.write(modelpath, model);
    }


}

