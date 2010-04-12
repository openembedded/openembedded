SRC_URI_append = "file://configure.in.patch;patch=1 \
                  file://Makefile.am.patch;patch=1"

do_install_prepend () {
        # It only needs this app during the install, so compile it natively
        $BUILD_CC -DHAVE_SYS_STAT_H -o cherokee_replace cherokee_replace.c
}

require cherokee.inc
PR = "${INC_PR}.0"

SRC_URI[md5sum] = "fb891b3da7eb921c09a5eb93e296f5e1"
SRC_URI[sha256sum] = "e9c6feee2a626a38cd69c726ed31ffbbf55d288386f50fe6f90fa63de410d67a"
