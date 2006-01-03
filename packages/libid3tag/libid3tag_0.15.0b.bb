PR = "r1"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "zlib"
DESCRIPTION = "Library for interacting with ID3 tags."
LICENSE = "GPL"

SRC_URI = "ftp://ftp.mars.org/pub/mpeg/libid3tag-${PV}.tar.gz "
S = "${WORKDIR}/libid3tag-${PV}"

inherit autotools 

EXTRA_OECONF = "-enable-speed"

do_stage() {
	autotools_stage_all
}
