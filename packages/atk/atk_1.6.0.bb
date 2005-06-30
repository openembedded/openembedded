DEPENDS = "glib-2.0"
DESCRIPTION = "An accessibility toolkit for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
LICENSE = "LGPL"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.4/atk-${PV}.tar.bz2 \
	   file://gtk-doc.patch;patch=1"

inherit autotools  pkgconfig

EXTRA_OECONF = "--disable-glibtest"

CFLAGS_append = " -I${STAGING_INCDIR}/glib-2.0 \
		  -I${STAGING_INCDIR}/glib-2.0/glib \
		  -I${STAGING_INCDIR}/glib-2.0/gobject"

do_stage () {
	oe_libinstall -so -C atk libatk-1.0 ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/atk
	install -m 0644 atk/atkaction.h ${STAGING_INCDIR}/atk/atkaction.h
	install -m 0644 atk/atkcomponent.h ${STAGING_INCDIR}/atk/atkcomponent.h
	install -m 0644 atk/atkdocument.h ${STAGING_INCDIR}/atk/atkdocument.h
	install -m 0644 atk/atkeditabletext.h ${STAGING_INCDIR}/atk/atkeditabletext.h
	install -m 0644 atk/atk-enum-types.h ${STAGING_INCDIR}/atk/atk-enum-types.h
	install -m 0644 atk/atkgobjectaccessible.h ${STAGING_INCDIR}/atk/atkgobjectaccessible.h
	install -m 0644 atk/atk.h ${STAGING_INCDIR}/atk/atk.h
	install -m 0644 atk/atkhyperlink.h ${STAGING_INCDIR}/atk/atkhyperlink.h
	install -m 0644 atk/atkhypertext.h ${STAGING_INCDIR}/atk/atkhypertext.h
	install -m 0644 atk/atkimage.h ${STAGING_INCDIR}/atk/atkimage.h
	install -m 0644 atk/atknoopobjectfactory.h ${STAGING_INCDIR}/atk/atknoopobjectfactory.h
	install -m 0644 atk/atknoopobject.h ${STAGING_INCDIR}/atk/atknoopobject.h
	install -m 0644 atk/atkobjectfactory.h ${STAGING_INCDIR}/atk/atkobjectfactory.h
	install -m 0644 atk/atkobject.h ${STAGING_INCDIR}/atk/atkobject.h
	install -m 0644 atk/atkregistry.h ${STAGING_INCDIR}/atk/atkregistry.h
	install -m 0644 atk/atkrelation.h ${STAGING_INCDIR}/atk/atkrelation.h
	install -m 0644 atk/atkrelationset.h ${STAGING_INCDIR}/atk/atkrelationset.h
	install -m 0644 atk/atkrelationtype.h ${STAGING_INCDIR}/atk/atkrelationtype.h
	install -m 0644 atk/atkselection.h ${STAGING_INCDIR}/atk/atkselection.h
	install -m 0644 atk/atkstate.h ${STAGING_INCDIR}/atk/atkstate.h
	install -m 0644 atk/atkstateset.h ${STAGING_INCDIR}/atk/atkstateset.h
	install -m 0644 atk/atkstreamablecontent.h ${STAGING_INCDIR}/atk/atkstreamablecontent.h
	install -m 0644 atk/atktable.h ${STAGING_INCDIR}/atk/atktable.h
	install -m 0644 atk/atktext.h ${STAGING_INCDIR}/atk/atktext.h
	install -m 0644 atk/atkutil.h ${STAGING_INCDIR}/atk/atkutil.h
	install -m 0644 atk/atkvalue.h ${STAGING_INCDIR}/atk/atkvalue.h
}
