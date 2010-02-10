PV = "4.999.9beta"

require xz.inc
PR = "${INC_PR}.0"
SRC_URI = "http://tukaani.org/xz/xz-${PV}.tar.bz2;name=xz"
SRC_URI[xz.md5sum] = "cc4044fcc073b8bcf3164d1d0df82161"
SRC_URI[xz.sha256sum] = "330312c4397608d8b7be362cc7edbfeafa6101614bc2164d816ea767656aa15c"
EXTRA_OECONF = "--enable-shared"
