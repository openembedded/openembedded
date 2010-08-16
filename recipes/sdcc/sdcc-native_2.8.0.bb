require sdcc_${PV}.bb
DEPENDS = "bison-native flex-native"
PR = "r2"

# don't need native-tools patch here
SRC_URI = "${SOURCEFORGE_MIRROR}/sdcc/sdcc-src-${PV}.tar.bz2 \
          "

inherit native

