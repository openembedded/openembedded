DESCRIPTION = "Clutter GStreamer"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPL"

DEPENDS = "clutter gstreamer gst-plugins-base"

PACKAGES =+ "${PN}-examples"
FILES_${PN}-examples = "${bindir}/video-player ${bindir}/video-sink ${bindir}/audio"

inherit autotools pkgconfig

do_configure_prepend() {
	if [ -e ${WORKDIR}/gtk-doc.make ] ; then
		cp ${WORKDIR}/gtk-doc.make ${S}/gtk-doc.make
	else
		touch ${S}/gtk-doc.make
	fi
}

do_stage () {
        autotools_stage_all
}

