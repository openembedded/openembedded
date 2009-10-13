include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto"
LIB_DEPS = "libdrm virtual/libx11 libxext libxxf86vm libxdamage libxfixes"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS}"

PV = "7.5.1+gitr${SRCREV}"
PR = "${INC_PR}.0"
PE = "1"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_om-gta02 = "2"

SRC_URI = "git://anongit.freedesktop.org/git/mesa/mesa;protocol=git"
SRC_URI_om-gta02 = "git://git.bitwiz.org.uk/mesa.git;protocol=git;branch=glamo"
S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/dri/*.so"
FILES_${PN}-dbg += "${libdir}/dri/.debug/*"

EXTRA_OECONF += "--with-driver=dri --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"
EXTRA_OECONF_append_om-gta02 = " --disable-glx-tls --disable-gallium-intel "
