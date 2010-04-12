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

SRC_URI[md5sum] = "9d478031be34232e988f3d5874396499"
SRC_URI[sha256sum] = "e4c0875794a74ac627b7b74b6098e75c8413bd156856dc434a49c4c112a68af2"
