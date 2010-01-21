require gcc-common.inc

INC_PR = "r11"

SRC_URI = "${GNU_MIRROR}/gcc/releases/gcc-${PV}/gcc-${PV}.tar.bz2 \
	   file://arm-gotoff.dpatch;patch=1;pnum=0 \
	   file://arm-ldm.dpatch;patch=1;pnum=0 \
	   file://arm-tune.patch;patch=1;pnum=0 \
	   file://arm-ldm-peephole.patch;patch=1;pnum=0 \
	   file://libibery-crosstool.patch;patch=1;pnum=1 \
	   file://reverse-compare.patch;patch=1 \
	   file://gcc34-15089.patch;patch=1 \
	   file://gcc-uclibc-3.3-100-conf.patch;patch=1 \
	   file://gcc-uclibc-3.3-110-conf.patch;patch=1 \
	   file://gcc-uclibc-3.3-120-softfloat.patch;patch=1 \
	   file://gcc-uclibc-3.3-200-code.patch;patch=1 \
	   file://zecke-xgcc-cpp.patch;patch=1 \
	   file://gcc-com.patch;patch=1 \
	   file://bash3.patch;patch=1"

