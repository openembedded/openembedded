require qpegps.inc

PR = "r1"

do_configure_prepend() {
         mv ${S}/Place.cpp ${S}/place.cpp
         mv ${S}/Place.h ${S}/place.h
}

SRC_URI[md5sum] = "71b270b75bd773b81be3aaa0e4fc88cd"
SRC_URI[sha256sum] = "f186ef1f117d3a9a9374ac19cfc8daad40a522638e5a758ec79fdd79fac351f4"
