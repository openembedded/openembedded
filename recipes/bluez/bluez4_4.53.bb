require bluez4.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

DEPENDS += "libsndfile1"

PR = "${INC_PR}.0"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
EXTRA_OECONF += "${BTUDEV}"


SRC_URI[md5sum] = "432509193ea508da5ce23fe056625d0f"
SRC_URI[sha256sum] = "bef741e8538f99baad6c32b4026cdecc636e8fa0c9f549542a4451e0987ceccf"
