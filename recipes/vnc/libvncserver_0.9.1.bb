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
            file://clientlogger.patch;patch=1 \
            file://autoreconf.patch;patch=1"
S = "${WORKDIR}/LibVNCServer-${PV}"

# => create libvncserver only
EXTRA_OEMAKE_append=" SUBDIRS='libvncserver' "

inherit autotools
do_stage() {
    autotools_stage_all
}

SRC_URI[md5sum] = "aa00efc3dabde82fde9509bfbab0aba4"
SRC_URI[sha256sum] = "0fbda7fc37c1f360bdbeb586e48d6203a5ef56a8cfc3b78887d7d90db683f282"
