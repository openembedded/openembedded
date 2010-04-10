require popt_${PV}.bb
DEPENDS = "gettext-native"
inherit native

S = "${WORKDIR}/popt-${PV}"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/popt-${PV}"

SRC_URI[md5sum] = "5988e7aeb0ae4dac8d83561265984cc9"
SRC_URI[sha256sum] = "4e75cb28793f0d44134f71fae53057d5f250805e6268fbd9c9780654b73b0dc1"
