require libxslt.inc
DEPENDS = "libxml2"
PR = "${INC_PR}.0"

SRC_URI += " file://destdir.patch;patch=1"

EXTRA_OECONF += " --without-plugins"

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

	cat xslt-config | sed -e "s,^prefix=.*,prefix=${STAGING_DIR_HOST}${layout_prefix}," \
		       	     -e "s,^exec_prefix=.*,exec_prefix=${STAGING_DIR_HOST}${layout_exec_prefix}," \
			     -e "s,^includedir=.*,includedir=${STAGING_INCDIR}," \
			     -e "s,^libdir=.*,libdir=${STAGING_LIBDIR}," > ${STAGING_BINDIR_CROSS}/xslt-config
	chmod a+rx ${STAGING_BINDIR_CROSS}/xslt-config
	install -m 0644 libxslt.m4 ${STAGING_DATADIR}/aclocal/
}

SRC_URI[archive.md5sum] = "fde6a7a93c0eb14cba628692fa3a1000"
SRC_URI[archive.sha256sum] = "d337faebd64ddb8c52cde23df8469e1b3c65545af5f939e9bb4be9eeb9658c8a"
