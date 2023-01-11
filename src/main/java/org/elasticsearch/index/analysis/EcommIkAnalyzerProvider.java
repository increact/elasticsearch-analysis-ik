package org.elasticsearch.index.analysis;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.wltea.EcommAnalyzer.cfg.Configuration;
import org.wltea.EcommAnalyzer.lucene.IKAnalyzer;

public class EcommIkAnalyzerProvider extends AbstractIndexAnalyzerProvider<IKAnalyzer> {
    private final IKAnalyzer analyzer;

    public EcommIkAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings,boolean useSmart) {
        super(name, settings);

        Configuration configuration=new Configuration(env,settings).setUseSmart(useSmart);

        analyzer=new IKAnalyzer(configuration);
    }

    public static EcommIkAnalyzerProvider getIkSmartAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new EcommIkAnalyzerProvider(indexSettings,env,name,settings,true);
    }

    public static EcommIkAnalyzerProvider getIkAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new EcommIkAnalyzerProvider(indexSettings,env,name,settings,false);
    }

    @Override public IKAnalyzer get() {
        return this.analyzer;
    }
}
