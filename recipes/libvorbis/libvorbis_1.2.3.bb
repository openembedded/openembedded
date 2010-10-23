
require libvorbis.inc

PR = "${INC_PR}.1"

SRC_URI = "http://downloads.xiph.org/releases/vorbis/libvorbis-${PV}.tar.gz \
	   file://configure_powerpc-no-fixed-cpu.patch \
	   file://patch-lib_backends.h;apply=yes;striplevel=0 \
	   file://patch-lib_codebook.c;apply=yes;striplevel=0 \
	   file://patch-lib_modes_residue_44.h;apply=yes;striplevel=0 \
	   file://patch-lib_modes_residue_44u.h;apply=yes;striplevel=0 \
	   file://patch-lib_res0.c;apply=yes;striplevel=0 \
	  "

SRC_URI[md5sum] = "5aa77f55c0e0aab8eb8ed982335daac8"
SRC_URI[sha256sum] = "c679d1e5e45a3ec8aceb5e71de8e3712630b7a6dec6952886c17435a65955947"
