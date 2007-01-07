require qemu_${PV}.bb
require qemu-gcc-check.inc

SRC_URI += "file://2.6.17-linux-libc-headers-fix.patch;patch=1"

inherit native

PR = "r2"

S = "${WORKDIR}/qemu-${PV}"
prefix = "${STAGING_DIR}/${BUILD_SYS}"
