# This image is for testing the ipv6 mobility extensions

require console-image.bb
IMAGE_INSTALL += " task-mipl "

export IMAGE_BASENAME = "console-mobile-ipv6-image"

