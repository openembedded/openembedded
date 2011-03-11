DESCRIPTION = "Linux Bluetooth Stack HCI Debugger Tool."
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "bluez-libs"
LICENSE = "GPLv2"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/bluez-hcidump-${PV}.tar.gz"
S = "${WORKDIR}/bluez-hcidump-${PV}"

EXTRA_OECONF = "--with-bluez-libs=${STAGING_LIBDIR} --with-bluez-includes=${STAGING_INCDIR}"

inherit autotools

SRC_URI[md5sum] = "5c2e3ef0a68b2845047867ba51ff8ac9"
SRC_URI[sha256sum] = "b3b64fd0b18301df07d3aaf34c037c1e4808b4aaf702294822d62b5424f617fd"
