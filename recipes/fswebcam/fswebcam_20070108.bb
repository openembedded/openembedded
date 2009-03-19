DESCRIPTION = "Webcam imaage grabber and manipulation application."
SECTION = "graphics"
DEPENDS = "gd"
LICENSE = "GPL"

PR = "r0"

inherit autotools

SRC_URI = "http://www.firestorm.cx/fswebcam/files/${P}.tar.gz"
