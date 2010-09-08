DESCRIPTION = "rlpr makes it possible to print files on remote sites to your networked printers"
HOMEPAGE = "http://freshmeat.net/projects/rlpr/"
SECTION = "console/network"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://linuxfocus.org/~guido/rlpr-2.06.tar.gz"
SRC_URI[md5sum] = "c3192d0e84ccae432e754640f6003478"
SRC_URI[sha256sum] = "32ae5893f4b9250b7a02c98a41b5929cfdd5731b6efbd7edfc77c2c5314388f7"

inherit autotools

do_configure() {
        oe_runconf
}
do_install() {
        make install DESTDIR=${D}
}

TARGET_CC_ARCH += " ${LDFLAGS}"
