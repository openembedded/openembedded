SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = ""
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/glib-2.0-${PV}"

SRC_URI = "http://ftp.gnome.org/pub/gnome/sources/glib/2.2/glib-${PV}.tar.bz2 \
           file://automake-lossage.patch;patch=1 \
           file://glibconfig-sysdefs.h"
S = "${WORKDIR}/glib-${PV}"

inherit autotools  native

acpaths = ""
do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glibconfig-sysdefs.h .
}

do_stage () {
	install -m 0755 gobject/glib-mkenums ${STAGING_BINDIR}/
	install -m 0755 gobject/glib-genmarshal ${STAGING_BINDIR}/
	oe_libinstall -so -C glib libglib-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gmodule libgmodule-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gthread libgthread-2.0 ${STAGING_LIBDIR}
	oe_libinstall -so -C gobject libgobject-2.0 ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/glib-2.0/glib
	install -m 0755 ${S}/glibconfig.h ${STAGING_INCDIR}/glib-2.0/glibconfig.h
	install -m 0644 ${S}/glib/glib-object.h ${STAGING_INCDIR}/glib-2.0/glib-object.h
	install -m 0644 ${S}/glib/glib.h ${STAGING_INCDIR}/glib-2.0/glib.h
	install -m 0644 ${S}/gmodule/gmodule.h ${STAGING_INCDIR}/glib-2.0/gmodule.h
	install -m 0644 ${S}/glib/galloca.h ${STAGING_INCDIR}/glib-2.0/glib/galloca.h
	install -m 0644 ${S}/glib/garray.h ${STAGING_INCDIR}/glib-2.0/glib/garray.h
	install -m 0644 ${S}/glib/gasyncqueue.h ${STAGING_INCDIR}/glib-2.0/glib/gasyncqueue.h
	install -m 0644 ${S}/glib/gbacktrace.h ${STAGING_INCDIR}/glib-2.0/glib/gbacktrace.h
	install -m 0644 ${S}/glib/gcache.h ${STAGING_INCDIR}/glib-2.0/glib/gcache.h
	install -m 0644 ${S}/glib/gcompletion.h ${STAGING_INCDIR}/glib-2.0/glib/gcompletion.h
	install -m 0644 ${S}/glib/gconvert.h ${STAGING_INCDIR}/glib-2.0/glib/gconvert.h
	install -m 0644 ${S}/glib/gdataset.h ${STAGING_INCDIR}/glib-2.0/glib/gdataset.h
	install -m 0644 ${S}/glib/gdate.h ${STAGING_INCDIR}/glib-2.0/glib/gdate.h
	install -m 0644 ${S}/glib/gdir.h ${STAGING_INCDIR}/glib-2.0/glib/gdir.h
	install -m 0644 ${S}/glib/gerror.h ${STAGING_INCDIR}/glib-2.0/glib/gerror.h
	install -m 0644 ${S}/glib/gfileutils.h ${STAGING_INCDIR}/glib-2.0/glib/gfileutils.h
	install -m 0644 ${S}/glib/ghash.h ${STAGING_INCDIR}/glib-2.0/glib/ghash.h
	install -m 0644 ${S}/glib/ghook.h ${STAGING_INCDIR}/glib-2.0/glib/ghook.h
	install -m 0644 ${S}/glib/giochannel.h ${STAGING_INCDIR}/glib-2.0/glib/giochannel.h
	install -m 0644 ${S}/glib/glist.h ${STAGING_INCDIR}/glib-2.0/glib/glist.h
	install -m 0644 ${S}/glib/gmacros.h ${STAGING_INCDIR}/glib-2.0/glib/gmacros.h
	install -m 0644 ${S}/glib/gmain.h ${STAGING_INCDIR}/glib-2.0/glib/gmain.h
	install -m 0644 ${S}/glib/gmarkup.h ${STAGING_INCDIR}/glib-2.0/glib/gmarkup.h
	install -m 0644 ${S}/glib/gmem.h ${STAGING_INCDIR}/glib-2.0/glib/gmem.h
	install -m 0644 ${S}/glib/gmessages.h ${STAGING_INCDIR}/glib-2.0/glib/gmessages.h
	install -m 0644 ${S}/glib/gnode.h ${STAGING_INCDIR}/glib-2.0/glib/gnode.h
	install -m 0644 ${S}/glib/gpattern.h ${STAGING_INCDIR}/glib-2.0/glib/gpattern.h
	install -m 0644 ${S}/glib/gprimes.h ${STAGING_INCDIR}/glib-2.0/glib/gprimes.h
	install -m 0644 ${S}/glib/gqsort.h ${STAGING_INCDIR}/glib-2.0/glib/gqsort.h
	install -m 0644 ${S}/glib/gquark.h ${STAGING_INCDIR}/glib-2.0/glib/gquark.h
	install -m 0644 ${S}/glib/gqueue.h ${STAGING_INCDIR}/glib-2.0/glib/gqueue.h
	install -m 0644 ${S}/glib/grand.h ${STAGING_INCDIR}/glib-2.0/glib/grand.h
	install -m 0644 ${S}/glib/grel.h ${STAGING_INCDIR}/glib-2.0/glib/grel.h
	install -m 0644 ${S}/glib/gscanner.h ${STAGING_INCDIR}/glib-2.0/glib/gscanner.h
	install -m 0644 ${S}/glib/gshell.h ${STAGING_INCDIR}/glib-2.0/glib/gshell.h
	install -m 0644 ${S}/glib/gslist.h ${STAGING_INCDIR}/glib-2.0/glib/gslist.h
	install -m 0644 ${S}/glib/gspawn.h ${STAGING_INCDIR}/glib-2.0/glib/gspawn.h
	install -m 0644 ${S}/glib/gstrfuncs.h ${STAGING_INCDIR}/glib-2.0/glib/gstrfuncs.h
	install -m 0644 ${S}/glib/gstring.h ${STAGING_INCDIR}/glib-2.0/glib/gstring.h
	install -m 0644 ${S}/glib/gthread.h ${STAGING_INCDIR}/glib-2.0/glib/gthread.h
	install -m 0644 ${S}/glib/gthreadpool.h ${STAGING_INCDIR}/glib-2.0/glib/gthreadpool.h
	install -m 0644 ${S}/glib/gtimer.h ${STAGING_INCDIR}/glib-2.0/glib/gtimer.h
	install -m 0644 ${S}/glib/gtree.h ${STAGING_INCDIR}/glib-2.0/glib/gtree.h
	install -m 0644 ${S}/glib/gtypes.h ${STAGING_INCDIR}/glib-2.0/glib/gtypes.h
	install -m 0644 ${S}/glib/gunicode.h ${STAGING_INCDIR}/glib-2.0/glib/gunicode.h
	install -m 0644 ${S}/glib/gutils.h ${STAGING_INCDIR}/glib-2.0/glib/gutils.h
	install -m 0644 ${S}/glib/gwin32.h ${STAGING_INCDIR}/glib-2.0/glib/gwin32.h
	install -m 0644 ${S}/glib/gprintf.h ${STAGING_INCDIR}/glib-2.0/glib/gprintf.h
	install -d ${STAGING_INCDIR}/glib-2.0/gobject
	install -m 0644 ${S}/gobject/gboxed.h ${STAGING_INCDIR}/glib-2.0/gobject/gboxed.h
	install -m 0644 ${S}/gobject/gclosure.h ${STAGING_INCDIR}/glib-2.0/gobject/gclosure.h
	install -m 0644 ${S}/gobject/genums.h ${STAGING_INCDIR}/glib-2.0/gobject/genums.h
	install -m 0644 ${S}/gobject/gobject.h ${STAGING_INCDIR}/glib-2.0/gobject/gobject.h
	install -m 0644 ${S}/gobject/gparam.h ${STAGING_INCDIR}/glib-2.0/gobject/gparam.h
	install -m 0644 ${S}/gobject/gparamspecs.h ${STAGING_INCDIR}/glib-2.0/gobject/gparamspecs.h
	install -m 0644 ${S}/gobject/gsignal.h ${STAGING_INCDIR}/glib-2.0/gobject/gsignal.h
	install -m 0644 ${S}/gobject/gsourceclosure.h ${STAGING_INCDIR}/glib-2.0/gobject/gsourceclosure.h
	install -m 0644 ${S}/gobject/gtype.h ${STAGING_INCDIR}/glib-2.0/gobject/gtype.h
	install -m 0644 ${S}/gobject/gtypemodule.h ${STAGING_INCDIR}/glib-2.0/gobject/gtypemodule.h
	install -m 0644 ${S}/gobject/gtypeplugin.h ${STAGING_INCDIR}/glib-2.0/gobject/gtypeplugin.h
	install -m 0644 ${S}/gobject/gvalue.h ${STAGING_INCDIR}/glib-2.0/gobject/gvalue.h
	install -m 0644 ${S}/gobject/gvaluearray.h ${STAGING_INCDIR}/glib-2.0/gobject/gvaluearray.h
	install -m 0644 ${S}/gobject/gvaluecollector.h ${STAGING_INCDIR}/glib-2.0/gobject/gvaluecollector.h
	install -m 0644 ${S}/gobject/gvaluetypes.h ${STAGING_INCDIR}/glib-2.0/gobject/gvaluetypes.h
	install -m 0644 ${S}/gobject/gobjectnotifyqueue.c ${STAGING_INCDIR}/glib-2.0/gobject/gobjectnotifyqueue.c
	install -m 0644 ${S}/gobject/gmarshal.h ${STAGING_INCDIR}/glib-2.0/gobject/gmarshal.h
	install -m 0644 ${S}/m4macros/glib-2.0.m4 ${STAGING_DATADIR}/aclocal/
	install -m 0644 ${S}/m4macros/glib-gettext.m4 ${STAGING_DATADIR}/aclocal/
}

do_install () {
	:
}
