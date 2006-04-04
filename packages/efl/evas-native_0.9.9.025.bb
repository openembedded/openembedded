include evas-fb_${PV}.bb
inherit native
DEPENDS = "freetype-native libpng-native jpeg-native eet-native"
PROVIDES = "evas-native"

do_install() {
  autotools_do_install
}