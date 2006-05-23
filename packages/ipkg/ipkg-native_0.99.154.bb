include ipkg_${PV}.bb
include ipkg-native.inc

PR = "r1"

SRC_URI += "file://sw.patch;patch=1"
