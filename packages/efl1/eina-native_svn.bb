require eina_svn.bb
inherit native
DEPENDS = ""
# we no longer inherit pkgconfig, so we need to state this explicitly
# (see explanation in efl.bbclass and autotools.bbclass)
DEPENDS += "pkgconfig-native"
