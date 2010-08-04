DESCRIPTION = "The Moblin mediaplayer"
LICENSE = "LGPLv2.1"

SRCREV = "125a1dea08d552ed2510ee762e1b54ca161915c1"
PV = "0.0"
PR = "r1"
PR_append = "+git${SRCREV}"

DEPENDS = "clutter-0.9 clutter-gst-0.9 bickley nbtk bognor-regis libunique startup-notification gtk+"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git \
           file://fix-api.patch \
"
S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "${datadir}/icons"

