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

SRC_URI[md5sum] = "3c52a0afb970e8a1fb2d34f30d330a83"
SRC_URI[sha256sum] = "20923a3f771a14c58c8cddfff2b589d568aff09f8a931919dc63ddaabb32407a"
