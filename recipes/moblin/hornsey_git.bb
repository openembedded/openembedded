DESCRIPTION = "The Moblin mediaplayer"
LICENSE = "LGPLv2.1"

SRCREV = "125a1dea08d552ed2510ee762e1b54ca161915c1"
PV = "0.0+gitr${SRCPV}"
PR = "r1"
PE = "1"

DEPENDS = "clutter clutter-gst-0.9 bickley nbtk bognor-regis libunique startup-notification gtk+"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git \
           file://fix-api.patch;patch=1 \
"
S = "${WORKDIR}/git"

inherit autotools_stage

FILES_${PN} += "${datadir}/icons"

