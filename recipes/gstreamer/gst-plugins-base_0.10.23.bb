require gst-plugins.inc

PR = "${INC_PR}.1"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "libtheora alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv"


SRC_URI[archive.md5sum] = "641cc7def2d8667b9b4df15e69dba25f"
SRC_URI[archive.sha256sum] = "1c11d98eb9a1b1bc54becf465e74c2aa4019bb57a31dd70686269af6a9b9e93b"
