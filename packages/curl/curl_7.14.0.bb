# NOTE: FIXME: curl puts its LDFLAGS in its curl-config and curl.pc files.
# This is flawed, as the LDFLAGS are often overridden by the user, and in
# addition, are generally specific to the *build* environment, not target.
# curl's build should be fixed to manipulate LIBS where appropriate and
# use that. -CL

DESCRIPTION = "Command line tool and library for \
client-side URL transfers."
LICENSE = "MIT" 
DEPENDS = "zlib"
SECTION = "console/network"
PR = "r0"

SRC_URI = "http://curl.haxx.se/download/curl-${PV}.tar.bz2"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-zlib=${STAGING_LIBDIR}/../ \
		--without-ssl --with-random=/dev/urandom"

do_stage () {
	install -d ${STAGING_INCDIR}/curl
	install -m 0644 ${S}/include/curl/*.h ${STAGING_INCDIR}/curl/
	oe_libinstall -so -a -C lib libcurl ${STAGING_LIBDIR}

	cat curl-config | sed -e "s,-I/usr/include,-I${STAGING_INCDIR}/," \
                        | sed -e "s,-L/usr/lib , , "> ${STAGING_BINDIR}/curl-config
        chmod a+rx ${STAGING_BINDIR}/curl-config
}

PACKAGES = "curl curl-doc libcurl libcurl-dev libcurl-doc"
FILES_${PN} = "${bindir}/curl"
FILES_${PN}-doc = "${mandir}/man1/curl.1"
FILES_lib${PN} = "${libdir}/lib*.so.*"
FILES_lib${PN}-dev = "${includedir} \
                      ${libdir}/lib*.so \
                      ${libdir}/lib*.a \
                      ${libdir}/lib*.la \
                      ${libdir}/pkgconfig \
                      ${datadir}/aclocal \
                      ${bindir}/*-config"
FILES_lib${PN}-doc = "${mandir}/man3 \
                      ${mandir}/man1/curl-config.1"

