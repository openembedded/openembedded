require gst-plugins.inc

PR = "${INC_PR}.1"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv"

PR = "r5"


SRC_URI[archive.md5sum] = "151b66228e08ab0c7601713030fb1c3f"
SRC_URI[archive.sha256sum] = "f82cfd5669c756726f503dde5936e2fbe2969631095f0efc40df1fae1a74f70d"
