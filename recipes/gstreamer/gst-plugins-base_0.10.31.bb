require gst-plugins.inc

SRC_URI += " \
            file://ivorbis-thumb.patch \
"

SRC_URI[archive.md5sum] = "9baa0d87e81c88b2477a3554ab629c46"
SRC_URI[archive.sha256sum] = "abb006c78222cfb69d31e983268d1d5219e9d4e0da24c6c4cd687968af7a33bd"

PR = "${INC_PR}.0"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just
# a missing alsa plugin
DEPENDS += "udev cdparanoia pango libtheora alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv gtk+"

# Needs a udev that enabled gudev, which isn't the default
EXTRA_OECONF_append = " --with-gudev"

do_configure_prepend() {
	sed -i -e s:QtGui:NoQtGui:g ${S}/configure.ac
}

