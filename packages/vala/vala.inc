DESCRIPTION = "Vala is a C#-like language dedicated to ease GObject programming. \
Vala compiles to plain C and has no runtime environment nor penality whatsoever."
SECTION = "devel"
DEPENDS = "glib-2.0 dbus"
HOMEPAGE = "http://live.gnome.org/Vala"
LICENSE = "LGPL"

MAJV = "${@bb.data.getVar('PV',d,1)[:3]}"

SRC_URI = "\
  http://download.gnome.org/sources/vala/${MAJV}/vala-${PV}.tar.bz2 \
  file://0001-glib-2.0.vapi-add-necessary-struct-members-to-use-B.patch;patch=1 \
  file://0002-glib-2.0-bind-g_io_channel_add_watch_full.patch;patch=1 \
  file://static-dbus-methods.patch;patch=1 \
"
S = "${WORKDIR}/vala-${PV}"

inherit autotools autotools_stage lib_package

EXTRA_OECONF = "--enable-vapigen"

FILES_${PN}-doc += ${datadir}/devhelp
