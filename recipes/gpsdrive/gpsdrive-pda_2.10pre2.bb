require gpsdrive.inc

PR = "r2"

DESCRIPTION = "GPS navigation/map display software, PDA-optimized version"
HOMEPAGE = "http://www.gedanken.demon.co.uk/gpsdrive-ipaq/"

SRC_URI = "http://www.gedanken.demon.co.uk/gpsdrive-ipaq/gpsdrive-2.10pre2-ipaq-r4.tar.gz \
           file://gpsdrive.desktop \
	   file://makefile.patch;patch=1 "

S = "${WORKDIR}/gpsdrive-2.10pre2-ipaq"

do_compile() {
	oe_runmake "CC=${CC}" "LD=${CC}" "STRIP=${STRIP}" all
}

do_install() {
	mkdir -p ${D}${datadir}
        cp -a ipkg-data/usr/share/*  ${D}${datadir}/
        cp -a README.iPAQ.txt ${D}${datadir}/gpsdrive
        cp -a COPYING  ${D}${datadir}/gpsdrive
        cp -a original-docs  ${D}${datadir}/gpsdrive

	mkdir -p ${D}${bindir}
        install -m 0755 gpsdrive ${D}${bindir}/
}

FILES_${PN} += "${datadir}/gpsdrive"
