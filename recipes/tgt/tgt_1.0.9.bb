DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS_${PN} = "iscsi-target"
PR = "r0"

SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz"
SRC_URI[md5sum] = "872a7258af278bdd81c861217eb3e51e"
SRC_URI[sha256sum] = "86c956bf865fc20bf6196f729a6c8ee4f9ca3742b9fe6d39a60fc8c19e31a361"

EXTRA_OEMAKE += "ISCSI=1"

do_install() {
        oe_runmake DESTDIR="${D}" install
}

TARGET_CC_ARCH += "${LDFLAGS}"
