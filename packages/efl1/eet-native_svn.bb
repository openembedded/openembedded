require eet_svn.bb
inherit native
DEPENDS = "zlib-native jpeg-native eina-native"
# we no longer inherit pkgconfig, so we need to state this explicitly
# (see explanation in efl.bbclass and autotools.bbclass)
DEPENDS += "pkgconfig-native"
