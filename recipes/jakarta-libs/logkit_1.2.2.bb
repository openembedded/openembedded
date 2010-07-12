DESCRIPTION = "Logging toolkit designed for secure performance orientated logging in Java applications"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://www.apache.org/dist/avalon/logkit/source/${BP}-src.tar.gz"

inherit java-library

S = "${WORKDIR}/${BP}-dev"

DEPENDS = "fastjar-native oro servlet2.3 gnumail gnujaf log4j1.2 avalon-framework-api"

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s oro servlet-2.3 activation gnumail log4j-1.2 avalon-framework-api

  # Built everything but the JMS and JMX classes (like in Debian)
  javac -encoding ISO8859-1 -sourcepath src/java -cp $cp -d build \
    `find src/java -name \*.java -and -not \( -iwholename "*jms*" -or -wholename "*test*" \)`

  (cd src/java && find . -name "*.properties" -exec cp {} ../../build/{} \;)

  fastjar -C build -c -f ${JARFILENAME} .
}
