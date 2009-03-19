DESCRIPTION = "Framework for constructing recognizers, interpreters, compilers, and translators"
# see http://www.antlr2.org/license.html
LICENSE = "Public Domain"
HOMEPAGE = "http://www.antlr2.org"

SRC_URI = "http://www.antlr2.org/download/${BP}.tar.gz"

inherit java-library

do_compile() {
  mkdir -p build

  javac -sourcepath . -d build `find antlr -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}
