include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto"
LIB_DEPS = "virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS}"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive \
           ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaDemos-${PV}.tar.bz2;name=demos \
           file://fix-progs-makefile.patch;patch=1 \
          "

SRC_URI[archive.md5sum] = "85cb891eecb89aae4fdd3499cccd934b"
SRC_URI[archive.sha256sum] = "8c85db5844303b806b18fc6bd40a9dccb02d90b54878a94f910674673ba0aa35"
SRC_URI[demos.md5sum] = "9fe8ec184c7f78691e43c4c0a7f97d56"
SRC_URI[demos.sha256sum] = "5bf65f03ddcd04b02e9ca044285f8754decee67eb274191da1f31627f1d84b0e"

PR = "${INC_PR}.0"

EXTRA_OECONF += "--disable-gallium --with-driver=xlib"
