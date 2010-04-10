PR = "${INC_PR}.1"

require gcc-${PV}.inc
require gcc-configure-target.inc
require gcc-native.inc
PROVIDES += "gcc3-native"

SRC_URI[md5sum] = "b594ff4ea4fbef4ba9220887de713dfe"
SRC_URI[sha256sum] = "3444179840638cb8664e8e53604900c4521d29d57785a5091202ee4937d8d0fd"
