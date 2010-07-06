DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS_${PN} = "iscsi-target"

PR = "r1"
SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz"
SRC_URI[md5sum] = "a7e40b4f6854d25e4216c6dfde441a9c"
SRC_URI[sha256sum] = "3f29e4ebdc096a601a258fc56fc15bd673c6c614fcfbe17513c0ebbe2f38b798"

EXTRA_OEMAKE += "ISCSI=1"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
}

do_install() {
	oe_runmake DESTDIR="${D}" install
}
