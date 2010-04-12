DESCRIPTION = "Sail design and plotting software"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "qt4-x11-free"
SRCNAME = "sailcut"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"
EXTRA_OECONF = "\
	--with-qt-includes=${STAGING_INCDIR}/qt4 \
	--with-qt-libraries=${STAGING_LIBDIR} \
	MOC=moc4 UIC=uic4 LRELEASE=lrelease4 LUPDATE=lupdate4"

inherit autotools


SRC_URI[md5sum] = "4bd5142c1741bb302dcd8e3b2e22dcd5"
SRC_URI[sha256sum] = "c93f35baa7100fa04033b646b273ebf1da01954ea1d1dd33ab599b92ed916fa1"
