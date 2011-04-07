require gst-plugins.inc

PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "6ef1588921f59d85c44ee2e49a3c97a0"
SRC_URI[archive.sha256sum] = "adfbce68b9fbadb7a7aeda2227af6afe1928ef025af4158726617b9d6834b028"

inherit gconf

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound libv4l"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

EXTRA_OECONF += " --with-libv4l2 "

PACKAGES_DYNAMIC = "\
gst-plugin-alaw* \
gst-plugin-alpha* \
gst-plugin-alphacolor* \
gst-plugin-annodex* \
gst-plugin-apetag* \
gst-plugin-audiofx* \
gst-plugin-auparse* \
gst-plugin-autodetect* \
gst-plugin-avi* \
gst-plugin-cairo* \
gst-plugin-cutter* \
gst-plugin-debug* \
gst-plugin-deinterlace* \
gst-plugin-efence* \
gst-plugin-effectv* \
gst-plugin-equalizer* \
gst-plugin-esd* \
gst-plugin-flac* \
gst-plugin-flv* \
gst-plugin-flxdec* \
gst-plugin-gconfelements* \
gst-plugin-gdkpixbuf* \
gst-plugin-goom* \
gst-plugin-goom2k1* \
gst-plugin-halelements* \
gst-plugin-icydemux* \
gst-plugin-id3demux* \
gst-plugin-imagefreeze* \
gst-plugin-interleave* \
gst-plugin-jack* \
gst-plugin-jpeg* \
gst-plugin-level* \
gst-plugin-matroska* \
gst-plugin-mulaw* \
gst-plugin-multifile* \
gst-plugin-multipart* \
gst-plugin-navigationtest* \
gst-plugin-oss4audio* \
gst-plugin-ossaudio* \
gst-plugin-png* \
gst-plugin-pulse* \
gst-plugin-qtdemux* \
gst-plugin-replaygain* \
gst-plugin-rtp* \
gst-plugin-rtpmanager* \
gst-plugin-rtsp* \
gst-plugin-shapewipe* \
gst-plugin-smpte* \
gst-plugin-souphttpsrc* \
gst-plugin-spectrum* \
gst-plugin-speex* \
gst-plugin-udp* \
gst-plugin-video4linux2* \
gst-plugin-videobox* \
gst-plugin-videocrop* \
gst-plugin-videofilter* \
gst-plugin-videomixer* \
gst-plugin-wavenc* \
gst-plugin-wavpack* \
gst-plugin-wavparse* \
gst-plugin-ximagesrc* \
gst-plugin-y4menc* \
"
