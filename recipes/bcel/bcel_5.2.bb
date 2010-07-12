DESCRIPTION = "Java Bytecode manipulation library"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://archive.apache.org/dist/jakarta/bcel/source/${BP}-src.tar.gz"

inherit java-library

DEPENDS = "fastjar-native xerces-j regexp"

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s xercesImpl regexp

  javac -sourcepath src/java -d build -cp $cp `find src/java -name \*.java`

  fastjar -C build -c -f ${JARFILENAME} .
}
