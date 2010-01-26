require qt4-x11-free.inc
PR = "${INC_PR}.1"

require qt-4.6.0.inc

QT_CONFIG_FLAGS += " \
 -no-embedded \
 -xrandr \
 -x11"


