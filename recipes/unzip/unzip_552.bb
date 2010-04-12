DESCRIPTION = "A (de)compression library for the ZIP format"
SECTION = "console/utils"
LICENSE = "Info-ZIP"
PR = "r1"
SRC_URI = "${SOURCEFORGE_MIRROR}/project/infozip/UnZip%205.x%20and%20earlier/5.52/unzip${PV}.tar.gz"
S = "${WORKDIR}/unzip-5.52"

export LD = "${CC} ${LDFLAGS}"

do_compile() {
        oe_runmake -f unix/Makefile generic
}

do_install() {
        oe_runmake -f unix/Makefile install prefix=${D}${prefix}
	install -d ${D}${mandir}
	mv ${D}${prefix}/man/* ${D}${mandir}
}



SRC_URI[md5sum] = "9d23919999d6eac9217d1f41472034a9"
SRC_URI[sha256sum] = "145d95e2ef1ef9add2e3c97d1340907e33ab8749eb1235372e7f0b7af600a8e9"
