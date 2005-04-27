DESCRIPTION = "library for easy implementation of a RDP/VNC server"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib jpeg x11"
LICENSE = "GPL"
PACKAGES = "x11vnc libvncserver-storepasswd libvncserver-javaapplet"
FILES_libvncserver-storepasswd = "${bindir}/storepasswd"
FILES_libvncserver-javaapplet = "/${datadir}fbvncserver/classes/index.vnc \
			         /${datadir}fbvncserver/classes/VncViewer.jar"
FILES_x11vnc = "${bindir}/x11vnc"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/LibVNCServer-${PV}.tar.gz"

CFLAGS_append = " -D_REENTRANT"
S = "${WORKDIR}/LibVNCServer-${PV}"
# Original SUBDIRS is='libvncserver examples contrib vncterm classes libvncclient client_examples test'
EXTRA_OEMAKE_append=" SUBDIRS='libvncserver x11vnc examples classes'"

inherit autotools

do_stage () {
	install -d ${STAGING_INCDIR}/rfb
	install -m 0644 rfb/rfb.h rfb/rfbproto.h rfb/rfbint.h rfb/rfbconfig.h \
		    rfb/rfbclient.h rfb/rfbregion.h rfb/keysym.h \
		    rfb/default8x16.h ${STAGING_INCDIR}/rfb

	oe_libinstall -a -C libvncserver libvncserver ${STAGING_LIBDIR}/
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 examples/storepasswd ${D}${bindir}
	install -m 0755 x11vnc/x11vnc ${D}${bindir}
	install -d ${D}${datadir}fbvncserver/classes
	install -m 0644 classes/index.vnc ${D}${datadir}fbvncserver/classes/
	install -m 0644 classes/VncViewer.jar ${D}${datadir}fbvncserver/classes/
}
