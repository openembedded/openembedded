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

