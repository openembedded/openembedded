require gst-plugins.inc

SRC_URI += "file://fix-playbin2.patch;patch=1 \
            file://gst-plugins-base_rowstride.patch;patch=1 \
"

PR = "${INC_PR}.3"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "cdparanoia pango libtheora alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv"

