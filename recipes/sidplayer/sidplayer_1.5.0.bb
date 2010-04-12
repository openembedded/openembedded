DESCRIPTION = "A SID Player for the Qt/Embedded based Palmtop Environments"
SECTION = "opie/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://sidplayer.sourceforge.net/"
DEPENDS = "libsidplay"
PR = "r1"

SRC_URI = "http://sidplayer.sourceforge.net/sidplayer.tar.gz \
           file://use-external-libsidplay.patch;patch=1 \
           file://gcc3.patch;patch=1 \
	   file://gcc34.patch;patch=1"
S = "${WORKDIR}/sidplayer"

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/sidplay"

inherit palmtop

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics
	cp -pPR ../apps ../bin ../pics ${D}${palmtopdir}/
}

SRC_URI[md5sum] = "bba4a99e59581066e905c9326a724ba5"
SRC_URI[sha256sum] = "bc6bfd100c495e74baa651c470252484b19bfc2e6fa8520f591b0c01b9fcfb5d"
