package org.elasticsearch.plugin.analysis.EcommIK;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.EcommIkAnalyzerProvider;
import org.elasticsearch.index.analysis.EcommIkTokenizerFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;


public class EcommAnalysisIkPlugin extends Plugin implements AnalysisPlugin {

	public static String PLUGIN_NAME = "ecomm-analysis-ik";

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();

        extra.put("ecomm_ik_smart", EcommIkTokenizerFactory::getIkSmartTokenizerFactory);
        extra.put("ecomm_ik_max_word", EcommIkTokenizerFactory::getIkTokenizerFactory);

        return extra;
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> extra = new HashMap<>();

        extra.put("ecomm_ik_smart", EcommIkAnalyzerProvider::getIkSmartAnalyzerProvider);
        extra.put("ecomm_ik_max_word", EcommIkAnalyzerProvider::getIkAnalyzerProvider);

        return extra;
    }

}
