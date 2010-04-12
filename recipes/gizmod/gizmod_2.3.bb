DESCRIPTION = "Gizmo Daemon"
HOMEPAGE = "http://gizmod.sourceforge.net"
LICENSE = "GPLv2"
SECTION = "console/multimedia"
DEPENDS = "python virtual/libx11 xf86vidmodeproto alsa-lib"
SRC_URI = "${SOURCEFORGE_MIRROR}/gizmod/gizmod-${PV}.tar.bz2 \
           file://disable-xmms.patch;patch=1 \
           file://fix-python-configure.patch;patch=1 \
           file://disable-bmp.patch;patch=1"

PR = "r0"

inherit autotools

EXTRA_OECONF = "--disable-xmms --disable-bmp --disable-xosd"

#do_configure_prepend() {
#    sed -i 's/TARGET_SYS/${TARGET_SYS}/' ${S}/configure.ac
#}

FILES_${PN} += "${datadir}/gizmo/scripts ${datadir}/gizmo/plugins/*.so ${datadir}/gizmo/plugins/*.so.*"
FILES_${PN}-dev += "${datadir}/gizmo/plugins/*.a ${datadir}/gizmo/plugins/*.la"
FILES_${PN}-dbg += "${datadir}/gizmo/plugins/.debug"
SRC_URI[md5sum] = "b7200b08149599c4c0f56d88f0c7f208"
SRC_URI[sha256sum] = "53af32530e58ba23cbb752f063364612bbea57b31de2ee35814973452c2f63f2"
