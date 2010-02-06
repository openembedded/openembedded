DESCRIPTION = "A wxWindows wrapper for the sqlite database."
HOMEPAGE = "http://wxcode.sourceforge.net/components/wxsqlite3"
SECTION = "libs"
LICENSE = "wxWindows"
DEPENDS = "sqlite3 wxwidgets"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxcode/wxsqlite3-${PV}.tar.gz;name=wxsqlite3 \
	file://gcc-inline.patch;patch=1 \
	file://wxtranslate.patch;patch=1 \
	"
SRC_URI[wxsqlite3.md5sum] = "2e1bec387bbdf50c632649d041b32a4a"
SRC_URI[wxsqlite3.sha256sum] = "eaee8290c1f386413f5cb1e1af9ec4e7573c1dcce2760d79f4276497a75c4f64"

inherit autotools

EXTRA_OECONF = "--with-sqlite3-prefix=${STAGING_LIBDIR}"

do_install() {
	oe_runmake 'DESTDIR=${D}' install
	newincludedir=${D}/${includedir}/wx-$(wx-config --release)
	mkdir "$newincludedir"
	mv ${D}/${includedir}/wx "$newincludedir"
}
