include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto"
LIB_DEPS = "virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS}"

PE = "1"
PR = "${INC_PR}.0"

EXTRA_OECONF += "--with-driver=xlib"

PACKAGES =+ "${PN}-xprogs"

FILES_${PN}-xprogs = "${bindir}/glxdemo ${bindir}/glxgears ${bindir}/glxheads ${bindir}/glxinfo"

do_install_append () {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/progs/xdemos/{glxdemo,glxgears,glxheads,glxinfo} ${D}/${bindir}
}

SRC_URI[archive.md5sum] = "7ecddb341a2691e0dfdb02f697109834"
SRC_URI[archive.sha256sum] = "6e945389add4e5b41f2c403ced13c343767565f2eacde4b16de2d0f9f8a6aac4"
SRC_URI[demos.md5sum] = "02816f10f30b1dc5e069e0f68c177c98"
SRC_URI[demos.sha256sum] = "c3de74d62f925e32030adb3d0edcfb3c7a4129fc92c48181a389eeed8f14b897"
