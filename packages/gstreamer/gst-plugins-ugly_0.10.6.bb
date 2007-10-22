require gst-plugins.inc

DEPENDS += "gst-plugins-base mpeg2dec libsidplay"
PR = "r2"

SRC_URI += "file://cross-compile.patch;patch=1 \
            file://gstmad_16bit.patch;patch=1"
