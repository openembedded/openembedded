require gcc-common.inc

INC_PR = "r18"

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
	   file://15342.patch \
	   file://jarfix.patch \
	   file://always-fixincperm.patch \
	   file://GCOV_PREFIX_STRIP-cross-profile_3.4.patch \
	   file://zecke-xgcc-cpp.patch \
	   file://gcc-libgcc2-inhibit-libc.patch \
	   file://gcc4-mtune-compat.patch \
	   file://gcc34-configure.in.patch \
	   file://gcc34-thumb-support.patch \
	   file://gcc-cross-fixincl.patch \
	   file://gcc-posix-open-fix.patch \
	   "
SRC_URI += "file://zecke-no-host-includes.patch"

SRC_URI[archive.md5sum] = "b594ff4ea4fbef4ba9220887de713dfe"
SRC_URI[archive.sha256sum] = "3444179840638cb8664e8e53604900c4521d29d57785a5091202ee4937d8d0fd"
