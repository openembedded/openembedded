HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
SUMMARY  = "Moblin Glib D-Bus integration"
LICENSE  = "GPL LGPL"
DEPENDS  = "glib-2.0 dbus"
PE       = "1"
PV       = "0.0+gitr${SRCREV}"
S        = "${WORKDIR}/git"

SRC_URI  = "git://git.moblin.org/repos/projects/libgdbus.git;protocol=http"

inherit autotools pkgconfig

do_stage() {
    autotools_stage_all
}
