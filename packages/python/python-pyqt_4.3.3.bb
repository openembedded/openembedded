PYQT_OE_VERSION = "Qt_4_3_3"
require python-pyqt.inc

PR = "ml2"
SRC_URI += "file://04_qreal_api_fixes.dpatch;patch=1"

EXTRA_QMAKEVARS_POST += "DEFINES+=QT_NO_FPU"

FIX_QREAL += "\
  QtCore/qtimeline.sip \
  QtCore/qrect.sip \
  QtGui/qtransform.sip \
"
