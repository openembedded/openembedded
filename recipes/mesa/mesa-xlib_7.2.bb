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

SRC_URI[archive.md5sum] = "04d379292e023df0b0266825cb0dbde5"
SRC_URI[archive.sha256sum] = "a9cc62ab760afeebcb1319a193508734a2d470cab8effab2776a2d3c65bd9cd2"
SRC_URI[demos.md5sum] = "22e03dc4038cd63f32c21eb60994892b"
SRC_URI[demos.sha256sum] = "3d73988ad3e87f6084a4593cc6b3aac63aca3e893d3e9409d892a6f51558e4c4"
