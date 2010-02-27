DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS = "iscsi-target"

PR = "r0"
SRC_URI = "http://stgt.berlios.de/releases/tgt-1.0.2.tar.gz;name=tgt102targz"
SRC_URI[tgt102targz.md5sum] = "69f55046aaba9c8b9599115366b3938b"
SRC_URI[tgt102targz.sha256sum] = "ab5db63cb1a1bd74d7c5f1e4fe2727fa22d992c38fd346917506954f960f0586"


EXTRA_OEMAKE += "ISCSI=1"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
}

do_install() {
	oe_runmake DESTDIR="${D}" install
}
