# Upgraded
# use newer version then preferred by default
PREFERRED_VERSION_dbus = "1.4.0"
PREFERRED_VERSION_dbus-native = "1.4.0"
PREFERRED_VERSION_autoconf = "2.65"
PREFERRED_VERSION_autoconf-native = "2.65"
PREFERRED_VERSION_automake = "1.11.1"
PREFERRED_VERSION_automake-native = "1.11.1"
PREFERRED_VERSION_libmikmod = "3.2.0-beta2"
PREFERRED_VERSION_mtd-utils-native = "1.2.0+git"
PREFERRED_VERSION_strace = "4.5.15"
PREFERRED_VERSION_emacs-x11 = "23.1"
PREFERRED_VERSION_ncurses = "5.7"
PREFERRED_VERSION_ncurses-native = "5.7"
PREFERRED_VERSION_python-pycairo = "1.8.0"

# we need new headers for libc, now OLDEST_KERNEL_linux-gnueabi = "2.6.24"
# and 2.6.31 for fsodeviced
LINUX_LIBC_HEADERS_VERSION ?= "2.6.32"
PREFERRED_VERSION_linux-libc-headers = "${LINUX_LIBC_HEADERS_VERSION}"
PREFERRED_VERSION_linux-libc-headers-native = "${LINUX_LIBC_HEADERS_VERSION}"

# override EFL_SRCREV from sane-srcrevs.inc
# EFL_SRCREV ?= "44424"

# specifically set an openssh version
# NOTE: whenever changing the version here make sure
#       to check we won't loose our specific config !!!
PREFERRED_VERSION_openssh = "5.2p1"

# upgrades used in Angstrom
PREFERRED_VERSION_xserver-common = "1.33"
PREFERRED_VERSION_xserver-nodm-init = "2.0"
PREFERRED_VERSION_gtk+          = "2.20.1"
PREFERRED_VERSION_gtk+-native   = "2.20.1"
PREFERRED_VERSION_hal           = "0.5.13"
LIBTOOL_HAS_SYSROOT = "yes"
LIBTOOL_VERSION = "2.4"
PREFERRED_VERSION_libtool       = "${LIBTOOL_VERSION}"
PREFERRED_VERSION_libtool-native = "${LIBTOOL_VERSION}"
PREFERRED_VERSION_libtool-cross = "${LIBTOOL_VERSION}"
PREFERRED_VERSION_libtool-sdk   = "${LIBTOOL_VERSION}"
PREFERRED_VERSION_udev          = "151"
PREFERRED_VERSION_usbutils      = "0.86"
PREFERRED_VERSION_wpa-supplicant = "0.6.9"
PREFERRED_VERSION_glib-2.0      = "2.24.1"
PREFERRED_VERSION_glib-2.0-native = "2.24.1"
PREFERRED_VERSION_openssl = "1.0.0a"
PREFERRED_VERSION_openssl-native = "1.0.0a"
UDEV_GE_141 = "1"

PREFERRED_VERSION_postgresql = "8.4.4"
ANGSTROM_QT_VERSION ?= "4.7.0"
PREFERRED_VERSION_qt4-tools-native = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-tools-sdk = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-embedded = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-embedded-gles = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-x11-free = "${ANGSTROM_QT_VERSION}"
PREFERRED_VERSION_qt4-x11-free-gles = "${ANGSTROM_QT_VERSION}"

PREFERRED_VERSION_tslib = "1.0+git%"

# epdf needs > 0.12, but recipes have D_P = -1
PREFERRED_VERSION_poppler = "0.12.3"

# git version fails to build
PREFERRED_VERSION_mupdf = "0.6"

# Downgraded
PREFERRED_VERSION_pulseaudio = "0.9.15"
