require gst-plugins.inc
PR = "r0"

DEPENDS += "gst-plugins-base mpeg2dec libsidplay"

SRC_URI += "\
#  file://cross-compile.patch;patch=1 \
  file://gstmad_16bit.patch;patch=1 \
  file://gstsid_autofoo_HACK.patch;patch=1 \
"
