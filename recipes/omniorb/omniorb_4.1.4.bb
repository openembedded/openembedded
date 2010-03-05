DESCRIPTION = "OmniORB High Performance ORB"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "omniorb-native"
PR = "r0"

SRC_URI = "http://downloads.sourceforge.net/omniorb/omniORB-4.1.4.tar.gz;name=omniORB414targz \
file://omniorb_4.1.4.patch;patch=1 \ 
file://omniORB.cfg \
file://omniORB-cross.patch;patch=1 \
file://omniORB_embedded_appl.patch;patch=1 \
file://rm_LongDouble.patch;patch=1 \
"

SRC_URI[omniORB414targz.md5sum] = "1f6070ff9b6339876976d61981eeaa6a"
SRC_URI[omniORB414targz.sha256sum] = "84fb9790c25d6e46248c9773747e393b429573190da2150850d4a49debda4e8e"

S = "${WORKDIR}/omniORB-${PV}"

FILES_${PN}-dev += "${datadir}/idl/omniORB/* ${datadir}/idl/omniORB/cos/*
TARGET_CC_ARCH += ${LDFLAGS}

inherit autotools pkgconfig 

do_compile () {
        export EmbeddedSystem=1
        export TOOLBINDIR=${STAGING_BINDIR_NATIVE}
	oe_runmake
	
}
do_install () {
        export EmbeddedSystem=1
        make DESTDIR=${D} install
        install -d ${D}${sysconfdir}
        install -m 0644 ${WORKDIR}/omniORB.cfg ${D}${sysconfdir}
        install -d ${D}${localstatedir}/omninames
	
	#only executable libraries are stripped by the stripper
	chmod +x ${WORKDIR}/image/usr/lib/lib*
}
do_stage () {
        export EmbeddedSystem=1
        autotools_stage_all
}
