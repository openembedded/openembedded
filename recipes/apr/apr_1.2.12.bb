DESCRIPTION = "Apache Portable Runtime (APR) library"
SECTION = "libs"
LICENSE = "Apache License, Version 2.0"

PR = "r1"

# apache mirrors?
SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.bz2 \
           file://configure_fixes.patch;patch=1"

inherit autotools lib_package binconfig

OE_BINCONFIG_EXTRA_MANGLE = " -e 's:location=source:location=installed:'"
EXTRA_OEMAKE = " LIBTOOL=\"${S}/${TARGET_PREFIX}libtool\" "

do_configure_prepend() {
	rm -f ${S}/build/libtool.m4
}

do_stage() {
  autotools_stage_all
  install -d ${STAGING_DATADIR}/apr
  cp ${S}/build/apr_rules.mk ${STAGING_DATADIR}/apr/
  sed -i s,apr_builddir=.*,apr_builddir=,g ${STAGING_DATADIR}/apr/apr_rules.mk
  sed -i s,apr_builders=.*,apr_builders=,g ${STAGING_DATADIR}/apr/apr_rules.mk
  sed -i s,LIBTOOL=.*,LIBTOOL=\$\(SHELL\)\ ${TARGET_PREFIX}libtool,g ${STAGING_DATADIR}/apr/apr_rules.mk
  sed -i s,\$\(apr_builders\),${STAGING_DATADIR}/apr/,g ${STAGING_DATADIR}/apr/apr_rules.mk
  cp ${S}/build/mkdir.sh ${STAGING_DATADIR}/apr/
  cp ${S}/build/make_exports.awk ${STAGING_DATADIR}/apr/
  cp ${S}/build/make_var_export.awk ${STAGING_DATADIR}/apr/
}

SRC_URI[md5sum] = "c5da94517e3918f0f2b2e0a05f56aa21"
SRC_URI[sha256sum] = "db22b34c0bfcab8546632475c6de2c63990214fb8ae5e2ada565410a85e22134"
