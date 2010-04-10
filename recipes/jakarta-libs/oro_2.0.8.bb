DESCRIPTION = "Perl5-compatible regular expressions library for Java"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://www.apache.org/dist/jakarta/oro/source/jakarta-${BP}.tar.gz"

inherit java-library

S = "${WORKDIR}/jakarta-${BP}"

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

  javac -sourcepath src/java -d build `find src/java -name \*.java`

  fastjar -C build -c -f ${JARFILENAME} org
}

SRC_URI[md5sum] = "6f7690c6ba9750e3cbb8ebd10078a79a"
SRC_URI[sha256sum] = "4c4f3c7c479994c3ce09f542d4fbdc03eed58a2d7f320d32f2baf238b5b6f566"
