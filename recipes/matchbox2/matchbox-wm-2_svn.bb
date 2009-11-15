DEPENDS = "gtk+ startup-notification dbus dbus-glib"
PV = "0.1.0+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=matchbox-window-manager-2;proto=http \
	   file://fix-timeout-handler-free.patch;patch=1 \
	   file://makefile-vars.patch;patch=1;pnum=0 \
"
S = "${WORKDIR}/matchbox-window-manager-2"

inherit autotools pkgconfig

# FIXME: --enable-glib-main-loop causes hard grab-freeze
EXTRA_OECONF = "--with-gtk --with-pango --enable-matchbox-remote --enable-png-theme --enable-maemo-manager"

do_install_append() {
	mv ${D}${bindir}/matchbox-remote ${D}${bindir}/matchbox-remote-2
	# Without libmatchbox there are no includes and no libraries, just empty directories:
	rm -r ${D}${includedir} ${D}${libdir}
}

FILES_${PN} += "${datadir}/themes/*"
