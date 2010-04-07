DESCRIPTION = "Take photos and videos with your webcam, with fun graphical effects"
LICENSE = "GPLv2"

DEPENDS = "gtk+ gstreamer libcanberra udev librsvg gnome-desktop eds-dbus"
RRECOMMENDS_${PN} = "gst-plugin-gconfelements gst-plugins-good-meta gst-plugins-base-meta"

inherit gnome

SRC_URI[archive.md5sum] = "bdcd6f220749ec7ec1a7d4b4726cac78"
SRC_URI[archive.sha256sum] = "7eab2c736abc1a333eb3dd7fb5c888c08f2dc0f34443b5801a7dfc581101aab9"

FILES_${PN} += "${datadir}/dbus-1"

