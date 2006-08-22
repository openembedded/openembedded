DESCRIPTION = "GPE screenshot application"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"
PR = "r1"

DEPENDS = "glib-2.0 gtk+ libglade"

inherit gpe autotools

SRC_URI += "file://fix-segfault.patch;patch=1;pnum=0 "
