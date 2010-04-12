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

SRC_URI[md5sum] = "2d8b899aeeebbbe68158d25adf8a4f1e"
SRC_URI[sha256sum] = "915ee6c4b8f1ffd5313d990875cd44e5e7092a51de259707daca797fd5c42b46"
