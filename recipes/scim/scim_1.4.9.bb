DESCRIPTION = "Smart Common Input Method (SCIM) platform"
HOMEPAGE = "http://www.scim-im.org"
SECTION = "libs/inputmethod"
LICENSE = "LGPL"
DEPENDS = "gtk+"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz \
           file://gcc-4.4-const-char.dpatch;patch=1 \
           file://configure.patch;patch=1 \
           file://20_scim_config.dpatch;patch=1 \
           file://40_scim_user_home_overrides.dpatch;patch=1 \
           file://50_validate-desktop-entry.dpatch;patch=1 \
           file://51_scim-1.4.7-fix-capslock.dpatch;patch=1 \
           file://52_scim-1.4.7-imdkit-read-property-properly.dpatch;patch=1 \
           file://53_scim-1.4.7-trayicon.dpatch;patch=1 \
           file://54_scim-1.4.7-xim-wrong-format.dpatch;patch=1 \
           file://scim-1.4.7-syslibltdl.patch;patch=1 \
           "

inherit autotools pkgconfig

EXTRA_OECONF = " --without-doxygen "
LEAD_SONAME = "libscim-1.0.so"

PDIR = "${PN}-1.0"

do_configure_append () {
	# Fix unset @ALL_LINGUAS@
	#   Replace with a list of available translations in ${S}/po

	cd ${S}/po
	SEDR=`ls *.gmo -1 --color=none | sed 's/.gmo//' | tr '\n' ' '`
	SEDL='@ALL_LINGUAS@'
	sed -i "s/${SEDL}.*/${SEDR}/" Makefile.in.in
	sed -i "s/${SEDL}.*/${SEDR}/" Makefile.in
	sed -i "s/${SEDL}.*/${SEDR}/" Makefile

	# Fix unset @INTLTOOL_LIBDIR@
	#   Only needed for a check to see if charmap.alias is present,
	#   not really needed, so we fail that test by having it look
	#   in ${S}

	cd ${S}
	sed -i 's/@INTLTOOL_LIBDIR@/./' intltool-merge.in
	sed -i 's/@INTLTOOL_LIBDIR@/./' intltool-merge

	# Fix unset @GTK_LIBDIR@
	#   This is the same as ${libdir} so we use that

	cd ${S}/extras/gtk2_immodule
	sed -i 's/@GTK_LIBDIR@/$(libdir)/g' Makefile.in
	sed -i 's/@GTK_LIBDIR@/$(libdir)/g' Makefile.am
}

pkg_postinst_${PN} () {
	# Update gtk2 immodules
	#   Adds SCIM to the list
	/usr/bin/gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules
}

pkg_postrm_${PN} () {
	# Update gtk2 immodules
	#   Removes SCIM from the list
	/usr/bin/gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules
}

FILES_${PN}-dbg +=   "${libdir}/${PDIR}/.debug \
                      ${libdir}/${PDIR}/1.4.0/*/.debug \
		      ${libdir}/gtk-2.0/immodules/.debug"
FILES_${PN} +=       "${libdir}/${PDIR}/scim-panel-gtk \
                      ${libdir}/${PDIR}/scim-helper* \
                      ${libdir}/${PDIR}/scim-launcher \
		      ${libdir}/${PDIR}/1.4.0 \
                      ${libdir}/gtk-2.0/immodules"
