include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto"
LIB_DEPS = "virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS}"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaDemos-${PV}.tar.bz2;name=demos \
          "

PE = "1"
PR = "${INC_PR}.0"

EXTRA_OECONF += "--disable-gallium --with-driver=xlib"

SRC_URI[archive.md5sum] = "8c75f90cd0303cfac9e4b6d54f6759ca"
SRC_URI[archive.sha256sum] = "782a7b2810b1c466b3a994eba96485b59b47cc1120c0caa24de1aecf1e013830"
SRC_URI[demos.md5sum] = "0ede7adf217951acd90dbe4551210c07"
SRC_URI[demos.sha256sum] = "2fdf09fd7967fb1946e7f6af07d39c9fb695c373e1bad3855d3c3fbece5badd0"
