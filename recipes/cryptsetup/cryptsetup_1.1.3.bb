DESCRIPTION = "Setup virtual encryption devices under dm-crypt Linux"
HOMEPAGE = "http://code.google.com/p/cryptsetup/"
SECTION = "console"
LICENSE = "GPLv2"
DEPENDS = "util-linux-ng device-mapper libgcrypt popt"
RRECOMMENDS_${PN} = "kernel-module-aes \
                     kernel-module-dm-crypt \
                     kernel-module-md5 \
                     kernel-module-cbc \
                     kernel-module-sha256 \
                    "
PR = "r0"

SRC_URI = "http://cryptsetup.googlecode.com/files/cryptsetup-${PV}.tar.bz2"
SRC_URI[md5sum] = "318a64470861ea5b92a52f2014f1e7c1"
SRC_URI[sha256sum] = "9c8e68a272f6d9cfb6cd65cc0743f4c44a2096c61f74e0602bf40208b5e69c0a"

inherit autotools
