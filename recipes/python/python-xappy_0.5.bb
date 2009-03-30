DESCRIPTION = "The xappy python module is an easy-to-use interface to the Xapian search engine"
SECTION = "devel/python"
LICENSE = "GPLv2"
DEPENDS = "xapian-core"
PR = "ml0"

SRC_URI = "http://xappy.googlecode.com/files/xappy-${PV}.tar.gz"
S = "${WORKDIR}/xappy-${PV}"

inherit distutils

do_stage() {
	distutils_stage_all
}

