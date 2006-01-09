SECTION = "x11/utils"
PV = "0.0+cvs${SRCDATE}"
DEPENDS = "gtk+ libgpewidget x11 libxrandr libxft xtst xext xau \
	   virtual/libintl"
DESCRIPTION = "Multistroke / full word handwriting recognition for X"
LICENSE = "GPL"

SRC_URI = "${HANDHELDS_CVS};module=rosetta \
	file://rosetta-makefile.patch;patch=1"
S = "${WORKDIR}/rosetta"
PR = "r4"

inherit pkgconfig gettext

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps ${datadir}/applications ${datadir}/rosetta"

do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
}

pkg_postinst () {
if test "x$D" != "x"; then
	exit 1
else
  ${prefix}/bin/rosetta -P
fi
}
