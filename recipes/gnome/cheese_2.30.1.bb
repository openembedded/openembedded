DESCRIPTION = "Take photos and videos with your webcam, with fun graphical effects"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "gtk+ gstreamer gst-plugins-base libcanberra udev librsvg gnome-desktop eds-dbus"
RRECOMMENDS_${PN} = "gst-plugin-gconfelements gst-plugins-good-meta gst-plugins-base-meta"

inherit gnome

SRC_URI[archive.md5sum] = "1599fded8a1797ea51fb010af4e6c45b"
SRC_URI[archive.sha256sum] = "48f03470c6f527caa0e3b269d3afcff86ae0939a74f66ce030d4eed3bc3cbd9a"

FILES_${PN} += "${datadir}/dbus-1"

