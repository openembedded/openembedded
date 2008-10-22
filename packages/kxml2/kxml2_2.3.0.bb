DESCRIPTION = "A small XML pull parser, specially designed for constrained environments such as Applets, Personal Java or MIDP devices"
HOMEPAGE = "http://kxml.sourceforge.net"
PRIORITY = "optional"
SECTION = "libs"
LICENSE = "BSD CPL LGPL"
PR = "r1"

inherit java-library

DEPENDS = "xmlpull"
RDEPENDS = "libxmlpull-java"

S = "${WORKDIR}"

JAR = "${PN}-${PV}.jar"

SRC_URI = "\
    ${SOURCEFORGE_MIRROR}/kxml/${PN}-src-${PV}.zip \
    file://makefile.patch;patch=1 \
    "

do_compile() {
 oe_runmake -C src \
    JAVAC_FLAGS="-sourcepath . -cp ${STAGING_DATADIR}/java/xmlpull.jar" \
    JAR="oefatal \"No jar invocation expected here.\"" \

 oe_runmake -C src \
    JAVAC="oefatal \"No Java compilation expected here.\"" \
    jar
}

do_stage() {
  oe_jarinstall -s src/${JAR} ${PN}.jar
}

do_install() {
  oe_jarinstall src/${JAR} ${PN}.jar
}
