package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.wltea.EcommAnalyzer.cfg.Configuration;
import org.wltea.EcommAnalyzer.lucene.IKTokenizer;

public class EcommIkTokenizerFactory extends AbstractTokenizerFactory {
  private Configuration configuration;

  public EcommIkTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
      super(indexSettings, settings,name);
	  configuration=new Configuration(env,settings);
  }

  public static EcommIkTokenizerFactory getIkTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
      return new EcommIkTokenizerFactory(indexSettings,env, name, settings).setSmart(false);
  }

  public static EcommIkTokenizerFactory getIkSmartTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
      return new EcommIkTokenizerFactory(indexSettings,env, name, settings).setSmart(true);
  }

  public EcommIkTokenizerFactory setSmart(boolean smart){
        this.configuration.setUseSmart(smart);
        return this;
  }

  @Override
  public Tokenizer create() {
      return new IKTokenizer(configuration);  }
}
