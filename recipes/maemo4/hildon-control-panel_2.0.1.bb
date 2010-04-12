LICENSE    = "GPL"

DEPENDS = "libosso libhildon gnome-vfs libhildonhelp"

SRC_URI = "http://repository.maemo.org/pool/os2008/free/source/h/hildon-control-panel/hildon-control-panel_2.0.1-1.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/dbus-1.0 ${datadir}/applications"

do_stage() {
	autotools_stage_all
}

# pkg-config file will get broken after pkgconfig.bbclass work
# 
# This code will fix it
#
#	sed -i -e 's:${STAGING_LIBDIR}/hildon:${libdir}/hildon:g' -e 's:${STAGING_DATADIR}/applications/hildon:${datadir}/applications/hildon:g' ${PKG_CONFIG_DIR}/hildon-control-panel.pc
#

SRC_URI[md5sum] = "b2247355c2fa3763904d698ec03ee78f"
SRC_URI[sha256sum] = "bc532113a4e4f4646fb523393e1c3da4dbd5cb2955f223bcbfc794216a7ab8b0"
