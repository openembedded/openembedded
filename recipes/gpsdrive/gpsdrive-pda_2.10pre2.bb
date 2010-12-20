require gpsdrive.inc

PR = "r2"

DESCRIPTION = "GPS navigation/map display software, PDA-optimized version"
HOMEPAGE = "http://www.gedanken.demon.co.uk/gpsdrive-ipaq/"

SRC_URI = "http://www.gedanken.demon.co.uk/gpsdrive-ipaq/gpsdrive-2.10pre2-ipaq-r9.tar.gz \
           file://gpsdrive.desktop \
	   file://makefile.patch "

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

SRC_URI[md5sum] = "410d4f63c05e346bafcd601f1fd8e9e2"
SRC_URI[sha256sum] = "9be8fc02639e14eb3918ae2d69abb17d753d788fdbc0ce0f2f07ff9396996098"
