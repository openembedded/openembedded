DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r3"
ALLOW_EMPTY = "1"

inherit sdk

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    pkgconfig-sdk \
    opkg-sdk \
    libtool-sdk \
    "
