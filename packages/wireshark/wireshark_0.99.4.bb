DESCRIPTION = "Wireshark is the world's most popular network protocol analyzer"
require wireshark.inc
DEPENDS += "gtk+"

PR = "r1"


FILES_${PN}-dbg += "${libdir}/wireshark/plugins/${PV}/.debug"


