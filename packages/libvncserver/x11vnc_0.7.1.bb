DESCRIPTION = "X11 VNC server"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "zlib jpeg x11"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/LibVNCServer-${PV}.tar.gz"

CFLAGS_append = " -D_REENTRANT"
S = "${WORKDIR}/LibVNCServer-${PV}"
# Original SUBDIRS is='libvncserver examples contrib vncterm classes libvncclient client_examples test'
EXTRA_OEMAKE_append=" SUBDIRS='libvncserver x11vnc'"

inherit autotools

do_install () {
	install -d ${D}${bindir}
	install -m 0755 x11vnc/x11vnc ${D}${bindir}
}
