require bluez4.inc

SRC_URI[md5sum] = "fd2586143e2d87ee5cb1474cf2d6a221"
SRC_URI[sha256sum] = "7dac3fb1c6d92fd86e5d98923c4da48b14fffec7b327f9008cacd1ca7777f371"

DEPENDS += "libsndfile1"

PR = "${INC_PR}.0"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
BTUDEV_shr = " --enable-udevrules"

EXTRA_OECONF += "${BTUDEV}"
