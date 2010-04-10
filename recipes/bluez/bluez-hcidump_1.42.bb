DESCRIPTION = "Linux Bluetooth Stack HCI Debugger Tool."
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://bluez.sourceforge.net/download/bluez-hcidump-${PV}.tar.gz"
S = "${WORKDIR}/bluez-hcidump-${PV}"

EXTRA_OECONF = "--with-bluez-libs=${STAGING_LIBDIR} --with-bluez-includes=${STAGING_INCDIR}"

inherit autotools

SRC_URI[md5sum] = "5704737aaf72104eeaf77335218a1827"
SRC_URI[sha256sum] = "689e39f9432ab90af5f390d86cb46e06c35693d01ea29aec4e41c4f9e315f49f"
