DESCRIPTION = "EPDF is the EFL PDF rendering library based on poppler"
DEPENDS = "etk poppler"
LICENSE = "MIT"
PR = "r0"

inherit efl

SRC_URI = "${E_CVS};module=e17/proto/epdf;date=${PV}"
S = "${WORKDIR}/epdf"
