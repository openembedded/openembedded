require etk_svn.bb
inherit native
DEPENDS = "evas-native ecore-native edje-native"

SRC_URI += "file://no-tests.patch;patch=1"
