require gst-plugins.inc

SRC_URI += " \
            file://ivorbis-thumb.patch \
            file://make382.patch \
"

SRC_URI[archive.md5sum] = "3ad90152b58563e1314af26c263f3c4c"
SRC_URI[archive.sha256sum] = "63938641380be9935c804ae8d55acdcfd93920ed2deb72dcf70f027a78b085d7"

PR = "${INC_PR}.0"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "udev cdparanoia pango libtheora alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv"

# Needs a udev that enabled gudev, which isn't the default
EXTRA_OECONF_append = " --with-gudev"

do_configure_prepend() {
	sed -i -e s:QtGui:NoQtGui:g ${S}/configure.ac
}

