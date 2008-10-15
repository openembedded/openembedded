require gnash-minimal.inc

PR = "r8"

EXTRA_OECONF += " --without-included-ltdl \
                  --with-ltdl-include=${STAGING_INCDIR} \
                  --with-ltdl-lib=${STAGING_LIBDIR} \
"

SRC_URI += "file://libtool-2.2.patch;patch=1 file://libintl.patch;patch=1"


