DESCRIPTION = "Java Regular Expression package"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://archive.apache.org/dist/jakarta/regexp/source/jakarta-${BP}.tar.gz"

inherit java-library

S = "${WORKDIR}/jakarta-${BP}"

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

  javac -sourcepath src/java -d build `find src/java -name \*.java`

  fastjar -C build -c -f ${JARFILENAME} .
}
