require clutter-gst.inc

SRCREV = "70f4b0cbd568dfa265484a03be3bd08ad15ed12e"
PV = "0.9.0+git${SRCREV}"
PR = "r0"

SRC_URI = "git://git.clutter-project.org/clutter-gtk.git;protocol=git"

S = "${WORKDIR}/git"

DEPENDS = "clutter"
