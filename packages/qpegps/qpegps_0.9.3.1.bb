require qpegps.inc

FILE_PR = "r1"

do_configure_prepend() {
         mv ${S}/Place.cpp ${S}/place.cpp
         mv ${S}/Place.h ${S}/place.h
}
