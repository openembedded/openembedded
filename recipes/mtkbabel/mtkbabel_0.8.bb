SECTION = "console/utils"
DESCRIPTION = "Control program for GPS units using the MediaTek (MTK) chipset"
HOMEPAGE = "http://www.rigacci.org/wiki/doku.php/doc/appunti/hardware/gps_logger_i_blue_747"
LICENSE = "GPL"
PACKAGE_ARCH = "all"
PR = "r1"

RDEPENDS = "libdevice-serialport-perl libtimedate-perl perl-module-file-basename perl-module-getopt-std"

SRC_URI = "${SOURCEFORGE_MIRROR}/sourceforge/${PN}/${P}.tar.gz \
	   file://fast-logging.patch;patch=1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 mtkbabel ${D}${bindir}/
	install -d ${D}${mandir}/man1
	install -m 0644 mtkbabel.1 ${D}${mandir}/man1/
}

SRC_URI[md5sum] = "d5518b678bffb58ceeae898d950ee27e"
SRC_URI[sha256sum] = "591597c0787822c9fd56c7a3da214e81edd3c98f32d16858221e02dfc0f63779"
