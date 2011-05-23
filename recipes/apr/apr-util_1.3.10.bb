DESCRIPTION = "Apache Portable Runtime (APR) companion library"
SECTION = "libs"
DEPENDS = "apr expat gdbm"
LICENSE = "Apache License, Version 2.0"

PR = "r1"

SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.gz \
           file://configfix.patch \
           file://configure_fixes.patch"

EXTRA_OECONF = "--with-apr=${STAGING_BINDIR_CROSS}/apr-1-config \ 
		--with-dbm=gdbm \
		--with-gdbm=${STAGING_DIR_HOST}${layout_prefix} \
		--without-sqlite2 \
		--without-sqlite3 \
		--without-pgsql \
		--without-odbc \
		--with-expat=${STAGING_DIR_HOST}${layout_prefix}"

SRC_URI[md5sum] = "82acd25cf3df8c72eba44eaee8b80c19"
SRC_URI[sha256sum] = "7c37ac40b2351bfc23000fb6b7b54a67e0872255df315c82eb60c821bcef4b23"

inherit autotools lib_package binconfig

OE_BINCONFIG_EXTRA_MANGLE = " -e 's:location=source:location=installed:'"

do_configure_prepend() {
	cp ${STAGING_DATADIR}/apr/apr_rules.mk ${S}/build/rules.mk
	echo "AC_PROG_LIBTOOL" >> ${S}/configure.in
}

do_configure_append() {
	sed -i -e  s:apr_builders=/usr/share/build-1:apr_builders=${STAGING_DATADIR}/build-1:g ${S}/build/rules.mk
	sed -i /^LIBTOOL/d ${S}/build/rules.mk
	echo LIBTOOL="${HOST_SYS}-libtool --tag=CC" >> ${S}/build/rules.mk
}
