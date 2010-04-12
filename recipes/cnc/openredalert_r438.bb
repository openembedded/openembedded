DESCRIPTION = "Game engine to run Red Alert 1"
LICENSE = "GPLv2"

DEPENDS = "virtual/libsdl libsdl-mixer" 

SRC_URI = "http://openredalert.googlecode.com/files/openredalert-${PV}-src.tar.gz \
           file://gcc43-fix.patch;patch=1 \
           file://openredalert-launcher"

PR = "r1"

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

SRC_URI[md5sum] = "12dc7a8042c023bc77b7830946fc8492"
SRC_URI[sha256sum] = "68058b6ffd9a286111c1860ca6d53af0d98d3f0c2a53875efd72ab381a3f9d6d"
