SECTION = "devel"
DEPENDS += "python-native"
PR = "r0"

SRC_URI = "http://downloads.sourceforge.net/omniorb/omniORB-4.1.4.tar.gz;name=omniORB414targz \
	  file://omniorb_4.1.4.patch;patch=1 \
"

SRC_URI[omniORB414targz.md5sum] = "1f6070ff9b6339876976d61981eeaa6a"
SRC_URI[omniORB414targz.sha256sum] = "84fb9790c25d6e46248c9773747e393b429573190da2150850d4a49debda4e8e"

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
