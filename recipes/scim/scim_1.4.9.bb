DESCRIPTION = "Smart Common Input Method (SCIM) platform"
HOMEPAGE = "http://www.scim-im.org"
SECTION = "libs/inputmethod"
LICENSE = "LGPLv2.1+"
DEPENDS = "gtk+ cairo"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz \
           file://gcc-4.4-const-char.dpatch;apply=yes \
           file://configure.patch \
           file://20_scim_config.dpatch;apply=yes \
           file://40_scim_user_home_overrides.dpatch;apply=yes \
           file://50_validate-desktop-entry.dpatch;apply=yes \
           file://51_scim-1.4.7-fix-capslock.dpatch;apply=yes \
           file://52_scim-1.4.7-imdkit-read-property-properly.dpatch;apply=yes \
           file://53_scim-1.4.7-trayicon.dpatch;apply=yes \
           file://54_scim-1.4.7-xim-wrong-format.dpatch;apply=yes \
           file://scim-1.4.7-syslibltdl.patch \
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
	# the below sed is done to prevent an infinite loop when make enters po/
	# since intltoolize is not a knobbable operation in autotools do_configure
	# good old sed comes to our rescue
	# this is equivalent of a patch to Makefile.in.in which would be
	#-       $(SHELL) ./config.status
	#+       $(SHELL) ./config.status
	#+       touch stamp-it

        sed -i 's/^[ \t]*\$(SHELL).*$/\t\$(SHELL) .\/config.status\n\ttouch stamp-it/g' Makefile.in.in
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

SRC_URI[md5sum] = "975ba34b01304ea8166ac8ea27aa9e88"
SRC_URI[sha256sum] = "f72e9779e220565f6002923bf7d6aa9891be2bbddcd91a4e2a2d5e20aefba8d0"
