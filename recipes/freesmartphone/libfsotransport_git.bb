require cornucopia.inc
DESCRIPTION = "freesmartphone.org transport library"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "0.9.6+gitr${SRCPV}"
PE = "1"
PR = "${INC_PR}.2"

EXTRA_OECONF = "--enable-palmpre-hsuart"
