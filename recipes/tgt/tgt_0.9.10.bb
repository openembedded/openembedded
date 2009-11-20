DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.bz2"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
}

do_install() {
	oe_runmake DESTDIR="${D}" install
}
