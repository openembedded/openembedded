DESCRIPTION = "A library to support implementations of RDP/VNC servers"
AUTHOR = "Johannes Schindelin <dscho@users.sourceforge.net>"
HOMEPAGE = "http://sourceforge.net/projects/libvncserver"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "virtual/libsdl virtual/libx11 zlib jpeg libxext"
PROVIDES = "x11vnc"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/LibVNCServer-${PV}.tar.gz"
S = "${WORKDIR}/LibVNCServer-${PV}"

inherit autotools

do_stage() {
    autotools_stage_all
}

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 examples/storepasswd ${D}${bindir}
        install -d ${D}${datadir}/fbvncserver/classes
        install -m 0644 classes/index.vnc ${D}${datadir}/fbvncserver/classes/
        install -m 0644 classes/VncViewer.jar ${D}${datadir}/fbvncserver/classes/
}

PACKAGES =+ "x11vnc libvncserver-storepasswd libvncserver-javaapplet"
FILES_x11vnc = "${bindir}/x11vnc ${bindir}/LinuxVNC"
FILES_libvncserver-storepasswd = "${bindir}/storepasswd"
FILES_libvncserver-javaapplet = "${datadir}/fbvncserver/classes/index.vnc \
                                 ${datadir}/fbvncserver/classes/VncViewer.jar"

SRC_URI[md5sum] = "4769d70bcd9d8390afb64c5eddfcd60e"
SRC_URI[sha256sum] = "0ef94a1857e03e826825c559b5b8f07a4b412112fb9326f5eb694d5216747071"
