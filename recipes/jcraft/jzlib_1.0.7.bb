DESCRIPTION = "zlib implementation in Java"
LICENSES = "BSD"

HOMEPAGE = "http://www.jcraft.com/jzlib"

SRC_URI = "http://www.jcraft.com/jzlib/jzlib-${PV}.tar.gz"

inherit java-library

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

  javac -sourcepath . -d build `find com -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}
