DESCRIPTION = "The Unidentified Flying Raw (UFRaw) is a utility to read and manipulate raw images from digital cameras. "
LICENSE = "GPL"

DEPENDS = "gtk+ gtkimageview lcms exiv2 tiff"

SRC_URI = "${SOURCEFORGE_MIRROR}/ufraw/ufraw-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-extras "

PACKAGES =+ "dcraw dcraw-dbg"
FILES_dcraw = "${bindir}/dcraw"
FILES_dcraw-bdg = "${bindir}/.debug/dcraw"



SRC_URI[md5sum] = "b2c104938c1c3eb47e7605432bbd3157"
SRC_URI[sha256sum] = "c750c8180057385eaa0844f1148d6f0223b986da322773195eab44b33b97c19f"
