# Task for installing gstreamer plugins on TI platforms

PR = "r2"

DEPENDS = "gst-plugins-base gst-plugins-bad gst-plugins-good gst-plugins-ugly"

GST_CODEC_ELEMENT = " \
	gstreamer-ti \
"

GST_CODEC_ELEMENT_am3517-evm = "\
	gst-ffmpeg \
	gst-omapfb \
"

RDEPENDS_${PN} = " \
	gst-plugins-base-meta \
	gst-plugins-good-meta \
	gst-plugins-bad-meta \
	gst-plugins-ugly-meta \
	${GST_CODEC_ELEMENT} \
"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

