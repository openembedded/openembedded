SECTION = "console/utils"
DESCRIPTION = "pkg-config is a system for managing library \
compile/link flags that works with automake and autoconf. \
It replaces the ubiquitous *-config scripts you may have \
seen with a single tool."
HOMEPAGE = "http://pkg-config.freedesktop.org/wiki/"
LICENSE = "GPLv2+"
DEPENDS = "glib-2.0"
INC_PR = "r8"

SRC_URI = "http://pkgconfig.freedesktop.org/releases/pkg-config-${PV}.tar.gz \
          "

# Setting `S` is needed, since the recipe name is `pkgconfig` instead of `pkg-config`.
S = "${WORKDIR}/pkg-config-${PV}/"

inherit autotools

do_install_append() {
	install -d -m 0755 ${D}${libdir}/pkgconfig
}
