require cornucopia.inc
inherit fso-plugin

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=78aab3f7875ffe21aebed9932fa3f993"

DEPENDS += "alsa-lib"

# We need to uncomment the line below after the migration of all scenario files from
# fsodeviced to fsoaudiod is done. Otherwise we will get build errors as both fsodeviced
# and fsoaudiod are dependencies of the FSO framework.
# PROVIDES_${PN} = "openmoko-alsa-scenarios virtual/alsa-scenarios"

SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "0.1.0+gitr${SRCPV}"
PE = "2"
PR = "${INC_PR}.2"

inherit update-rc.d

INITSCRIPT_NAME = "fsoaudiod"
INITSCRIPT_PARAMS = "defaults 30"

SRC_URI += "file://fsoaudiod"

CONFFILES_${PN} = " \
  ${sysconfdir}/freesmartphone/conf/palm_pre/fsoaudiod.conf \
  ${sysconfdir}/asound.conf \
"
RCONFLICTS_${PN} = "alsa-state"

do_install_append() {
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/fsoaudiod ${D}${sysconfdir}/init.d/
}
