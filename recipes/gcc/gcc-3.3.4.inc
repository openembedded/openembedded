require gcc-common.inc

INC_PR = "r14"

SRC_URI = "${GNU_MIRROR}/gcc/releases/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	   file://arm-gotoff.dpatch;apply=yes;striplevel=0 \
	   file://arm-ldm.dpatch;apply=yes;striplevel=0 \
	   file://arm-tune.patch;striplevel=0 \
	   file://arm-ldm-peephole.patch;striplevel=0 \
	   file://libibery-crosstool.patch \
	   file://reverse-compare.patch \
	   file://gcc34-15089.patch \
	   file://gcc-uclibc-3.3-100-conf.patch \
	   file://gcc-uclibc-3.3-110-conf.patch \
	   file://gcc-uclibc-3.3-120-softfloat.patch \
	   file://gcc-uclibc-3.3-200-code.patch \
	   file://zecke-xgcc-cpp.patch \
	   file://gcc-com.patch \
	   file://bash3.patch"

SRC_URI[archive.md5sum] = "a1c267b34f05c8660b24251865614d8b"
SRC_URI[archive.sha256sum] = "3f409186acee739641341e5486e30ea9acecc039452e97a9eb850afbc6c3a691"
