SRCDATE_qemu-native = "20071121"
require qemu_${PV}.bb
inherit native
PR = "r1"
DEPENDS = "zlib-native"
prefix = "${STAGING_DIR_NATIVE}/${layout_prefix}"

require qemu-gcc3-check.inc
