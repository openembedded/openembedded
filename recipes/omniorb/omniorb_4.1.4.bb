DESCRIPTION = "OmniORB High Performance ORB"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS += "omniorb-native"
DEPENDS_virtclass-native += "python-native"
PR = "r2"

SRC_URI = "http://downloads.sourceforge.net/omniorb/omniORB-4.1.4.tar.gz;name=omniORB414targz \
file://omniorb_4.1.4.patch \ 
file://omniORB.cfg \
file://omniORB-cross.patch \
file://omniORB_embedded_appl.patch \
file://rm_LongDouble.patch \
"
SRC_URI_virtclass-native = "http://downloads.sourceforge.net/omniorb/omniORB-4.1.4.tar.gz;name=omniORB414targz \
	  file://omniorb_4.1.4.patch \
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

do_compile_virtclass-native() {
        oe_runmake
}

do_install () {
        # Set a variable that the Makefiles obey for install.
        export EmbeddedSystem=1
        autotools_do_install
        install -d ${D}${sysconfdir}
        install -m 0644 ${WORKDIR}/omniORB.cfg ${D}${sysconfdir}
        install -d ${D}${localstatedir}/omninames
	
	#only executable libraries are stripped by the stripper
	chmod +x ${WORKDIR}/image/usr/lib/lib*
}

do_install_virtclass-native() {
        autotools_do_install

	# Ugly hack so libtool does not find native libs when building cross
	# packages We really only build this package for omniidl anyway
        rm -f  ${D}${libdir}/libomni*
}

BBCLASSEXTEND = "native"

NATIVE_INSTALL_WORKS = "1"
