DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS = "iscsi-target"

PR = "r0"
SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz;name=tgttargz"
SRC_URI[tgttargz.md5sum] = "5a7c6b2c585c5f969c64e2c19f49f439"
SRC_URI[tgttargz.sha256sum] = "018f772370fe3dae815e09416e5dae5ae464335a1efe6343cf80612a29fe54e4"


EXTRA_OEMAKE += "ISCSI=1"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
}

do_install() {
	oe_runmake DESTDIR="${D}" install
}
