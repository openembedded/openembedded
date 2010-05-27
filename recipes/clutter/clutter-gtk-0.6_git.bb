require clutter-gtk.inc

SRCREV = "2ba362a1a223c2b28541030a80aa11191615340a"
PV = "0.6.0+git${SRCREV}"

DEPENDS += "clutter-0.6"

SRC_URI = "git://git.clutter-project.org/clutter-gtk.git;protocol=git;branch=clutter-gtk-0-6"

S = "${WORKDIR}/git"
