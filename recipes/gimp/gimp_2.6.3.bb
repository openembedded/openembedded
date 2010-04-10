require gimp.inc

PR = "r2"

DEPENDS += "webkit-gtk lcms gegl hal"

SRC_URI = "ftp://ftp.gimp.org/pub/gimp/v2.6/gimp-${PV}.tar.bz2 \
          "



SRC_URI[md5sum] = "39c30867511b79391eb9177c86c8b79a"
SRC_URI[sha256sum] = "08e4d272471d377cd7c6cac6a6089a540436961c00ddd09de4f29a3148ec71ef"
