DESCRIPTION = "GNOME Partition Manager"
LICENSE = "GPL"
DEPENDS = "gtkmm parted"
PR = "r1"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/gparted/gparted-${PV}.tar.bz2 \
           file://cross.patch;patch=1 \
	   file://gparted-0.3.3-llabs.patch;patch=1;pnum=0"

SRC_URI[md5sum] = "f3d16ccfda72fa1dac9fa1ff9ded2c42"
SRC_URI[sha256sum] = "c7c86abd344055bdf1f840a037d04064759f52039cb075260b60369b721f245c"
