include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto expat"
LIB_DEPS = "libdrm virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS} makedepend-native mesa-dri-glsl-native"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaDemos-${PV}.tar.bz2;name=demos \
	   file://fix-progs-makefile.patch \
	   file://glamo.patch \
          "
SRC_URI[archive.md5sum] = "6be2d343a0089bfd395ce02aaf8adb57"
SRC_URI[archive.sha256sum] = "505bf418dceba05837f4ea1b1972b9620c35f8cb94bc4d1e6d573c15f562576d"
SRC_URI[demos.md5sum] = "757d9e2e06f48b1a52848be9b0307ced"
SRC_URI[demos.sha256sum] = "ea7b9ebfb7a80de2b275c0c9124c8a505382ec48411a2794ab82542f9885ac3c"

PR = "${INC_PR}.0"

# most of our targets do not have DRI so will use mesa-xlib
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "2"

# ASUS EeePC 901 has DRI support so use mesa-dri by default
DEFAULT_PREFERENCE_eee901 = "1"

PACKAGES =+ "${PN}-xprogs"

FILES_${PN} += "${libdir}/dri/*.so \
                ${libdir}/egl/*.so"
FILES_${PN}-dbg += "${libdir}/dri/.debug/* \
                    ${libdir}/egl/.debug/*"
FILES_${PN}-xprogs = "${bindir}/glxdemo ${bindir}/glxgears ${bindir}/glxheads ${bindir}/glxinfo"

EXTRA_OECONF += "--with-driver=dri --disable-glx-tls --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"
EXTRA_OECONF_shr += "--with-driver=dri --disable-glx-tls --disable-gallium \
 --disable-gallium-intel --with-dri-drivers=swrast,${MACHINE_DRI_MODULES} \
 ${@base_conditional( 'MACHINE',"htcdream", "--disable-egl", "",d)} "

# We need glsl-compile built for buildhost arch instead of target (is provided by mesa-dri-glsl-native)"
do_configure_prepend() {
  sed -i "s#^GLSL_CL = .*\$#GLSL_CL = ${STAGING_BINDIR_NATIVE}/glsl-compile#g" ${S}/src/mesa/shader/slang/library/Makefile
}
