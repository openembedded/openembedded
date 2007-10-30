require qemu_${PV}.bb
inherit native
DEPENDS = "zlib-native"
prefix = "${STAGING_DIR_NATIVE}/${layout_prefix}"

require qemu-gcc3-check.inc

