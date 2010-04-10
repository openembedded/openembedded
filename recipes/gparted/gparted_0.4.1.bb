DESCRIPTION = "GNOME Partition Manager"
LICENSE = "GPL"
DEPENDS = "gtkmm parted"

inherit gnome

SRC_URI = "${SOURCEFORGE_MIRROR}/gparted/gparted-${PV}.tar.bz2 \
           file://cross.patch;patch=1 \
"

EXTRA_OECONF = " --disable-doc  --disable-scrollkeeper "

SRC_URI[md5sum] = "38762b12b8dfeb0518e24b470b1b5675"
SRC_URI[sha256sum] = "333f07ca8579f69f6b79e2ed1cf28c6b9353a64f7bab458950d7667abb3d8a3e"
