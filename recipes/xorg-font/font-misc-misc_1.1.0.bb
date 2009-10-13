EXTRA_OECONF = "STAGING_LIBDIR_NATIVE=\"${STAGING_LIBDIR_NATIVE}\""

require xorg-font-common.inc

SRC_URI += " file://configure-mapdir.patch;patch=1"

#DESCRIPTION = ""

#DEPENDS += " "
