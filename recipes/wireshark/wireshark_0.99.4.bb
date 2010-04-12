DESCRIPTION = "Wireshark is the world's most popular network protocol analyzer"
require wireshark.inc
DEPENDS += "gtk+"

PR = "r1"


FILES_${PN}-dbg += "${libdir}/wireshark/plugins/${PV}/.debug"



SRC_URI[md5sum] = "05fada181e12bfa94b52f0b10395b28c"
SRC_URI[sha256sum] = "a4f15c73e2b67c888cbedfaa8093661dff6cb859357c197c60f3026baddb939e"
