include boost-38.inc

PR = "r2"

# See http://lwn.net/Articles/314144/ for the ARM atomic discussion.

SRC_URI = "${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2 \
	file://armv4-intrinsics-1.38.patch;patch=1 \
	"

BJAM_OPTS += "--disable-long-double"
