require libpng_${PV}.bb
require libpng-native.inc

PR = "r1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libpng-${PV}"

SRC_URI[tarball.md5sum] = "29bbd1c3cbe54b04bfc2bda43067ccb5"
SRC_URI[tarball.sha256sum] = "a6197352ad5b79a9a1ce0dd59f5e737cfbf909e0f3c5f64631cf0d93549e4e40"
