DESCRIPTION = "A mileage calculator for GPE"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"

DEPENDS = "glib-2.0 gtk+ libglade sqlite"

SRC_URI = "http://handhelds.org/~rw/gpe/${PN}/${P}.tar.gz"

inherit autotools
