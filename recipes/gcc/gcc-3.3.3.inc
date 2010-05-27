require gcc-common.inc

SRC_URI = "${GNU_MIRROR}/gcc/releases/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive\
	   file://config.sub.patch \
	   file://empty6.patch \
	   file://pr10392-1-test.patch \
	   file://pr10412-1-test.patch \
	   file://pr10589-1-test.patch \
	   file://pr11162-1-test.patch \
	   file://pr11587-1-test.patch \
	   file://pr11608.patch \
	   file://pr11736-1-test.patch \
	   file://pr11864-1-test.patch \
	   file://pr12009.patch \
	   file://pr12010.patch \
	   file://pr13260-test.patch \
	   file://pr9365-1-test.patch \
	   file://sh-lib1funcs_sizeAndType.patch \
	   file://sh-pic-set_fpscr-gcc-3.3.2.patch \
	   file://thunk3.patch \
	   file://arm-10730.dpatch;apply=yes;striplevel=0 \
	   file://arm-12527.dpatch;apply=yes;striplevel=0 \
	   file://arm-14558.dpatch;apply=yes;striplevel=0 \
	   file://arm-common.dpatch;apply=yes;striplevel=0 \
	   file://arm-gotoff.dpatch;apply=yes;striplevel=0 \
	   file://arm-ldm.dpatch;apply=yes;striplevel=0 \
	   file://arm-tune.patch;striplevel=0 \
	   file://arm-xscale.patch;striplevel=0 \
	   file://arm-14302.patch;striplevel=0 \
	   file://arm-ldm-peephole.patch;striplevel=0 \
	   file://libibery-crosstool.patch \
	   file://reverse-compare.patch \
	   file://gcc34-15089.patch \
	file://gcc-uclibc-3.3-100-conf.patch \
	file://gcc-uclibc-3.3-110-conf.patch \
	file://gcc-uclibc-3.3-120-softfloat.patch \
	file://gcc-uclibc-3.3-200-code.patch \
	file://zecke-xgcc-cpp.patch \
	file://bash3.patch"

SRC_URI[archive.md5sum] = "3c6cfd9fcd180481063b4058cf6faff2"
SRC_URI[archive.sha256sum] = "9ac6618495b7dd2ff0cd50abd76fe3c51287efcc724340687407f9fc250bdc6a"
