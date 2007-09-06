require gnuradio.inc

DEFAULT_PREFERENCE = "1"

PV = "3.0.4+svnr${SRCREV}"
PR = "r2"

SRC_URI = "svn://gnuradio.org/svn/gnuradio;module=trunk;proto=http \
	   file://no-trellis-doc.patch;patch=1 \
	   "

S="${WORKDIR}/trunk"


