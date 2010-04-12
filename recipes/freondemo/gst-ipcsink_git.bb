DESCRIPTION = "gst-ipcsink: custom gstreamer element for IPC video sink"
HOMEPAGE = "http://sourceforge.net/projects/freondemo"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

inherit autotools

DEPENDS = "gstreamer gst-plugins-base"

SRCREV = "7e38d82d1207bb75f235f5643c4c2d15591e9b3c"

PV = "1.0"
PR = "r0"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://freondemo.git.sourceforge.net/gitroot/freondemo/gst-ipcsink;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so ${sysconfdir}"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.a ${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
