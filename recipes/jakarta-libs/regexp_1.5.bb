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

SRC_URI[md5sum] = "b941b8f4de297827f3211c2cb34af199"
SRC_URI[sha256sum] = "79e80af8cbeb68ddad75a1aa6244d7acd62176bfd69bcdc0640d11177dcde97d"
