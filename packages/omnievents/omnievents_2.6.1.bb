PR = "r0"
DESCRIPTION = "OmniEvent service for omniORB
SECTION = "devel"
PRIORITY = "optional"
MAINTAINER = "Philip Balister <philip@balister.org>"
LICENSE = "LGPL"

DEPENDS = omniorb

SRC_URI = "${SOURCEFORGE_MIRROR}/omnievents/omniEvents-2_6_1-src.tar.gz \
file://omniidl-cross.patch;patch=1"

S = "${WORKDIR}/omniEvents-2_6_1"

inherit autotools pkgconfig

#do_configure () {
EXTRA_OECONF="--with-omniorb=${STAGING_LIBDIR}/../usr"
#	oe_runconf
#}

do_compile () {
	export IDL=${STAGING_DIR}/${BUILD_SYS}/bin/omniidl
	export IDL_COS_DIR=${STAGING_DIR}/${BUILD_SYS}/share/idl/omniORB
	oe_runmake
}

do_stage () {
	make DESTDIR=${STAGING_LIBDIR}/.. install
}

#do_install () {
#	export EmbeddedSystem=1
#	make DESTDIR=${D} install
#}
