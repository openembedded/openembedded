DEFAULT_PREFERENCE = "-1"

require qt4-embedded.inc

PR = "${INC_PR}.1"

QT_CONFIG_FLAGS_append_armv6 = " -no-neon "

require qt-${PV}.inc

# SRC_URI from qt4-embedded.inc was replaced in .inc above and qte.sh lost
# Set necessary variables in the profile
SRC_URI += "file://qte.sh"

QT_CONFIG_FLAGS += " \
 -exceptions \
"

