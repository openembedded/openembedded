DESCRIPTION = "Volume Control Applet for GPE"
LICENSE = "GPL"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "gpe"

DEPENDS = "libgpewidget"

GPE_SRC_COMPRESSION = "bz2"
inherit gpe autotools
