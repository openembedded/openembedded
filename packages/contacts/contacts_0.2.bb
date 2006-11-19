LICENSE = "LGPL"
SECTION = "x11"
DEPENDS = "glib-2.0 gtk+ libglade libbacon eds-dbus"
DESCRIPTION = "Contacts is an address-book application."
PR = "r0"

SRC_URI = "http://projects.o-hand.com/sources/contacts/contacts-0.2.tar.gz \
	   file://stock_contact.png \
	   file://stock_person.png"

inherit autotools pkgconfig


do_install_append () {
	install -d ${D}/${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/stock_contact.png ${D}/${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/stock_person.png ${D}/${datadir}/pixmaps
}

FILES_${PN} += "${datadir}/pixmaps/stock_contact.png \
		${datadir}/pixmaps/stock_person.png"

