LICENSE = "GPLV2"
DESCRIPTION = "Skippy is a full-screen task-switcher for X11."
SECTION = "x11"
MAINTAINER = "Chris Lord <cwiiis@handhelds.org>"
DEPENDS = "virtual/xserver libxdamage libxcomposite"

inherit pkgconfig

SRC_URI = "http://thegraveyard.org/files/${PN}-${PV}.tar.bz2 \
           file://fix-makefile.patch;patch=1 \
           file://event_base.patch;patch=1"

EXTRA_OEMAKE = "X11PREFIX='${STAGING_DIR}/${TARGET_SYS}' PKG_CONFIG='${STAGING_BINDIR}/pkg-config'"
CFLAGS_append = " -I${STAGING_DIR}/${TARGET_SYS}/include/X11"
LDFLAGS_append = " -L${STAGING_DIR}/${TARGET_SYS}/lib/X11"

do_install() {
	oe_runmake 'BINDIR=${D}${bindir}' install
}
