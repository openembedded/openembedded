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

SRC_URI[md5sum] = "d06e2dcef6ac6c975311e88083d8ef26"
SRC_URI[sha256sum] = "f30ffe64bcf4fc8a82a76594c254ce54c82a33d797cdc0f35f19519572f94c4a"
