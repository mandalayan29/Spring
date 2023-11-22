

Server.port= 8443
// want to make this as https port

Server.ssl.key-alias=httpexample
Server.ssl.key-store-type=JKS
Server.ssl.key-password=password
Server.ssl.key-store=classpath:httpsexmaple.jks

Can secure in two types
Ssl- secure socket layer
tls- transport layer security


Trust store- store public certificate
Keystore- private certificate



keytool -genkey -alias httpsexample -storetype JKS -keyalg RSA -keysize 2048 -validity 365 -keystore httpsexample.jks

