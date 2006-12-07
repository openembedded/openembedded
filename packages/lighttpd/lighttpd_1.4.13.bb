DESCRIPTION = "Web server"
SECTION = "net"
#DEPENDS = "libpcre openssl"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "http://www.lighttpd.net/download/lighttpd-1.4.13.tar.gz \
file://${PV}/configure.in.patch;patch=1;pnum=2 file://${PV}/src-server.c.patch;patch=1;pnum=1"

EXTRA_OECONF="--without-bzip2 \
		--without-ldap \
		--without-lua \
		--without-memcache \
		--without-mysql \
		--without-pcre \
		--without-openssl \
		--without-webdav-locks \
		--without-webdav-props \
		--disable-nls \
		--disable-static"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/mod_*.so"
