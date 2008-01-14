inherit autotools pkgconfig

PR = "r1"
DESCRIPTION = "GPS navigation/map display software, PDA-optimized version"
HOMEPAGE = "http://www.gedanken.demon.co.uk/gpsdrive-ipaq/"
DEPENDS = "virtual/libc gtk+ libpcre gpsd"
RDEPENDS_${PN} = "gdk-pixbuf-loader-gif gpsd"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPL"

inherit pkgconfig

SRC_URI = "http://www.gedanken.demon.co.uk/gpsdrive-ipaq/gpsdrive-2.10pre2-ipaq-r4.tar.gz \
	   file://makefile.patch;patch=1 "

S = "${WORKDIR}/gpsdrive-2.10pre2-ipaq"

FILES_${PN} = "${bindir}/gpsdrive ${datadir}/gpsdrive ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += "${datadir}/${PN}"

do_compile () {
	oe_runmake "CC=${CC}" "LD=${CC}" "STRIP=${STRIP}" all
}

do_install () {
	mkdir -p ${D}${datadir}
        cp -a ipkg-data/usr/share/*  ${D}${datadir}/
        cp -a README.iPAQ.txt ${D}${datadir}/gpsdrive
        cp -a COPYING  ${D}${datadir}/gpsdrive
        cp -a original-docs  ${D}${datadir}/gpsdrive
	mkdir -p ${D}${bindir}
        install -m 0755 gpsdrive ${D}${bindir}/
}
