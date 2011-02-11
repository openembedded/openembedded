require gst-plugins.inc

SRC_URI += " \
            file://ivorbis-thumb.patch \
"

SRC_URI[archive.md5sum] = "2920af2b3162f3d9fbaa7fabc8ed4d38"
SRC_URI[archive.sha256sum] = "e9aabfac83f6480896da0686e9c911989f896fbad634821b7771ed84a446172b"

PR = "${INC_PR}.1"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just
# a missing alsa plugin
DEPENDS += "udev cdparanoia pango libtheora alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv libxrandr gtk+"

def get_gstreamer_fpu_setting(bb, d):
    if bb.data.getVar('TARGET_FPU', d, 1) in [ 'soft' ]:
        return "--with-audioresample-format=int"
    return ""

# Needs a udev that enabled gudev, which isn't the default
EXTRA_OECONF += "--with-gudev --disable-gnome_vfs ${@get_gstreamer_fpu_setting(bb, d)}"

do_configure_prepend() {
	sed -i -e s:QtGui:NoQtGui:g ${S}/configure.ac
}

