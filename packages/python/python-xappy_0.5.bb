DESCRIPTION = "The xappy python module is an easy-to-use interface to the Xapian search engine"
LICENSE = "GPLv2"

DEPENDS += "xapian-core"

SRC_URI = "http://xappy.googlecode.com/files/xappy-${PV}.tar.gz"

inherit distutils

S = "${WORKDIR}/xappy-${PV}"

do_stage() {
	distutils_stage_all
}
	
