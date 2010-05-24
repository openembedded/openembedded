require gcc-common.inc

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
	   file://jarfix.patch;apply=yes \
	   file://always-fixincperm.patch;apply=yes \
	   file://GCOV_PREFIX_STRIP-cross-profile_3.4.patch;apply=yes \
	   file://zecke-xgcc-cpp.patch;apply=yes \
	   file://gcc-posix-open-fix.patch;apply=yes \
	   file://gcc4-mtune-compat.patch;apply=yes"

SRC_URI += "file://gcc34-configure.in.patch;apply=yes"
SRC_URI += "file://gcc34-thumb-support.patch;apply=yes"
SRC_URI_append = " file://zecke-no-host-includes.patch;apply=yes "

SRC_URI[archive.md5sum] = "4a21ac777d4b5617283ce488b808da7b"
SRC_URI[archive.sha256sum] = "7791a601878b765669022b8b3409fba33cc72f9e39340fec8af6d0e6f72dec39"
