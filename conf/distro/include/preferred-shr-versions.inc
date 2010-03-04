# Upgraded
# use newer version then preferred by default
PREFERRED_VERSION_boost = "1.40.0"
PREFERRED_VERSION_dbus = "1.3.0"
PREFERRED_VERSION_autoconf = "2.63"
PREFERRED_VERSION_autoconf-native = "2.63"
PREFERRED_VERSION_libmikmod = "3.2.0-beta2"
PREFERRED_VERSION_mtd-utils-native = "1.2.0+git"
PREFERRED_VERSION_strace = "4.5.15"
PREFERRED_VERSION_mesa-dri     = "7.7.999"

# We need this for jamvm
PREFERRED_VERSION_classpath = "0.98"
PREFERRED_VERSION_classpath-native = "0.98"

# we need new headers for libc, now OLDEST_KERNEL_linux-gnueabi = "2.6.24"
# and 2.6.31 for fsodeviced
PREFERRED_VERSION_linux-libc-headers = "2.6.32"

# override EFL_SRCREV from sane-srcrevs.inc
# EFL_SRCREV ?= "44424"

# specifically set an openssh version
# NOTE: whenever changing the version here make sure
#       to check we won't loose our specific config !!!
PREFERRED_VERSION_openssh = "5.2p1"

# upgrades used in Angstrom
PREFERRED_VERSION_gtk+          = "2.18.6"
PREFERRED_VERSION_gtk+-native   = "2.18.6"
PREFERRED_VERSION_hal           = "0.5.13"
PREFERRED_VERSION_libtool       = "2.2.6b"
PREFERRED_VERSION_libtool-native = "2.2.6b"
PREFERRED_VERSION_libtool-cross = "2.2.6b"
PREFERRED_VERSION_libtool-sdk   = "2.2.6b"
PREFERRED_VERSION_udev          = "151"
PREFERRED_VERSION_usbutils      = "0.86"
PREFERRED_VERSION_wpa-supplicant = "0.6.9"
PREFERRED_VERSION_glib-2.0      = "2.22.4"
PREFERRED_VERSION_glib-2.0-native = "2.22.4"
UDEV_GE_141 = "1"

ANGSTROM_QT_VERSION ?= "4.6.2"
PREFERRED_VERSION_qt4-tools-native = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-tools-sdk = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-embedded = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-embedded-gles = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-x11-free = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-x11-free-gles = "${ANGSTROM_QT_VERSION}"

# epdf needs > 0.12, but recipes have D_P = -1
PREFERRED_VERSION_poppler = "0.12.3"

# Downgraded
PREFERRED_VERSION_pulseaudio = "0.9.15"
