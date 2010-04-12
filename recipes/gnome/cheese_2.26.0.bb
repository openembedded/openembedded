DESCRIPTION = "Take photos and videos with your webcam, with fun graphical effects"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "gtk+ gstreamer hal librsvg gnome-desktop eds-dbus"
RRECOMMENDS_${PN} = "gst-plugin-gconfelements gst-plugins-good-meta gst-plugins-base-meta"

inherit gnome

FILES_${PN} += "${datadir}/dbus-1"


SRC_URI[archive.md5sum] = "17c991c695c3a7549da6e42d1b327d79"
SRC_URI[archive.sha256sum] = "297c7aa579e14c1c22fbbc19254fbefca3b79ef8e6643856c83be0fdb8721412"
