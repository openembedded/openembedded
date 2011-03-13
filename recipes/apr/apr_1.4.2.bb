DESCRIPTION = "Apache Portable Runtime (APR) library"
SECTION = "libs"
LICENSE = "Apache License, Version 2.0"

SRC_URI = "${APACHE_MIRROR}/apr/${P}.tar.bz2 \
           file://configure_fixes.patch \
           file://configfix.patch"

inherit autotools lib_package binconfig

OE_BINCONFIG_EXTRA_MANGLE = " -e 's:location=source:location=installed:'"

do_configure_prepend() {
	echo "top_builddir=@apr_builddir@" >> ${S}/Makefile.in
}

FILES_${PN}-dev += "${datadir}/build-1/* ${libdir}/apr.exp"

do_install_append() {
	install -d ${D}${datadir}/apr
	cp ${S}/build/apr_rules.mk ${D}${datadir}/apr/
	sed -i s,apr_builddir=.*,apr_builddir=,g ${D}${datadir}/apr/apr_rules.mk
	sed -i s,apr_builders=.*,apr_builders=,g ${D}${datadir}/apr/apr_rules.mk
	sed -i s,LIBTOOL=.*,LIBTOOL=\$\(SHELL\)\ ${HOST_SYS}-libtool,g ${D}${datadir}/apr/apr_rules.mk
	sed -i s,\$\(apr_builders\),${D}${datadir}/apr/,g ${D}${datadir}/apr/apr_rules.mk
	cp ${S}/build/mkdir.sh ${D}${datadir}/apr/
	cp ${S}/build/make_exports.awk ${D}${datadir}/apr/
	cp ${S}/build/make_var_export.awk ${D}${datadir}/apr/
	cp ${S}/${HOST_SYS}-libtool ${D}${datadir}/build-1/libtool
}

SRC_URI[md5sum] = "4b00e8f70c067893d075577962656b35"
SRC_URI[sha256sum] = "2017ca700694d09d2b0b21dd7c4d195e43a48735aac88526160c6195ee8f5391"
