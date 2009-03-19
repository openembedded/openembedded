DESCRIPTION = "The Unidentified Flying Raw (UFRaw) is a utility to read and manipulate raw images from digital cameras. "
LICENSE = "GPL"

DEPENDS = "gtk+ gtkimageview lcms exiv2 tiff"

SRC_URI = "${SOURCEFORGE_MIRROR}/ufraw/ufraw-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-extras "

PACKAGES =+ "dcraw dcraw-dbg"
FILES_dcraw = "${bindir}/dcraw"
FILES_dcraw-bdg = "${bindir}/.debug/dcraw"


