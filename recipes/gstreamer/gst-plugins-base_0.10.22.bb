require gst-plugins.inc

PR = "${INC_PR}.1"

PROVIDES += "gst-plugins"

PR = "r2"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "libtheora alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv"


SRC_URI[archive.md5sum] = "5d0f1e07f8f6db564971b50f75261e8a"
SRC_URI[archive.sha256sum] = "184c5aed03ebfe38a276fc03cb7d8685d9a6da5a48bf6a0565c83e11a29cd5f9"
