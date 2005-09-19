PR = "r1"
DESCRIPTION = "GNOME XSLT library"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "libxml2"
LICENSE = "MIT"
PACKAGES = "${PN}-dev ${PN}-utils ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN}-dev += "${bindir}/xslt-config"
FILES_${PN}-utils += "${bindir}"

SRC_URI = "http://xmlsoft.org/sources/old/libxslt-${PV}.tar.gz"
S = "${WORKDIR}/libxslt-${PV}"

inherit autotools pkgconfig 

EXTRA_OECONF = "--without-python --without-debug --without-mem-debug"

xsltheaders = "attributes.h documents.h extensions.h extra.h functions.h imports.h \
               keys.h namespaces.h numbersInternals.h pattern.h preproc.h security.h \
               templates.h transform.h variables.h xslt.h xsltInternals.h xsltconfig.h \
               xsltexports.h xsltutils.h"
exsltheaders = "exslt.h exsltconfig.h exsltexports.h"

do_stage () {
	oe_libinstall -C libxslt -so -a libxslt ${STAGING_LIBDIR}
	oe_libinstall -C libexslt -so -a libexslt ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/libxslt
	for i in ${xsltheaders}; do
		install -m 0644 ${S}/libxslt/$i ${STAGING_INCDIR}/libxslt/$i
	done
	mkdir -p ${STAGING_INCDIR}/libexslt
	for i in ${exsltheaders}; do
		install -m 0644 ${S}/libexslt/$i ${STAGING_INCDIR}/libexslt/$i
	done

	cat xslt-config | sed -e "s,^prefix=.*,prefix=${STAGING_BINDIR}/..," \
		       	     -e "s,^exec_prefix=.*,exec_prefix=${STAGING_BINDIR}/..," \
			     -e "s,^includedir=.*,includedir=${STAGING_INCDIR}," \
			     -e "s,^libdir=.*,libdir=${STAGING_LIBDIR}," > ${STAGING_BINDIR}/xslt-config
	chmod a+rx ${STAGING_BINDIR}/xslt-config
	install -m 0644 libxslt.m4 ${STAGING_DATADIR}/aclocal/
}
