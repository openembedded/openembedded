SRC_URI_append = "file://configure.patch;patch=1 \
                  file://Makefile.in.patch;patch=1 \
                  file://Makefile.cget.patch;patch=1 \
                  file://util.patch;patch=1"

require cherokee.inc
PR = "${INC_PR}.0"

do_configure() {
        gnu-configize
        oe_runconf
        sed -i 's:-L\$:-L${STAGING_LIBDIR} -L\$:' ${S}/*libtool
}

do_install_prepend () {
        # It only needs this app during the install, so compile it natively
        $BUILD_CC -DHAVE_SYS_STAT_H -o cherokee_replace cherokee_replace.c
}
