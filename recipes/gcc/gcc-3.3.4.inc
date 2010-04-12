require gcc-common.inc

INC_PR = "r11"

SRC_URI = "${GNU_MIRROR}/gcc/releases/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
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

SRC_URI[archive.md5sum] = "a1c267b34f05c8660b24251865614d8b"
SRC_URI[archive.sha256sum] = "3f409186acee739641341e5486e30ea9acecc039452e97a9eb850afbc6c3a691"
