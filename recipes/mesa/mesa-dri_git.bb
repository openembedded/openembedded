require mesa-common.inc
require mesa-dri.inc

PV = "7.7.999"
PR = "${INC_PR}.0"
PR_append = "+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-2"

SRCREV = "196214bf2b677a83653d49f79d03752f29df44ec"
SRCREV_shr = "1ac166895fef47806c9e9286d2a6356b4db8398d"

SRC_URI = "git://anongit.freedesktop.org/git/mesa/mesa;protocol=git"
SRC_URI_shr = "git://git.bitwiz.org.uk/mesa.git;protocol=git;branch=glamo"
SRC_URI_append = " file://fix-progs-makefile.patch"
SRC_URI_shr_append = " file://fix-progs-makefile.patch"

S = "${WORKDIR}/git"

DEPENDS += "mesa-dri-glsl-native"

# We need glsl-compile built for buildhost arch instead of target (is provided by mesa-dri-glsl-native)"
do_configure_prepend() {
  sed -i "s#glsl_compile\[0\].abspath + '#'${STAGING_BINDIR_NATIVE}/glsl-compile#g" ${S}/src/mesa/shader/slang/library/SConscript
  sed -i "s#^GLSL_CL = .*\$#GLSL_CL = ${STAGING_BINDIR_NATIVE}/glsl-compile#g" ${S}/src/mesa/shader/slang/library/Makefile
}
