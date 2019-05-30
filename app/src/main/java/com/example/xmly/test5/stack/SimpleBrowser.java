package com.example.xmly.test5.stack;

public class SimpleBrowser {

    public static void main(String[] args){

        SimpleBrowser simpleBrowser = new SimpleBrowser();
        simpleBrowser.open("www.baidu.com");
        simpleBrowser.open("www.google.com");
        simpleBrowser.open("www.sougou.com");

        simpleBrowser.goBack();
        simpleBrowser.goBack();
        simpleBrowser.goForward();
        simpleBrowser.open("www.last.com");
        simpleBrowser.goBack();
        simpleBrowser.goForward();


    }

    public SimpleBrowser(){
        this.backStack = new LinkedStack();
        this.forwardStack = new LinkedStack();
    }

    private LinkedStack backStack;
    private LinkedStack forwardStack;
    private String currentPage;


    public void open(String web){
        if (currentPage != null){
            backStack.push(currentPage);
            forwardStack.clear();
        }
        showUrl(web,"open");
    }

    public void goForward(){
        if (canGoForWord()){
            backStack.push(currentPage);
            currentPage = forwardStack.pop();

            showUrl(currentPage,"Forward");
            return;
        }
        System.out.println("Can go Forward");
    }

    public void goBack(){
        if (canGoBack()){
            String url = backStack.pop();
            forwardStack.push(url);
            showUrl(url,"Back");
            return;
        }
        System.out.println("Can go back");

    }

    public boolean canGoBack(){
        return backStack.size > 0;
    }

    public boolean canGoForWord(){
        return forwardStack.size > 0;
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

}
