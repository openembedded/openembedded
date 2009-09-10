SRC_URI_append = "file://configure.in.patch;patch=1 \
                  file://Makefile.am.patch;patch=1"

do_install_prepend () {
        # It only needs this app during the install, so compile it natively
        $BUILD_CC -DHAVE_SYS_STAT_H -o cherokee_replace cherokee_replace.c
}

require cherokee.inc
PR = "${INC_PR}.0"
