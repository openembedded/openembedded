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
