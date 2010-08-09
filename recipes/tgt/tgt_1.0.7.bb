DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS_${PN} = "iscsi-target"
PR = "r0"

SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz"
SRC_URI[md5sum] = "f7d2fdc39aeadc7971d40fffe029a6f5"
SRC_URI[sha256sum] = "708e7b8e5e7b5f6f4fea9fb9085e66ca9d967127d60fcbd136bcfd89a2c1db3b"

EXTRA_OEMAKE += "ISCSI=1"

do_install() {
        oe_runmake DESTDIR="${D}" install
}

TARGET_CC_ARCH += "${LDFLAGS}"
