SECTION = "console/utils"
DESCRIPTION = "Control program for GPS units using the MediaTek (MTK) chipset"
HOMEPAGE = "http://www.rigacci.org/wiki/doku.php/doc/appunti/hardware/gps_logger_i_blue_747"
LICENSE = "GPL"
PACKAGE_ARCH = "all"
PR = "r0"

RDEPENDS_${PN} = "libdevice-serialport-perl libtimedate-perl perl-module-file-basename perl-module-getopt-std"

SRC_URI = "${SOURCEFORGE_MIRROR}/sourceforge/${PN}/${P}.tar.gz"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 mtkbabel ${D}${bindir}/
	install -d ${D}${mandir}/man1
	install -m 0644 mtkbabel.1 ${D}${mandir}/man1/
}

SRC_URI[md5sum] = "2c33519ac28afce2ba9da2db6fb83e47"
SRC_URI[sha256sum] = "3c7b7959b7d0394a99fc95fd524b9a698c19bfe0b59188bd3cf7bb15f81ed6df"
