# CORSの設定
## CORSとは
クロスオリジンリソース共有のことで、あるオリジンから別のオリジンへのリクエストを許可する仕組みのこと。
同じオリジンは以下が一致するものと定義。どれか一つでも異なれば異なるオリジンとみなされる。
- スキーム(プロトコル)
- ホスト名(ドメイン)
- ポート番号

ブラウザは、セキュリティを守るため、デフォルトでは異なるオリジンへの通信ができなくなっている。<br>
　↓<br>
Viteで起動したフロントエンドのhttp://hoge:5173 から、SpringBootのhttp://fuga:8080 へは通信できない。

## CORSをどうやって許可するか
サーバー側で、CORSを許可する設定をする。その情報は、HTTPヘッダーに含まれ、以下のようなものがある。
- `Access-Control-Allow-Origin`:どのオリジンからのリクエストを許可するか
- `Access-Control-Allow-Methods`:どのHTTPメソッドを許可するか
- `Access-Control-Allow-Headers`:どのようなHTTPヘッダーを許可するか
  - 例えばContent-TypeやX-Custom-Header


## Springの設定
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // どのパスにCORS許可設定をするか
        registry.addMapping("/**")
        // どのオリジンからのリクエストを許可するか
        .allowedOrigins("http://127.0.0.1:5173/")
        // どのメソッドをCORSにて許可するか
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        // どのヘッダーを許可するか
        .allowedHeaders("Content-Type");
    }
}
```