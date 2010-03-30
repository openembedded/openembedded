include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto expat"
LIB_DEPS = "libdrm virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS} makedepend-native mesa-dri-glsl-native"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaDemos-${PV}.tar.bz2;name=demos \
	   file://fix-progs-makefile.patch;patch=1 \
          "
SRC_URI[archive.md5sum] = "85cb891eecb89aae4fdd3499cccd934b"
SRC_URI[archive.sha256sum] = "8c85db5844303b806b18fc6bd40a9dccb02d90b54878a94f910674673ba0aa35"
SRC_URI[demos.md5sum] = "9fe8ec184c7f78691e43c4c0a7f97d56"
SRC_URI[demos.sha256sum] = "5bf65f03ddcd04b02e9ca044285f8754decee67eb274191da1f31627f1d84b0e"

PR = "${INC_PR}.0"

# most of our targets do not have DRI so will use mesa-xlib
DEFAULT_PREFERENCE = "-1"

# ASUS EeePC 901 has DRI support so use mesa-dri by default
DEFAULT_PREFERENCE_eee901 = "1"

PACKAGES =+ "${PN}-xprogs"

FILES_${PN} += "${libdir}/dri/*.so"
FILES_${PN}-dbg += "${libdir}/dri/.debug/*"
FILES_${PN}-xprogs = "${bindir}/glxdemo ${bindir}/glxgears ${bindir}/glxheads ${bindir}/glxinfo"

EXTRA_OECONF += "--with-driver=dri --disable-glx-tls --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"
EXTRA_OECONF_shr += "--with-driver=dri --disable-glx-tls --disable-gallium --disable-gallium-intel --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"

# We need glsl-compile built for buildhost arch instead of target (is provided by mesa-dri-glsl-native)"
do_configure_prepend() {
  sed -i "s#^GLSL_CL = .*\$#GLSL_CL = ${STAGING_BINDIR_NATIVE}/glsl-compile#g" ${S}/src/mesa/shader/slang/library/Makefile
}
