LICENSE = "GPL"
inherit gpe

DEPENDS = "gtk+ libdisplaymigration libgpewidget"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "gpe"
DESCRIPTION = "Editor for the GPE Palmtop Environment"
FILES_${PN} = "/etc ${bindir} ${datadir}/pixmaps ${datadir}/applications"
