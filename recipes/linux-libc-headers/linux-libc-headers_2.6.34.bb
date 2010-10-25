require linux-libc-headers.inc

# untested for non nios2 systems
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_nios2 = "1"
INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PR = "r2"

COMPATIBLE_TARGET_SYS = "."

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
	  "

# For nios2 the source comes from sopc.et.ntust.edu.tw, but as this one is very slow
# a tarball is placed at opensource.axon.tv
#SRC_URI_nios2 = "git://sopc.et.ntust.edu.tw/git/linux-2.6.git;branch=nios2mmu;protocol=http;tag=a32ca88c4f3f3850c5c9789db2afab2530c6856d;protocol=http \
SRC_URI_nios2 = "ftp://opensource.axon.nl/mirror/git_sopc.et.ntust.edu.tw.linux-2.6.git_a32ca88c4f3f3850c5c9789db2afab2530c6856d.tar.gz;name=nios2tarball \
	  "

SRC_URI[md5sum] = "10eebcb0178fb4540e2165bfd7efc7ad"
SRC_URI[sha256sum] = "fa395fec7de633df1cb85b6248b8f35af98380ed128a8bc465fb48bc4d252633"

# nios2 checksums
SRC_URI[nios2tarball.md5sum] = "ad27c6ddfe5b2bb0f81968c0155d072d"
SRC_URI[nios2tarball.sha256sum] = "7c99c5ee4bf26d08fde030c605c618454984dba5ae79c298064228ab0053e60f"


S = "${WORKDIR}/linux-2.6.34"
S_nios2 = "${WORKDIR}/linux-2.6"

do_configure() {
	cd ${S}
	oe_runmake allnoconfig ARCH=$ARCH
}

do_compile () {
}

do_install() {
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix} ARCH=$ARCH
	rm -f ${D}${exec_prefix}/include/scsi/scsi.h
}
