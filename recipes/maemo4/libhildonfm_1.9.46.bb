require libhildonfm.inc

PR = "r1"

SRC_URI = "\
	http://repository.maemo.org/pool/maemo4.0/free/source/libh/${PN}/${PN}_${PV}.tar.gz \
  file://libhildonfm-gtkmaemo-ifdef.patch;patch=1 \
	"


SRC_URI[md5sum] = "2077191776071a94af3194dbeefdab38"
SRC_URI[sha256sum] = "8df5de457571e93ffd9220b6c45378ffe8742f047d386a3c56e265baeb33607f"
