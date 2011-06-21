require valgrind.inc
export PERL="/usr/bin/env perl"

PR = "r2"

SRC_URI += "file://vg-ppc-feature.patch"

COMPATIBLE_HOST = "^(i.86|x86_64|powerpc).*-linux"

SRC_URI[md5sum] = "2c3aa122498baecc9d69194057ca88f5"
SRC_URI[sha256sum] = "49bdcc4fbcf060049b5f0dcfd8a187a6e90e0b0e57309f633b64e44430726a0e"
