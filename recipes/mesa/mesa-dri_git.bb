include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto"
LIB_DEPS = "libdrm virtual/libx11 libxext libxxf86vm libxdamage libxfixes expat"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS} makedepend-native mesa-dri-glsl-native"

PV = "7.7.999"
PR = "${INC_PR}.0"
PR_append = "+gitr${SRCREV}"
PE = "1"

DEFAULT_PREFERENCE = "-2"
DEFAULT_PREFERENCE_shr = "2"

SRCREV_pn-mesa-dri ?= "196214bf2b677a83653d49f79d03752f29df44ec"
SRCREV_pn-mesa-dri_shr ?= "1ac166895fef47806c9e9286d2a6356b4db8398d"

SRC_URI = "git://anongit.freedesktop.org/git/mesa/mesa;protocol=git"
SRC_URI_shr = "git://git.bitwiz.org.uk/mesa.git;protocol=git;branch=glamo"
SRC_URI_append = " file://fix-progs-makefile.patch;patch=1"
SRC_URI_shr_append = " file://fix-progs-makefile.patch;patch=1"

S = "${WORKDIR}/git"

PACKAGES =+ " mesa-utils "

FILES_${PN} += "${libdir}/dri/*.so"
FILES_${PN}-dbg += "${libdir}/dri/.debug/*"
FILES_mesa-utils = "${bindir}/*"

EXTRA_OECONF += "--with-driver=dri --disable-glx-tls --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"
EXTRA_OECONF_om-gta02 += "--with-driver=dri --disable-glx-tls --disable-gallium --disable-gallium-intel --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"
EXTRA_OECONF_om-gta01 += "--with-driver=dri --disable-glx-tls --disable-gallium --disable-gallium-intel --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"

# We need glsl-compile built for buildhost arch instead of target (is provided by mesa-dri-glsl-native)"
do_configure_prepend() {
  sed -i "s#glsl_compile\[0\].abspath + '#'${STAGING_BINDIR_NATIVE}/glsl-compile#g" ${S}/src/mesa/shader/slang/library/SConscript
  sed -i "s#^GLSL_CL = .*\$#GLSL_CL = ${STAGING_BINDIR_NATIVE}/glsl-compile#g" ${S}/src/mesa/shader/slang/library/Makefile
}
