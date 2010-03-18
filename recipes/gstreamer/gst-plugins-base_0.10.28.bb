require gst-plugins.inc

SRC_URI += " \
            file://gst-plugins-base_rowstride.patch;patch=1 \
            file://ivorbis-thumb.patch;patch=1 \
"

SRC_URI[archive.md5sum] = "0107cf985ac90544bae70288220f5bab"
SRC_URI[archive.sha256sum] = "132b6fd7749fcbfa9ad88c854aada44b6870c4175bda21cdb01a52b59a98e14f"

PR = "${INC_PR}.1"

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

