DESCRIPTION = "Apache Portable Runtime (APR) companion library"
SECTION = "libs"
DEPENDS = "apr expat gdbm"
LICENSE = "Apache License, Version 2.0"

PR = "r3"

inherit autotools lib_package binconfig

# apache mirrors?
SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.gz \
           file://configure_fixes.patch;patch=1"

EXTRA_OECONF = "--with-apr=${STAGING_BINDIR_CROSS} --with-dbm=gdbm \
		--with-gdbm=${STAGING_DIR_HOST}${layout_prefix} \
		--without-sqlite2 \
		--without-sqlite3 \
		--with-expat=${STAGING_DIR_HOST}${layout_prefix}"


OE_BINCONFIG_EXTRA_MANGLE = " -e 's:location=source:location=installed:'"
EXTRA_OEMAKE = " LIBTOOL=\"${S}/${TARGET_PREFIX}libtool\" "

export LIBTOOL="${S}/${TARGET_PREFIX}libtool"

do_configure_prepend() {
	cp ${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool ${S}/
	cp ${STAGING_DATADIR}/apr/apr_rules.mk ${S}/build/rules.mk
	echo "AC_PROG_LIBTOOL" >> ${S}/configure.in
	libtoolize --force
}

do_stage() {
	autotools_stage_all
}
