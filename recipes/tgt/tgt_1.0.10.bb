DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS_${PN} = "iscsi-target"
PR = "r0"

SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz"
SRC_URI[md5sum] = "c9cb76dc9026d59b52283daa67c9f9ae"
SRC_URI[sha256sum] = "77a2d1f57cd9893fb2a1f4157d9241ac21efff9875126ed6aabb8cc0d9f9a93b"

EXTRA_OEMAKE += "ISCSI=1"

do_install() {
        oe_runmake DESTDIR="${D}" install
}

TARGET_CC_ARCH += "${LDFLAGS}"
