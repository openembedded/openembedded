SECTION = "gpe"
DESCRIPTION = "GPE application launcher"
DEPENDS = "libgpewidget libgpelaunch cairo"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
LICENSE = "GPL"
PR = "r0"

inherit gpe

SRC_URI += " file://no-render-h.patch;patch=1"
