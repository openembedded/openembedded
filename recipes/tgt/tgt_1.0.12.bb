DESCRIPTION = "Linux target framework (tgt) aims to simplify various SCSI target driver (iSCSI, Fibre Channel, SRP, etc) creation and maintenance"
HOMEPAGE = "http://stgt.berlios.de/"
LICENSE = "GPLv2"
DEPENDS = "openssl"
RDEPENDS_${PN} = "iscsi-target"
PR = "r2"

SRC_URI = "http://stgt.berlios.de/releases/tgt-${PV}.tar.gz \
	   file://stub-out-posix-fallocate-uclibc.patch \
	  "
SRC_URI[md5sum] = "d3bc4098d0ec6f4418e574ea7fdd18eb"
SRC_URI[sha256sum] = "4d90567997e16194b86cc3ab0a55c7aa5c5054681176b60c6635b20a1feaffe2"

EXTRA_OEMAKE += "ISCSI=1"

do_install() {
        oe_runmake DESTDIR="${D}" install
}

TARGET_CC_ARCH += "${LDFLAGS}"
