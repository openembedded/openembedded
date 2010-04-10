DESCRIPTION = "Apache Portable Runtime (APR) companion library"
SECTION = "libs"
DEPENDS = "apr expat gdbm"
LICENSE = "Apache License, Version 2.0"

PR = "r5"

SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.gz \
           file://configfix.patch;patch=1 \
           file://configure_fixes.patch;patch=1"

EXTRA_OECONF = "--with-apr=${STAGING_BINDIR_CROSS}/apr-1-config \ 
		--with-dbm=gdbm \
		--with-gdbm=${STAGING_DIR_HOST}${layout_prefix} \
		--without-sqlite2 \
		--without-sqlite3 \
		--with-expat=${STAGING_DIR_HOST}${layout_prefix}"


inherit autotools_stage lib_package binconfig

OE_BINCONFIG_EXTRA_MANGLE = " -e 's:location=source:location=installed:'"

do_configure_prepend() {
	cp ${STAGING_DATADIR}/apr/apr_rules.mk ${S}/build/rules.mk
	echo "AC_PROG_LIBTOOL" >> ${S}/configure.in
}

do_configure_append() {
	sed -i -e  s:apr_builders=/usr/share/build-1:apr_builders=${STAGING_DATADIR}/build-1:g ${S}/build/rules.mk
	sed -i /^LIBTOOL/d ${S}/build/rules.mk
	echo LIBTOOL="${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool --tag=CC" >> ${S}/build/rules.mk
}


SRC_URI[md5sum] = "a10e2ca150ff07f484c724c36142211f"
SRC_URI[sha256sum] = "3f07ffdb18fb853290c9b83e82cd5cae66b8fbc357bd391e846c0afdd24fed7e"
