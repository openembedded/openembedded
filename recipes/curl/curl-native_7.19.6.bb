require curl-common.inc
inherit native
DEPENDS = "zlib-native"
PR = "${INC_PR}.2"

CURL_FEATURES = "zlib,cookies,crypto-auth,dict,file,ftp,http,telnet,tftp"
