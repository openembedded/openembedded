require gcc-common.inc

INC_PR = "r11"

SRC_URI = "${GNU_MIRROR}/gcc/releases/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	   file://arm-gotoff.dpatch;apply=yes;striplevel=0 \
	   file://arm-ldm.dpatch;apply=yes;striplevel=0 \
	   file://arm-tune.patch;apply=yes;striplevel=0 \
	   file://arm-ldm-peephole.patch;apply=yes;striplevel=0 \
	   file://libibery-crosstool.patch;apply=yes \
	   file://reverse-compare.patch;apply=yes \
	   file://gcc34-15089.patch;apply=yes \
	   file://gcc-uclibc-3.3-100-conf.patch;apply=yes \
	   file://gcc-uclibc-3.3-110-conf.patch;apply=yes \
	   file://gcc-uclibc-3.3-120-softfloat.patch;apply=yes \
	   file://gcc-uclibc-3.3-200-code.patch;apply=yes \
	   file://zecke-xgcc-cpp.patch;apply=yes \
	   file://gcc-com.patch;apply=yes \
	   file://bash3.patch;apply=yes"

SRC_URI[archive.md5sum] = "a1c267b34f05c8660b24251865614d8b"
SRC_URI[archive.sha256sum] = "3f409186acee739641341e5486e30ea9acecc039452e97a9eb850afbc6c3a691"
