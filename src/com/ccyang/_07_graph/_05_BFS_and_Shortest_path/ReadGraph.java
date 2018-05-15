package com.ccyang._07_graph._05_BFS_and_Shortest_path;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 读取文件中数据，根据读取的数据创建图
 */
public class ReadGraph {

    private Scanner scanner;

    public ReadGraph(Graph graph, String fileName) throws Exception {

        readFile(fileName);

        try{
            int V = scanner.nextInt();
            if( V < 0 ){
                throw new IllegalArgumentException("graph 的节点个数不能小于零");
            }
            assert V == graph.V();

            int E = scanner.nextInt();
            if( E < 0 ){
                throw new IllegalArgumentException("graph 的边不能小于零");
            }

            for(int i=0; i<E ; i++){
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                if(!((v >= 0 && v < V) && (w >= 0 && w <V)))
                    throw new Exception("图中无此节点:");

                graph.addEdge(v,w);
            }
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'int' value from input stream, but there are no more tokens available");
        }
    }

    private void readFile(String fileName) throws Exception {

        if(fileName == null || fileName == "")
            throw new Exception("文件名不能为空");

        File file = new File(fileName);
        if(!file.exists())
            throw new  IllegalArgumentException(fileName+ " don't exist");
        else {
            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
            scanner.useLocale(Locale.ENGLISH);
        }
    }
}
