require libfso-qt.inc

PR = "${INC_PR}.0"

DEPENDS = "qt4-embedded"
EXTRA_OECONF_append = "--enable-qt-embedded"
