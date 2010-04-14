
require libvorbis.inc

PR = "${INC_PR}.1"

SRC_URI = "http://www.vorbis.com/files/${PV}/unix/libvorbis-${PV}.tar.gz \
file://m4.patch;patch=1"


SRC_URI[md5sum] = "4d6726fd02ce02f6e24824e594b0949a"
SRC_URI[sha256sum] = "20b3cbdb4b05322d470404a7d2e8cdae1e0ce5372113218ae3cada3b29da70f7"
