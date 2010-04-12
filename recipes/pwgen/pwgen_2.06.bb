DESCRIPTION = "Password generator which creates passwords which can be easily memorized by a human"
HOMEPAGE = "http://sf.net/projects/pwgen/"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/pwgen/pwgen-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "935aebcbe610fbc9de8125e7b7d71297"
SRC_URI[sha256sum] = "61598c9e3a0f7eb2e7367d4ecc71522c4f16a7d41ed31db29e3afee8d9843454"
