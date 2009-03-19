DESCRIPTION = "GTK bindings for mono"
SECTION = "devel/mono"

DEPENDS = "mono mono-native gtk+ atk pango cairo glib-2.0 libglade "
RDEPENDS = "mono"

inherit autotools

# For some reason the URL template changes from version to version, 
# therefore use some variables for the directory and extension
SRC_URI = "http://go-mono.com/sources/gtk-sharp${SDIRVER}/gtk-sharp-${PV}.tar.${SEXT}"
