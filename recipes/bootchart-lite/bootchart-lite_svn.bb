DESCRIPTION = "Bootchart Lite for Embedded Systems."
AUTHOR = "Fred Chien"
LICENSE = "GPLv2"
SECTION = "console/utils"
HOMEPAGE = "http://code.google.com/p/bootchart-lite/"
PV = "0.1+svnr${SRCPV}"
PR = "r0"
SRCREV = "4"

SRC_URI = "svn://bootchart-lite.googlecode.com/svn/;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit autotools

pkg_postinst_${PN} () {
	mkdir /etc/bootchart-lite
}

pkg_postrm_${PN} () {
	rm -rf /etc/bootchart-lite
}
