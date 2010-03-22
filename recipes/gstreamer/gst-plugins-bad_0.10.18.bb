require gst-plugins.inc

SRC_URI[archive.md5sum] = "84838893b447e774d401a698ff812b32"
SRC_URI[archive.sha256sum] = "2f800127e00da0f157358f87b06563b3de23cbc630fbf6295b43405e52e02070"

DEPENDS += "orc-native gst-plugins-base openssl directfb"

# We don't have vdpau headers in OE and it creates crosscompile badness
EXTRA_OECONF_append = " --disable-vdpau "
