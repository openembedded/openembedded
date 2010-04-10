require rdesktop.inc

PR = "${INC_PR}.1"

SRC_URI += "file://strip.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_EXECPREFIXDIR} "

SRC_URI[md5sum] = "78dd2bae04edf1cb9f65c29930dcc993"
SRC_URI[sha256sum] = "db3da6016ceec07efda277adcb175b14c4e5255b0f85137f4a1dce79b0ee5144"
