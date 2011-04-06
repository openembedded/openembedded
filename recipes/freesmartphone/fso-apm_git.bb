require cornucopia.inc

DESCRIPTION = "freesmartphone.org apm compatibility utility"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ebb5c50ab7cab4baeffba14977030c07"
PE = "1"
RCONFLICTS_${PN} = "apm"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "2.0.0+gitr${SRCPV}"
PR = "${INC_PR}.1"

S = "${WORKDIR}/git/tools/apm2"
