LICENSE = "Open Market"
DESCRIPTION = "Fast CGI backend (web server to CGI handler) library"
PR = "r1"

SRC_URI = "http://www.fastcgi.com/dist/fcgi-${PV}.tar.gz"

S=${WORKDIR}/fcgi-${PV}

LEAD_SONAME = "libfcgi.so*"

PARALLEL_MAKE=""

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

do_compile() {
}

