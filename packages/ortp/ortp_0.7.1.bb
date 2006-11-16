PR = "r0"
LICENSE = "LGPL"
DEPENDS = "glibc "
DESCRIPTION = "An LGPL implementation of RTP - RFC3550"

inherit autotools pkgconfig

SRC_URI = "http://download.savannah.nongnu.org/releases/linphone/${PN}/sources/${P}.tar.gz"

do_stage () {
	autotools_stage_all
}
