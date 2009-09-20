DESCRIPTION = "Tcl interpreter for Java"
LICENSES = "BSD"

HOMEPAGE = "http://sourceforge.net/projects/tcljava"

SRC_URI = "http://downloads.sourceforge.net/tcljava/jacl${PV}.tar.gz"

inherit java-library

S = "${WORKDIR}/jacl${PV}"

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

  javac -sourcepath src/tcljava:src/jacl -d build `find src/tcljava src/jacl -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}
