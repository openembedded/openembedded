DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS_${PN} = "iscsi-target"

<<<<<<< HEAD:recipes/tgt/tgt_1.0.5.bb
PR = "r0"
SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz"
SRC_URI[md5sum] = "200fb1b4e8d42b072de2bac238c7d779"
SRC_URI[sha256sum] = "b8cc9fdbacdcd9717b6c4bc15f7999a5bd4a20a334a09b47a3ae5ea21383eb1a"
=======
PR = "r1"
SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz;name=tgttargz"
SRC_URI[tgttargz.md5sum] = "5a7c6b2c585c5f969c64e2c19f49f439"
SRC_URI[tgttargz.sha256sum] = "018f772370fe3dae815e09416e5dae5ae464335a1efe6343cf80612a29fe54e4"
>>>>>>> 2bca6bd1a15123af28ff5ef8fd6ebb417a3a4dee:recipes/tgt/tgt_1.0.3.bb


EXTRA_OEMAKE += "ISCSI=1"

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
}

do_install() {
	oe_runmake DESTDIR="${D}" install
}
