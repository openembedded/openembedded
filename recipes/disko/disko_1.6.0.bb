require disko.inc

PR = "${INC_PR}.0"

SRC_URI = "http://www.diskohq.com/repository/ubuntu/pool/${PN}_${PV}.tar.bz2 \
           file://pkgconfig.patch \
           file://mmsfiletransfer.patch \           
          "

SRC_URI[md5sum] = "9725e3d692492188b4c74e38884501b9"
SRC_URI[sha256sum] = "6553d69dc4968f38840f408b6e75ece5f575a816ff8c2df76cccb6d966a836b7"
