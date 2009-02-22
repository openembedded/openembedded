
# Task for dsp accelerated gstreamer plugins

DEPENDS = "gst-plugins-base gst-plugins-good gst-plugins-ugly gst-ffmpeg gstreamer-ti gst-openmax"

RDEPENDS_${PN} = " \
gst-plugins-base-meta \
gst-plugins-good-meta \
gst-plugins-ugly-meta \
gst-ffmpeg \
gst-openmax \
gstreamer-ti \
"

inherit task

