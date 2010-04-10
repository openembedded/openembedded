require rdesktop.inc

PR = "${INC_PR}.1"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_EXECPREFIXDIR} "

SRC_URI[md5sum] = "433546f60fc0f201e99307ba188369ed"
SRC_URI[sha256sum] = "5ead17c3d29cb1028aeca485ee7a8c65694c1b02a1b7014c3da920b265a438aa"
