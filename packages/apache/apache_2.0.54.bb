MAINTAINER="David Karlstrom <daka@nslu2-linux.org>"
SECTION = "net"
DEPENDS = "openssl expat pcre"

PR = "r4"

# ------------------------------------------
# NOTE: This package is currently only meant
# to be built nativly on the target device
# ------------------------------------------

SRC_URI = "http://www.apache.org/dist/httpd/httpd-${PV}.tar.gz \
	   "

S = "${WORKDIR}/httpd-${PV}"

inherit autotools update-rc.d

INITSCRIPT_NAME = "apache"
INITSCRIPT_PARAMS = "defaults 91 20"

CONFFILES_${PN} = "${sysconfdir}/apache/httpd.conf \
		   ${sysconfdir}/apache/ssl.conf \
		   ${sysconfdir}/apache/magic \
		   ${sysconfdir}/apache/mime.types \
		   ${datadir}/apache/htdocs/index.html \
		   ${datadir}/apache/htdocs/apache_pb.gif \
		  "

PACKAGES = "libaprutil libapr apache-dev apache-doc apache"
FILES_libapr = "${libdir}/libapr*.so.0* ${libdir}/apr.exp"
FILES_libaprutil = "${libdir}/libaprutil*.so.0* ${libdir}/aprutil.exp"

FILES_apache-dev_prepend = "${datadir}/apache/build ${bindir}/apr-config ${bindir}/apu-config "
FILES_apache-doc_prepend = "${datadir}/apache/manual "

FILES_${PN} = "${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
	       ${libdir}/*/ ${sysconfdir} ${sharedstatedir} ${localstatedir} \
	       ${datadir}/apache"

CFLAGS_append = " -DPATH_MAX=4096"
CFLAGS_prepend = "-I${STAGING_INCDIR}/openssl "
EXTRA_OECONF = "--enable-ssl \
		--with-ssl=${STAGING_LIBDIR}/.. \
		--enable-dav \
		--enable-dav-fs \
		--with-dbm=sdbm \
		--with-berkeley-db=no \
		--localstatedir=${localstatedir}/log/apache \
		--with-gdbm=no \
		--with-ndbm=no \
		--datadir=${datadir}/apache \
		--sysconfdir=${sysconfdir}/apache \
		"

export LD_LIBRARY_PATH=${STAGING_LIBDIR}

do_configure () {
	# Looks like rebuilding configure doesn't work, so we are skipping
	# that and are just using the shipped one
	oe_runconf
}

do_install_append () {
	set -x
	rm ${D}/${datadir}/apache/htdocs/index*
	rm ${D}/${datadir}/apache/htdocs/apache_pb2.*
	rm ${D}/${datadir}/apache/htdocs/apache_pb.png
	install -m 0644 ${FILESDIR}/index.html ${D}/${datadir}/apache/htdocs/

	install -d ${D}/${sysconfdir}/init.d
	cat ${FILESDIR}/init | \
		sed -e 's,/usr/sbin/,${sbindir}/,g' \
		    -e 's,/usr/bin/,${bindir}/,g' \
		    -e 's,/usr/lib,${libdir}/,g' \
		    -e 's,/etc/,${sysconfdir}/,g' \
		    -e 's,/usr/,${prefix}/,g' > ${D}/${sysconfdir}/init.d/apache
	chmod 755 ${D}/${sysconfdir}/init.d/apache
	
	install -m 0644 ${FILESDIR}/httpd.conf ${D}/${sysconfdir}/apache/httpd.conf
	
	rm ${D}/${libdir}/libexpat.*
}

python () {
	# Don't build apache unless we are building nativly
	target = bb.data.getVar("TARGET_ARCH", d, 1)
	build = bb.data.getVar("BUILD_ARCH", d, 1)
	if target != build:
		raise bb.parse.SkipPackage("Apache will only build nativly (TARGET_ARCH == BUILD_ARCH)")
}

