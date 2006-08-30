require qemu_${PV}.bb
EXTRA_OECONF = ""
inherit native
FILESPATH =. "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qemu-${PV}:"
S = "${WORKDIR}/qemu-${PV}"
prefix = "${STAGING_DIR}/${BUILD_SYS}"

