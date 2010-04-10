DESCRIPTION = "Take photos and videos with your webcam, with fun graphical effects"
LICENSE = "GPLv2"

DEPENDS = "gtk+ gstreamer hal librsvg gnome-desktop eds-dbus"
RRECOMMENDS_${PN} = "gst-plugin-gconfelements gst-plugins-good-meta gst-plugins-base-meta"

inherit gnome

FILES_${PN} += "${datadir}/dbus-1"


SRC_URI[archive.md5sum] = "843a64fb7392286dce9ac1dd0e2457c5"
SRC_URI[archive.sha256sum] = "8a55e8c5db5c90d77f53b48d00785fa3d2897570e1a4016cf4b0cf602a7ae2ed"
