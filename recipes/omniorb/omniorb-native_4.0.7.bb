SECTION = "devel"
DEPENDS += "python-native"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/omniorb/omniORB-${PV}.tar.gz"

S = "${WORKDIR}/omniORB-${PV}"

inherit native autotools

do_compile () {
        oe_runmake
}
# Ugly hack so libtool does not find native libs when building cross packages
# We really only build this package for omniidl anyway
do_stage_append() {
        rm -f  ${STAGING_LIBDIR_NATIVE}/libomni*
}
