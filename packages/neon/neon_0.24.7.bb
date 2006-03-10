DESCRIPTION = "neon is an HTTP and WebDAV client library, with a C interface."
SECTION = "base"
LICENSE = "LGPL"
DEPENDS = "openssl zlib libxml2 expat time"

PR = "r1"

SRC_URI = "http://www.webdav.org/neon/neon-0.24.7.tar.gz \
	   file://no-func-checks.patch;patch=1"

inherit autotools lib_package

EXTRA_OECONF = " --with-ssl --with-libxml2 --with-expat --enable-shared"

do_stage () {
	autotools_stage_includes
	oe_libinstall -C src -so -a libneon ${STAGING_LIBDIR}/

        cat neon-config | sed -e "s,^prefix=.*,prefix=${STAGING_BINDIR}/..," \
                             -e "s,^exec_prefix=.*,exec_prefix=${STAGING_BINDIR}/..," \
                             -e "s,^includedir=.*,includedir=${STAGING_INCDIR}," \
                             -e "s,^libdir=.*,libdir=${STAGING_LIBDIR}," > ${STAGING_BINDIR}/neon-config
        chmod a+rx ${STAGING_BINDIR}/neon-config
}
