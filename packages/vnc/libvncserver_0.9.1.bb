DESCRIPTION = "library for easy implementation of a RDP/VNC server"
AUTHOR = "Johannes Schindelin <dscho@users.sourceforge.net"
HOMEPAGE = "http://sourceforge.net/projects/libvncserver/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "zlib jpeg"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI  = "${SOURCEFORGE_MIRROR}/libvncserver/LibVNCServer-${PV}.tar.gz \
            file://configure_ac.patch;patch=1 \
           file://clientlogger.patch;patch=1"
S = "${WORKDIR}/LibVNCServer-${PV}"

# => create libvncserver only
EXTRA_OEMAKE_append=" SUBDIRS='libvncserver' "

inherit autotools
do_stage() {
    autotools_stage_all
}
