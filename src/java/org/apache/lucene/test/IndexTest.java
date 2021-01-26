package org.apache.lucene.test;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

public class IndexTest {
    public static void main(String[] args) throws Exception {
        String indexDir = "/Users/yz/work/github/lucene1.0.1/src/java/index1";
        IndexWriter writer = new IndexWriter(indexDir, new SimpleAnalyzer(), true);
        Document doc = new Document();
        doc.add(Field.Keyword("path", "/etc/test.txt"));

        writer.addDocument(doc);
        // writer.optimize();
        writer.close();
    }

}