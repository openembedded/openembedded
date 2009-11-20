require guile-native.inc

DEPENDS = "libtool (< 2)"

SRC_URI = "http://ftp.gnu.org/pub/gnu/guile/guile-${PV}.tar.gz \
           file://configure-fix.patch;patch=1 \
           file://cpp-linemarkers.patch;patch=1 \
          "

PR = "r1"

