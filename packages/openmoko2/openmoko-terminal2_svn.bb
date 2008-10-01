DESCRIPTION = "The Openmoko Command Line Terminal"
SECTION = "openmoko/applications"
DEPENDS = "vala-native vte libmokoui2"
RDEPENDS = "ttf-liberation-mono"
PV = "3.0.0+svnr${SRCREV}"
PR = "r2"
PKG_TAGS_${PN} = "group::programming alias::Om_Terminal2"

inherit openmoko2
