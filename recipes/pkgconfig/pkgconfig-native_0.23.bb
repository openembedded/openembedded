require pkgconfig.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/pkgconfig-${PV}"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/pkg-config-${PV}/"
inherit native
DEPENDS = ""
