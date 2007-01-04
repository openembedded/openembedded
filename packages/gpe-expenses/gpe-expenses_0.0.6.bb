DESCRIPTION = "Equivalent for Expenses on the Palm. Supports payment types, categories, expense types (mileage, meals, parking, etc.), notes, currency selection etc."
LICENSE = "GPL"

DEPENDS = "qof libgpewidget"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
	  "

inherit autotools pkgconfig


