DESCRIPTION = "Curses Development Kit"
HOMEPAGE = "http://invisible-island.net/cdk/"
SECTION = "devel/libs"
LICENSE = "MIT"

SRC_URI = "ftp://invisible-island.net/cdk/cdk-${PV}.tgz"

inherit autotools

EXTRA_OEMAKE += 'DOCUMENT_DIR="${D}${datadir}/doc/cdk"'

# FIXME
do_configure() {
	gnu-configize
	oe_runconf
}

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "0ec2460a4484d5f5595d8faca61bc9c5"
SRC_URI[sha256sum] = "e823bfcce52916727cb23d6d549a64347c45c364b3c628d6a352c407fce8f4b4"
