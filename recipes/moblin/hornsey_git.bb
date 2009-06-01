DESCRIPTION = "The Moblin mediaplayer"
LICENSE = "LGPLv2.1"

SRCREV = "92e1ebf8f5fdb8f4abcc190213c20b653aac411a"
PV = "0.0"
PR_append = "+git${SRCREV}"

DEPENDS = "clutter clutter-gst-0.9 bickley nbtk bognor-regis libunique startup-notification gtk+"

SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
S = "${WORKDIR}/git"

inherit autotools_stage

