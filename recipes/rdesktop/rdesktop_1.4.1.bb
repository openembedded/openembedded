require rdesktop.inc

PR = "${INC_PR}.1"

SRC_URI += "file://strip.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_EXECPREFIXDIR} "
