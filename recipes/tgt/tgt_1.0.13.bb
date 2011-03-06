DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS_${PN} = "iscsi-target"
PR = "r0"

SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz \
	   file://stub-out-posix-fallocate-uclibc.patch \
	  "
SRC_URI[md5sum] = "e8363decf721a2993121e1071dbf04b1"
SRC_URI[sha256sum] = "7221dbddf4744593ea75ad9365205dab90c01b2f1a568f4b7d5276dcbef520e6"

EXTRA_OEMAKE += "ISCSI=1"

do_install() {
        oe_runmake DESTDIR="${D}" install
}

TARGET_CC_ARCH += "${LDFLAGS}"
