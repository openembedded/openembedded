include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto expat"
LIB_DEPS = "libdrm virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS}"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaDemos-${PV}.tar.bz2;name=demos \
          "
PR = "${INC_PR}.0"

# most of our targets do not have DRI so will use mesa-xlib
DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_om-gta01 = "2"

# ASUS EeePC 901 has DRI support so use mesa-dri by default
DEFAULT_PREFERENCE_eee901 = "1"

PACKAGES =+ "${PN}-xprogs"

FILES_${PN} += "${libdir}/dri/*.so"
FILES_${PN}-dbg += "${libdir}/dri/.debug/*"
FILES_${PN}-xprogs = "${bindir}/glxdemo ${bindir}/glxgears ${bindir}/glxheads ${bindir}/glxinfo"

EXTRA_OECONF += "--disable-gallium --with-driver=dri --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"

SRC_URI[archive.md5sum] = "8c75f90cd0303cfac9e4b6d54f6759ca"
SRC_URI[archive.sha256sum] = "782a7b2810b1c466b3a994eba96485b59b47cc1120c0caa24de1aecf1e013830"
SRC_URI[demos.md5sum] = "0ede7adf217951acd90dbe4551210c07"
SRC_URI[demos.sha256sum] = "2fdf09fd7967fb1946e7f6af07d39c9fb695c373e1bad3855d3c3fbece5badd0"
