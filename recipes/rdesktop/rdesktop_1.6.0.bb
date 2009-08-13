require rdesktop.inc

PR = "${INC_PR}.2"

SRC_URI += " file://audio-2008.patch;patch=1"
SRC_URI_append_ossystems = " file://rdesktop-addin.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_EXECPREFIXDIR} "
