SECTION = "unknown"
LICENSE = "GPL"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SRC_URI = "http://ftp.gnu.org/pub/gnu/guile/guile-${PV}.tar.gz \
	   file://guile-amd64.patch;patch=1"

inherit autotools native

S="${WORKDIR}/guile-${PV}"

do_configure() {
	# no autoreconf, thanks
	oe_runconf
}
