LICENSE = "LGPL"
PR = "r1"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ cairo libxrender"

inherit pkgconfig gpe

headers = "infoprint.h init.h render.h errorbox.h smallbox.h pixmaps.h gpetimesel.h gtkdatecombo.h dirbrowser.h stylus.h picturebutton.h popup_menu.h spacing.h translabel.h question.h windows.h gpe-iconlist.h gtksimplemenu.h gpewindowlist.h tray.h popup.h gpeiconlistview.h gpehelp.h gpeiconlistitem.h gpeclockface.h"

do_stage () {
	oe_libinstall -so libgpewidget ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gpe
	for h in ${headers}; do
		install -m 0644 ${S}/gpe/$h ${STAGING_INCDIR}/gpe/$h
	done
}

do_install_append () {
	oe_runmake PREFIX='${prefix}' DESTDIR='${D}' install-devel
}

