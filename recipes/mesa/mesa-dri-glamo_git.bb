include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto"
LIB_DEPS = "libdrm-glamo virtual/libx11 libxext libxxf86vm libxdamage libxfixes expat"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS}"
PROVIDES = "mesa"

PV = "7.5.1+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://git.bitwiz.org.uk/mesa.git;protocol=git;branch=glamo"

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/dri/*.so"
FILES_${PN}-dbg += "${libdir}/dri/.debug/*"

EXTRA_OECONF += "--disable-glx-tls --with-driver=dri --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"
CFLAGS_append = " -D_POSIX_SOURCE -D_POSIX_C_SOURCE=199309L -D_SVID_SOURCE "
CFLAGS_append += "-D_BSD_SOURCE -D_GNU_SOURCE"

do_install_append () {
    install -d ${D}/usr/bin
    install -m 0755 ${S}/progs/xdemos/{glxdemo,glxgears,glxheads,glxinfo} ${D}/usr/bin/
}
