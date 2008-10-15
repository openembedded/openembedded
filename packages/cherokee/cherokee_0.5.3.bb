PR = "r7"

SRC_URI_append = "file://configure.patch;patch=1 \
                  file://Makefile.in.patch;patch=1 \
                  file://Makefile.cget.patch;patch=1 \
                  file://util.patch;patch=1"

require cherokee.inc

do_configure() {
        gnu-configize
        oe_runconf
        sed -i 's:-L\$:-L${STAGING_LIBDIR} -L\$:' ${S}/*libtool
}
