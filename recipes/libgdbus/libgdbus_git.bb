DESCRIPTION = "dbus glib integration library"
SECTION = "libs"
HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
LICENSE = "GPL LGPL"
DEPENDS = "glib-2.0 dbus"
PE = "1"
PV = "0.2+gitr${SRCREV}"

SRC_URI  = "git://git.moblin.org/repos/projects/libgdbus.git;protocol=http"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
    autotools_stage_all
}
