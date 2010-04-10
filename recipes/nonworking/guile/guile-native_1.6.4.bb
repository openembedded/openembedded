SECTION = "unknown"
LICENSE = "GPL"
DEPENDS = "gmp-native"
SRC_URI = "http://ftp.gnu.org/pub/gnu/guile/guile-${PV}.tar.gz \
	   file://guile-amd64.patch;patch=1"

inherit autotools native

S="${WORKDIR}/guile-${PV}"

do_configure() {
	# no autoreconf, thanks
	oe_runconf
}

SRC_URI[md5sum] = "a4aceb5f185878c1de4e8aa7c38b6d1d"
SRC_URI[sha256sum] = "6391c9735615ee929f4ae23bbfa8373c97ae64923c7fbe72cc4b0e262c4759e0"
