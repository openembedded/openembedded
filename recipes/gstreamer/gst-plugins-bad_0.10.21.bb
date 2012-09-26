require gst-plugins.inc

SRC_URI += "file://0001-opencv-update-to-opencv-2.2-api-for-cvHaarDetectObje.patch"

SRC_URI[archive.md5sum] = "f501336ab1d18d2565f47c36ce653a82"
SRC_URI[archive.sha256sum] = "422badacbda37ac33cb446c6751dabcd0b223c308dbb01024a34ded682fa47e3"

DEPENDS += "opencv orc-native orc libcdaudio gst-plugins-base openssl directfb libmodplug librsvg"

PR = "${INC_PR}.1"

# We don't have vdpau headers in OE and it creates crosscompile badness.
# Also, mpeg2enc and mplex from mjpegtools don't build, because of AC_TRY_RUN.
EXTRA_OECONF += " \
        --disable-mpeg2enc \
        --disable-mplex \
        --disable-vdpau \
"

EXTRA_OECONF += "${@base_conditional('ENTERPRISE_DISTRO', '1', '--disable-faac --disable-faad', '', d)}"

PACKAGES_DYNAMIC = "\
gst-plugin-adpcmdec* \
gst-plugin-adpcmenc* \
gst-plugin-aiff* \
gst-plugin-apexsink* \
gst-plugin-asfmux* \
gst-plugin-audioparsersbad* \
gst-plugin-autoconvert* \
gst-plugin-bayer* \
gst-plugin-bz2* \
gst-plugin-camerabin* \
gst-plugin-cdxaparse* \
gst-plugin-cog* \
gst-plugin-coloreffects* \
gst-plugin-colorspace* \
gst-plugin-dataurisrc* \
gst-plugin-dccp* \
gst-plugin-debugutilsbad* \
gst-plugin-dfbvideosink* \
gst-plugin-dtmf* \
gst-plugin-dvb* \
gst-plugin-dvbsuboverlay* \
gst-plugin-dvdspu* \
gst-plugin-fbdevsink* \
gst-plugin-festival* \
gst-plugin-freeze* \
gst-plugin-frei0r* \
gst-plugin-gaudieffects* \
gst-plugin-geometrictransform* \
gst-plugin-gsettingselements* \
gst-plugin-gsm* \
gst-plugin-h264parse* \
gst-plugin-hdvparse* \
gst-plugin-id3tag* \
gst-plugin-interlace* \
gst-plugin-invtelecine* \
gst-plugin-ivfparse* \
gst-plugin-jp2k* \
gst-plugin-jp2kdecimator* \
gst-plugin-jpegformat* \
gst-plugin-legacyresample* \
gst-plugin-liveadder* \
gst-plugin-mms* \
gst-plugin-modplug* \
gst-plugin-mpeg4videoparse* \
gst-plugin-mpegdemux* \
gst-plugin-mpegpsmux* \
gst-plugin-mpegtsmux* \
gst-plugin-mpegvideoparse* \
gst-plugin-mve* \
gst-plugin-mxf* \
gst-plugin-nsf* \
gst-plugin-nuvdemux* \
gst-plugin-opencv* \
gst-plugin-pcapparse* \
gst-plugin-pnm* \
gst-plugin-qtmux* \
gst-plugin-rawparse* \
gst-plugin-rfbsrc* \
gst-plugin-rsvg* \
gst-plugin-rtpmux* \
gst-plugin-scaletempoplugin* \
gst-plugin-schro* \
gst-plugin-sdl* \
gst-plugin-sdpelem* \
gst-plugin-segmentclip* \
gst-plugin-shm* \
gst-plugin-siren* \
gst-plugin-sndfile* \
gst-plugin-speed* \
gst-plugin-stereo* \
gst-plugin-subenc* \
gst-plugin-tta* \
gst-plugin-vcdsrc* \
gst-plugin-videomaxrate* \
gst-plugin-videomeasure* \
gst-plugin-videosignal* \
gst-plugin-vmnc* \
gst-plugin-vp8* \
gst-plugin-y4mdec* \
"

PACKAGES_DYNAMIC += "${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugin-faac* gst-plugin-faad*', d)}"

