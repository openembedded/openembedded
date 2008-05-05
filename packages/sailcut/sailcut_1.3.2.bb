DESCRIPTION = "Sail design and plotting software"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "qt4-x11-free"
SRCNAME = "sailcut"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"
EXTRA_OECONF = "\
	--with-qt-includes=${STAGING_INCDIR}/qt4 \
	--with-qt-libraries=${STAGING_LIBDIR} \
	MOC=moc4 UIC=uic4"

inherit autotools

