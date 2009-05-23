DESCRIPTION = "Python keyring"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python python-pygtk python-xml python-netclient pydes"

PR = "r1"
ARCH_pyring = "all"

SRC_URI = "http://handheldshell.com/software/pyring_1.1.6.tgz "

inherit autotools

S = ${WORKDIR}

do_install() {
        install -d ${D}/usr/share/applications
        install -d ${D}/usr/bin
        install -d ${D}/usr/lib/pyring
        install -d ${D}/usr/share/pixmaps
        install -m 0755 ${S}/pyring/pyring.py ${D}/usr/bin
        install -m 0755 ${S}/pyring/pyring.desktop ${D}/usr/share/applications
        install -m 0755 ${S}/pyring/pyring_icon_48x48.png ${D}/usr/share/pixmaps
        install -m 0755 ${S}/pyring/neo_gui.glade ${D}/usr/lib/pyring
}

do_configure() {
        exit 0
}

do_compile() {
        exit 0
}

