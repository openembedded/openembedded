require cornucopia.inc

DESCRIPTION = "A GSM 07.10 Multiplexing Engine"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SECTION = "devel"
DEPENDS = "glib-2.0 libgsm0710 libfsotransport"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "0.9.2+gitr${SRCPV}"
PE = "1"
PR = "${INC_PR}.0"
