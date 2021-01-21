package org.apache.lucene.test;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DocumentWriter;
import org.apache.lucene.document.Field;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class IndexTest {
    public static void main(String[] args) throws Exception {
        String indexDir = "/Users/yz/work/github/lucene1.0.1/src/java/index";
        Directory directory = FSDirectory.getDirectory(indexDir, false);
        Analyzer analyzer = new SimpleAnalyzer();
        DocumentWriter writer = new DocumentWriter(directory, analyzer, 1000);

        Document doc = new Document();
        doc.add(Field.Keyword("path", "/etc/test.txt"));
        String segment = "s1";

        writer.addDocument(segment, doc);

        directory.close();

    }

}