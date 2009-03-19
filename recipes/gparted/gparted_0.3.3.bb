DESCRIPTION = "GNOME Partition Manager"
LICENSE = "GPL"
DEPENDS = "gtkmm parted"
PR = "r1"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/gparted/gparted-${PV}.tar.bz2 \
           file://cross.patch;patch=1 \
	   file://gparted-0.3.3-llabs.patch;patch=1;pnum=0"
