DESCRIPTION = "Parses, manipulates, and outputs XML using standard Java constructs"
LICENSE = "BSD"

HOMEPAGE = "http://jdom.org/

DEPENDS = "fastjar-native jaxen"

SRC_URI = "\
	http://www.jdom.org/dist/binary/archive/jdom-${PV}.tar.gz \
	"

inherit java-library

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s jaxen

  javac -sourcepath src/java -cp $cp -d build `find src/java -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}


SRC_URI[md5sum] = "22745cbaaddb12884ed8ee09083d8fe2"
SRC_URI[sha256sum] = "a13549087141be24ad176b659afdc2c675f1ffa5288ff999a193d6d44a282056"
