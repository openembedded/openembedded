include nylon-image-standard.bb

export IMAGE_BASENAME = "nylon-extra"
 
NYLON_EXTRA = "\
	kismet \
	netperf \
	nylon-statistics \
	openvpn \
	"

DEPENDS += "${NYLON_EXTRA}"

RDEPENDS += "${NYLON_EXTRA}"
LICENSE = MIT
