require clutter-gtk.inc

PV = "0.8.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "clutter"

SRC_URI = "git://git.clutter-project.org/clutter-gtk.git;protocol=git;branch=clutter-gtk-0-8"

S = "${WORKDIR}/git"
