require gcc-common.inc

INC_PR = "r19"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	   file://gcc34-reverse-compare.patch;patch=1 \
	   file://gcc34-arm-ldm.patch;patch=1 \
	   file://gcc34-arm-ldm-peephole.patch;patch=1 \
	   file://gcc34-arm-tune.patch;patch=1 \
	   file://gcc-3.4.1-uclibc-100-conf.patch;patch=1 \
	   file://gcc-3.4.1-uclibc-200-locale.patch;patch=1 \
	   file://gcc-3.4.0-arm-lib1asm.patch;patch=1 \
	   file://gcc-3.4.0-arm-nolibfloat.patch;patch=1 \
	   file://gcc-3.4.0-arm-bigendian.patch;patch=1 \
	   file://gcc-3.4.0-arm-bigendian-uclibc.patch;patch=1 \
	   file://GCC3.4.0VisibilityPatch.diff;patch=1 \
	   file://15342.patch;patch=1 \
	   file://always-fixincperm.patch;patch=1 \
	   file://GCOV_PREFIX_STRIP-cross-profile_3.4.patch;patch=1 \
	   file://zecke-xgcc-cpp.patch;patch=1 "
SRC_URI[archive.md5sum] = "e744b30c834360fccac41eb7269a3011"
SRC_URI[archive.sha256sum] = "63dc1c03a107ec73871151bb765da7d5dfc1d699c0d0d6a3d244cf5ccb030913"
