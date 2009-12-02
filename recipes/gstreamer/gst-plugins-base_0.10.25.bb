require gst-plugins.inc

PR = "${INC_PR}.1"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "cdparanoia pango libtheora alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv"

