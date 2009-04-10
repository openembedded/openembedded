require curl-common.inc
inherit sdk
DEPENDS = "zlib-sdk"
PR = "r1"

do_stage () {
        install -d ${STAGING_INCDIR}/curl
        install -m 0644 ${S}/include/curl/*.h ${STAGING_INCDIR}/curl/
        oe_libinstall -so -a -C lib libcurl ${STAGING_LIBDIR}
}

do_install() {
	:
}
