require bluez4.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

DEPENDS += "libsndfile1"
PR = "${INC_PR}.1"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
EXTRA_OECONF += "${BTUDEV}"


SRC_URI[md5sum] = "b54a199004b578ec5652014a5e62aeaa"
SRC_URI[sha256sum] = "830bb7da6836b0c709abee212ed8387e1ad8cd7087ed0b925fad3d16b0113b76"
