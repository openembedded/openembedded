DESCRIPTION = "kxml2 is a small XML pull parser"
HOMEPAGE = "http://kxml.sourceforge.net/"
LICENSE  = "BSD"
PRIORITY = "optional"
PR = "r0"

SRC_URI = "http://downloads.sourceforge.net/kxml/kxml2-2.3.0.jar"

JAR = ${PN}-${PV}.jar

do_unpack() {
	:
}

do_install() {

install -d ${D}${datadir}/java
install -m 0644 ${DL_DIR}/${JAR} ${D}${datadir}/java

}

do_stage() {

install -d ${STAGING_DATADIR}/java
install -m 0644 ${DL_DIR}/${JAR} ${STAGING_DATADIR}/java

}

PACKAGES = "${PN}"

FILES_${PN} = "${datadir}/java/${JAR}"
