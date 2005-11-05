PR = "r0"
DESCRIPTION = "OmniORB High Performance ORB"
SECTION = "devel"
PRIORITY = "optional"
MAINTAINER = "Philip Balister <philip@balister.org>"
LICENSE = "LGPL"

DEPENDS = omniorb-native

SRC_URI = "${SOURCEFORGE_MIRROR}/omniorb/omniORB-${PV}.tar.gz \
file://omniORB-cross.patch;patch=1 \
file://omniORB_embedded_appl.patch;patch=1"

S = "${WORKDIR}/omniORB-${PV}"

inherit autotools pkgconfig

#do_configure () {
#	oe_runconf
#}

do_compile () {
	export EmbeddedSystem=1
	export TOOLBINDIR=${STAGING_BINDIR}
	oe_runmake
}

do_stage () {
	export EmbeddedSystem=1
	make DESTDIR=${STAGING_DIR}/${TARGET_SYS} install
}

do_install () {
	export EmbeddedSystem=1
	make DESTDIR=${D} install
}
