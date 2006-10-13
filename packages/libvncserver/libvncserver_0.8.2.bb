DESCRIPTION = "A library to support implementations of RDP/VNC servers"
LICENSE = "GPLv2"
HOMEPAGE = "http://sourceforge.net/projects/libvncserver"
AUTHOR = "Johannes Schindelin <dscho@users.sourceforge.net>"
SECTION = "libs"
PRIORITY = "optional"
PROVIDES = "x11vnc"
DEPENDS = "virtual/libsdl virtual/libx11 zlib jpeg libxext"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/LibVNCServer-${PV}.tar.gz;md5sum=17a18e398af6c1730f72068022a152aa"
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
