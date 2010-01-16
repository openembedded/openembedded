DESCRIPTION="A simple gstreamer based player"

DEPENDS = "gstreamer"
RDEPENDS = "gstreamer-ti"

SRCREV = "6"
SRC_URI = "svn://gstplayer.googlecode.com/svn;module=trunk;proto=http"

S = "${WORKDIR}/trunk/gstplayer"

PE = "1"
PV = "1.0.0+svnr${SRCPV}"
PR = "r0"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 gstplayer ${D}/usr/bin
}

