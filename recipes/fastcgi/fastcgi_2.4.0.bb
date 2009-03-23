LICENSE = "Open Market"
DESCRIPTION = "Fast CGI backend (web server to CGI handler) library"
PR = "r2"

SRC_URI = "http://www.fastcgi.com/dist/fcgi-${PV}.tar.gz \
file://link-against-math.patch;patch=1"

S=${WORKDIR}/fcgi-${PV}

LEAD_SONAME = "libfcgi.so*"

PARALLEL_MAKE=""

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

