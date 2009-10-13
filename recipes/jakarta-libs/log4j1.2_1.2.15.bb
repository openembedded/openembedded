DESCRIPTION = "Java library to help the programmer output log statements to a variety of output targets"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://archive.apache.org/dist/logging/log4j/${PV}/apache-log4j-${PV}.tar.gz"

inherit java-library

S = "${WORKDIR}/apache-log4j-${PV}"

DEPENDS = "fastjar-native gnumail gnujaf"

JARFILENAME = "log4j-${PV}.jar"
ALTJARFILENAMES = "log4j-1.2.jar log4j1.2.jar"

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s activation gnumail

  # Built everything but the JMS and JMX classes (like in Debian)
	javac -sourcepath src/main/java -cp $cp -d build `find src/main/java -name "*.java" -and -not \( -iwholename "*jms*" -or -iwholename "*jmx*" \)`

  cp -r src/main/resources/* build/

  fastjar -C build -c -f ${JARFILENAME} .
}
