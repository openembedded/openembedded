require cornucopia.inc

DESCRIPTION = "A GSM 07.10 Multiplexing Engine"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "GPL"
SECTION = "devel"
DEPENDS = "glib-2.0 libgsm0710 libfsotransport"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "0.9.2+gitr${SRCPV}"
PE = "1"
PR = "${INC_PR}.0"
