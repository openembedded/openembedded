DESCRIPTION = "matchbox-keyboard layouts control application"
AUTHOR = "Sergey Lapin"
SRC_URI = "git://ossfans.org/home/slapin/git/mk-layouts-gui.git;protocol=git"
LICENSE = "GPL"
PR = "r2"

S = "${WORKDIR}/git"

inherit autotools
