require rdesktop.inc

FILE_PR = "r0"

inherit autotools

EXTRA_OECONF = "--with-openssl=${STAGING_EXECPREFIXDIR} "
