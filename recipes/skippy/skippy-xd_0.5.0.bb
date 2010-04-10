LICENSE = "GPLV2"
DESCRIPTION = "Skippy is a full-screen task-switcher for X11."
SECTION = "x11"
DEPENDS = "virtual/xserver libxdamage libxcomposite"

inherit pkgconfig

SRC_URI = "http://thegraveyard.org/files/${PN}-${PV}.tar.bz2 \
           file://fix-makefile.patch;patch=1 \
           file://event_base.patch;patch=1"

EXTRA_OEMAKE = "X11PREFIX='${STAGING_DIR_TARGET}${layout_prefix}' PKG_CONFIG='${STAGING_BINDIR_NATIVE}/pkg-config'"
CFLAGS_append = " -I${STAGING_INCDIR}/X11"
LDFLAGS_append = " -L${STAGING_LIBDIR}/X11"

do_install() {
	oe_runmake 'BINDIR=${D}${bindir}' install
}

SRC_URI[md5sum] = "0e847845c4cb8c16f79bc4538ae288ad"
SRC_URI[sha256sum] = "52ff7476b3580a92c385167f1855583c2cf74ae1898a6a5e8446ce67c80bc139"
