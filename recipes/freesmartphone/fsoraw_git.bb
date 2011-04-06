require cornucopia.inc

DESCRIPTION = "A console wrapper for the FSO Usage API"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "fso/base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ebb5c50ab7cab4baeffba14977030c07"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "1.0.0+gitr${SRCPV}"
PR = "${INC_PR}.0"
PE = "1"

S = "${WORKDIR}/git/tools/fso-raw"

# for backward compatibility in scripts
do_install_append() {
        install -d ${D}${bindir}
	ln -s fso-raw ${D}${bindir}/fsoraw
}
