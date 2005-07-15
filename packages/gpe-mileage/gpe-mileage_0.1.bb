DESCRIPTION = "A mileage calculator for GPE"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"

DEPENDS = "glib-2.0 gtk+ libglade sqlite"

inherit gpe autotools
