require gnash.inc

PR = "r5"

EXTRA_OECONF += " --without-included-ltdl \
                  --with-ltdl-include=${STAGING_INCDIR} \
                  --with-ltdl-lib=${STAGING_LIBDIR} \
"

SRC_URI += "file://libtool-2.2.patch;patch=1"


SRC_URI[md5sum] = "5033ef2602ea1234a9ccb73000a0dedb"
SRC_URI[sha256sum] = "af1fd8454472e0ac588c015b09c67449392f32aa6297d4a625b8344dce11c39a"
