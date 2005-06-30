BROKEN = "1"
SECTION = "console/network"
DEPENDS = "expat openssl"
DESCRIPTION = "A high performance Unix-based HTTP server."
LICENSE="Apache-2.0"

SRC_URI = "http://ftp.epix.net/apache/httpd/httpd-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://pcre-configure.patch;patch=1 \
           file://init \
	   file://httpd.conf"
S = "${WORKDIR}/httpd-${PV}"

basesysconfdir := "${sysconfdir}"
sysconfdir = "/etc/apache"

inherit autotools

FILES_${PN}="${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
	     ${libdir}/*/ ${basesysconfdir} ${sharedstatedir} ${localstatedir} \
	     /bin /sbin /lib/*/ /lib/*.so* ${datadir}/${PN} ${datadir}/htdocs \
	     ${datadir}/icons ${datadir}/cgi-bin ${datadir}/error /var"

CFLAGS_append = " -DPATH_MAX=4096"
CFLAGS_prepend = "-I${STAGING_INCDIR}/openssl "
EXTRA_OECONF = "--enable-ssl --with-ssl=${STAGING_LIBDIR}/.. --enable-dav \
		--enable-dav-fs --with-dbm=sdbm --with-berkeley-db=no \
		--with-gdbm=no --with-ndbm=no"
do_configure () {
	(cd srclib/apr && ./buildconf)
	(cd srclib/apr-util && ./buildconf)

	cp srclib/apr/build/config.guess srclib/apr/build/config.sub \
	   srclib/apr/build/PrintPath srclib/apr/build/apr_common.m4 \
	   srclib/apr/build/find_apr.m4 $apu_src_dir/build/find_apu.m4 build

	(cd srclib/pcre && autoconf)

	aclocal -I build
	autoheader
	autoconf
	oe_runconf
}

do_compile () {
	touch srclib/apr-util/uri/gen_uri_delims.lo
	${BUILD_CC} srclib/apr-util/uri/gen_uri_delims.c -o srclib/apr-util/uri/gen_uri_delims
	touch srclib/pcre/dftables.lo
	${BUILD_CC} -I/usr/include/pcre srclib/pcre/dftables.c -o srclib/pcre/dftables
	cd server
	${BUILD_CC} -I${S}/srclib/apr/include -c gen_test_char.c && touch gen_test_char.lo
	${BUILD_CC} -I${S}/os/unix -I${S}/srclib/apr/include -I${S}/srclib/apr-util/include -I${S}/include -c util_debug.c && touch util_debug.lo
	${BUILD_CC} gen_test_char.o util_debug.o -o gen_test_char
	/bin/sh ${S}/srclib/apr/libtool --silent --mode=compile ${CC} -DPATH_MAX=4096 -I${S}/srclib/apr/include -prefer-non-pic -static -c gen_test_char.c && touch gen_test_char.lo
	/bin/sh ${S}/srclib/apr/libtool --silent --mode=compile ${CC} -DPATH_MAX=4096 -I${S}/os/unix -I${S}/srclib/apr/include -I${S}/srclib/apr-util/include -I${S}/include -prefer-non-pic -static -c util_debug.c && touch util_debug.lo
	touch gen_test_char
	cd ..
	oe_runmake
}

do_install_append () {
	set -x
	install -d ${D}${basesysconfdir}/init.d
	cat ${WORKDIR}/init | \
		sed -e 's,/usr/sbin/,${sbindir}/,g; \
			s,/usr/bin/,${bindir}/,g; \
			s,/usr/lib,${libdir}/,g; \
			s,/etc/apache/,${sysconfdir}/,g; \
			s,/etc/,${basesysconfdir}/,g; \
			s,/usr/,${prefix}/,g;' > ${D}${basesysconfdir}/init.d/httpd
	chmod 755 ${D}${basesysconfdir}/init.d/httpd
	install -m 0644 ${WORKDIR}/httpd.conf ${D}${sysconfdir}/httpd.conf
}

pkg_postinst () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D httpd defaults 91 20
}

pkg_prerm () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D httpd remove
}
