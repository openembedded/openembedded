DESCRIPTION = "Game engine to run Red Alert 1"
LICENSE = "GPLv2"

DEPENDS = "virtual/libsdl libsdl-mixer" 

SRC_URI = "http://openredalert.googlecode.com/files/openredalert-${PV}-src.tar.gz \
           file://openredalert-launcher"

S = "${WORKDIR}"

CFLAGS_append = " -I. -I${STAGING_INCDIR}"

do_compile() {
	cd ${S}/src ; cp ${S}/makefile .
	oe_runmake -e 
}

do_install() {
	install -d ${D}/${datadir}/games/redalert/
	cp -pPr ${S}/data ${D}/${datadir}/games/redalert/
	install -m 0755 ${S}/src/openredalert ${D}/${datadir}/games/redalert/

	install -d ${D}/${bindir}
	install -m 0755 ${S}/openredalert-launcher ${D}/${bindir}	
}

FILES_${PN} += "${datadir}/games/redalert/"
FILES_${PN}-dbg += "${datadir}/games/redalert/.debug"
