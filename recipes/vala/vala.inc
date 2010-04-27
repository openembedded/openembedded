DESCRIPTION = "Vala is a C#-like language dedicated to ease GObject programming. \
Vala compiles to plain C and has no runtime environment nor penalities whatsoever."
SECTION = "devel"
DEPENDS = "glib-2.0 dbus"
HOMEPAGE = "http://vala-project.org"
LICENSE = "LGPL"
INC_PR = "r1"

#
# WARNING: This source release has specifically been built for OpenEmbedded.
# Don't update to an upstream release!
#

SRC_URI = "\
  http://downloads.freesmartphone.org/sources/vala-${PV}.tar.bz2;name=archive \
"

inherit autotools

EXTRA_OECONF = "--disable-vapigen"

FILES_${PN}-doc += ${datadir}/devhelp
