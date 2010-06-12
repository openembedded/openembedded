require dropbear.inc
PR = "${INC_PR}.0"

SRC_URI += "file://no-host-lookup.patch"

SRC_URI[md5sum] = "95d900913bee4b27d7e9ce55f8a55427"
SRC_URI[sha256sum] = "8daa89512f9349fc131d48555726ffe1187e0f7d9f4cef992464c8098d86e77c"
