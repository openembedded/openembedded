require imagemagick_${PV}.bb
DEPENDS ="libtool-native"
# FIXME: There is much more checked libraries. All should be added or explicitly disabled to get consistent results.
# tiff-native does not exist
DEPENDS += "bzip2-native jpeg-native libpng-native librsvg-native zlib-native"
inherit native
