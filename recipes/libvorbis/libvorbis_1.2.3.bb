
require libvorbis.inc

PR = "${INC_PR}.1"

SRC_URI = "http://downloads.xiph.org/releases/vorbis/libvorbis-${PV}.tar.gz \
	   file://configure_powerpc-no-fixed-cpu.patch;patch=1 \
	   file://patch-lib_backends.h;patch=1;pnum=0 \
	   file://patch-lib_codebook.c;patch=1;pnum=0 \
	   file://patch-lib_modes_residue_44.h;patch=1;pnum=0 \
	   file://patch-lib_modes_residue_44u.h;patch=1;pnum=0 \
	   file://patch-lib_res0.c;patch=1;pnum=0 \
	  "

# override should be handeld by pkgconfig now
EXTRA_OECONF = ""
