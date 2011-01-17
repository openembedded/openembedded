DESCRIPTION = "Apache Portable Runtime (APR) library"
SECTION = "libs"
LICENSE = "Apache License, Version 2.0"

SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.bz2 \
           file://configure_fixes.patch \
#	   file://cleanup.patch \
           file://configfix.patch"

SRC_URI[md5sum] = "6f19af60a161480cc16bb6adb9820040"
SRC_URI[sha256sum] = "cdc5eff894239344cb35e06f10e8d39a5b46d4250750c6c4ac4058ffbfb6ae80"

inherit autotools lib_package binconfig

OE_BINCONFIG_EXTRA_MANGLE = " -e 's:location=source:location=installed:'"

do_configure_prepend() {
	cd ${S}
	echo "top_builddir=@apr_builddir@" >> build/apr_rules.mk.in
	cp build/libtool.m4 .
	./buildconf
}

FILES_${PN}-dev += "${datadir}/build-1/* ${libdir}/apr.exp"

do_install_append() {
	install -d ${D}${datadir}/apr
	cp ${S}/build/apr_rules.mk ${D}${datadir}/apr/
	sed -i s,apr_builddir=.*,apr_builddir=,g ${D}${datadir}/apr/apr_rules.mk
	sed -i s,apr_builders=.*,apr_builders=,g ${D}${datadir}/apr/apr_rules.mk
	sed -i s,LIBTOOL=.*,LIBTOOL=\$\(SHELL\)\ ${TARGET_PREFIX}libtool,g ${D}${datadir}/apr/apr_rules.mk
	sed -i s,\$\(apr_builders\),${D}${datadir}/apr/,g ${D}${datadir}/apr/apr_rules.mk
	cp ${S}/build/mkdir.sh ${D}${datadir}/apr/
	cp ${S}/build/make_exports.awk ${D}${datadir}/apr/
	cp ${S}/build/make_var_export.awk ${D}${datadir}/apr/
}
