require uim.inc
DEPENDS = "gtk+ uim-native anthy fontconfig libxft xt glib-2.0 ncurses"
SECTION_uim-gtk2.0 = "x11/inputmethods"
PR = "r2"

SRC_URI += "file://uim-module-manager.patch;patch=1"

inherit autotools pkgconfig

PACKAGES += "uim-xim uim-utils uim-skk uim-gtk2.0 uim-fep uim-common uim-anthy libuim0 libuim-dev"

LEAD_SONAME = "libuim.so.1"
RDEPENDS_uim = "libuim0"
RDEPENDS_uim-anthy = "virtual/japanese-font"

DESCRIPTION_libuim0 = "Simple and flexible input method collection and library"
SECTION_libuim0 = "libs/inputmethods"
FILES_libuim0 = "${libdir}/uim/plugin/libuim-custom-enabler.* \
                 ${libdir}/libuim-custom.so.* \
                 ${datadir}/locale/ja/LC_MESSAGES/uim.mo \
                 ${datadir}/locale/fr/LC_MESSAGES/uim.mo \
                 ${datadir}/locale/ko/LC_MESSAGES/uim.mo \
                 ${libdir}/libuim.so.*"

DESCRIPTION_libuim-dev = "Development files for uim"
SECTION_libuim-dev = "devel/libs"
FILES_libuim-dev = "${libdir}/libuim*.a \
                    ${libdir}/libuim*.la \
                    ${libdir}/libuim*.so \
                    ${includedir}/uim \
                    ${libdir}/pkgconfig/uim.pc"

DESCRIPTION_uim-anthy = "Anthy plugin for uim"
FILES_uim-anthy = "${libdir}/uim/plugin/libuim-anthy.* \
                   ${datadir}/uim/anthy*.scm"

pkg_postinst_uim-anthy() {
#! /bin/sh
set -e
if [ -f /usr/bin/uim-module-manager ]; then
	/usr/bin/uim-module-manager --register anthy --path /etc/uim
fi
}

pkg_postrm_uim-anthy() {
#! /bin/sh
set -e
if [ -f /usr/bin/uim-module-manager ]; then
	/usr/bin/uim-module-manager --path /etc/uim --unregister anthy
fi
}

pkg_prerm_uim-anthy() {
#! /bin/sh
set -e
if [ -f /usr/bin/uim-module-manager ]; then
	/usr/bin/uim-module-manager --register anthy --path /etc/uim
fi
}

DESCRIPTION_uim-fep = "uim Front End Processor"
FILES_uim-fep = "${bindir}/uim-fep*"

DESCRIPTION_uim-gtk2.0  = "GTK+2.x immodule for uim"
FILES_uim-gtk2.0 = "${libdir}/gtk-2.0 \
                    ${bindir}/uim-toolbar-gtk* \
                    ${bindir}/uim-*-gtk \
                    ${bindir}/uim-input-pad-ja \
                    ${datadir}/uim/helperdata/uim-dict-ui.xml"

pkg_postinst_uim-gtk2.0() {
#! /bin/sh
set -e
gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules
}

#pkg_postrm_uim-gtk2.0() {
##! /bin/sh
#set -e
#/usr/sbin/update-gtk-immodules
#}

DESCRIPTION_uim-skk = "SKK plugin for uim"
FILES_uim-skk = "${libdir}/uim/plugin/libuim-skk.* \
                 ${datadir}/uim/skk*.scm"

pkg_postinst_uim-skk() {
#! /bin/sh
set -e
if [ -f /usr/bin/uim-module-manager ]; then
	/usr/bin/uim-module-manager --register skk --path /etc/uim
fi
}

pkg_postrm_uim-skk() {
#! /bin/sh
set -e
if [ -f /usr/bin/uim-module-manager ]; then
	/usr/bin/uim-module-manager --path /etc/uim --unregister skk
fi
}

DESCRIPTION_uim-utils = "Utilities for uim"
FILES_uim-utils = "${bindir}/uim-sh \
                   ${bindir}/uim-module-manager \
		   ${libexecdir}/uim-helper-server"

DESCRIPTION_uim-xim = "A bridge between uim and XIM"
FILES_uim-xim = "${bindir}/uim-xim \
                 ${libexecdir}/uim-candwin-gtk \
                 ${datadir}/man/man1/uim-xim.1 \
                 ${sysconfdir}/X11/xinit/xinput.d/uim*"

# to .xinitrc, or .xsession
#pkg_postinst_uim-xim() {
#GTK_IM_MODULE=uim ; export GTK_IM_MODULE
#QT_IM_MODULE=uim ; export QT_IM_MODULE
#uim-xim &
#XMODIFIERS=@im=uim ; export XMODIFIERS
#}

DESCRIPTION_uim-common = "Common files for uim"
FILES_uim-common = "${datadir}/uim/pixmaps/*.png \
                    ${datadir}/uim"
pkg_postinst_uim-common() {
#! /bin/sh
set -e
if [ -f /usr/bin/uim-module-manager ]; then
	/usr/bin/uim-module-manager --path /etc/uim --register \
		tutcode tcode hangul viqr ipa-x-sampa latin byeoru
fi
}

pkg_prerm_uim-common() {
#! /bin/sh
set -e
if [ -f /usr/bin/uim-module-manager ]; then
	/usr/bin/uim-module-manager --path /etc/uim --register \
		tutcode tcode hangul viqr ipa-x-sampa latin byeoru
fi
}

do_stage() {
	autotools_stage_all
}
