DESCRIPTION = "GStreamer elements for IMG BufferClass API"
LICENSE = "GPLv3"

PV = "0.10.1.1"
PR = "r1"
PR_append = "+gitr${SRCREV}"

inherit autotools

SRC_URI = "git://gitorious.org/gst-plugin-bc/gst-plugin-bc.git;protocol=git \
           http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-0.10.25.tar.bz2 \
           file://gst-debug.diff;patch=1 \
"

SRCREV = "e14e249ef6cb67e91be9198b71efc61eb84c11b5"

S = "${WORKDIR}/git"

EXTRA_OECONF = " --enable-gles2-example "

# bitbake git fetcher doesn't handle git submodules currently
do_configure_prepend () {
	cp -rf ${WORKDIR}/gstreamer-0.10.25/common/* ${S}/common/
	autopoint
}

ALLOW_EMPTY = "1"

require gst-plugins-package.inc

