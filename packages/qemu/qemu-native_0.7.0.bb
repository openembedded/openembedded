require qemu_${PV}.bb
inherit native
S = "${WORKDIR}/qemu-${PV}"
require qemu-native.inc
