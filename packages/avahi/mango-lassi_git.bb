DESCRIPTION = "Input sharing, the avahi way"
DEPENDS = "avahi-ui libglade libnotify"

PV = "0.0+git${SRCDATE}"

SRC_URI = "git://git.0pointer.de/repos/mango-lassi.git/;protocol=http"


S = "${WORKDIR}/${PN}"

do_compile_prepend() {
        export CFLAGS="-Wall -Wextra -W -O0 -g -pipe -Wno-unused-parameter `pkg-config --cflags dbus-glib-1 glib-2.0 gtk+-2.0 xtst avahi-ui avahi-glib avahi-client libnotify libglade-2.0` `pkg-config --libs dbus-glib-1 glib-2.0 gtk+-2.0 xtst avahi-glib avahi-client avahi-ui libnotify libglade-2.0`"
}

do_install() {
        install -d ${D}${bindir}
	install -m 755 mango-lassi ${D}${bindir}
}
