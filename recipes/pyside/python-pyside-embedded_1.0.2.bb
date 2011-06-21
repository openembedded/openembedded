inherit qt4e
require python-pyside.inc
require python-pyside-${PV}.inc

PR = "${INC_PR}.3"
SRC_URI += " \
 file://no-accessibility-support.patch \
 file://support-qws.patch \
"
