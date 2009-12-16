include mesa-common.inc

PROTO_DEPS = "xf86driproto glproto dri2proto"
LIB_DEPS = "libdrm virtual/libx11 libxext libxxf86vm libxdamage libxfixes expat"

DEPENDS = "${PROTO_DEPS}  ${LIB_DEPS}"

PV = "7.6.1+gitr${SRCREV}"
PR = "${INC_PR}.3"
PE = "1"

DEFAULT_PREFERENCE = "-2"
DEFAULT_PREFERENCE_om-gta02 = "2"

SRCREV_om-gta02 ?= "a8a1c12262998e5fa3a857eebf857c6d3a95f85e"

SRC_URI = "git://anongit.freedesktop.org/git/mesa/mesa;protocol=git"
SRC_URI_om-gta02 = "git://git.bitwiz.org.uk/mesa.git;protocol=git;branch=glamo"
S = "${WORKDIR}/git"

PACKAGES =+ " mesa-utils "

FILES_${PN} += "${libdir}/dri/*.so"
FILES_${PN}-dbg += "${libdir}/dri/.debug/*"
FILES_mesa-utils = "${bindir}/*"

EXTRA_OECONF += "--with-driver=dri --disable-glx-tls --disable-gallium-intel --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"
