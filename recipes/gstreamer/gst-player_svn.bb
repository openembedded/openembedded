DESCRIPTION="A simple gstreamer based player"

DEPENDS = "gstreamer"
RDEPENDS_${PN} = "gstreamer-ti"

SRCREV = "6"
SRC_URI = "svn://gstplayer.googlecode.com/svn;module=trunk;proto=http"

S = "${WORKDIR}/trunk/gstplayer"

PV = "svnr${SRCREV}"
PR = "r3"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 gstplayer ${D}/usr/bin
}

