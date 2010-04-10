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

SRC_URI[md5sum] = "01cc9a2a454dd33dcd8c856ec89af090"
SRC_URI[sha256sum] = "853aeb021aef7586bda29e74a6b03006bcb565a755c86b66032d8ec31b67dbb9"
