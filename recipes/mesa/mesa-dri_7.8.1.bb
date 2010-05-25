include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto expat"
LIB_DEPS = "libdrm virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS} makedepend-native mesa-dri-glsl-native"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaDemos-${PV}.tar.bz2;name=demos \
	   file://fix-progs-makefile.patch \
	   file://glamo.patch \
          "
SRC_URI[archive.md5sum] = "25ec15f8e41fde6d206118cc786dbac4"
SRC_URI[archive.sha256sum] = "b0b46e5abfd75db44501e308125fa92bcf1c91d91e97a043a3b1764cfa0907fa"
SRC_URI[demos.md5sum] = "9ef47f911869657c6bf2f43ebce86b61"
SRC_URI[demos.sha256sum] = "e9f20b9345240064ac35ec914ebce63322a96d3f7c566963791d0daf7e7a93e5"

PR = "${INC_PR}.2"

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
