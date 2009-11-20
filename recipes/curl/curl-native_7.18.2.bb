require curl-common.inc
inherit native
DEPENDS = "zlib-native"
SRC_URI += "file://curl-7.18.1-CVE-2009-2417.patch;patch=1;pnum=0"

PR = "${INC_PR}.2"
