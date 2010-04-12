require curl-common.inc
inherit native
DEPENDS = "zlib-native"
PR = "${INC_PR}.2"

CURL_FEATURES = "zlib,cookies,crypto-auth,dict,file,ftp,http,telnet,tftp"

SRC_URI[tarball.md5sum] = "8402c1f654c51ad7287aad57c3aa79be"
SRC_URI[tarball.sha256sum] = "ea88f48c8415f7d3af482e4d241277b2bdbfaffaf285e8001c88c1376cbc1021"
