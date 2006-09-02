require qemu_${PV}.bb
EXTRA_OECONF = ""
inherit native
require qemu-native.inc
S = "${WORKDIR}/qemu-${PV}"

