DESCRIPTION = "OmniORB High Performance ORB"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "omniorb-native"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/omniorb/omniORB-${PV}.tar.gz \
file://omniORB.cfg \
file://omniORB-cross.patch;patch=1 \
file://omniORB_embedded_appl.patch;patch=1 \
file://rm_LongDouble.patch;patch=1 \
file://arm_double.patch;patch=1;pnum=0 \
file://dynskel.patch;patch=1;pnum=0 \
"

S = "${WORKDIR}/omniORB-${PV}"

FILES_${PN}-dev += "${datadir}/idl/omniORB/* ${datadir}/idl/omniORB/cos/*

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
}
do_stage () {
        export EmbeddedSystem=1
        autotools_stage_all
}

SRC_URI[md5sum] = "9d478031be34232e988f3d5874396499"
SRC_URI[sha256sum] = "e4c0875794a74ac627b7b74b6098e75c8413bd156856dc434a49c4c112a68af2"
