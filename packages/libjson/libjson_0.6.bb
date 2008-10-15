DESCRIPTION = "A library for parsing and creating JSON files"
HOMEPAGE = "http://oss.metaparadigm.com/json-c/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "http://oss.metaparadigm.com/json-c/json-c-${PV}.tar.gz"
S = "${WORKDIR}/json-c-${PV}"

inherit autotools 

do_stage() {
	autotools_stage_all
}
