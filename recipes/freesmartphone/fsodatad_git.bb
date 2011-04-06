require cornucopia.inc
inherit fso-plugin
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=78aab3f7875ffe21aebed9932fa3f993"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PR = "${INC_PR}.3"
PV = "0.1.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "\
  libxml2 \
  mobile-broadband-provider-info \
"
RDEPENDS_${PN} += "mobile-broadband-provider-info"
