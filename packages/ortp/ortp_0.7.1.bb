PR = "r0"
LICENSE = "LGPL"
DEPENDS = "glibc "
DESCRIPTION = "An LGPL implementation of RTP - RFC3550"

inherit autotools pkgconfig

SRC_URI = "http://www.linphone.org/${PN}/sources/${P}.tar.gz"

do_stage () {
	autotools_stage_all
}
