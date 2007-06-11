DESCRIPTION = "matchbox-keyboard layouts control application"
AUTHOR = "Sergey Lapin"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS = "gtk+"
PR = "r3"

SRC_URI = "git://ossfans.org/home/slapin/git/mk-layouts-gui.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools
