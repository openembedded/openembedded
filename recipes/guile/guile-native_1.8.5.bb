require guile-native.inc

DEPENDS = "libtool (< 2)"

SRC_URI = "http://ftp.gnu.org/pub/gnu/guile/guile-${PV}.tar.gz \
           file://configure-fix.patch;patch=1 \
           file://cpp-linemarkers.patch;patch=1 \
          "

PR = "r1"


SRC_URI[md5sum] = "a3f8216544509a74a4441f689a0410d2"
SRC_URI[sha256sum] = "e2f63d2d445ffeb072638eab885b1a629e372d1db711c8afb26a62bc56096289"
