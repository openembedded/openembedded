DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native"
PR = "r0"
PV = "0.0+cvs-${CVSDATE}"

DEFAULT_PREFERENCE = 1

SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=libmimedir"
S = "${WORKDIR}/libmimedir"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

headers = "mimedir-attachment.h mimedir-attendee.h mimedir-attribute.h mimedir-datetime.h mimedir-init.h mimedir-marshal.h mimedir-period.h mimedir-profile.h mimedir-recurrence.h mimedir-utils.h mimedir-valarm.h mimedir-vcal.h mimedir-vcard-address.h mimedir-vcard-email.h mimedir-vcard-phone.h mimedir-vcard.h mimedir-vcomponent.h mimedir-vevent.h mimedir-vfreebusy.h mimedir-vjournal.h mimedir-vtimezone.h mimedir-vtodo.h mimedir.h"

do_stage() {
	install -d ${STAGING_INCDIR}/mimedir-1.0/mimedir
	for i in ${headers}; do
		install -m 0644 ${S}/mimedir/$i ${STAGING_INCDIR}/mimedir-1.0/mimedir/$i
	done

	oe_libinstall -so -C mimedir libmimedir-0.2 ${STAGING_LIBDIR}
	ln -sf libmimedir-0.2.so ${STAGING_LIBDIR}/libmimedir.so
}
