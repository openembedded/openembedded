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

