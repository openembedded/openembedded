LICENSE = "LGPL"
DESCRIPTION = "GTK+ is a multi-platform toolkit for creating graphical user interfaces. Offering a complete \
set of widgets, GTK+ is suitable for projects ranging from small one-off projects to complete application suites."
HOMEPAGE = "http://www.gtk.org"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "pango atk jpeg libpng libxext"

SRC_URI = "http://ftp.gnome.org/pub/gnome/sources/gtk+/2.2/gtk+-${PV}.tar.bz2 \
           http://handhelds.org/packages/gtk-2.0/gtk+-2.2.4.diff.bz2;patch=1;pnum=1 \
           file://automake-lossage.patch;patch=1;pnum=0 \
           file://configure-lossage.patch;patch=1;pnum=0 \
           file://no-demos.patch;patch=1 \
           file://libtool-lossage.patch;patch=1;pnum=0 \
           file://no-xwc.patch;patch=1;pnum=0 \
           file://glib-2.0.m4 \
           file://glib-gettext.m4"

inherit autotools  pkgconfig

do_configure_prepend() {
	install -d m4
	install ${WORKDIR}/glib-2.0.m4 m4/
	install ${WORKDIR}/glib-gettext.m4 m4/
}

EXTRA_OECONF = "--without-libtiff --enable-debug=no --disable-cruft"

LIBV = "2.2.0"

gtk_include = "gtk.h gtkaccelgroup.h gtkaccellabel.h gtkaccelmap.h gtkaccessible.h gtkadjustment.h gtkalignment.h gtkarrow.h gtkaspectframe.h gtkbbox.h gtkbin.h gtkbindings.h gtkbox.h gtkbutton.h gtkcalendar.h gtkcelleditable.h gtkcellrenderer.h gtkcellrendererpixbuf.h gtkcellrenderertext.h gtkcellrenderertoggle.h gtkcheckbutton.h gtkcheckmenuitem.h gtkclipboard.h gtkclist.h gtkcolorsel.h gtkcolorseldialog.h gtkcombo.h gtkcontainer.h gtkctree.h gtkcurve.h gtkdebug.h gtkdialog.h gtkdnd.h gtkdrawingarea.h gtkeditable.h gtkentry.h gtkenums.h gtkeventbox.h gtkfilesel.h gtkfixed.h gtkfontsel.h gtkframe.h gtkgamma.h gtkgc.h gtkhandlebox.h gtkhbbox.h gtkhbox.h gtkhpaned.h gtkhruler.h gtkhscale.h gtkhscrollbar.h gtkhseparator.h gtkiconfactory.h gtkimage.h gtkimagemenuitem.h gtkimcontext.h gtkimcontextsimple.h gtkimmodule.h gtkimmulticontext.h gtkinputdialog.h gtkinvisible.h gtkitem.h gtkitemfactory.h gtklabel.h gtklayout.h gtklist.h gtklistitem.h gtkliststore.h gtkmain.h gtkmarshal.h gtkmenu.h gtkmenubar.h gtkmenuitem.h gtkmenushell.h gtkmessagedialog.h gtkmisc.h gtknotebook.h gtkobject.h gtkoldeditable.h gtkoptionmenu.h gtkpaned.h gtkpixmap.h gtkplug.h gtkpreview.h gtkprivate.h gtkprogress.h gtkprogressbar.h gtkradiobutton.h gtkradiomenuitem.h gtkrange.h gtkrc.h gtkruler.h gtkscale.h gtkscrollbar.h gtkscrolledwindow.h gtkselection.h gtkseparator.h gtkseparatormenuitem.h gtksettings.h gtksignal.h gtksizegroup.h gtksocket.h gtkspinbutton.h gtkstatusbar.h gtkstock.h gtkstyle.h gtktable.h gtktearoffmenuitem.h gtktext.h gtktextbuffer.h gtktextchild.h gtktextdisplay.h gtktextiter.h gtktextlayout.h gtktextmark.h gtktexttag.h gtktexttagtable.h gtktextview.h gtktipsquery.h gtktogglebutton.h gtktoolbar.h gtktooltips.h gtktree.h gtktreednd.h gtktreeitem.h gtktreemodel.h gtktreemodelsort.h gtktreeselection.h gtktreesortable.h gtktreestore.h gtktreeview.h gtktreeviewcolumn.h gtktypebuiltins.h gtktypeutils.h gtkvbbox.h gtkvbox.h gtkversion.h gtkviewport.h gtkvpaned.h gtkvruler.h gtkvscale.h gtkvscrollbar.h gtkvseparator.h gtkwidget.h gtkwindow.h"
gdk_include = "gdk.h gdkcolor.h gdkcursor.h gdkdisplay.h gdkdisplaymanager.h gdkdnd.h gdkdrawable.h gdkenumtypes.h gdkevents.h gdkfont.h gdkgc.h gdki18n.h gdkimage.h gdkinput.h gdkkeys.h gdkkeysyms.h gdkpango.h gdkpixbuf.h gdkpixmap.h gdkprivate.h gdkproperty.h gdkregion.h gdkrgb.h gdkscreen.h gdkselection.h gdktypes.h gdkvisual.h gdkwindow.h x11/gdkx.h"
gdk_pixbuf_include = "gdk-pixbuf-animation.h gdk-pixbuf-enum-types.h gdk-pixbuf-features.h gdk-pixbuf-io.h gdk-pixbuf-loader.h gdk-pixbuf-marshal.h gdk-pixbuf.h gdk-pixdata.h"

do_stage () {
	oe_libinstall -so -C gtk libgtk-x11-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gdk libgdk-x11-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C contrib/gdk-pixbuf-xlib libgdk_pixbuf_xlib-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gdk-pixbuf libgdk_pixbuf-2.0 ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/gtk-2.0/gtk
	for i in ${gtk_include}; do
		install -m 0644 gtk/$i ${STAGING_INCDIR}/gtk-2.0/gtk/$i
	done

	mkdir -p ${STAGING_INCDIR}/gtk-2.0/gdk
	for i in ${gdk_include}; do
		install -m 0644 gdk/$i ${STAGING_INCDIR}/gtk-2.0/gdk/`basename $i`
	done

	mkdir -p ${STAGING_INCDIR}/gtk-2.0/gdk-pixbuf
	for i in ${gdk_pixbuf_include}; do
		install -m 0644 gdk-pixbuf/$i ${STAGING_INCDIR}/gtk-2.0/gdk-pixbuf/$i
	done

	mkdir -p ${STAGING_LIBDIR}/gtk-2.0/include
	install -m 0644 gdk/gdkconfig.h ${STAGING_LIBDIR}/gtk-2.0/include/gdkconfig.h

	install -m 0644 m4macros/gtk-2.0.m4 ${STAGING_DATADIR}/aclocal/
}

do_install_append () {
	install -d ${D}${sysconfdir}/gtk-2.0
}

PACKAGES_DYNAMIC = "gdk-pixbuf-loader-* gtk-immodule-*"

python populate_packages_prepend () {
	import os.path

	gtk_libdir = bb.data.expand('${libdir}/gtk-2.0/${LIBV}', d)
	loaders_root = os.path.join(gtk_libdir, 'loaders')
	immodules_root = os.path.join(gtk_libdir, 'immodules')

	do_split_packages(d, loaders_root, '^libpixbufloader-(.*)\.so$', 'gdk-pixbuf-loader-%s', 'GDK pixbuf loader for %s', 'gdk-pixbuf-query-loaders > /etc/gtk-2.0/gdk-pixbuf.loaders')
	do_split_packages(d, immodules_root, '^im-(.*)\.so$', 'gtk-immodule-%s', 'GTK input module for %s', 'gtk-query-immodules > /etc/gtk-2.0/gtk.immodules')
}
