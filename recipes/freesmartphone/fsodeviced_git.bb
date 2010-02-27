require cornucopia.inc
inherit fso-plugin

DEPENDS += "alsa-lib libcanberra libfsoresource"
RDEPENDS += "libcanberra-alsa"
# Included in fsodeviced itself now
# RRECOMMENDS += "fso-alsa-data"
RPROVIDES_${PN} = "openmoko-alsa-scenarios virtual/alsa-scenarios"
PV = "0.9.0+gitr${SRCREV}"
PE = "1"
PR = "${INC_PR}.10"

EXTRA_OECONF = "\
  --enable-kernel26-rfkill \
  --enable-player-canberra \
"

inherit update-rc.d

INITSCRIPT_NAME = "fsodeviced"
INITSCRIPT_PARAMS = "defaults 27"

SRC_URI += "file://fsodeviced"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/fsodeviced ${D}${sysconfdir}/init.d/
}
