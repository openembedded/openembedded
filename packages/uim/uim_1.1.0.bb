DESCRIPTION = "A multilingual user input method library"
HOMEPAGE = "http://uim.freedesktop.org/"
LICENSE = "GPL"
DEPENDS = "uim-native"
SECTION = "libs/inputmethod"
PR = "r0"

SRC_URI = "http://uim.freedesktop.org/releases/uim-${PV}.tar.gz \
	   file://uim-module-manager.patch;patch=1"

S = "${WORKDIR}/uim-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

#pkg_postinst_${PN} () {
#	ldconfig
#	gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules
#}

PACKAGES = "uim-xim uim-utils uim-skk uim-qt uim-prime uim-m17nlib uim-gtk2.0 uim-fep uim-el uim-common \
            uim-canna uim-applet-gnome uim-anthy libuim0 libuim-dbg libuim-dev"

DESCRIPTION_uim = "A Japanese input method (backend, dictionary and utility)"
DESCRIPTION_libuim0 = "uim runtime library"
DESCRIPTION_libuim-dev = "uim static library, headers and documents for developers"

LEAD_SONAME = "libuim.so.1"
RDEPENDS_uim = "libuim0"

FILES_libuim-dev = "${libdir}/libuim*.a \
                    ${libdir}/libuim*.la \
                    ${libdir}/libuim*.so \
                    ${includedir}/uim \
                    ${libdir}/pkgconfig/uim.pc"

FILES_libuim0-dbg = "${libdir}/debug"


FILES_libuim0 = "${libdir}/uim/plugin/libuim-custom-enabler.* \
                 ${libdir}/libuim-custom.so.* \
#                 ${datadir}/locale/ja/LC_MESSAGES/uim.mo \
#                 ${datadir}/locale/fr/LC_MESSAGES/uim.mo \
#                 ${datadir}/locale/ko/LC_MESSAGES/uim.mo \
                 ${libdir}/libuim.so.*"


FILES_uim-anthy = "${libdir}/uim/plugin/libuim-anthy.* \
                   ${datadir}/uim/anthy*.scm"

FILES_uim-applet-gnome = "${libdir}/bonobo \
                          ${libdir}/uim/uim-toolbar-applet \
                          ${datadir}/applications/uim.desktop"

FILES_uim-canna = "${libdir}/uim/plugin/libuim-canna.* \
                   ${datadir}/uim/canna*.scm"

FILES_uim-el = "${datadir}/emacs \
                ${bindir}/uim-el-*"

FILES_uim-fep = "${bindir}/uim-fep*"

FILES_uim-gtk2.0 = "${libdir}/gtk-2.0 \
                    ${bindir}/uim-toolbar-gtk* \
                    ${bindir}/uim-*-gtk \
                    ${bindir}/uim-input-pad-ja \
                    ${datadir}/uim/helperdata/uim-dict-ui.xml"

FILES_uim-m17nlib = "${libdir}/uim/plugin/libuim-m17nlib.* \
                     ${datadir}/uim/m17nlib.scm"

FILES_uim-prime = "${libdir}/uim/plugin/libuim-prime.* \
                   ${datadir}/uim/prime*.scm"


FILES_uim-qt = "${bindir}/uim-*-qt \
                ${libdir}/uim/uim-candwin-qt \
                ${libdir}/qt3/plugins/inputmethods \
                ${datadir}/locale/ja/LC_MESSAGES/uim-chardict-qt.mo"

FILES_uim-skk = "${libdir}/uim/plugin/libuim-skk.* \
                 ${datadir}/uim/skk*.scm"


FILES_uim-utils = "${bindir}/uim-sh \
                   ${bindir}/uim-module-manager \
		   ${libexecdir}/uim-helper-server"

FILES_uim-xim = "${bindir}/uim-xim \
                 ${libexecdir}/uim-candwin-gtk \
                 ${datadir}/man/man1/uim-xim.1 \
                 ${sysconfdir}/X11/xinit/xinput.d/uim*"

FILES_uim-common = "${datadir}/uim/pixmaps/*.png \
                    ${datadir}/uim"
