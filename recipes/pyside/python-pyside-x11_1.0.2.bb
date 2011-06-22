inherit qt4x11

require python-pyside.inc
require python-pyside-${PV}.inc

PR = "${INC_PR}.0"

SRC_URI += " \
 file://no-accessibility-support.patch \
"
