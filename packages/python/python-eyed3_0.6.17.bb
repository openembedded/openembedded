DESCRIPTION = "Module for manipulating ID3 (v1 + v2) tags in Python"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Andreas Frisch <andreas.frisch@multimedia-labs.de>"
LICENSE = "GPL"
SRCNAME = "eyed3"

SRC_URI = "http://eyed3.nicfit.net/releases/eyeD3-${PV}.tar.gz"
SRC_URI_append_opendreambox = " file://python-${SRCNAME}_${PV}/no-shutil_fixed-utf8-filesystemencoding.patch;patch=1;pnum=0"

S = "${WORKDIR}/eyeD3-${PV}"

inherit distutils

do_configure() {
	cd ${S}
	ls
	./configure
}
