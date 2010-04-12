require rdesktop.inc

PR = "${INC_PR}.2"

SRC_URI += " file://audio-2008.patch;patch=1"
SRC_URI_append_ossystems = " file://rdesktop-addin.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_EXECPREFIXDIR} "

SRC_URI[md5sum] = "c6fcbed7f0ad7e60ac5fcb2d324d8b16"
SRC_URI[sha256sum] = "35026eaa8e14ca8bd0ba3730926f14222f8452f2ac662623bbf1909d8b060979"
