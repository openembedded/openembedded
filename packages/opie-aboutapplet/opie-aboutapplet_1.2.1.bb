include ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/aboutapplet \
           file://add-hrw-to-authors.patch;patch=1"
