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


SRC_URI[md5sum] = "cc0c6d5a8f9346ad90bd5f8183789c96"
SRC_URI[sha256sum] = "998d148114abb4ae68ef2c340d971dfe09ec581850a1f0fd7c856f3c9b397b3e"
