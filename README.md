[Cay S. Horstmann著、柴田芳樹訳『Javaプログラマーなら習得しておきたい Java SE 8 実践プログラミング』(インプレス)](https://www.amazon.co.jp/Java%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9E%E3%83%BC%E3%81%AA%E3%82%89%E7%BF%92%E5%BE%97%E3%81%97%E3%81%A6%E3%81%8A%E3%81%8D%E3%81%9F%E3%81%84-Java-%E5%AE%9F%E8%B7%B5%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0-impress-gear/dp/4844336673)について、本書は全9章構成で、各々章末に演習問題が掲載されているのですが、このレポジトリはその演習問題の回答集です。ただし全問題ではなく、以下の2章については、解答していません。

- 第2章「JavaFXによるGUIプログラミング」: GUIに対する関心が低いため
- 第7章「Nashorn JavaScriptエンジンの活用」: Nashornが非推奨になり、将来的にJDKから外される可能性があるため。
    - 参考: https://www.publickey1.jp/blog/18/javajavascriptnashornecmascriptgraalvm.html

また本書はそのタイトルにある通り、JavaSE8で新たに追加された機能に関して学習を進めるものですが、本書の演習問題の回答にあたってはJava10を利用しています。つまりJava10現在で利用できる機能については、特段の明記なしに使用しています(ex. ローカル変数の型変換など)

参考http://nekotheshadow.hatenablog.com/entry/2018/09/23/223155?_ga=2.37540903.605516043.1537702416-746574989.1527256880
