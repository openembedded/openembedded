DESCRIPTION = "Web server"
SECTION = "net"
DEPENDS = "sqlite3 libpcre libxml2"
LICENSE = "BSD"
PR = "r3"

SRC_URI = "http://www.lighttpd.net/download/lighttpd-1.4.13.tar.gz \
	   file://${PV}/configure.in.patch;patch=1;pnum=2 \
	   file://${PV}/src-server.c.patch;patch=1;pnum=1 \
	   file://conf/etc "

EXTRA_OECONF="--without-bzip2 \
		--without-ldap \
		--without-lua \
		--without-memcache \
		--with-pcre \
		--with-webdav-props \
		--with-webdav-locks \
		--without-openssl \
		--disable-nls \
		--disable-static"

inherit autotools pkgconfig

do_install_append() {
	cp -R ${WORKDIR}/conf/etc ${D}/etc
	rm -fR ${D}/etc/.svn
	rm -fR ${D}/etc/init.d/.svn

	chmod -R 755 ${D}/etc
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/mod_*.so /etc"
