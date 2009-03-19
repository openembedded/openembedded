require popt_${PV}.bb
DEPENDS = "gettext-native"
inherit native

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/popt-${PV}"
