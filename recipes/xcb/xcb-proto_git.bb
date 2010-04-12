DEFAULT_PREFERENCE = "-1"

include xcb-proto.inc
SRCREV = "2d873a3dc8c0e1315be426da8054adb4188574b0"
PV = "1.6+git"
PR = "r0"

SRC_URI = "git://anongit.freedesktop.org/xcb/proto;protocol=git"
S = "${WORKDIR}/git"

do_stage() {
	autotools_stage_all
}

