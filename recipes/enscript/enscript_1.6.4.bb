SECTION = "console/utils"
DESCRIPTION = "GNU enscript is a drop-in replacement for the enscript program. \
Enscript converts ASCII files to PostScript and stores generated \
output to a file or sends it directly to the printer."
LICENSE = "GPL"

SRC_URI = "${DEBIAN_MIRROR}/main/e/enscript/enscript_${PV}.orig.tar.gz \
	   file://autotools.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "b5174b59e4a050fb462af5dbf28ebba3"
SRC_URI[sha256sum] = "45299a4db47c9c08c3649d4f62b211ae79ef5143360c264a40371a728f6ad99b"
