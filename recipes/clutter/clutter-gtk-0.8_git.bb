require clutter-gtk.inc

SRCREV = "7d3c3230376e731c06c21afa9d8c1d44dbea27cd"
PV = "0.8.0+git${SRCREV}"

DEPENDS += "clutter"

SRC_URI = "git://git.clutter-project.org/clutter-gtk.git;protocol=git;branch=clutter-gtk-0-8"

S = "${WORKDIR}/git"
