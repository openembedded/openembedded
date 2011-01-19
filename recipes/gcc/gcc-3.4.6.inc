require gcc-common.inc

INC_PR = "r2"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	   file://gcc34-reverse-compare.patch \
	   file://gcc34-arm-ldm.patch \
	   file://gcc34-arm-ldm-peephole.patch \
	   file://gcc34-arm-tune.patch \
	   file://gcc-3.4.1-uclibc-100-conf.patch \
	   file://gcc-3.4.1-uclibc-200-locale.patch \
	   file://gcc-3.4.0-arm-lib1asm.patch \
	   file://gcc-3.4.0-arm-nolibfloat.patch \
	   file://gcc-3.4.0-arm-bigendian.patch \
	   file://gcc-3.4.0-arm-bigendian-uclibc.patch \
	   file://GCC3.4.0VisibilityPatch.diff \
	   file://jarfix.patch \
	   file://always-fixincperm.patch \
	   file://GCOV_PREFIX_STRIP-cross-profile_3.4.patch \
	   file://zecke-xgcc-cpp.patch \
	   file://gcc-posix-open-fix.patch \
	   file://gcc4-mtune-compat.patch"

SRC_URI += "file://gcc34-configure.in.patch"
SRC_URI += "file://gcc34-thumb-support.patch"
SRC_URI += "file://zecke-no-host-includes.patch"

SRC_URI[archive.md5sum] = "4a21ac777d4b5617283ce488b808da7b"
SRC_URI[archive.sha256sum] = "7791a601878b765669022b8b3409fba33cc72f9e39340fec8af6d0e6f72dec39"
