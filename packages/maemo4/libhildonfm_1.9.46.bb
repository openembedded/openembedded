require libhildonfm.inc

PR = "r1"

SRC_URI = "\
	http://repository.maemo.org/pool/maemo4.0/free/source/libh/${PN}/${PN}_${PV}.tar.gz \
  file://libhildonfm-gtkmaemo-ifdef.patch;patch=1 \
	"

