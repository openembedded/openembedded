LICENSE = GPL
SECTION = "console/utils"
PRIORITY = "required"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DESCRIPTION = "gzip (GNU zip) is a compression utility designed \
to be a replacement for 'compress'. The GNU Project uses it as \
the standard compression program for its system."

SRC_URI = "${DEBIAN_MIRROR}/main/g/gzip/gzip_${PV}.orig.tar.gz \
	   file://configure.patch;patch=1"

S = "${WORKDIR}/gzip-${PV}"

inherit autotools
