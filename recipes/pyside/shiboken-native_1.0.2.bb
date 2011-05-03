require shiboken.inc

DEPENDS = "apiextractor-native generatorrunner-native python-native"
PR = "${INC_PR}.0"

SRC_URI[md5sum] = "585aa365811575ec3b48d59ca007f6ae"
SRC_URI[sha256sum] = "eb3eea79945a62ed2a7282b8b99d3b8011f021465bdea6a3aad9399fa52bd5fe"

inherit cmake native
