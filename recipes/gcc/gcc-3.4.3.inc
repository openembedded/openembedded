require gcc-common.inc

INC_PR = "r19"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	   file://gcc34-reverse-compare.patch;apply=yes \
	   file://gcc34-arm-ldm.patch;apply=yes \
	   file://gcc34-arm-ldm-peephole.patch;apply=yes \
	   file://gcc34-arm-tune.patch;apply=yes \
	   file://gcc-3.4.1-uclibc-100-conf.patch;apply=yes \
	   file://gcc-3.4.1-uclibc-200-locale.patch;apply=yes \
	   file://gcc-3.4.0-arm-lib1asm.patch;apply=yes \
	   file://gcc-3.4.0-arm-nolibfloat.patch;apply=yes \
	   file://gcc-3.4.0-arm-bigendian.patch;apply=yes \
	   file://gcc-3.4.0-arm-bigendian-uclibc.patch;apply=yes \
	   file://GCC3.4.0VisibilityPatch.diff;apply=yes \
	   file://15342.patch;apply=yes \
	   file://always-fixincperm.patch;apply=yes \
	   file://GCOV_PREFIX_STRIP-cross-profile_3.4.patch;apply=yes \
	   file://zecke-xgcc-cpp.patch;apply=yes "
SRC_URI[archive.md5sum] = "e744b30c834360fccac41eb7269a3011"
SRC_URI[archive.sha256sum] = "63dc1c03a107ec73871151bb765da7d5dfc1d699c0d0d6a3d244cf5ccb030913"
