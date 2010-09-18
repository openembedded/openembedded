require gst-plugins.inc

SRC_URI += " \
            file://ivorbis-thumb.patch \
            file://make382.patch \
"

SRC_URI[archive.md5sum] = "d07e251152cccbaa81807c14cf0fd8c0"
SRC_URI[archive.sha256sum] = "ac035cce4d68e2e0b980d3ddb6c74674667cbfde6cddc65e18ea16368d34732c"

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

