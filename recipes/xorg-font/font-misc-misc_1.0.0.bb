EXTRA_OECONF = "STAGING_LIBDIR_NATIVE=\"${STAGING_LIBDIR_NATIVE}\""

require xorg-font-common.inc

PR = "${INC_PR}.0"

SRC_URI += " file://configure-mapdir.patch;patch=1"

SRC_URI[archive.md5sum] = "2a57f6188c41d4bc1b88ca3d08ad011d"
SRC_URI[archive.sha256sum] = "26a02560ad1f1648e7c36be6daf42910762131d3974422d1b306e6cae13f17db"
