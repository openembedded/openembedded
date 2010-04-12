require gcc-common.inc

SRC_URI = "${GNU_MIRROR}/gcc/releases/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive\
	   file://config.sub.patch;patch=1 \
	   file://empty6.patch;patch=1 \
	   file://pr10392-1-test.patch;patch=1 \
	   file://pr10412-1-test.patch;patch=1 \
	   file://pr10589-1-test.patch;patch=1 \
	   file://pr11162-1-test.patch;patch=1 \
	   file://pr11587-1-test.patch;patch=1 \
	   file://pr11608.patch;patch=1 \
	   file://pr11736-1-test.patch;patch=1 \
	   file://pr11864-1-test.patch;patch=1 \
	   file://pr12009.patch;patch=1 \
	   file://pr12010.patch;patch=1 \
	   file://pr13260-test.patch;patch=1 \
	   file://pr9365-1-test.patch;patch=1 \
	   file://sh-lib1funcs_sizeAndType.patch;patch=1 \
	   file://sh-pic-set_fpscr-gcc-3.3.2.patch;patch=1 \
	   file://thunk3.patch;patch=1 \
	   file://arm-10730.dpatch;patch=1;pnum=0 \
	   file://arm-12527.dpatch;patch=1;pnum=0 \
	   file://arm-14558.dpatch;patch=1;pnum=0 \
	   file://arm-common.dpatch;patch=1;pnum=0 \
	   file://arm-gotoff.dpatch;patch=1;pnum=0 \
	   file://arm-ldm.dpatch;patch=1;pnum=0 \
	   file://arm-tune.patch;patch=1;pnum=0 \
	   file://arm-xscale.patch;patch=1;pnum=0 \
	   file://arm-14302.patch;patch=1;pnum=0 \
	   file://arm-ldm-peephole.patch;patch=1;pnum=0 \
	   file://libibery-crosstool.patch;patch=1;pnum=1 \
	   file://reverse-compare.patch;patch=1 \
	   file://gcc34-15089.patch;patch=1 \
	file://gcc-uclibc-3.3-100-conf.patch;patch=1 \
	file://gcc-uclibc-3.3-110-conf.patch;patch=1 \
	file://gcc-uclibc-3.3-120-softfloat.patch;patch=1 \
	file://gcc-uclibc-3.3-200-code.patch;patch=1 \
	file://zecke-xgcc-cpp.patch;patch=1 \
	file://bash3.patch;patch=1"

SRC_URI[archive.md5sum] = "3c6cfd9fcd180481063b4058cf6faff2"
SRC_URI[archive.sha256sum] = "9ac6618495b7dd2ff0cd50abd76fe3c51287efcc724340687407f9fc250bdc6a"
