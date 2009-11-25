
require libvorbis.inc

PR = "${INC_PR}.0"

SRC_URI = "http://downloads.xiph.org/releases/vorbis/libvorbis-${PV}.tar.gz \
	   file://configure_powerpc-no-fixed-cpu.patch;patch=1 \
	  "

# override should be handeld by pkgconfig now
EXTRA_OECONF = ""
