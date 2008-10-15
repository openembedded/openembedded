require rdesktop.inc

FILE_PR = "r1"

SRC_URI += "file://strip.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_EXECPREFIXDIR} "
