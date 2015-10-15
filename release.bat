rem pass is bloodbane
%JAVA_HOME%\bin\jarsigner -verbose -keystore keys\mharkus.keystore unsigned\Viida.apk mharkus
zipalign -f -v 4 unsigned\Viida.apk aligned\Viida.apk