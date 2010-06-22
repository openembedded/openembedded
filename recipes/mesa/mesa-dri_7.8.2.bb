require mesa-common.inc
require mesa-${PV}.inc
require mesa-dri.inc
PR = "${INC_PR}.0"

DEPENDS += "mesa-dri-glsl-native"

# We need glsl-compile built for buildhost arch instead of target (is provided by mesa-dri-glsl-native)"
do_configure_prepend() {
  sed -i "s#^GLSL_CL = .*\$#GLSL_CL = ${STAGING_BINDIR_NATIVE}/glsl-compile#g" ${S}/src/mesa/shader/slang/library/Makefile
}
