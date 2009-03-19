require nylon-image-standard.bb

export IMAGE_BASENAME = "nylon-extra"

IMAGE_INSTALL = "\
    kismet \
    netperf \
    nylon-statistics \
    openvpn"
