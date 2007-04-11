require u-boot.inc

PR = "r2"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-1.2.0.tar.bz2 \
	"
SRC_URI_append_turbostation = "file://qnap.diff;patch=1"

SRC_URI_append_lsppchg = "file://u-boot-kurobox.patch;patch=1 \
			  file://u-boot-kurobox-fdt.patch;patch=1 \
			  file://defconfig_lsppchg"

SRC_URI_append_lsppchd = "file://u-boot-kurobox.patch;patch=1 \ 
                          file://u-boot-kurobox-fdt.patch;patch=1 \ 
                          file://defconfig_lsppchg"

do_compile_prepend_lsppchg () {
        cp ${WORKDIR}/defconfig_lsppchg ${S}/include/configs/linkstation.h
}

do_compile_prepend_lsppchd () {
        cp ${WORKDIR}/defconfig_lsppchd ${S}/include/configs/linkstation.h
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
