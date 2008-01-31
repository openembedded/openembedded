DESCRIPTION = "Apache Portable Runtime (APR) companion library"
SECTION = "libs"
DEPENDS = "apr expat gdbm"
LICENSE = "Apache License, Version 2.0"

PR = "r2"

# apache mirrors?
SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.gz"

EXTRA_OECONF = "--with-apr=${STAGING_BINDIR_CROSS} --with-dbm=gdbm \
		--with-gdbm=${STAGING_DIR_HOST}${layout_prefix} \
		--without-sqlite2 \
		--without-sqlite3 \
		--with-expat=${STAGING_DIR_HOST}${layout_prefix}"


inherit autotools lib_package binconfig

OE_BINCONFIG_EXTRA_MANGLE = " -e 's:location=source:location=installed:'"

do_configure() {
  cp ${STAGING_DATADIR}/apr_rules.mk ${S}/build/rules.mk
  oe_runconf
}

do_stage() {
  autotools_stage_all
  sed -i s,/usr/lib/libgdbm.la,-lgdbm,g   ${STAGING_LIBDIR}/libaprutil-1.la
  sed -i s,/usr/lib/libexpat.la,-lexpat,g ${STAGING_LIBDIR}/libaprutil-1.la
  sed -i s,/usr/lib/libapr-1.la,-lapr-1,g ${STAGING_LIBDIR}/libaprutil-1.la
}
