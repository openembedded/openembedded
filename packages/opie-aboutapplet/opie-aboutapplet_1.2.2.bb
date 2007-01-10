include ${PN}.inc

PR = "r2"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/aboutapplet \
           file://opie-1.2.1.patch;patch=1 \
           file://add-hrw-to-authors.patch;patch=1"
