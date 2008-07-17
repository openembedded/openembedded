require gnash.inc

PR = "r2"

EXTRA_OECONF += " --without-included-ltdl \
                  --with-ltdl-include=${STAGING_INCDIR} \
                  --with-ltdl-lib=${STAGING_LIBDIR} \
"

SRC_URI += "file://libtool-2.2.patch;patch=1"

