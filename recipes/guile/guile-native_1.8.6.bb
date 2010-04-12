require guile-native.inc
SRC_URI = "http://ftp.gnu.org/pub/gnu/guile/guile-${PV}.tar.gz \
           file://configure-fix.patch;patch=1 \
           file://cpp-linemarkers.patch;patch=1 \
          "

SRC_URI[md5sum] = "9e23d3dbea0e89bab8a9acc6880150de"
SRC_URI[sha256sum] = "69a2f9491480ff756d1cc4c8ea2bdc13d40ea8ddc8f93f26957bade8219a1d86"
