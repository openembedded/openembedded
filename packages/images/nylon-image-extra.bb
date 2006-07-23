include nylon-image-standard.bb

export IMAGE_BASENAME = "nylon-extra"
 
RDEPENDS = "\
    kismet \
    netperf \
    nylon-statistics \
    openvpn"

LICENSE = MIT
