require fakeroot.inc

DEFAULT_PREFERENCE = "-1"
PR = "${INC_PR}.0"

SRC_URI =+ "\
    https://launchpad.net/ubuntu/+archive/primary/+files/${PN}_${PV}.orig.tar.bz2 \
    file://quiet-getopt-check.patch \
"

SRC_URI[md5sum] = "248c408b1e06e776c5739871b49bd968"
SRC_URI[sha256sum] = "45fbb9ad611f33224cc09954963dde563cc80fe58c76feb25b6e98550b81729a"
