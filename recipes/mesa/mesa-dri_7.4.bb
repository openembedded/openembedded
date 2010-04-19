include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto expat"
LIB_DEPS = "libdrm virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS}"

PR = "${INC_PR}.0"

# most of our targets do not have DRI so will use mesa-xlib
DEFAULT_PREFERENCE = "-1"

# ASUS EeePC 901 has DRI support so use mesa-dri by default
DEFAULT_PREFERENCE_eee901 = "1"

PACKAGES =+ "${PN}-xprogs"

FILES_${PN} += "${libdir}/dri/*.so"
FILES_${PN}-dbg += "${libdir}/dri/.debug/*"
FILES_${PN}-xprogs = "${bindir}/glxdemo ${bindir}/glxgears ${bindir}/glxheads ${bindir}/glxinfo"

EXTRA_OECONF += "--with-driver=dri --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"

SRC_URI[archive.md5sum] = "7ecddb341a2691e0dfdb02f697109834"
SRC_URI[archive.sha256sum] = "6e945389add4e5b41f2c403ced13c343767565f2eacde4b16de2d0f9f8a6aac4"
SRC_URI[demos.md5sum] = "02816f10f30b1dc5e069e0f68c177c98"
SRC_URI[demos.sha256sum] = "c3de74d62f925e32030adb3d0edcfb3c7a4129fc92c48181a389eeed8f14b897"
