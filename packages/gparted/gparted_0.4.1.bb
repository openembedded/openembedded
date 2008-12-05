DESCRIPTION = "GNOME Partition Manager"
LICENSE = "GPL"
DEPENDS = "gtkmm parted"

inherit gnome

SRC_URI = "${SOURCEFORGE_MIRROR}/gparted/gparted-${PV}.tar.bz2 \
           file://cross.patch;patch=1 \
"

EXTRA_OECONF = " --disable-doc  --disable-scrollkeeper "
