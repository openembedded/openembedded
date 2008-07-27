SRC_URI = "svn://svn.openchrome.org/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"
PACKAGES_DYNAMIC = "xorg-driver-via"

include openchrome.inc
