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

SRC_URI[md5sum] = "a7ec8300e8933164e854460c73ac6269"
SRC_URI[sha256sum] = "0edac0a7d2253c29c44ccc92427fa9ad4ee81b6c82142e417f72399a8584b749"
