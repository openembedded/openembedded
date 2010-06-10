require cornucopia.inc

DESCRIPTION = "freesmartphone.org apm compatibility utility"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console"
LICENSE = "GPLv2"
PE = "1"
RCONFLICTS_${PN} = "apm"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "2.0.0+gitr${SRCPV}"
PR = "${INC_PR}.1"

S = "${WORKDIR}/git/tools/apm2"
