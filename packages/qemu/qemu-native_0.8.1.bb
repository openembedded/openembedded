require qemu_${PV}.bb
require qemu-gcc-check.inc

inherit native

PR = "r1"

S = "${WORKDIR}/qemu-${PV}"
prefix = "${STAGING_DIR}/${BUILD_SYS}"
