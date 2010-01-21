SECTION = "net"
DESCRIPTION = "The apache v2 web server"
DEPENDS = "apache2-native openssl expat pcre"
RDEPENDS += "openssl"

PR = "r1"

SRC_URI = "http://apache.mirrors.tds.net/httpd/httpd-${PV}.tar.bz2 \
	   file://apr-sockets-patch;patch=1 \
	   file://configure-patch;patch=1 \
	   file://server-makefile-patch;patch=1 \
	   file://configure.in.patch;patch=1 \
	   file://apr.h.in.patch;patch=1 \
           file://init"

#
# over-ride needed since apache unpacks into httpd
#
S = "${WORKDIR}/httpd-${PV}"

#
# implications - autotools defines suitable do_configure, do_install, etc.
# update-rc.d adds hooks for rc-update.
#
#
inherit autotools update-rc.d

#
# implications - used by update-rc.d scripts
#
INITSCRIPT_NAME = "apache2"
INITSCRIPT_PARAMS = "defaults 91 20"
LEAD_SONAME = "libapr-1.so.0"

CONFFILES_${PN} = "${sysconfdir}/${PN}/httpd.conf \
		   ${sysconfdir}/${PN}/magic \
		   ${sysconfdir}/${PN}/mime.types \
		   ${sysconfdir}/init.d/${PN} "

#
PACKAGES = "${PN}-doc ${PN}-dev ${PN}-dbg ${PN}"

# we override here rather than append so that .so links are
# included in the runtime package rather than here (-dev)
# and to get build, icons, error into the -dev package
FILES_${PN}-dev = "${datadir}/${PN}/build \
		${datadir}/${PN}/icons \
		${datadir}/${PN}/error \
		${bindir}/apr-config ${bindir}/apu-config \
		${libdir}/apr*.exp \
		${includedir}/${PN} \
		${libdir}/*.la \
		${libdir}/*.a"

# manual to manual
FILES_${PN}-doc += " ${datadir}/${PN}/manual"

#
# override this too - here is the default, less datadir
#
FILES_${PN} =  "${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* ${sysconfdir} \
		${sharedstatedir} ${localstatedir} /bin /sbin /lib/*.so* \
		${libdir}/${PN}"

# we want htdocs and cgi-bin to go with the binary
FILES_${PN} += "${datadir}/${PN}/htdocs ${datadir}/${PN}/cgi-bin"

#make sure the lone .so links also get wrapped in the base package
FILES_${PN} += " ${libdir}/lib*.so ${libdir}/pkgconfig/*"

CFLAGS_append = " -DPATH_MAX=4096"
CFLAGS_prepend = "-I${STAGING_INCDIR}/openssl "
EXTRA_OECONF = "--enable-ssl \
		--with-ssl=${STAGING_LIBDIR}/.. \
		--with-expat=${STAGING_LIBDIR}/.. \
		--with-pcre=${STAGING_LIBDIR}/.. \
		--enable-info \
		--enable-rewrite \
		--with-dbm=sdbm \
		--with-berkeley-db=no \
		--localstatedir=/var/${PN} \
		--with-gdbm=no \
		--with-ndbm=no \
		--includedir=${includedir}/${PN} \
		--datadir=${datadir}/${PN} \
		--sysconfdir=${sysconfdir}/${PN} \
		"

#
# here we over-ride the autotools provided do_configure.
#
do_configure() {
	( cd srclib/apr; ./buildconf ) 
	oe_runconf
}

do_compile_prepend() {
	ln -sf ${S}/srclib/apr/${TARGET_PREFIX}libtool ${S}/srclib/apr/libtool
}	

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	cat ${WORKDIR}/init | \
		sed -e 's,/usr/sbin/,${sbindir}/,g' \
		    -e 's,/usr/bin/,${bindir}/,g' \
		    -e 's,/usr/lib,${libdir}/,g' \
		    -e 's,/etc/,${sysconfdir}/,g' \
		    -e 's,/usr/,${prefix}/,g' > ${D}/${sysconfdir}/init.d/${PN}
	chmod 755 ${D}/${sysconfdir}/init.d/${PN}
# remove the goofy original files...
	rm -rf ${D}/${sysconfdir}/${PN}/original
# Expat should be found in the staging area via DEPENDS...
	rm -f ${D}/${libdir}/libexpat.*
}
